package Class_21_and22th_Binary_Tree;

import java.util.LinkedList;
import java.util.Scanner;

public class BST {
	private class Node {
		private int data;
		private Node left;
		private Node right;

	}

	private Node root;
	private int size;

	public BST(int[] pre, int[] in) { // Constructor
		root = construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}

	private Node construct(int[] pos, int[] in, int psi, int pei, int isi, int iei) {
		if (psi > pei || isi > iei) {
			return null;
		}

		Node node = new Node();
		this.size++;
		node.data = pos[pei];

		int idx = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == node.data) {
				idx = i;
				break;
			}
		}

		int nelonls = idx - isi;

		node.left = construct(pos, in, psi, nelonls - 1, isi, idx - 1);
		node.right = construct(pos, in, psi + nelonls, pei - 1, idx + 1, iei);

		return node;

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}

		str += "<=";
		str += node.data;
		str += "=>";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}

		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}

		int lsize = size2(node.left);
		int rsize = size2(node.right);
		return lsize + rsize + 1;
	}

	public boolean find(int data) {

		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (node.data > data) {
			return find(node.right, data);
		} else if (node.data < data) {
			return find(node.left, data);
		} else {
			return true;
		}

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node.right != null) {
			return max(node.right);
		} else {
			return node.data;
		}

	}

	public int min() {
		return min(root);
	}

	private int min(Node node) {
		if (node.left != null) {
			return min(node.left);
		} else {
			return node.data;
		}

	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int holb = height(node.left); // holb=height_of_left_branch
		int horb = height(node.right); // horb=height_of_right_branch

		return Math.max(holb, horb) + 1;

	}

	public int diameter() {

		return diameter(root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int dl = diameter(node.left);
		int dr = diameter(node.right);

		int hl = height(node.left);
		int hr = height(node.right);
		int f1 = hl + hr + 2;
		int f2 = dl;
		int f3 = dr;

		return Math.max(Math.max(f2, f3), f1);

	}

	private class DiaPair {
		private int dia;
		private int height;
	}

	public int diameter2() {

		return diameter2(root).dia;
	}

	private DiaPair diameter2(Node node) {
		if (node == null) {
			DiaPair db = new DiaPair();
			db.height = -1;
			db.dia = 0;
			return db;
		}

		DiaPair dl = diameter2(node.left);
		DiaPair dr = diameter2(node.right);

		int f1 = dl.height + dr.height + 2;

		DiaPair md = new DiaPair();
		md.dia = f1;
		md.height = Math.max(dl.height, dr.height) + 1;

		return md;

	}

	private class isBalanced {
		private int height;
		private boolean isbal;
	}

	public boolean isBalanced() {
		return isBalanced(root).isbal;
	}

	private isBalanced isBalanced(Node node) {
		if (node == null) {
			isBalanced br = new isBalanced();
			br.height = -1;
			br.isbal = true;
			return br;
		}

		isBalanced lb = isBalanced(node.left);
		isBalanced rb = isBalanced(node.right);

		int gap = Math.abs(lb.height - rb.height);
		isBalanced mr = new isBalanced();

		mr.height = Math.max(lb.height, rb.height) + 1;

		if (lb.isbal == true && rb.isbal == true && gap <= 1) {
			mr.isbal = true;
		} else {
			mr.isbal = false;
		}

		return mr;

	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);

	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data);

	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.println(node.data);
		inOrder(node.right);

	}

	public void levelOrder() {
		levelOrder(root);
	}

	private void levelOrder(Node node) {
		LinkedList<Node> queue = new LinkedList();
		queue.add(root);

		while (queue.size() != 0) {
			Node result = queue.removeLast();
			System.out.println(result.data);

			if (node.left != null) {
				queue.addFirst(node.left);

			}

			if (node.right != null) {
				queue.addFirst(node.right);

			}
		}

	}

	private class TraversalPair {
		private Node node;
		private boolean selfdone;
		private boolean leftdone;
		private boolean rightdone;
	}

	public void preOrderIrr() {
		LinkedList<TraversalPair> stack = new LinkedList<>();
		TraversalPair pair = new TraversalPair();

		pair.node = root;
		stack.addFirst(pair);

		while (stack.size() != 0) {
			pair = stack.getFirst();

			if (pair.selfdone == false) {
				System.out.print(pair.node.data + ",");

				pair.selfdone = true;

			} else if (pair.leftdone == false) {
				if (pair.node.left != null) {
					TraversalPair ld = new TraversalPair();
					ld.node = pair.node.left;
					stack.addFirst(ld);
				}

				pair.leftdone = true;

			} else if (pair.rightdone == false) {
				if (pair.node.right != null) {
					TraversalPair rd = new TraversalPair();
					rd.node = pair.node.right;
					stack.addFirst(rd);
				}

				pair.rightdone = true;

			} else {
				stack.removeFirst();

			}
		}
	}

	public void postOrderIrr() {
		LinkedList<TraversalPair> stack = new LinkedList<>();
		TraversalPair pair = new TraversalPair();

		pair.node = root;
		stack.addFirst(pair);

		while (stack.size() != 0) {
			pair = stack.getFirst();

			if (pair.leftdone == false) {
				if (pair.node.left != null) {
					TraversalPair ld = new TraversalPair();
					ld.node = pair.node.left;
					stack.addFirst(ld);
				}

				pair.leftdone = true;

			} else if (pair.rightdone == false) {
				if (pair.node.right != null) {
					TraversalPair rd = new TraversalPair();
					rd.node = pair.node.right;
					stack.addFirst(rd);
				}

				pair.rightdone = true;

			} else if (pair.selfdone == false) {
				System.out.print(pair.node.data + ",");
				pair.selfdone = true;

			}

			else {
				stack.removeFirst();

			}
		}
	}

	public void InOrderIrr() {
		LinkedList<TraversalPair> stack = new LinkedList<>();
		TraversalPair pair = new TraversalPair();

		pair.node = root;
		stack.addFirst(pair);

		while (stack.size() != 0) {
			pair = stack.getFirst();

			if (pair.leftdone == false) {
				if (pair.node.left != null) {
					TraversalPair ld = new TraversalPair();
					ld.node = pair.node.left;
					stack.addFirst(ld);
				}

				pair.leftdone = true;

			} else if (pair.selfdone == false) {
				System.out.print(pair.node.data + ",");
				pair.selfdone = true;

			} else if (pair.rightdone == false) {
				if (pair.node.right != null) {
					TraversalPair rd = new TraversalPair();
					rd.node = pair.node.right;
					stack.addFirst(rd);
				}

				pair.rightdone = true;

			} else {
				stack.removeFirst();

			}
		}
	}

	public void add(int data) {
		if (root == null) {
			Node node = new Node();
			node.data = data;
			this.size++;
		} else {
			add(root, data);
		}
	}

	private void add(Node node, int data) {

		if (node.data < data) {
			if (node.right != null) {
				add(node.right, data);
			} else {
				Node nn = new Node();
				nn.data = data;
				node.right = nn;
				this.size++;
			}

		} else if (node.data > data) {
			if (node.left != null) {
				add(node.left, data);
			} else {
				Node nn = new Node();
				nn.data = data;
				node.left = nn;
				this.size++;
			}

		} else {

		}

	}

	public BST(int[] sa) {
		root = construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node node = new Node();
		this.size++;
		node.data = sa[mid];

		node.left = construct(sa, lo, mid - 1);
		node.right = construct(sa, mid + 1, hi);

		return node;

	}

	public void remove(int data) {
		if (root == null) {
			return;
		} else {
			remove(data, root, null, false);
		}
	}

	private void remove(int data, Node node, Node parent, boolean ilc) {

		if (data > node.data) {
			remove(data, node.right, node, false);
		} else if (data < node.data) {
			remove(data, node.left, node, true);
		} else {

			if (node.left != null && node.right != null) {

				int maxl = this.max(node.left);
				node.data = maxl;
				remove(maxl, node.left, node, true);

			} else {
				this.size--;
				if (ilc) {
					parent.left = ((node.left != null) ? node.left : node.right);
				} else {
					parent.right = ((node.left != null) ? node.left : node.right);
				}
			}

		}

	}

	private class HeapMover {
		int sum;
	}

	public void replaceWithSumOfLarerNode() {
		HeapMover bucket = new HeapMover();
		replaceWithSumOfLarerNode(bucket, root);
	}

	private void replaceWithSumOfLarerNode(HeapMover bucket, Node node) {

		if (node == null) {
			return;
		}

		replaceWithSumOfLarerNode(bucket, node.right);
		int temp = node.data;
		node.data = bucket.sum;
		bucket.sum += temp;
		replaceWithSumOfLarerNode(bucket, node.left);

	}

	public void printBetweenLoHi(int lodata, int hidata) {
		printBetweenLoHi(root, lodata, hidata);
	}

	private void printBetweenLoHi(Node node, int lodata, int hidata) {
		if (node == null) {
			return;
		}
		if (node.data < lodata) {
			printBetweenLoHi(node.right, lodata, hidata);
		} else if (node.data > hidata) {
			printBetweenLoHi(node.left, lodata, hidata);
		} else {
			System.out.print(node.data + " ");
			printBetweenLoHi(node.left, lodata, hidata);
			printBetweenLoHi(node.right, lodata, hidata);
		}
	}

	public void removeAllLeaves() {

		removeAllLeaves(root, null, false);

	}

	private void removeAllLeaves(Node node, Node parent, boolean lic) {

		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			if (lic) {
				parent.left = null;

			} else {
				parent.right = null;
			}
		}

		removeAllLeaves(node.left, node, true);
		removeAllLeaves(node.right, node, false);

	}

	public void printWithoutSublings() {
		printWithoutSublings(root, null, false);
	}

	private void printWithoutSublings(Node node, Node parent, boolean lic) {
		if (node == null) {
			return;
		}

		if (node.left != null && node.right == null) {
			System.out.println(node.data + " ");
		} else if (node.right != null && node.left == null) {
			System.out.println(node.data + " ");
		}

		printWithoutSublings(node.left, node, true);
		printWithoutSublings(node.right, node, false);

	}

	private class isBST {
		private int max;
		private int min;
		private boolean isBst;
		private int maxbst;
		private Node root;
	}

	public boolean isBst() {
		return isBst(root).isBst;
	}

	private isBST isBst(Node node) {
		if (node == null) {
			isBST br = new isBST();
			br.max = Integer.MIN_VALUE;
			br.min = Integer.MAX_VALUE;
			br.isBst = true;
			return br;
		}

		isBST lb = isBst(node.left);
		isBST rb = isBst(node.right);

		int maxl = Math.max(Math.max(lb.max, rb.max), node.data);
		int minr = Math.min(Math.min(lb.min, rb.min), node.data);

		isBST mr = new isBST();
		mr.max = maxl;
		mr.min = minr;

		if (lb.isBst && rb.isBst && node.data > lb.max && rb.min > node.data) {
			mr.isBst = true;
			mr.root = node;
			mr.maxbst = lb.maxbst + rb.maxbst + 1;
		} else {
			mr.isBst = false;
			if (lb.maxbst > rb.maxbst) {
				mr.root = lb.root;
				mr.maxbst = lb.maxbst;
			} else {
				mr.root = rb.root;
				mr.maxbst = rb.maxbst;
			}
		}
		return mr;
	}

}
