package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public GenericTree() {
		this.root = this.takeInput(new Scanner(System.in), null, -1);
	}

	// create ith child for parent and return that
	private Node takeInput(Scanner scn, Node parent, int i) {
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			System.out.println("Enter the data for " + i + " child of " + parent.data);
		}

		int childData = scn.nextInt();

		System.out.println("Enter the number of children for " + childData);
		int numGC = scn.nextInt();

		Node child = new Node();
		child.data = childData;
		this.size++;

		for (int j = 0; j < numGC; j++) {
			Node gc = this.takeInput(scn, child, j);
			child.children.add(gc);
		}

		return child;
	}

	public void display() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		this.display(this.root);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	private void display(Node node) {
		// work
		String str = node.data + "=>";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		System.out.println(str + ".");

		// delegate
		for (Node child : node.children) {
			this.display(child);
		}
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
		int size = 0;
		for (Node child : node.children) {
			int csize = this.size2(child);
			size += csize;
		}

		return 1 + size; // for the node itself
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		int max = node.data;

		for (Node child : node.children) {
			int cmax = this.max(child);
			max = Math.max(max, cmax);
		}

		return max;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		int mh = -1;

		for (Node child : node.children) {
			int ch = this.height(child);
			mh = Math.max(mh, ch);
		}

		return mh + 1;
	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}

		for (Node child : node.children) {
			boolean fic = this.find(child, data);
			if (fic) {
				return true;
			}
		}

		return false;
	}

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node node) {
		for (Node child : node.children) {
			this.mirror(child);
		}

		int li = 0, ri = node.children.size() - 1;
		while (li < ri) {
			Node left = node.children.get(li);
			Node right = node.children.get(ri);
			node.children.set(li, right);
			node.children.set(ri, left);

			li++;
			ri--;
		}
	}

	public void preOrder() {
		this.preOrder(this.root);
		System.out.println(".");
	}

	private void preOrder(Node node) {
		System.out.print(node.data + "\t");

		for (Node child : node.children) {
			this.preOrder(child);
		}
	}

	public void postOrder() {
		this.postOrder(this.root);
		System.out.println(".");
	}

	private void postOrder(Node node) {
		// System.out.println("Hi" + node.data + "\t");
		for (Node child : node.children) {
			// System.out.println("To the next child " + node.data + ":" +
			// child.data);
			this.postOrder(child);
		}
		// System.out.println("Bye" + node.data + "\t");
		System.out.print(node.data + "\t");
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(this.root);
		while (!queue.isEmpty()) {
			// de
			Node node = queue.removeFirst();

			// print
			System.out.print(node.data + "\t");

			// en child
			for (Node child : node.children) {
				queue.addLast(child);
			}
		}
		System.out.println(".");
	}

	public void preOrderI2() {
		LinkedList<PreOPair> stack = new LinkedList<>();

		PreOPair pair = new PreOPair();
		pair.node = this.root;
		stack.addFirst(pair);

		while (!stack.isEmpty()) {
			PreOPair prnt = stack.getFirst();

			if (prnt.self == false) {
				System.out.println(prnt.node.data + " via " + prnt.ptillme);
				prnt.self = true;
			} else if (prnt.childrenDone < prnt.node.children.size()) {
				PreOPair cpair = new PreOPair();
				cpair.node = prnt.node.children.get(prnt.childrenDone);
				cpair.ptillme = prnt.ptillme + " => " + prnt.node.data;
				stack.addFirst(cpair);

				prnt.childrenDone++;
			} else {
				stack.removeFirst();
			}
		}
	}

	private class PreOPair {
		Node node;
		boolean self = false;
		int childrenDone = 0;
		String ptillme = "";
	}

	public void multiSolver(int data) {
		HeapMover rb = new HeapMover();
		this.multiSolver(this.root, rb, 0, data);

		System.out.println("Size = " + rb.size);
		System.out.println("Max = " + rb.max);
		System.out.println("Min = " + rb.min);
		System.out.println("Height = " + rb.height);
		System.out.println("Found = " + rb.found);
		System.out.println("Pred = " + (rb.pred == null ? "null" : rb.pred.data));
		System.out.println("Succ = " + (rb.succ == null ? "null" : rb.succ.data));
		System.out.println("JL = " + (rb.justLarger == null ? "null" : rb.justLarger.data));
	}

	private void multiSolver(Node node, HeapMover rb, int depth, int data) {
		// work
		rb.size++;
		if (node.data > rb.max) {
			rb.max = node.data;
		}

		if (node.data < rb.min) {
			rb.min = node.data;
		}

		if (depth > rb.height) {
			rb.height = depth;
		}

		rb.prev = rb.curr;

		if (rb.found == true && rb.succ == null) {
			rb.succ = node;
		}

		if (node.data == data) {
			rb.pred = rb.prev;
			rb.found = true;
		}

		rb.curr = node;

		if (node.data > data) {
			if (rb.justLarger == null) {
				rb.justLarger = node;
			} else {
				if (node.data < rb.justLarger.data) {
					rb.justLarger = node;
				}
			}
		}

		// work

		for (Node child : node.children) {
			this.multiSolver(child, rb, depth + 1, data);
		}
	}

	private class HeapMover {
		int size = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int height = 0;
		boolean found = false;

		Node curr = null;
		Node prev = null;

		Node pred = null;
		Node succ = null;

		Node justLarger = null;
	}

	public int kthSmallest(int k) {
		// int ks = Integer.MIN_VALUE;
		//
		// for (int i = 0; i < k; i++) {
		// HeapMover rb = new HeapMover();
		// this.multiSolver(this.root, rb, 0, ks);
		// ks = rb.justLarger.data;
		// }
		//
		// return ks;
		ArrayList<Integer> list = new ArrayList<>();
		this.kthSmallest(this.root, list);

		Integer[] arr = new Integer[list.size()];
		list.toArray(arr);

		Arrays.sort(arr);
		return arr[k];
	}

	private void kthSmallest(Node node, ArrayList<Integer> list) {
		list.add(node.data);
		for (Node child : node.children) {
			this.kthSmallest(child, list);
		}
	}

	public void printAtLevel(int level) {

	}

	public void removeLeaves() {
		this.removeLeaves(this.root);
	}

	private void removeLeaves(Node node) {
		System.out.print(node.data + "\t");

		// hi node

		for (int i = node.children.size() - 1; i >= 0; i--) {
			// before moving to the child
			Node child = node.children.get(i);
			if (child.children.size() == 0) {
				node.children.remove(i);
			} else {
				this.removeLeaves(child);
			}
			// back from the child
		}

		// bye node
	}


}
