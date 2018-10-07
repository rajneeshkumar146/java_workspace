package july12;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.LinkedList;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data) {
			this.data = data;
		}
	}

	Node root;

	public GenericTree() {
		root = new Node(10);

		Node l1c1 = new Node(20);
		Node l1c2 = new Node(30);
		Node l1c3 = new Node(40);
		root.children.add(l1c1);
		root.children.add(l1c2);
		root.children.add(l1c3);

		Node l2c1 = new Node(50);
		Node l2c2 = new Node(60);
		l1c1.children.add(l2c1);
		l1c1.children.add(l2c2);

		Node l2c3 = new Node(70);
		Node l2c4 = new Node(80);
		Node l2c5 = new Node(90);
		l1c2.children.add(l2c3);
		l1c2.children.add(l2c4);
		l1c2.children.add(l2c5);

		Node l2c6 = new Node(100);
		l1c3.children.add(l2c6);

		Node l3c1 = new Node(110);
		Node l3c2 = new Node(120);
		l2c4.children.add(l3c1);
		l2c4.children.add(l3c2);
	}

	public GenericTree(int[] arr) {
		LinkedList<Node> stack = new LinkedList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				Node nattop = stack.removeFirst();

				if (stack.size() > 0) {
					Node nattopnow = stack.getFirst();
					nattopnow.children.add(nattop);
				} else {
					root = nattop;
				}
			} else {
				stack.addFirst(new Node(arr[i]));
			}
		}
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		String str = node.data + " -> ";
		for (Node child : node.children) {
			str += child.data + ", ";
		}

		System.out.println(str + ".");

		for (Node child : node.children) {
			display(child);
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		int ps = 0;
		for (Node child : node.children) {
			int cs = size(child);
			ps += cs;
		}

		ps += 1; // for the parent himself
		return ps;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int max = node.data;

		for (Node child : node.children) {
			int cm = max(child);
			if (cm > max) {
				max = cm;
			}
		}

		return max;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int maxch = -1; // -1 for edges and 0 for nodes

		for (Node child : node.children) {
			int ch = height(child);
			if (ch > maxch) {
				maxch = ch;
			}
		}

		return maxch + 1;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}

		for (Node child : node.children) {
			boolean found = find(child, data);
			if (found == true) {
				return true;
			}
		}

		return false;
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		for (Node child : node.children) {
			mirror(child);
		}

		// Collections.reverse(node.children);
		int left = 0;
		int right = node.children.size() - 1;
		while (left <= right) {
			Node leftn = node.children.get(left);
			Node rightn = node.children.get(right);
			node.children.set(left, rightn);
			node.children.set(right, leftn);

			left++;
			right--;
		}
	}

	public void removeLeaves() {
		removeLeaves(root);
	}

	private void removeLeaves(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);

			if (child.children.size() == 0) {
				node.children.remove(i);
			} else {
				removeLeaves(child);
			}
		}
	}

	public void linearize() {
		linearize(root);
	}

	// returns tail
	private Node linearize(Node node) {
		if (node.children.size() == 0) {
			return node;
		}

		Node lastkitail = linearize(node.children.get(node.children.size() - 1));

		for (int i = node.children.size() - 1; i > 0; i--) {
			Node im1thkitail = linearize(node.children.get(i - 1));
			im1thkitail.children.add(node.children.remove(i));
		}

		return lastkitail;
	}

	// bfs
	public void levelorder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);

		while (queue.size() > 0) {
			// 1. remove
			Node rem = queue.removeFirst();

			// 2. print
			System.out.print(rem.data + " ");

			// 3. add child
			for (Node child : rem.children) {
				queue.addLast(child);
			}
		}

		System.out.println(".");
	}

	public void levelorderLW() {
		LinkedList<Node> clqueue = new LinkedList<>();
		LinkedList<Node> nlqueue = new LinkedList<>();

		clqueue.addLast(root);

		while (clqueue.size() > 0) {
			// 1. remove
			Node rem = clqueue.removeFirst();

			// 2. print
			System.out.print(rem.data + " ");

			// 3. add child
			for (Node child : rem.children) {
				nlqueue.addLast(child);
			}

			if (clqueue.size() == 0) {
				System.out.println();
				clqueue = nlqueue;
				nlqueue = new LinkedList<>();
			}
		}

		System.out.println(".");
	}

	public void levelorderLWZZ() {
		LinkedList<Node> clq = new LinkedList<>();
		LinkedList<Node> nls = new LinkedList<>();
		boolean l2r = true;

		clq.addLast(root);
		while (clq.size() > 0) {
			Node rem = clq.removeFirst();
			System.out.print(rem.data + " ");

			if (l2r) {
				for (int i = 0; i < rem.children.size(); i++) {
					Node child = rem.children.get(i);
					nls.addFirst(child);
				}
			} else {
				for (int i = rem.children.size() - 1; i >= 0; i--) {
					Node child = rem.children.get(i);
					nls.addFirst(child);
				}
			}

			if (clq.size() == 0) {
				System.out.println();
				clq = nls;
				nls = new LinkedList<>();
				l2r = !l2r;
			}
		}
	}

	public void preo() {
		preo(root);
		System.out.println(".");
	}

	private void preo(Node node) {
		System.out.print(node.data + " ");
		for (Node child : node.children) {
			preo(child);
		}
	}

	public void posto() {
		posto(root);
		System.out.println(".");
	}

	private void posto(Node node) {
		for (Node child : node.children) {
			posto(child);
		}
		System.out.print(node.data + " ");
	}

	private class HeapMover {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int size = 0;
		int height = -1;
		boolean find = false;

		int jl = Integer.MAX_VALUE;
		int js = Integer.MIN_VALUE;

		Node pred = null;
		Node succ = null;
		Node prev = null;
	}

	public void multisolver(int data) {

		HeapMover results = new HeapMover();
		multisolver(root, results, 0, data);

		System.out.println("Size = " + results.size);
		System.out.println("Min = " + results.min);
		System.out.println("Max = " + results.max);
		System.out.println("Height = " + results.height);
		System.out.println("Find = " + results.find);

		System.out.println("Pred = " + (results.pred != null ? results.pred.data : "Not Found"));
		System.out.println("Succ = " + (results.succ != null ? results.succ.data : "Not Found"));
		System.out.println("JL = " + results.jl);
	}

	private void multisolver(Node node, HeapMover results, int depth, int data) {
		results.size++;
		results.min = Math.min(results.min, node.data);
		results.max = Math.max(results.max, node.data);
		results.height = Math.max(results.height, depth);
		results.find = results.find || node.data == data;

		if (node.data > data) {
			results.jl = Math.min(results.jl, node.data);
		}

		if (node.data < data) {
			results.js = Math.max(results.js, node.data);
		}

		// here prev is one step behind
		if (node.data == data) {
			results.pred = results.prev;
		}
		if (results.prev != null && results.prev.data == data) {
			results.succ = node;
		}

		results.prev = node;

		for (Node child : node.children) {
			multisolver(child, results, depth + 1, data);
		}
	}

	public int kthLargest(int k) {
		HeapMover results = new HeapMover();
		int data = Integer.MAX_VALUE;

		for (int i = 0; i < k; i++) {
			multisolver(root, results, 0, data);
			data = results.js;
			results.js = Integer.MIN_VALUE;
		}

		return data;
	}

	public ArrayList<Integer> serialize() {
		return serialize(root);
	}

	private ArrayList<Integer> serialize(Node node) {
		if (node.children.size() == 0) {
			ArrayList<Integer> bres = new ArrayList<>();
			bres.add(node.data);
			bres.add(-1);
			return bres;
		}

		ArrayList<Integer> mres = new ArrayList<>();
		mres.add(node.data);
		for (Node child : node.children) {
			ArrayList<Integer> rres = serialize(child);
			mres.addAll(rres);
		}
		mres.add(-1);
		return mres;
	}

	public boolean isIsomorphic(GenericTree other) {
		return isIsomorphic(this.root, other.root);
	}

	private boolean isIsomorphic(Node tnode, Node onode) {
		if (tnode.children.size() != onode.children.size()) {
			return false;
		}

		for (int i = 0; i < tnode.children.size(); i++) {
			Node tchild = tnode.children.get(i);
			Node ochild = onode.children.get(i);

			boolean areChildIso = isIsomorphic(tchild, ochild);
			if (areChildIso == false) {
				return false;
			}
		}

		return true;
	}

	public boolean isMirrorImage(GenericTree other) {
		return isMirrorImage(this.root, other.root);
	}

	private boolean isMirrorImage(Node tnode, Node onode) {
		if (tnode.children.size() != onode.children.size()) {
			return false;
		}

		for (int i = 0; i < tnode.children.size(); i++) {
			Node tchild = tnode.children.get(i);
			Node ochild = onode.children.get(onode.children.size() - 1 - i);

			boolean areChildMirror = isMirrorImage(tchild, ochild);
			if (areChildMirror == false) {
				return false;
			}
		}

		return true;
	}

	public boolean isFoldable() {
		return isMirrorImage(this.root, this.root);
	}

}
