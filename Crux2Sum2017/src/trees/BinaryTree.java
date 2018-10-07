package trees;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public BinaryTree(int[] pre, int[] in){
		this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}
	
	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi){
		if(plo > phi){
			return null;
		}
		
		// create and attach data
		Node node = new Node();
		this.size++;
		
		node.data = pre[plo];
		
		// search in ino -> to know the number of elements on left side
		int srchIdx = -1;
		for(int i = ilo; i <= ihi; i++){
			if(in[i] == pre[plo]){
				srchIdx = i;
				break;
			}
		}
		
		int nelOnls = srchIdx - ilo;
		
		// set left
		node.left = this.construct(pre, plo + 1, plo + nelOnls, in, ilo, ihi);
		
		// set right
		node.right = this.construct(pre, plo + nelOnls + 1, phi, in, ilo, ihi);
		
		return node;
	}
	
 	public BinaryTree() {
		this.root = this.takeInput(new Scanner(System.in), null, false);
	}

	public Node takeInput(Scanner scn, Node parent, boolean ilc) {
		// prompt
		if (parent == null) {
			System.out.println("Enter the root");
		} else {
			if (ilc) {
				System.out.println("Enter the left child for " + parent.data);
			} else {
				System.out.println("Enter the right child for " + parent.data);
			}
		}

		// collect data and create node
		int cdata = scn.nextInt();
		Node child = new Node();
		child.data = cdata;
		this.size++;

		// left
		System.out.println("Do you have a left child for " + child.data);
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			child.left = this.takeInput(scn, child, true);
		}

		// right
		System.out.println("Do you have a right child for " + child.data);
		boolean hrc = scn.nextBoolean();

		if (hrc) {
			child.right = this.takeInput(scn, child, false);
		}

		// return
		return child;
	}

	public void display() {
		this.display(this.root);
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

		str += " => " + node.data + " <= ";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}

		System.out.println(str);

		this.display(node.left);
		this.display(node.right);
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}

		int ls = this.size2(node.left);
		int rs = this.size2(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lm = this.max(node.left);
		int rm = this.max(node.right);
		return Math.max(node.data, Math.max(lm, rm));
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int lh = this.height(node.left);
		int rh = this.height(node.right);
		return Math.max(lh, rh) + 1;
	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		}

		boolean fil = this.find(node.left, data);
		if (fil) {
			return true;
		}

		boolean fir = this.find(node.right, data);
		if (fir) {
			return true;
		} else {
			return false;
		}
	}

	public int diameter() {
		return this.diameter(this.root);
	}
 
	public int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int ld = this.diameter(node.left); // on the left subtree what is
											// maximum edge distance between any
											// pair of nodes
		int rd = this.diameter(node.right); // on the right subtree what is
											// maximum edge distance between any
											// pair of nodes

		int lh = this.height(node.left);
		int rh = this.height(node.right);

		int rootFactor = lh + rh + 2;
		return Math.max(rootFactor, Math.max(ld, rd));
	}

	public int diameter2() {
		return this.diameter2(this.root).diameter;
	}

	public DiaPair diameter2(Node node) {
		if (node == null) {
			DiaPair bp = new DiaPair();

			bp.height = -1;
			bp.diameter = 0;

			return bp;
		}

		DiaPair lp = this.diameter2(node.left);
		DiaPair rp = this.diameter2(node.right);

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
		return this.IsBalanced(this.root).isBalanced;
	}

	private BalancedPair IsBalanced(Node node) {
		if (node == null) {
			BalancedPair bp = new BalancedPair();

			bp.height = -1;
			bp.isBalanced = true;

			return bp;
		}

		BalancedPair lp = IsBalanced(node.left);
		BalancedPair rp = IsBalanced(node.right);

		BalancedPair mp = new BalancedPair();

		mp.height = Math.max(lp.height, rp.height) + 1;

		if (lp.isBalanced && rp.isBalanced && Math.abs(lp.height - rp.height) <= 1) {
			mp.isBalanced = true;
		} else {
			mp.isBalanced = false;
		}

		return mp;
	}

	private class BalancedPair {
		int height;
		boolean isBalanced;
	}

	public boolean IsBST() {
		BSTPair bstp = IsBST(this.root);

		System.out.println(bstp.largestBSTRoot.data);
		System.out.println(bstp.size);

		return bstp.isBST;
	}

	private BSTPair IsBST(Node node) {
		if (node == null) {
			BSTPair bp = new BSTPair();

			bp.isBST = true;
			bp.max = Integer.MIN_VALUE;
			bp.min = Integer.MAX_VALUE;
			bp.largestBSTRoot = null;
			bp.size = 0;

			return bp;
		}

		BSTPair lp = this.IsBST(node.left);
		BSTPair rp = this.IsBST(node.right);

		BSTPair mp = new BSTPair();
		mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
		mp.min = Math.min(node.data, Math.min(lp.min, rp.min));

		if (lp.isBST && rp.isBST && node.data > lp.max && node.data < rp.min) {
			mp.isBST = true;
			mp.largestBSTRoot = node;
			mp.size = lp.size + rp.size + 1;
		} else {
			mp.isBST = false;

			if (lp.size > rp.size) {
				mp.largestBSTRoot = lp.largestBSTRoot;
				mp.size = lp.size;
			} else {
				mp.largestBSTRoot = rp.largestBSTRoot;
				mp.size = rp.size;
			}
		}

		return mp;
	}

	private class BSTPair {
		boolean isBST;
		int min;
		int max;
		int size;
		Node largestBSTRoot;
	}

	public void preOrder() {
		this.preOrder(this.root);
		System.out.println(".");
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + ", ");
		this.preOrder(node.left);
		this.preOrder(node.right);
	}

	public void postOrder() {
		this.postOrder(this.root);
		System.out.println(".");
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}

		this.postOrder(node.left);
		this.postOrder(node.right);
		System.out.print(node.data + ", ");
	}

	public void inOrder() {
		this.inOrder(this.root);
		System.out.println(".");
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}

		this.inOrder(node.left);
		System.out.print(node.data + ", ");
		this.inOrder(node.right);
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);

		while (queue.size() != 0) {
			Node temp = queue.removeFirst();

			System.out.print(temp.data + ", ");

			if (temp.left != null) {
				queue.addLast(temp.left);
			}

			if (temp.right != null) {
				queue.addLast(temp.right);
			}
		}

		System.out.println("");
	}

	public void preOrderI() {
		LinkedList<OrderPair> stack = new LinkedList<>();

		stack.addFirst(new OrderPair(this.root));
		while (stack.size() != 0) {
			OrderPair temp = stack.getFirst();

			if (temp.selfDone == false) {
				System.out.print(temp.node.data + ", ");
				temp.selfDone = true;
			} else if (temp.leftDone == false) {
				if (temp.node.left != null) {
					OrderPair leftPair = new OrderPair(temp.node.left);
					stack.addFirst(leftPair);
				}
				temp.leftDone = true;
			} else if (temp.rightDone == false) {
				if (temp.node.right != null) {
					OrderPair rightPair = new OrderPair(temp.node.right);
					stack.addFirst(rightPair);
				}
				temp.rightDone = true;
			} else {
				stack.removeFirst();
			}
		}
		System.out.println();
	}

	public void inOrderI() {
		LinkedList<OrderPair> stack = new LinkedList<>();

		stack.addFirst(new OrderPair(this.root));
		while (stack.size() != 0) {
			OrderPair temp = stack.getFirst();

			if (temp.leftDone == false) {
				if (temp.node.left != null) {
					OrderPair leftPair = new OrderPair(temp.node.left);
					stack.addFirst(leftPair);
				}
				temp.leftDone = true;
			} else if (temp.selfDone == false) {
				System.out.print(temp.node.data + ", ");
				temp.selfDone = true;
			} else if (temp.rightDone == false) {
				if (temp.node.right != null) {
					OrderPair rightPair = new OrderPair(temp.node.right);
					stack.addFirst(rightPair);
				}
				temp.rightDone = true;
			} else {
				stack.removeFirst();
			}
		}
		System.out.println();
	}

	public void postOrderI() {
		LinkedList<OrderPair> stack = new LinkedList<>();

		stack.addFirst(new OrderPair(this.root));
		while (stack.size() != 0) {
			OrderPair temp = stack.getFirst();

			if (temp.leftDone == false) {
				if (temp.node.left != null) {
					OrderPair leftPair = new OrderPair(temp.node.left);
					stack.addFirst(leftPair);
				}
				temp.leftDone = true;
			} else if (temp.rightDone == false) {
				if (temp.node.right != null) {
					OrderPair rightPair = new OrderPair(temp.node.right);
					stack.addFirst(rightPair);
				}
				temp.rightDone = true;
			} else if (temp.selfDone == false) {
				System.out.print(temp.node.data + ", ");
				temp.selfDone = true;
			} else {
				stack.removeFirst();
			}
		}
		System.out.println();
	}

	private class OrderPair {
		Node node;

		boolean selfDone;
		boolean leftDone;
		boolean rightDone;

		OrderPair(Node node) {
			this.node = node;
		}
	}

	public void printSiblingLess() {
		this.printSiblingLess(null, this.root, false);
	}

	private void printSiblingLess(Node parent, Node child, boolean ilc) {
		if (child == null) {
			return;
		}
		
		// work
		if(ilc == true && parent.right == null){
			System.out.println(child.data);
		}
		
		if(ilc == false && parent.left == null){
			System.out.println(child.data);
		}

		this.printSiblingLess(child, child.left, true);
		this.printSiblingLess(child, child.right, false);
	}
	
	public void removeLeaves() {
		this.removeLeaves(null, this.root, false);
	}

	private void removeLeaves(Node parent, Node child, boolean ilc) {
		if (child == null) {
			return;
		}
		
		// work
		
		if(child.left == null && child.right == null){
			if(ilc){
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		

		this.removeLeaves(child, child.left, true);
		this.removeLeaves(child, child.right, false);
	}

}
