package Class_21_and22th_Binary_Tree;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {

	private class Node {
		private int data;
		private Node left;
		private Node right;

	}

	private Node root;
	private int size;

	public BinaryTree() {
		Scanner scn = new Scanner(System.in);
		this.root = takeinput(null, false, scn);
	}

	public Node takeinput(Node parent, boolean ilc, Scanner scn) {
		// prompt

		if (parent == null) {
			System.out.println("Enter data for root");
		} else {
			if (ilc == true) {
				System.out.println("Enter data for left child for" + parent.data);
			} else {
				System.out.println("Enter data for right child for" + parent.data);
			}
		}

		// collect data
		int data = scn.nextInt();

		// create_Node_assign_data_and_increase_size
		Node node = new Node();
		node.data = data;
		this.size++;

		// work for left child

		System.out.println("Do you have left child");
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			node.left = takeinput(node, true, scn);
		}

		// work for right child
		System.out.println("Do you have right child");
		boolean hrc = scn.nextBoolean();

		if (hrc) {
			node.right = takeinput(node, false, scn);
		}

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

		if (node.data == data) {
			return true;
		}

		boolean IsInlchild = find(node, data);
		if (IsInlchild == true) {
			return true;
		}

		boolean IsInrchild = find(node, data);
		if (IsInrchild == true) {
			return true;
		}

		return false;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int maxlchild = max(node);
		int maxrchild = max(node);

		return Math.max(Math.max(maxlchild, maxrchild), node.data);

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

	private class isBST {
		private int max;
		private int min;
		private boolean isBst;
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
		} else {
			mr.isBst = false;
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
		if (node == null) {
			return;
		}

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

	// public BinaryTree(int[] pos, int[] in) { // Constructor
	// root = construct(pos, in, 0, pos.length - 1, 0, in.length - 1);
	// }
	//
	// private Node construct(int[] pos, int[] in, int psi, int pei, int isi,
	// int iei) {
	// if (psi > pei || isi > iei) {
	// return null;
	// }
	//
	// Node node = new Node();
	// this.size++;
	// node.data = pos[pei];
	//
	// int idx = -1;
	// for (int i = isi; i <= iei; i++) {
	// if (in[i] == node.data) {
	// idx = i;
	// break;
	// }
	// }
	//
	// int nelonls = idx - isi;
	//
	// node.left = construct(pos, in, psi, nelonls - 1, isi, idx - 1);
	// node.right = construct(pos, in, psi + nelonls, pei - 1, idx + 1, iei);
	//
	// return node;
	//
	// }

	public BinaryTree(int[] pre, int[] in) { // Constructor
		root = construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}

	private Node construct(int[] pre, int[] in, int psi, int pei, int isi, int iei) {// preStartIndex,inStatrIndex.
		if (psi > pei || isi > iei) {
			return null;
		}

		Node node = new Node();
		this.size++;
		node.data = pre[psi];

		int idx = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == node.data) {
				idx = i;
				break;
			}
		}

		int nelonls = idx - isi;// Number_Of_eleement_in_left_side.

		node.left = construct(pre, in, psi + 1, psi + nelonls, isi, idx - 1);
		node.right = construct(pre, in, psi + nelonls + 1, pei, idx + 1, iei);

		return node;

	}

	public void kaway(int k, int data) {
		findandPrintKaway(root, k, data);

	}

	private int findandPrintKaway(Node node, int k, int data) {
		if (node == null) {
			return -1;
		}

		if (node.data == data) {
			printkDown(node, k);
			return 0;
		}

		int dfl = findandPrintKaway(node.left, k, data);
		if (dfl != -1) {
			if (dfl + 1 == k) {
				System.out.println(node.data);

			} else {
				this.printkDown(node.right, k - (dfl + 2));
			}
			return dfl + 1;
		}

		int dfr = findandPrintKaway(node.right, k, data);
		if (dfr != -1) {
			if (dfr + 1 == k) {
				System.out.println(node.data);

			} else {
				this.printkDown(node.right, k - (dfr + 2));
			}
			return dfr + 1;
		}

		return -1;

	}

	private void printkDown(Node node, int k) {
		if (node == null) {
			return;
		}

		if (k == 0) {
			System.out.println(node.data);

		}

		printkDown(node.left, k - 1);
		printkDown(node.right, k - 1);

	}

	public void printPathtoTargetSum(int k) {
		printPathtoTargetSum(root, "", k);
	}

	private void printPathtoTargetSum(Node node, String psf, int tar) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			if (tar == node.data) {
				System.out.println(psf + node.data);
			}
			return;
		}
		printPathtoTargetSum(node.left, psf + "L", tar - node.data);
		printPathtoTargetSum(node.right, psf + "R", tar - node.data);

	}

}
