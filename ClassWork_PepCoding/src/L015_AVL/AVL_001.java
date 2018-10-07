package L015_AVL;

import java.util.Scanner;

public class AVL_001 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		AVL al = new AVL(arr);
//		System.out.println(al);
		 al.addNode(110);
		 System.out.println(al);

	}

	private static class AVL {
		private class Node {
			private int data;
			private Node left;
			private Node right;
			private int Balance;
			private int Height;

			public Node(int data) {
				this.data = data;
			}

			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder();

				sb.append(left != null ? left.data : -1);
				sb.append(" -> " + data + "[" + Balance + ", " + Height + "]" + " <- ");
				sb.append(right != null ? right.data : -1);
				sb.append("\n");

				if (left != null) {
					sb.append(left);
				}
				if (right != null) {
					sb.append(right);
				}

				return sb.toString();

			}

		}

		private Node root;
		private int size;

		@Override
		public String toString() {
			return root.toString();
		}

		// constructor===================================================================================

		public AVL(int[] arr) {
			this.root = construcor(arr, 0, arr.length - 1);
		}

		private Node construcor(int[] arr, int i, int j) {
			if (i > j) {
				return null;
			}
			int mid = (i + j) >> 1;
			Node node = new Node(arr[mid]);
			this.size++;

			node.left = construcor(arr, i, mid - 1);
			node.right = construcor(arr, mid + 1, j);
			node.Height = getHeight(node);
			node.Balance = getBalance(node);
			return node;
		}

		private int getHeight(Node node) {
			if (node == null) {
				return -1;
			}

			int lh = -1;
			int rh = -1;

			if (node.left != null) {
				lh = node.left.Height;
			}

			if (node.right != null) {
				rh = node.right.Height;
			}

			return Math.max(lh, rh) + 1;
		}

		private int getBalance(Node node) {
			if (node == null) {
				return 0;
			}

			int lh = -1;
			int rh = -1;

			if (node.left != null) {
				lh = node.left.Height;
			}

			if (node.right != null) {
				rh = node.right.Height;
			}

			return lh - rh;
		}

		// Factors_And_Roatations.====================================================================================

		// RightRoation.for LL.
		private Node RightRoataion(Node node) {
			Node y = node.left;
			Node rightTree = y.right;

			y.right = node;
			node.left = rightTree;

			UpdateFactors(node);
			UpdateFactors(y);

			return y;
		}

		// LeftRoation.for RR.
		private Node LeftRoataion(Node node) {
			Node y = node.right;
			Node leftTree = y.left;

			y.left = node;
			node.right = leftTree;

			UpdateFactors(node);
			UpdateFactors(y);

			return y;
		}

		private void UpdateFactors(Node node) {
			node.Height = getHeight(node);
			node.Balance = getBalance(node);
		}

		private Node GetBalanceTree(Node node) {
			if (getBalance(node) > 1) { // ll,lr
				if (getBalance(node.left) > 0) { // ll
					node = RightRoataion(node);
				} else {// lr
					node.left = LeftRoataion(node.left);
					node = RightRoataion(node);
				}

			} else if (getBalance(node) < -1) { // rr,rl
				if (getBalance(node.right) < 0) { // rr
					node = LeftRoataion(node);
				} else { // rl
					node.right = RightRoataion(node.right);
					node = LeftRoataion(node);

				}
			}

			return node;
		}

		// generalFunctions.=======================================================================================

		public void addNode(int data) {
			this.root = addNode(this.root, data);
		}

		private Node addNode(Node node, int data) {
			if (node == null) {
				this.size++;
				return new Node(data);
			}

			if (node.data > data) {
				node.left = addNode(node.left, data);
			} else if (node.data < data) {
				node.right = addNode(node.right, data);
			} else {

			}

			UpdateFactors(node);

			node = GetBalanceTree(node);
			return node;
		}

		public void Remove(int data) {
			this.root = Remove(this.root, data);
		}

		private Node Remove(Node node, int data) {
			if (node == null) {
				return null;
			}

			if (node.data > data) {
				node.left = Remove(node.left, data);
			}

			else if (node.data > data) {
				node.right = Remove(node.right, data);
			} else {

				if (node.left == null && node.right == null) {
					return null;
				} else if (node.left == null || node.right == null) {
					return (node.left == null ? node.right : node.left);
				} else {
					node.data = min(node.right);
					node.right = Remove(node.right, node.data);
				}
			}

			UpdateFactors(node);
			GetBalanceTree(node);
			return node;
		}

		private int max(Node node) {
			if (node.right == null) {
				return node.data;
			} else {
				return max(node.right);
			}
		}

		private int min(Node node) {
			if (node.left == null) {
				return node.data;
			} else {
				return min(node.left);
			}
		}

	}

}
