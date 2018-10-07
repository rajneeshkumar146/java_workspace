package BinaryTree.Traversal;

import java.io.*;
import java.util.*;

public class Q13_Diagonal_Traversal {
	public static Scanner scn = new Scanner(System.in);

	private class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	public Q13_Diagonal_Traversal() {
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
		}

		System.out.println("Do you have a right child: ");
		boolean hrc = scn.nextBoolean();
		if (hrc) {
			node.right = takeinput(node, false, scn);
		}

		return node;
	}

	public void diagonalPrint() {
		int distance = 0;
		HashMap<Integer, HashSet<Integer>> set = new HashMap<Integer, HashSet<Integer>>();

		diagonalPrint(root, distance, set);

		for (Integer key : set.keySet()) {
			System.out.println(set.get(key));
		}

	}

	private void diagonalPrint(Node node, int distance, HashMap<Integer, HashSet<Integer>> set) {
		if (node == null) {
			return;
		}

		if (!set.containsKey(distance)) {
			set.put(distance, new HashSet<Integer>());
		}

		set.get(distance).add(node.data);
		diagonalPrint(node.right, distance, set); // Right_ki_saari_calls_same_Level_pe_hogi.
		diagonalPrint(node.left, distance + 1, set);// Left_ki_calls_1+_krke_Lagegei.

	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------

}
