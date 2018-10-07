package aug5;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public BinaryTree() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, false);
	}

	private Node takeInput(Scanner scn, Node parent, boolean ilc) {
		// prompt
		if (parent == null) {
			System.out.println("Data for root?");
		} else {
			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		// collect data
		int data = scn.nextInt();

		// create node, set data, increase size
		Node child = new Node();
		child.data = data;
		this.size++;

		// solve the left child of node
		System.out.println("Do you have a left child for " + child.data);
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			child.left = this.takeInput(scn, child, true);
		}

		// solve the right child of node
		System.out.println("Do you have a right child for " + child.data);
		boolean hrc = scn.nextBoolean();

		if (hrc) {
			child.right = this.takeInput(scn, child, false);
		}

		// return
		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String forprinting = forPrint(node);
		System.out.println(forprinting);

		display(node.left); // call to left subtree
		display(node.right); // call to right subtree
	}

	private String forPrint(Node node) {
		String rv = "";

		if (node.left != null) {
			rv += node.left.data + " -> ";
		} else {
			rv += ". -> ";
		}

		rv += node.data;

		if (node.right != null) {
			rv += " <- " + node.right.data;
		} else {
			rv += " <- .";
		}

		return rv;
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}

		int ls = size2(node.left);
		int rs = size2(node.right);
		return ls + rs + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lmax = max(node.left);
		int rmax = max(node.right);
		return Math.max(node.data, Math.max(lmax, rmax));
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int lh = height(node.left);
		int rh = height(node.right);
		return Math.max(lh, rh) + 1;
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

		boolean fil = find(node.left, data);

		if (fil == true) {
			return true;
		}

		boolean fir = find(node.right, data);

		if (fir == true) {
			return true;
		}

		return false;
	}

	public void preo() {
		preo(root);
		System.out.println(".");
	}

	private void preo(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + ", ");
		preo(node.left);
		preo(node.right);
	}

	public void posto() {
		posto(root);
		System.out.println(".");
	}

	private void posto(Node node) {
		if (node == null) {
			return;
		}

		posto(node.left);
		posto(node.right);
		System.out.print(node.data + ", ");
	}

	public void ino() {
		ino(root);
		System.out.println(".");
	}

	private void ino(Node node) {
		if (node == null) {
			return;
		}

		ino(node.left);
		System.out.print(node.data + ", ");
		ino(node.right);
	}

	private class Pair {
		Node node;
		boolean selfDone;
		boolean leftDone;
		boolean rightDone;
	}

	public void preoIterative() {
		Stack<Pair> stack = new Stack<>();

		Pair pairforroot = new Pair();
		pairforroot.node = root;

		stack.push(pairforroot);

		while (stack.size() != 0) {
			Pair toppair = stack.peek();

			if (toppair.selfDone == false) {
				toppair.selfDone = true;
				System.out.print(toppair.node.data + ", ");
			} else if (toppair.leftDone == false) {
				toppair.leftDone = true;

				if (toppair.node.left != null) {
					Pair pairforleft = new Pair();
					pairforleft.node = toppair.node.left;
					stack.push(pairforleft);
				}
			} else if (toppair.rightDone == false) {
				toppair.rightDone = true;

				if (toppair.node.right != null) {
					Pair pairforright = new Pair();
					pairforright.node = toppair.node.right;
					stack.push(pairforright);
				}
			} else {
				stack.pop();
			}
		}

		System.out.println(".");
	}

	public void postoIterative() {
		Stack<Pair> stack = new Stack<>();

		Pair pairforroot = new Pair();
		pairforroot.node = root;

		stack.push(pairforroot);

		while (stack.size() != 0) {
			Pair toppair = stack.peek();

			if (toppair.leftDone == false) {
				toppair.leftDone = true;

				if (toppair.node.left != null) {
					Pair pairforleft = new Pair();
					pairforleft.node = toppair.node.left;
					stack.push(pairforleft);
				}
			} else if (toppair.rightDone == false) {
				toppair.rightDone = true;

				if (toppair.node.right != null) {
					Pair pairforright = new Pair();
					pairforright.node = toppair.node.right;
					stack.push(pairforright);
				}
			} else if (toppair.selfDone == false) {
				toppair.selfDone = true;
				System.out.print(toppair.node.data + ", ");
			} else {
				stack.pop();
			}
		}

		System.out.println(".");
	}

	public void inoIterative() {
		Stack<Pair> stack = new Stack<>();

		Pair pairforroot = new Pair();
		pairforroot.node = root;

		stack.push(pairforroot);

		while (stack.size() != 0) {
			Pair toppair = stack.peek();

			if (toppair.leftDone == false) {
				toppair.leftDone = true;

				if (toppair.node.left != null) {
					Pair pairforleft = new Pair();
					pairforleft.node = toppair.node.left;
					stack.push(pairforleft);
				}
			} else if (toppair.selfDone == false) {
				toppair.selfDone = true;
				System.out.print(toppair.node.data + ", ");
			} else if (toppair.rightDone == false) {
				toppair.rightDone = true;

				if (toppair.node.right != null) {
					Pair pairforright = new Pair();
					pairforright.node = toppair.node.right;
					stack.push(pairforright);
				}
			} else {
				stack.pop();
			}
		}

		System.out.println(".");
	}

	public void levelo() {
		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(root);

		while (queue.size() != 0) {
			// 1.
			Node temp = queue.removeFirst();

			// 2.
			System.out.print(temp.data + ", ");

			// 3.
			if (temp.left != null) {
				queue.addLast(temp.left);
			}

			if (temp.right != null) {
				queue.addLast(temp.right);
			}
		}

		System.out.println(".");
	}

	public void levelolw() {
		LinkedList<Node> cl = new LinkedList<>();
		LinkedList<Node> nl = new LinkedList<>();

		cl.addLast(root);

		while (cl.size() != 0) {
			// 1.
			Node temp = cl.removeFirst();

			// 2.
			System.out.print(temp.data + ", ");

			// 3.
			if (temp.left != null) {
				nl.addLast(temp.left);
			}

			if (temp.right != null) {
				nl.addLast(temp.right);
			}

			// 4.
			if (cl.size() == 0) {
				cl = nl;
				nl = new LinkedList<>();
				System.out.println(".");
			}
		}

		System.out.println(".");
	}

	// maximum distance (in term of edges) btw any two nodes in the tree
	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int lh = height(node.left);
		int rh = height(node.right);

		int ld = diameter(node.left); // left ke farthest ka distance
		int rd = diameter(node.right); // right ke 2 farhtest ka distance
		int factor = lh + rh + 2; // left ke deppest se right ke deepst ka
									// distance

		return Math.max(factor, Math.max(ld, rd));
	}

	public int diameter2() {
		DiaPair pair = diameter2(root);
		return pair.diameter;
	}

	private DiaPair diameter2(Node node) {
		if (node == null) {
			DiaPair bp = new DiaPair();

			bp.height = -1;
			bp.diameter = 0;

			return bp;
		}

		DiaPair lp = diameter2(node.left);
		DiaPair rp = diameter2(node.right);

		DiaPair mp = new DiaPair();

		mp.height = Math.max(lp.height, rp.height) + 1;
		mp.diameter = Math.max(lp.height + rp.height + 2, Math.max(lp.diameter, rp.diameter));

		return mp;

	}

	private class DiaPair {
		int height;
		int diameter;
	}

	public boolean IsBalanced() {
		BalPair pair = IsBalanced(root);
		return pair.balanced;
	}

	private BalPair IsBalanced(Node node) {
		if (node == null) {
			BalPair bp = new BalPair();

			bp.height = -1;
			;
			bp.balanced = true;

			return bp;
		}

		BalPair lp = IsBalanced(node.left);
		BalPair rp = IsBalanced(node.right);

		BalPair mp = new BalPair();

		mp.height = Math.max(lp.height, rp.height) + 1;

		if (lp.balanced == false || rp.balanced == false) {
			mp.balanced = false;
		} else {
			int diff = Math.abs(lp.height - rp.height);

			if (diff > 1) {
				mp.balanced = false;
			} else {
				mp.balanced = true;
			}
		}

		return mp;
	}

	private class BalPair {
		int height;
		boolean balanced;
	}

	public boolean IsBST() {
		BSTPair pair = IsBST(root);

		System.out.println(pair.lBSTRoot.data);
		System.out.println(pair.lBSTSize);

		return pair.isBST;
	}

	private BSTPair IsBST(Node node) {
		if (node == null) {
			BSTPair bp = new BSTPair();

			bp.isBST = true;
			bp.min = Integer.MAX_VALUE;
			bp.max = Integer.MIN_VALUE;
			bp.lBSTRoot = null;
			bp.lBSTSize = 0;

			return bp;
		}

		BSTPair lp = IsBST(node.left);
		BSTPair rp = IsBST(node.right);

		BSTPair mp = new BSTPair();

		mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
		mp.min = Math.min(node.data, Math.min(lp.min, rp.min));

		if (lp.isBST == false || rp.isBST == false) {
			mp.isBST = false;
		} else {
			if (node.data > lp.max && node.data < rp.min) {
				mp.isBST = true;
			} else {
				mp.isBST = false;
			}
		}

		// quest
		if (mp.isBST == true) {
			mp.lBSTRoot = node;
			mp.lBSTSize = lp.lBSTSize + rp.lBSTSize + 1;
		} else {
			if (lp.lBSTSize > rp.lBSTSize) {
				mp.lBSTRoot = lp.lBSTRoot;
				mp.lBSTSize = lp.lBSTSize;
			} else {
				mp.lBSTRoot = rp.lBSTRoot;
				mp.lBSTSize = rp.lBSTSize;
			}
		}

		return mp;
	}

	private class BSTPair {
		boolean isBST;
		int min;
		int max;
		Node lBSTRoot;
		int lBSTSize;
	}

	public void pws() {
		pws(null, root, false);
		System.out.println(".");
	}

	private void pws(Node parent, Node node, boolean ilc) {
		if (node == null) {
			return;
		}

		// print
		if (parent != null) {
			if (ilc == true && parent.right == null) {
				System.out.print(node.data + ", ");
			}

			if (ilc == false && parent.left == null) {
				System.out.print(node.data + ", ");
			}
		}

		pws(node, node.left, true);
		pws(node, node.right, false);
	}

	public void removeLeaves() {
		removeLeaves(null, root, false);
	}

	private void removeLeaves(Node parent, Node node, boolean ilc) {
		if(node == null){
			return;
		}
		
		if(node.left == null && node.right == null){
			if(ilc == true){
				parent.left = null;
			} else {
				parent.right = null;
			}
			this.size--;
		}
		
		removeLeaves(node, node.left, true);
		removeLeaves(node, node.right, false);
	}
}
