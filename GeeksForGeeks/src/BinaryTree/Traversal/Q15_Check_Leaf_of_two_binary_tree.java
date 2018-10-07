package BinaryTree.Traversal;

import java.util.Scanner;
import java.util.Stack;
import java.util.Scanner;

public class Q15_Check_Leaf_of_two_binary_tree {
	public static Scanner scn = new Scanner(System.in);

	private class Node {
		private int data;
		private Node left;
		private Node right;
		private Node parent;
	}

	private Node root;
	private int size;

	public Q15_Check_Leaf_of_two_binary_tree() {
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

	public boolean chechLeaf(Q15_Check_Leaf_of_two_binary_tree other) {

		Stack<Node> st1 = new Stack<Node>();
		Stack<Node> st2 = new Stack<Node>();

		st1.add(this.root);
		st2.add(other.root);
		while (!st1.isEmpty() || !st2.isEmpty()) {

			if (st1 == null || st2 == null) {
				return false;
			}

			Node temp1 = st1.pop();
			while (!st1.isEmpty() || isLeaf(temp1)) {

				if (temp1.right != null) {
					st1.add(temp1.right);
				}

				if (temp1.left != null) {
					st1.add(temp1.left);
				}

				temp1 = st1.pop();
			}

			Node temp2 = st1.pop();
			while (!st2.isEmpty() && isLeaf(temp2)) {

				if (temp2.right != null) {
					st1.add(temp2.right);
				}

				if (temp2.left != null) {
					st1.add(temp2.left);
				}

				temp2 = st2.pop();
			}
			if (temp1 == null && temp2 != null) {
				return false;
			} else if (temp1 != null && temp2 == null) {
				return false;
			} else if (temp1 != null && temp2 != null) {

				if (temp1.data != temp2.data) {
					return false;
				}

			}

		}

		return true;
	}

	private boolean isLeaf(Node node) {
		if (node.left == null && node.right == null) {
			return true;
		}
		return false;
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------

}
