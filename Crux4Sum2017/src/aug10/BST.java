package aug10;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import javax.xml.soap.Node;

public class BST {
	private class Node {
		int data;
		Node left;
		Node right;
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
		node.data = sa[mid];
		this.size++;

		node.left = construct(sa, lo, mid - 1);
		node.right = construct(sa, mid + 1, hi);

		return node;
	}

	private Node root;
	private int size;

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

		if (data > node.data) {
			return find(node.right, data);
		} else if (data < node.data) {
			return find(node.left, data);
		} else {
			return true;
		}
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

	public void rwsol() {
		HeapMover mover = new HeapMover();

		rwsol(root, mover);
		System.out.println(".");
	}

	private void rwsol(Node node, HeapMover mover) {
		if (node == null) {
			return;
		}

		rwsol(node.right, mover);

		// work
		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;

		// work

		rwsol(node.left, mover);
	}

	private class HeapMover {
		int sum = 0;
	}

	public void pir(int lo, int hi) {
		pir(root, lo, hi);
		System.out.println(".");
	}

	private void pir(Node node, int lo, int hi) {
		if (node == null) {
			return;
		}

		if (node.data < lo) {
			pir(node.right, lo, hi);
		} else if (node.data > hi) {
			pir(node.left, lo, hi);
		} else {
			System.out.print(node.data + ", ");
			pir(node.left, lo, hi);
			pir(node.right, lo, hi);
		}
	}

	public void add(int data) {
		add(root, data);
	}

	private void add(Node node, int data) {
		if (data > node.data) {
			if (node.right != null) {
				add(node.right, data);
			} else {
				node.right = new Node();
				node.right.data = data;
				this.size++;
			}
		} else if (data < node.data) {
			if (node.left != null) {
				add(node.left, data);
			} else {
				node.left = new Node();
				node.left.data = data;
				this.size++;
			}
		} else {
			// nothing to do - duplicate
		}
	}

	public void remove(int data) {
		remove(null, root, false, data);
	}

	public void remove(Node parent, Node child, boolean ilc, int data) {
		if (data > child.data) {
			remove(child, child.right, false, data);
		} else if (data < child.data) {
			remove(child, child.left, true, data);
		} else {
			// reached
			if (child.left != null && child.right != null) {
				int lmax = max(child.left);
				child.data = lmax;
				this.remove(child, child.left, true, lmax);
			} else {
				this.size--;
				if (ilc == true) {
					parent.left = child.left != null? child.left: child.right;
				} else {
					parent.right = child.left != null? child.left: child.right;
				}
			}
		}
	}

}
