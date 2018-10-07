package L013_BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class L013_BinaryTree {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// 1. Lecture 17 BT
		// 1.1 Context & examples - expressions
		// 1.2 Node, ctor, data members
		// 1.3 takeInput, size, isEmpty, display
		// 1.4 size2, max, find, height
		// 1.5 preo, ino, posto, iteratives, binaries
		// 1.6 removeLeaves, printOnlyChild
		// 1.7 rootToNodePath, rootToLeafPathTargetSum
		// 1.8 printkDown, printkFar
		// 1.9 ctor - pre & in, post & in
		// 1.10 diameter, diameter2, isBalanced, isBST, largestBST

		solve();
		// solve2();

	}

	private static void solve() {
		// 22 50 25 12 -1 37 30 -1 52 -1 -1 -1 75 62 60 -1 70 -1 -1 87 -1 -1 -1

		int[] arr = ArrayInput(scn.nextInt());
		BinaryTree bt = new BinaryTree(arr);
		// System.out.println(bt);

		// System.out.println(bt.height());
		// System.out.println(bt.RootToNodePath(62));
		// bt.RootToLeafPathsInRange(150, 250);
		// System.out.println(bt.diameter());
		// System.out.println(bt.diameterDiaPair());
		// System.out.println(bt.diameterDiaPair2());

		// bt.removeLeaves();
		// System.out.println(bt);

		// bt.removeLeaves1();
		// System.out.println(bt);

		// bt.removeLeaves2();
		// System.out.println(bt);

		// bt.PintKDown(2, 25);

		// System.out.println(bt.RootToNodePath(25));

		// bt.PrintStepsDown(25, 2);
		// bt.preOrder();
		// bt.inOrder();
		// bt.postOrder();

		// int[] pre = { 50, 25, 12, 37, 30, 40, 75, 62, 60, 70, 87, };
		// int[] in = { 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87, };
		// int[] post = { 12, 30, 40, 37, 25, 60, 70, 62, 87, 75, 50, };
		// BinaryTree bt1 = new BinaryTree(post, in);
		// System.out.println(bt1);

		// int a = bt.diameter2();
		// System.out.println(a);
		// boolean ans = bt.isbalanced();
		// System.out.println(ans);

		// boolean ans2=bt.i
		boolean ans = bt.isbst();
		System.out.println(ans);
	}

	private static void solve2() {
		printBinary(50);
	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	// BinaryNumberTree===================================================================================================

	private static class BinaryNode {
		private int data;
		private String str;

		public BinaryNode(int data, String str) {
			this.data = data;
			this.str = str;
		}
	}

	private static void printBinary(int n) {
		BinaryNode node = new BinaryNode(1, "1");
		LinkedList<BinaryNode> queue = new LinkedList<>();
		queue.addLast(node);
		while (!queue.isEmpty()) {
			BinaryNode rem = queue.removeFirst();
			System.out.println(rem.data + " -> " + rem.str);

			if (rem.data == n) {
				break;
			}

			BinaryNode left = new BinaryNode(2 * rem.data, rem.str + "0");
			queue.addLast(left);
			BinaryNode right = new BinaryNode(2 * rem.data + 1, rem.str + "1");
			queue.addLast(right);

		}
	}

	// BinaryTree.========================================================================================================

	private static class BinaryTree {

		private class Node {
			private int data;
			private Node left;
			private Node right;

			private Node(int data, Node left, Node right) {
				this.data = data;
				this.left = left;
				this.right = right;
			}

			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder();

				// leftChild->Node<-rightChild.

				sb.append((left != null) ? left.data : ".");
				sb.append(" -> " + data + " <- ");
				sb.append((right != null) ? right.data : ".");

				sb.append("\n"); // nextLine.

				if (left != null) {
					sb.append(left);
				}
				if (right != null) {
					sb.append(right);
				}
				return sb.toString();
			}

		}

		@Override
		public String toString() {
			return root.toString();
		}

		private int size;
		private Node root;

		// Constructor.===============================================================================================

		public BinaryTree(int[] arr) {
			ArrayDeque<Node> stack = new ArrayDeque<>(); // addFirst,removeFirst.

			for (int i = 0; i < arr.length - 1; i++) {

				if (arr[i] != -1) {
					Node node = new Node(arr[i], null, null);
					this.size++;
					stack.addFirst(node);
				} else {
					Node node = stack.removeFirst();
					if (stack.peekFirst().left == null) {
						stack.peekFirst().left = node;
					} else {
						stack.peekFirst().right = node;
					}
				}
			}
			this.root = stack.removeFirst();
		}

		public BinaryTree(int[] pre, int[] in) {
			// this.root = BinaryTreePreInCon(pre, in, 0, pre.length - 1, 0,
			// in.length - 1);
			this.root = BinaryTreePostInCon(pre, in, 0, pre.length - 1, 0, in.length - 1);
		}

		private Node BinaryTreePreInCon(int[] pre, int[] in, int psi, int pei, int isi, int iei) {

			if (psi > pei || isi > iei) {
				return null;
			}

			Node node = new Node(pre[psi], null, null);

			int index = findIndex(in, pre[psi], isi);
			int len = index - isi;

			node.left = BinaryTreePreInCon(pre, in, psi + 1, psi + len, isi, index - 1);
			node.right = BinaryTreePreInCon(pre, in, psi + len + 1, pei, index + 1, iei);

			return node;
		}

		private Node BinaryTreePostInCon(int[] post, int[] in, int psi, int pei, int isi, int iei) {
			if (psi > pei || isi > iei) {
				return null;
			}

			Node node = new Node(post[pei], null, null);

			int index = findIndex(in, post[pei], isi);
			int len = index - isi;

			node.left = BinaryTreePostInCon(post, in, psi, pei - len - 1, isi, index - 1);
			node.right = BinaryTreePostInCon(post, in, pei - len, pei - 1, index + 1, iei);

			return node;
		}

		private int findIndex(int[] in, int ele, int isi) {
			int index = -1;
			while (isi < in.length) {
				if (in[isi] == ele) {
					index = isi;
					break;
				}
				isi++;
			}

			return index;
		}

		// GenneralFunction.===============================================================================================

		public int size() {
			return this.size;
		}

		public boolean isEmpty() {
			return (this.size == 0);
		}

		public int height() {
			return height(this.root);
		}

		private int height(Node node) {
			if (node == null) {
				return -1;
			}
			return Math.max(height(node.left), height(node.right)) + 1;
		}

		public int size2() {
			return size2(this.root);
		}

		private int size2(Node node) {
			if (node == null) {
				return 0;
			}
			return size2(node.left) + size2(node.right) + 1;
		}

		public boolean ContainsKey(int key) {
			return ContainsKey(this.root, key) != null;
		}

		private Node ContainsKey(Node node, int key) {
			if (node == null) {
				return null;
			}

			if (node.data == key) {
				return node;
			}

			Node IsInLeft = ContainsKey(node.left, key);
			if (IsInLeft != null) {
				return IsInLeft;
			}
			Node IsInRight = ContainsKey(node.left, key);
			if (IsInRight != null) {
				return IsInRight;
			}

			return null;
		}

		public int MaxValue() {
			return MaxValue(this.root);
		}

		private int MaxValue(Node node) {
			if (node == null) {
				return Integer.MIN_VALUE;
			}

			return Math.max(Math.max(MaxValue(node.left), MaxValue(node.right)), node.data);

		}

		public int MinValue() {
			return MinValue(this.root);
		}

		private int MinValue(Node node) {
			if (node == null) {
				return Integer.MAX_VALUE;
			}

			return Math.min(Math.min(MinValue(node.left), MinValue(node.right)), node.data);

		}

		public void preOrder() {
			System.out.print("{");
			preOrder(this.root);
			System.out.println("}");
		}

		private void preOrder(Node node) {
			if (node == null) {
				return;
			}

			System.out.print(node.data + ", ");
			preOrder(node.left);
			preOrder(node.right);
		}

		public void postOrder() {
			System.out.print("{");
			postOrder(this.root);
			System.out.println("}");
		}

		private void postOrder(Node node) {
			if (node == null) {
				return;
			}

			postOrder(node.left);
			postOrder(node.right);

			System.out.print(node.data + ", ");
		}

		public void inOrder() {
			System.out.print("{");
			inOrder(this.root);
			System.out.println("}");
		}

		private void inOrder(Node node) {
			if (node == null) {
				return;
			}

			inOrder(node.left);
			System.out.print(node.data + ", ");

			inOrder(node.right);

		}

		// Questions.================================================================================================

		// Diameter.=====================================================

		public int diameter() {
			return diameter(this.root);
		}

		private int diameter(Node node) { // O(n2)
			if (node == null) {
				return 0;
			}

			int ld = diameter(node.left);
			int rd = diameter(node.right);

			int lh = height(node.left);
			int rh = height(node.right);

			int ExpectedDiameter = lh + rh + 2;
			return Math.max(Math.max(ld, rd), ExpectedDiameter);

		}

		private class DiaPair {
			private int height = -1;
			private int diameter = 0;
		}

		public int diameterDiaPair() {
			DiaPair pair = diameterDiaPair(this.root);
			return pair.diameter;
		}

		private DiaPair diameterDiaPair(Node node) {
			if (node == null) {
				return new DiaPair();
			}

			DiaPair lpair = diameterDiaPair(node.left);
			DiaPair rpair = diameterDiaPair(node.right);

			DiaPair pair = new DiaPair();
			pair.height = Math.max(lpair.height, rpair.height) + 1;
			pair.diameter = lpair.height + rpair.height + 2;

			return pair;
		}

		public int diameterDiaPair2() {
			DiaPair pair = new DiaPair();
			diameterDiaPair2(this.root, pair);
			return pair.diameter;
		}

		private int diameterDiaPair2(Node node, DiaPair pair) {
			if (node == null) {
				return -1;
			}

			int lh = diameterDiaPair2(node.left, pair);
			int rh = diameterDiaPair2(node.right, pair);

			pair.diameter = Math.max(pair.diameter, lh + rh + 2);

			return Math.max(lh, rh) + 1;
		}

		// RootToLeaf.======================================================

		public ArrayList<Integer> RootToNodePath(int data) {
			ArrayList<Node> list = RootToNodePath(this.root, data);
			ArrayList<Integer> rlist = new ArrayList<>();
			for (Node node : list) {
				rlist.add(node.data);
			}
			return rlist;
		}

		private ArrayList<Node> RootToNodePath(Node node, int data) {
			if (node == null) {
				return new ArrayList<>();
			}

			if (node.data == data) {
				ArrayList<Node> list = new ArrayList<>();
				list.add(node);
				return list;
			}

			ArrayList<Node> llist = RootToNodePath(node.left, data);
			if (llist.size() != 0) {
				llist.add(node);
				return llist;
			}

			ArrayList<Node> rlist = RootToNodePath(node.right, data);
			if (rlist.size() != 0) {
				rlist.add(node);
				return rlist;
			}

			return new ArrayList<>();
		}

		public void RootToLeafPathsInRange(int lo, int hi) {
			RootToLeafPathsInRange(this.root, "", 0, lo, hi);
		}

		private void RootToLeafPathsInRange(Node node, String psf, int ssf, int lo, int hi) {
			if (node == null) {
				return;
			}

			psf += node.data + " ";
			ssf += node.data;
			if (node.left == null && node.right == null) {
				if (ssf >= lo && ssf <= hi) {
					System.out.println(psf);
				}
			}

			RootToLeafPathsInRange(node.left, psf, ssf, lo, hi);
			RootToLeafPathsInRange(node.right, psf, ssf, lo, hi);
		}

		// Kaway_And_Kdown================================================

		public void PintKDown(int level, int data) {

			Node node = ContainsKey(this.root, data);

			if (node != null) {
				PrintKDown(node, 0, level);
			} else {
				System.out.println("No Such Element");
			}
		}

		private void PrintKDown(Node node, int depth, int level) {
			if (node == null) {
				return;
			}

			if (depth == level) {
				System.out.println(node.data);
			}

			PrintKDown(node.left, depth + 1, level);
			PrintKDown(node.right, depth + 1, level);

		}

		private void PrintStepsDown(int data, int level) {
			ArrayList<Node> list = RootToNodePath(this.root, data);

			for (int i = 0; i < list.size() && i < level; i++) {
				PrintStepsDown(list.get(i), i == 0 ? null : list.get(i - 1), 0, level - i);
			}
		}

		private void PrintStepsDown(Node node, Node Obstacles, int depth, int level) {
			if (node == null || node == Obstacles) {
				return;
			}

			if (depth == level) {
				System.out.print(node.data + " ");
			}

			PrintStepsDown(node.left, Obstacles, depth + 1, level);
			PrintStepsDown(node.right, Obstacles, depth + 1, level);

		}

		// RemoveLeafes.========================================================

		public void removeLeaves() {
			this.root = removeLeaves(this.root);
		}

		private Node removeLeaves(Node node) {
			if (node == null) {
				return null;
			}

			if (node.left == null && node.right == null) {
				return null;
			}

			node.left = removeLeaves(node.left);
			node.right = removeLeaves(node.right);

			return node;
		}

		public void removeLeaves1() {
			removeLeaves1(this.root, null, false);
		}

		private void removeLeaves1(Node node, Node parent, boolean ilc) {
			if (node == null) {
				return;
			}

			if (node.left == null && node.right == null) {
				if (ilc) {
					parent.left = null;
				} else {
					parent.right = null;
				}
				return;
			}

			removeLeaves1(node.left, node, true);
			removeLeaves1(node.right, node, false);

		}

		public void removeLeaves2() {
			removeLeaves2(this.root);
		}

		private void removeLeaves2(Node node) {
			if (node == null) {
				return;
			}

			if (node.left != null && node.left.left == null && node.left.right == null) {
				node.left = null;

			}

			if (node.right != null && node.right.left == null && node.right.right == null) {
				node.right = null;
			}

			removeLeaves2(node.left);
			removeLeaves2(node.right);
		}

		// Soumya=========================================================================

		private class Diapair {
			int height;
			int diameter;
		}

		public int diameter2() {
			Diapair dp = diameter2(root);
			return dp.diameter;

		}

		private Diapair diameter2(Node node) {
			if (node == null) {
				Diapair b = new Diapair();
				b.diameter = 0;
				b.height = -1;
				return b;
			}
			Diapair dp = new Diapair();

			Diapair d1 = diameter2(node.left);
			Diapair d2 = diameter2(node.right);

			dp.height = Math.max(d1.height, d2.height) + 1;
			dp.diameter = Math.max((d1.height + d2.height + 2), Math.max(d1.diameter, d2.diameter));
			return dp;

		}

		private class balancetre {
			boolean isbalance = true;
			int height = -1;
		}

		public boolean isbalanced() {
			balancetre b = isbalanced(this.root);
			return b.isbalance;

		}

		private balancetre isbalanced(Node node) {
			if (node == null) {
				return new balancetre();
			}
			balancetre bt = new balancetre();
			balancetre bl = isbalanced(node.left);
			if (bl.isbalance == false) {
				return bl;
			}
			balancetre br = isbalanced(node.right);
			if (br.isbalance == false) {
				return br;
			}

			int delta = Math.abs(bl.height - br.height);
			if (delta > 1) {
				bt.isbalance = false;
			} else {
				bt.isbalance = true;
			}
			return bt;

		}

		// public void isbst()
		// {
		// System.out.println(isbst(root));
		// }
		//
		// private boolean isbst(Node node) {
		//
		// if (node == null) {
		// return true;
		// }
		//
		// boolean lans = isbst(node.left);
		// if (lans == false) {
		// return lans;
		// }
		// boolean rans = isbst(node.right);
		// if (rans == false) {
		// return rans;
		// }
		//
		// if (node.left != null) {
		// if (node.left.data > node.data) {
		// return false;
		// }
		// }
		//
		// if (node.right != null) {
		// if (node.right.data < node.data) {
		// return false;
		// }
		// }
		//
		// return true;
		//
		// }
		private class bstpair {
			private int max;
			private int min;
			private boolean isBST;
		}

		public boolean isbst() {
			bstpair bp = isbst(this.root);
			return bp.isBST;

		}

		private bstpair isbst(Node node) {
			if (node == null) {
				bstpair bp = new bstpair();

				bp.isBST = true;
				bp.max = Integer.MIN_VALUE;
				bp.min = Integer.MAX_VALUE;
				return bp;
			}

			bstpair lp = isbst(node.left);
			bstpair rp = isbst(node.right);

			bstpair mp = new bstpair();

			mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
			mp.min = Math.min(node.data, Math.min(lp.min, rp.min));

			if (lp.isBST && rp.isBST && node.data > lp.max && node.data < rp.min) {
				mp.isBST = true;
			}
			return mp;
		}

		private class tpair {
			Node node;
			boolean mywork;
			boolean leftwork;
			boolean rightwork;
		}

		public void traversaliterative() {
			LinkedList<tpair> stack = new LinkedList<>();

			tpair rootpair = new tpair();
			rootpair.node = root;
			stack.addFirst(rootpair);

			while (stack.size() > 0) {
				tpair tos = stack.getFirst();

				if (!tos.mywork) {
					tos.mywork = true;
				} else if (!tos.leftwork) {
					tos.leftwork = true;
					if (tos.node.left != null) {
						tpair tp = new tpair();
						tp.node = tp.node.left;
						stack.addFirst(tp);
					}
				} else if (!tos.rightwork) {
					tos.rightwork = true;
					if (tos.node.right != null) {
						tpair tp = new tpair();
						tp.node = tp.node.right;
						stack.addFirst(tp);
					} else {
						stack.removeFirst();
					}
				}
			}

		}
	}
}
