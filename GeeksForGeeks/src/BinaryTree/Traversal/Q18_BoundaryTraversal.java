package BinaryTree.Traversal;

import java.util.Scanner;

import javax.xml.soap.Node;

public class Q18_BoundaryTraversal {
	public static Scanner scn = new Scanner(System.in);

	private class Node {
		private int data;
		private Node left;
		private Node right;
		private Node parent;
	}

	private Node root;
	private int size;

	public Q18_BoundaryTraversal() {
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

	public void boundaryTraversal() {
		if (root == null) {
			return;
		}

		leftBoundary(root.left);

		printAllLeafes(root.left);
		printAllLeafes(root.right);

		rightBoundary(root.right);
	}

	private void leftBoundary(Node node) { // print_all_Boundary_node_in_Top_to_bottom_manner.
		if (node.left != null) {
			System.out.print(node.data + " ");
			leftBoundary(node.left);
		} else if (node.right != null) {
			System.out.print(node.data + " ");
			leftBoundary(node.right);
		}
	}

	private void printAllLeafes(Node node) { // print_all_Leafes.
		if (node == null) {
			return;
		}

		printAllLeafes(node.left);

		if (isLeaf(node)) {
			System.out.print(node.data + " ");
		}

		printAllLeafes(node.right);

	}

	private boolean isLeaf(Node node) {
		if (node.left == null && node.right == null) {
			return true;
		}
		return false;
	}

	private void rightBoundary(Node node) { //// print_all_Boundary_node_in_bottom_to_top_manner.
		if (node.right != null) {
			rightBoundary(node.right);
			System.out.print(node.data + " ");
		} else if (node.left != null) {
			rightBoundary(node.left);
			System.out.print(node.data + " ");
		}
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------

}
