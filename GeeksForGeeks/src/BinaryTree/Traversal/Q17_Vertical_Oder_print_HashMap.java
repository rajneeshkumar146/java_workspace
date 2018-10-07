package BinaryTree.Traversal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q17_Vertical_Oder_print_HashMap {
	private class Node {
		private int data;
		private Node left;
		private Node right;
		private Node parent;
	}

	private Node root;
	private int size;

	public Q17_Vertical_Oder_print_HashMap() {
		Scanner scn = new Scanner(System.in);
		this.root = takeinput(null, false, scn);
	}

	private Node takeinput(Node parent, boolean ilc, Scanner scn) {
		// prompt
		if (parent == null) {
			System.out.println("Entre Data for Root");
		} else {
			System.out.format("Enter data for %s for" + parent.data + "%n", ilc ? "Left Child" : "right Child");
		}

		// Set_Data
		int data = scn.nextInt();
		Node node = new Node();
		node.data = data;
		this.size++;

		System.out.println("Do you have a left Child: ");
		Boolean hlc = scn.nextBoolean();
		if (hlc) {
			node.left = takeinput(node, true, scn);
			node.left.parent = node;
		}

		System.out.println("Do you have a right child: ");
		boolean hrc = scn.nextBoolean();
		if (hrc) {
			node.right = takeinput(node, false, scn);
			node.right.parent = node;
		}

		return node;
	}

	public void VerticalOder() {
		HashMap<Integer, HashSet<Integer>> set = new HashMap<Integer, HashSet<Integer>>();
		VerticalOder(0, root, set);
		for (Integer i : set.keySet()) {
			System.out.println(set.get(i));
		}
	}

	private void VerticalOder(int line, Node node, HashMap<Integer, HashSet<Integer>> set) {
		if (node == null) {
			return;
		}
		if (!set.containsKey(line)) {
			set.put(line, new HashSet<Integer>());
		}
		set.get(line).add(node.data);
		VerticalOder(line + 1, node.left, set);
		VerticalOder(line - 1, node.right, set);
	}

}
