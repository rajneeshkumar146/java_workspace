package Class_32_SegmentTree;

public class SegmentTree {
	private class Node {
		private int data;
		private int size;
		private int si;
		private int ei;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	public SegmentTree(int[] arr) {
		this.root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int si, int ei) {
		if (si == ei) {
			Node base = new Node();
			base.size++;
			base.data = arr[si];
			base.si = base.ei = si;
			return base;
		}

		int mid = (si + ei) / 2;
		Node node = new Node();
		node.size++;
		node.si = si;
		node.ei = ei;
		node.left = construct(arr, si, mid);
		node.right = construct(arr, mid + 1, ei);
		node.data = node.left.data + node.right.data;

		return node;
	}

	public int query(int qsi, int qei) {
		return query(this.root, qsi, qei);
	}

	private int query(Node node, int qsi, int qei) {
		if (node.si >= qsi && node.ei <= qei) {
			return node.data;
		} else if (node.ei < qsi || node.si > qei) {
			return 0;

		} else {
			int lsc = query(node.left, qsi, qei);
			int rsc = query(node.right, qsi, qei);
			return lsc + rsc;
		}
	}

	public void update(int idx, int value) {
		update(this.root, idx, value);
	}

	private void update(Node node, int idx, int value) {
		if (node.si == idx && node.ei == idx) {
			node.data = value;
			return;
		}

		int mid = (node.si + node.ei) / 2;

		if (mid > idx) {
			update(node.left, idx, value);
		} else if (mid <= idx) {
			update(node.right, idx, value);
		}

		node.data = node.left.data + node.right.data;

	}

}
