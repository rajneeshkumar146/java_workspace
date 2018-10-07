package L020_SegmentTree;

import java.util.Scanner;

public class SegmentTree_001 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] arr = { 1, 2, 5, 8, -9, 7, 78, 56, -535, 67, 45, 65, 0, 7, 0, 1, 2, 4 };
		SegmentTree sb = new SegmentTree(arr);
		// System.out.println(sb);
		System.out.println(sb.Query(0, 2));
		sb.Update(0, 10);
		System.out.println(sb.Query(0, 2));
	}

	public static class SegmentTree {
		private class Node {
			private int data;
			private Node left;
			private Node right;
			private int li;
			private int ri;

			public Node(int data, Node left, Node right, int li, int ri) {

				this.data = data;
				this.left = left;
				this.right = right;
				this.li = li;
				this.ri = ri;
			}

			public String toString() {
				StringBuilder sb = new StringBuilder();

				sb.append(this.left == null ? "." : left.data);
				sb.append(" -> " + data + " <- ");
				sb.append(this.right == null ? "." : right.data);
				sb.append("\n");

				if (left != null) {
					sb.append(left.toString());
				}
				if (right != null) {
					sb.append(right.toString());
				}
				return sb.toString();
			}
		}

		Node root;

		public SegmentTree(int[] arr) {
			this.root = construction(arr, 0, arr.length - 1);
		}

		public String toString() {
			return root.toString();
		}

		private Node construction(int[] arr, int lo, int hi) {

			if (lo == hi) {
				Node node = new Node(arr[lo], null, null, lo, hi);
				return node;
			}

			int mid = (lo + hi) >> 1;
			Node node = new Node(0, null, null, lo, hi);
			node.left = construction(arr, lo, mid);
			node.right = construction(arr, mid + 1, hi);
			node.data = node.left.data + node.right.data;

			return node;
		}

		public int Query(int qsi, int qei) {
			return Query(this.root, qsi, qei);
		}

		private int Query(Node node, int qsi, int qei) {

			if (node.li >= qsi && node.ri <= qei) {
				return node.data;
			} else if (qsi > node.ri || qei < node.li) {
				return 0;
			} else {
				return Query(node.left, qsi, qei) + Query(node.right, qsi, qei);
			}
		}

		public void Update(int idx, int nv) {
			Update(this.root, idx, nv);
		}

		private void Update(Node node, int idx, int nv) {
			if (node.li == idx && node.ri == idx) {
				node.data = nv;
				return;
			}

			if (idx >= node.li && idx <= node.ri) {
				Update(node.left, idx, nv);
				Update(node.right, idx, nv);
				node.data = node.left.data + node.right.data;
			}

		}

	}

}
