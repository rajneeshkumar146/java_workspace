package july17;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	Node root;

	public BinaryTree(int[] arr) {
		LinkedList<Node> stack = new LinkedList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				Node top = stack.removeFirst();

				if (stack.size() == 0) {
					root = top;
				} else {
					if (stack.getFirst().left == null) {
						stack.getFirst().left = top;
					} else {
						stack.getFirst().right = top;
					}
				}
			} else {
				stack.addFirst(new Node(arr[i]));
			}
		}
	}

	public BinaryTree(int[] preo, int[] ino) {
		root = construct2(preo, ino, 0, preo.length - 1, 0, ino.length - 1);
	}

	private Node construct2(int[] posto, int[] ino, int psi, int pei, int isi, int iei) {
		if (psi > pei || isi > iei) {
			return null;
		}

		// 1. create a node and set data
		Node node = new Node(posto[pei]);

		// 2. searching
		int idx = -1;
		for (int i = isi; i <= iei; i++) {
			if (posto[pei] == ino[i]) {
				idx = i;
				break;
			}
		}
		int rhs = iei - idx;

		// 4. make a call for right
		node.right = construct2(posto, ino, pei - rhs, pei - 1, idx + 1, iei);

		// 3. think for its left - make a call
		node.left = construct2(posto, ino, psi, pei - rhs - 1, isi, idx - 1);

		// 5. return
		return node;
	}

	private Node construct(int[] preo, int[] ino, int psi, int pei, int isi, int iei) {
		if (psi > pei || isi > iei) {
			return null;
		}

		// 1. create a node and set data
		Node node = new Node(preo[psi]);

		// 2. searching
		int idx = -1;
		for (int i = isi; i <= iei; i++) {
			if (preo[psi] == ino[i]) {
				idx = i;
				break;
			}
		}
		int lhs = idx - isi;

		// 3. think for its left - make a call
		node.left = construct(preo, ino, psi + 1, psi + lhs, isi, idx - 1);

		// 4. make a call for right
		node.right = construct(preo, ino, psi + lhs + 1, pei, idx + 1, iei);

		// 5. return
		return node;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str = node.left != null ? node.left.data + " " : "-1 ";
		str += "<- " + node.data + " ->";
		str += node.right != null ? " " + node.right.data : " -1";

		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}

		int lsize = size(node.left);
		int rsize = size(node.right);
		return lsize + rsize + 1;
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
			return -1; // edges -> -1, nodes -> 0
		}

		int lheight = height(node.left);
		int rheight = height(node.right);

		return Math.max(lheight, rheight) + 1;
	}

	public boolean find(int data) {
		return findSmarter(root, data);
	}

	// private boolean find(Node node, int data){
	// if(node == null){
	// return false;
	// }
	//
	// boolean fil = find(node.left, data);
	// boolean fir = find(node.right, data);
	//
	// return fil || fir || node.data == data;
	// }

	private boolean findSmarter(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		}

		boolean fil = findSmarter(node.left, data);
		if (fil == true) {
			return true;
		}

		boolean fir = findSmarter(node.right, data);
		if (fir == true) {
			return true;
		}

		return false;
	}

	public ArrayList<Integer> nodeToRootPath(int data) {
		return nodeToRootPath(root, data);
	}

	private ArrayList<Integer> nodeToRootPath(Node node, int data) {
		if (node == null) {
			return new ArrayList<>();
		}

		if (node.data == data) {
			ArrayList<Integer> path = new ArrayList<>();
			path.add(node.data);
			return path;
		}

		ArrayList<Integer> lpath = nodeToRootPath(node.left, data);
		if (lpath.size() > 0) {
			lpath.add(node.data);
			return lpath;
		}

		ArrayList<Integer> rpath = nodeToRootPath(node.right, data);
		if (rpath.size() > 0) {
			rpath.add(node.data);
			return rpath;
		}

		return new ArrayList<>();

	}

	public void printRootToLeafPathsInRange(int lo, int hi) {
		printRootToLeafPathsInRange(root, "", 0, lo, hi);
	}

	private void printRootToLeafPathsInRange(Node node, String psf, int ssf, int lo, int hi) {
		if (node.left == null && node.right == null) {
			if (ssf + node.data >= lo && ssf + node.data <= hi) {
				System.out.println(psf + node.data);
			}
		}

		if (node.left != null) {
			printRootToLeafPathsInRange(node.left, psf + node.data, ssf + node.data, lo, hi);
		}

		if (node.right != null) {
			printRootToLeafPathsInRange(node.right, psf + node.data, ssf + node.data, lo, hi);
		}
	}

	public void removeLeaves() {
		// removeLeaves1(root, root.left);
		// removeLeaves1(root, root.right);
		// removeLeaves2(root);
		root = removeLeaves3(root);
	}

	private void removeLeaves1(Node parent, Node node) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			if (parent.left == node) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			return;
		}

		removeLeaves1(node, node.left);
		removeLeaves1(node, node.right);
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

	private Node removeLeaves3(Node node) {
		if (node == null) {
			return null;
		}

		if (node.left == null && node.right == null) {
			return null;
		}

		node.left = removeLeaves3(node.left);
		node.right = removeLeaves3(node.right);

		return node;
	}

	public void printSingleChild() {
		printSingleChild(root);
	}

	private void printSingleChild(Node node) {
		if (node == null) {
			return;
		}

		if (node.left != null && node.right == null) {
			System.out.println(node.left.data);
		} else if (node.right != null && node.left == null) {
			System.out.println(node.right.data);
		}

		printSingleChild(node.left);
		printSingleChild(node.right);
	}

	public void printStepsFar(int data, int steps) {
		ArrayList<Node> path = nodeToRootPath1(root, data);

		for (int i = 0; i < path.size() && i <= steps; i++) {
			printStepsDown(path.get(i), steps - i, i == 0 ? null : path.get(i - 1));
		}
	}

	private ArrayList<Node> nodeToRootPath1(Node node, int data) {
		if (node == null) {
			return new ArrayList<>();
		}

		if (node.data == data) {
			ArrayList<Node> path = new ArrayList<>();
			path.add(node);
			return path;
		}

		ArrayList<Node> lpath = nodeToRootPath1(node.left, data);
		if (lpath.size() > 0) {
			lpath.add(node);
			return lpath;
		}

		ArrayList<Node> rpath = nodeToRootPath1(node.right, data);
		if (rpath.size() > 0) {
			rpath.add(node);
			return rpath;
		}

		return new ArrayList<>();

	}

	private void printStepsDown(Node node, int steps, Node obstacle) {
		if (node == null || node == obstacle) {
			return;
		}

		if (steps == 0) {
			System.out.println(node.data);
			return;
		}

		printStepsDown(node.left, steps - 1, obstacle);
		printStepsDown(node.right, steps - 1, obstacle);
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);

		while (queue.size() > 0) {
			Node rem = queue.removeFirst();
			System.out.print(rem.data + " ");

			if (rem.left != null) {
				queue.addLast(rem.left);
			}

			if (rem.right != null) {
				queue.addLast(rem.right);
			}
		}

		System.out.println(".");
	}

	public void preo() {
		preo(root);
		System.out.println(".");
	}

	private void preo(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
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
		System.out.print(node.data + " ");
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
		System.out.print(node.data + " ");
		ino(node.right);
	}

	public int diameter() {
		return diameter(root);
	}

	// distance between farthest pair of nodes
	// both may belong to left side, or right side, or one to the left and
	// another to the right
	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		// max distance between pair of nodes, one to the left of node and
		// another to right
		int lh = height(node.left); // distance of deepst on left from left
		int rh = height(node.right);

		int factorleftRight = lh + rh + 2; // 2 for distance betwen left and
											// right
		// 2 for edges, 1 for node

		int ld = diameter(node.left); // faith, that it will give the distance
										// between farthest nodes of left side
		int rd = diameter(node.right);

		return Math.max(factorleftRight, Math.max(ld, rd));
	}

	private class DiaPair {
		int height;
		int diameter;
	}

	public int diameter2() {
		DiaPair dp = diameter2(root);
		return dp.diameter;
	}

	private DiaPair diameter2(Node node) {
		if (node == null) {
			DiaPair bp = new DiaPair();

			bp.height = -1;
			bp.diameter = 0;

			return bp;
		}

		DiaPair mp = new DiaPair();

		DiaPair lp = diameter2(node.left);
		DiaPair rp = diameter2(node.right);

		mp.diameter = Math.max(lp.height + rp.height + 2, Math.max(lp.diameter, rp.diameter));
		mp.height = Math.max(lp.height, rp.height) + 1;

		return mp;
	}

	public boolean isBalanced() {
		// return isBalanced(root);
		BalPair bp = isBalanced2(root);
		return bp.isBalanced;
	}

	private boolean isBalanced(Node node) {
		if (node == null) {
			return true;
		}

		boolean ilb = isBalanced(node.left);
		if (ilb == false) {
			return false;
		}

		boolean irb = isBalanced(node.right);
		if (irb == false) {
			return false;
		}

		int lh = height(node.left);
		int rh = height(node.right);
		int delta = Math.abs(lh - rh);

		if (delta <= 1) {
			return true;
		} else {
			return false;
		}
	}

	private class BalPair {
		int height;
		boolean isBalanced;
	}

	private BalPair isBalanced2(Node node) {
		if (node == null) {
			BalPair bp = new BalPair();

			bp.isBalanced = true;
			bp.height = -1;

			return bp;
		}

		BalPair lp = isBalanced2(node.left);
		if (lp.isBalanced == false) {
			return lp;
		}

		BalPair rp = isBalanced2(node.right);
		if (rp.isBalanced == false) {
			return rp;
		}

		BalPair mp = new BalPair();
		mp.height = Math.max(lp.height, rp.height) + 1;

		int delta = Math.abs(lp.height - rp.height);
		if (delta > 1) {
			mp.isBalanced = false;
		} else {
			mp.isBalanced = true;
		}

		return mp;
	}

	private class BSTPair {
		boolean isBST;
		int min;
		int max;
	}

	public boolean isBST() {
		BSTPair bst = isBST(root);
		return bst.isBST;
	}

	private BSTPair isBST(Node node) {
		if (node == null) {
			BSTPair bp = new BSTPair();

			bp.isBST = true;
			bp.max = Integer.MIN_VALUE;
			bp.min = Integer.MAX_VALUE;

			return bp;
		}

		BSTPair lp = isBST(node.left);
		BSTPair rp = isBST(node.right);

		BSTPair mp = new BSTPair();

		mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
		mp.min = Math.min(node.data, Math.min(lp.min, rp.min));

		if (lp.isBST && rp.isBST && node.data > lp.max && node.data < rp.min) {
			mp.isBST = true;
		}

		return mp;
	}

	private class TPair {
		Node node;
		boolean myselfProcessed;
		boolean leftProcessed;
		boolean rightProcessed;
	}

	public void traversalIterative() {
		LinkedList<TPair> stack = new LinkedList<>();

		TPair rootpair = new TPair();
		rootpair.node = root;
		stack.addFirst(rootpair);

		while (stack.size() > 0) {
			TPair tos = stack.getFirst();

			if (!tos.leftProcessed) {
				tos.leftProcessed = true;

				if (tos.node.left != null) {
					TPair lp = new TPair();
					lp.node = tos.node.left;
					stack.addFirst(lp);
				}
			} else if (!tos.rightProcessed) {
				tos.rightProcessed = true;

				if (tos.node.right != null) {
					TPair rp = new TPair();
					rp.node = tos.node.right;
					stack.addFirst(rp);
				}
			} else if (!tos.myselfProcessed) {
				tos.myselfProcessed = true;
				System.out.print(tos.node.data + " ");
			} else {
				stack.removeFirst();
			}
		}
		System.out.println(".");
	}

	public void lca(int d1, int d2) {
		Node node = lca(root, d1, d2);
		if (node == null) {
			System.out.println("Not found");
		} else {
			System.out.println(node.data);
		}
	}

	static Node lca = null;
	static boolean found = false;

	private Node lca(Node node, int d1, int d2) {
		if (node == null) {
			return null;
		}

		Node slca = null;
		if (node.data == d1 || node.data == d2) {
			slca = node;
		}

		Node llca = !found? lca(node.left, d1, d2): null;
		Node rlca = !found? lca(node.right, d1, d2): null;

		if ((slca != null && llca != null) || 
			(slca != null && rlca != null) || 
			(llca != null && rlca != null)) {
			lca = node;
			found = true;
			return node;
		} else {
			return slca != null ? slca : llca != null ? llca : rlca;
		}
	}
}
