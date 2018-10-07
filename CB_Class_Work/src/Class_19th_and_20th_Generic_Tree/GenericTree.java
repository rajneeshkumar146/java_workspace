package Class_19th_and_20th_Generic_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {

	public class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		root = takeInput(null, -1, scn);
	}

	private Node takeInput(Node parent, int children, Scanner scn) {
		// prompt
		if (parent == null) {
			System.out.println("Enter data for root?");
		} else {
			System.out.println("Enter data for" + children + "th child");
		}

		// collect data

		int data = scn.nextInt();

		// create node,set data and maintain size

		Node node = new Node();
		node.data = data;
		this.size++;

		// solve the same problem for children-ask number of children for child

		System.out.println("Number of children for " + node.data + "th parent");
		int noc = scn.nextInt(); // noc=number_of_child.

		for (int i = 0; i < noc; i++) {
			Node gchild = takeInput(node, i, scn);
			node.children.add(gchild);
		}

		// return child

		return node;

	}

	public int size() {
		return size;
	}

	public boolean Isempty() {
		return size == 0;
	}

	public void display() {

		display(root);

	}

	private void display(Node node) {

		String str = node.data + "=>";
		for (Node child : node.children) {
			str += child.data + ", ";
		}

		System.out.println(str + ".");

		for (Node child : node.children) {
			display(child);
		}

	}

	public int size2() {

		return size2(root);

	}

	private int size2(Node node) {
		int sz = 0;
		for (Node child : node.children) {
			int cs = size2(child);
			sz += cs;
		}

		sz += 1;
		return sz;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int maxr = node.data;
		for (Node child : node.children) {
			int maxc = max(child);
			if (maxc > maxr) {
				maxr = maxc;
			}
		}

		return maxr;

	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {

		int h = -1;
		for (Node child : node.children) {
			int ch = height(child);
			if (ch > h) {
				h = ch;
			}
		}
		return h + 1;
	}

	public boolean find(int n) {
		return find(root, n);
	}

	private boolean find(Node node, int n) {

		if (node.data == n) {
			return true;
		}

		for (Node child : node.children) {
			boolean res = find(child, n);
			if (res == true) {
				return true;
			}
		}
		return false;

	}

	public void mirrorimage() {

		mirrorimage(root);

	}

	private void mirrorimage(Node node) {

		for (Node child : node.children) {
			mirrorimage(child);
		}

		int li = 0, ri = node.children.size() - 1;
		while (li < ri) {
			Node lin = node.children.get(li);
			node.children.set(li, node.children.get(ri));
			node.children.set(ri, lin);
			li++;
			ri--;
		}

	}

	public void printAtDepth(int d) {

		printAtDepth(root, d, 0);

	}

	private void printAtDepth(Node node, int d, int hight) {

		for (Node child : node.children) {
			printAtDepth(child, d, hight + 1);
			if (d == hight) {
				System.out.print(child.data + " ");
			}
		}

	}

	public void predisplay() {
		predisplay(root);
		System.out.println(".");
	}

	private void predisplay(Node node) {
		System.out.println(node.data + ",");
		for (Node child : node.children) {
			predisplay(child);
		}

	}

	public void postdisplay() {
		postdisplay(root);
		System.out.println(".");
	}

	private void postdisplay(Node node) {
		for (Node child : node.children) {
			postdisplay(child);
		}

		System.out.println(node.data + ",");

	}

	public void levelOderDisplay() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);

		while (queue.size() != 0) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + " ");
			for (Node child : temp.children) { // iski jgha hum addall use
												// krskte hai.
				queue.addLast(child);
			}

		}

	}

	public void levelOderLinerwise() {
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> nexlev = new LinkedList<>(); //
		queue.addLast(root);

		while (queue.size() != 0) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + " ");

			for (Node child : temp.children) { // iski jgha hum addall use
												// krskte hai.
				nexlev.addLast(child);
			}

			if (queue.size() == 0) {
				queue = nexlev;
				nexlev = new LinkedList<>();
				System.out.println();
			}

		}

	}

	public void multisolver(int data) {
		HeapMover bucket = new HeapMover();

		multisolver(root, bucket, data, 0);

		System.out.println("size =>" + bucket.size);
		System.out.println("data =>" + bucket.found);
		System.out.println("maximum value =>" + bucket.max);
		System.out.println("minimum value =>" + bucket.min);
		System.out.println("Height of tree =>" + bucket.height);

		if (bucket.sacc == null) {
			System.out.println("Sacc not found");
		} else {
			System.out.println("Sacc is =>" + bucket.sacc.data);
		}

		if (bucket.pred == null) {
			System.out.println("Pred not found");
		} else {
			System.out.println("Pred is =>" + bucket.pred.data);
		}

		if (bucket.sacc == null) {
			System.out.println("Justlarger value not found");
		} else {
			System.out.println("JustLarger value is =>" + bucket.jl.data);
		}

	}

	private void multisolver(Node node, HeapMover bucket, int data, int depth) {

		bucket.prev = bucket.curr;
		bucket.curr = node;

		bucket.size++;

		if (bucket.found == true && bucket.sacc == null) {
			bucket.sacc = bucket.curr;
		}

		if (node.data == data) {
			bucket.found = true;
			bucket.pred = bucket.prev;
		}

		if (node.data > bucket.max) {
			bucket.max = node.data;
		}

		if (node.data < bucket.min) {
			bucket.min = node.data;
		}

		if (depth > bucket.height) {
			bucket.height = depth;
		}

		if (node.data > data) {
			if (bucket.jl == null) {
				bucket.jl = node;
			} else {
				if (node.data < bucket.jl.data) {
					bucket.jl = node;
				}
			}
		}

		for (Node child : node.children) {
			multisolver(child, bucket, data, depth + 1);
		}

	}

	private class HeapMover {

		private int size;
		private boolean found;
		private int max = Integer.MIN_VALUE;
		private int min = Integer.MAX_VALUE;
		private int height;

		private Node prev;
		private Node curr;

		private Node sacc;
		private Node pred;
		private Node jl;

		private ArrayList<Node> ncl = new ArrayList<>();

	}

	public int kthsmallest(int k) {
		int data = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			HeapMover bucket = new HeapMover();
			kthsmallest(root, bucket, data);
			data = bucket.jl.data;

		}

		return data;
	}

	private void kthsmallest(Node node, HeapMover bucket, int data) {
		if (node.data > data) {
			if (bucket.jl == null) {
				bucket.jl = node;
			} else {
				if (node.data < bucket.jl.data) {
					bucket.jl = node;
				}
			}
		}

		for (Node child : node.children) {
			kthsmallest(child, bucket, data);
		}
	}

	public int kthsmallest1(int k) {

		ArrayList<Integer> list = new ArrayList<>();

		kthsmallest1(root, list);

		Collections.sort(list);
		return list.get(k - 1);

	}

	private void kthsmallest1(Node node, ArrayList<Integer> list) {

		list.add(node.data);
		for (Node child : node.children) {
			kthsmallest1(child, list);
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
			}
		}

		for (Node child : node.children) {
			removeLeaves(child);
		}

	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {

		if (node.children.size() > 1) {
			for (int i = node.children.size() - 1; i >= 1; i--) {
				Node head = node.children.remove(i);
				gettail(node.children.get(i - 1)).children.add(head);
			}
		}

		for (Node child : node.children) {
			linearize(child);
		}

	}

	public void linearizeBtr() {
		this.linearizeBtr(root);
	}

	private Node linearizeBtr(Node node) {
		if (node.children.size() == 0) {
			return node;
		}
		Node tail = null;

		for (Node child : node.children) {
			if (tail != null) {
				tail.children.add(child);
			}

			tail = linearizeBtr(child);
		}

		while (node.children.size() > 1) {
			node.children.remove(node.children.size() - 1);
		}

		return tail;
	}

	private Node gettail(Node node) {
		Node result = null;
		if (node.children.size() == 0) {
			result = node;
		}
		for (Node child : node.children) {
			Node temp = gettail(child);
			result = temp;
		}
		return result;
	}

	public void levelOrderzz() {
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> nexlev = new LinkedList<>(); //
		queue.addLast(root);
		int count = 0;

		while (queue.size() != 0) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + " ");

			for (Node child : temp.children) {
				if (count % 2 != 0) {
					nexlev.addFirst(child);
				} else {
					nexlev.addLast(child);
				}
			}

			if (queue.size() == 0) {
				queue = nexlev;
				nexlev = null;
				System.out.println();
			}

		}
	}

	public void flatten() {
		flatten(this.root);
	}

	private void flatten(Node node) {
		if (node.children.size() == 0) {
			return;
		}

		for (Node child : node.children) {
			flatten(child);
		}

		ArrayList<Node> ncl = new ArrayList<>();
		for (Node child : node.children) {
			ncl.add(child);
			ncl.addAll(child.children);
			child.children.clear();
		}
		node.children = ncl;

		return;
	}

	public void flattenBtr() {
		HeapMover mover = new HeapMover();
		flattenBtr(this.root, mover);
		this.root.children = mover.ncl;

	}

	private void flattenBtr(Node node, HeapMover mover) {
		if (node != root) {
			mover.ncl.add(node);
		}

		for (Node child : node.children) {
			flattenBtr(child, mover);
		}
		node.children.clear();

		return;
	}

	public boolean isomorphic(GenericTree other) {
		return isomorphic(this.root, other.root);
	}

	private boolean isomorphic(Node tnode, Node onode) {
		if (tnode.children.size() != onode.children.size()) {
			return false;
		}

		for (int i = 0; i < tnode.children.size(); i++) {
			Node tchild = tnode.children.get(i);
			Node ochild = onode.children.get(onode.children.size() - 1);

			if (this.isomorphic(tchild, ochild) == false) {
				return false;
			}
		}

		return true;

	}

	public boolean ismirroriso() {
		return ismirroiso(root, root);
	}

	private boolean ismirroiso(Node lmnode, Node rmnode) {
		if (lmnode.children.size() != rmnode.children.size()) {
			return false;
		}

		for (int i = 0; i < lmnode.children.size(); i++) {
			Node lchild = lmnode.children.get(i);
			Node rchild = rmnode.children.get(rmnode.children.size() - 1 - i);

			boolean res = ismirroiso(lchild, rchild);
			if (res == false) {
				return false;
			}
		}
		return true;
	}

}
