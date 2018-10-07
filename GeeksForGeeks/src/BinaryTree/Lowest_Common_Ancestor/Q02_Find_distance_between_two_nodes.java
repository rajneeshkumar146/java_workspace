package BinaryTree.Lowest_Common_Ancestor;

import java.util.Scanner;

import BinaryTree.Lowest_Common_Ancestor.Q04Print_common_nodes_on_path_from_common_ancestors.Node;

public class Q02_Find_distance_between_two_nodes {

	public static Scanner scn = new Scanner(System.in);

	public class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	public Q02_Find_distance_between_two_nodes() {
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

	public void distanceBetween(int a, int b) {
		int ances = ancestor(root, a, b);
		int aheight = height(root, a);
		int bheight = height(root, b);
		int ancesheight = height(root, ances);
		System.out.println(aheight + bheight - 2 * ancesheight);
	}

	private int ancestor(Node node, int a, int b) {
		if (node == null) {
			return -1;
		}

		if (node.data == a || node.data == b) {
			return node.data;
		}

		int lancestor = ancestor(node.left, a, b);
		int rancestor = ancestor(node.right, a, b);

		if (lancestor != -1 && rancestor != -1) {
			return node.data;
		}

		return lancestor != -1 ? lancestor : rancestor;
	}

	private int height(Node node, int a) {

		if (node == null) {
			return -1;
		}

		if (node.data == a) {
			return 0;
		}

		int lh = height(node.left, a);
		if (lh != -1) {
			lh = lh + 1;
			return lh;
		}
		int rh = height(node.right, a);
		if (rh != -1) {
			rh = rh + 1;
			return rh;
		}

		return -1;
	}

}
