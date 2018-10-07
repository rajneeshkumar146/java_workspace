package BinaryTree.Traversal;

import java.util.LinkedList;
import java.util.Scanner;

public class Q03_Print_level_order_traversal_line_by_line {

	public class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	public Q03_Print_level_order_traversal_line_by_line() {
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

	public void LevelOderLinebyLine() {
		LinkedList<Node> que1 = new LinkedList<Node>();
		LinkedList<Node> que2 = new LinkedList<Node>();

		que1.addLast(root);
		while (!que1.isEmpty()) {
			Node node = que1.removeFirst();
			System.out.print(node.data + " ");

			if (node.left != null) {
				que2.addLast(node.left);
			}
			if (node.right != null) {
				que2.addLast(node.right);
			}

			if (que1.isEmpty()) {
				LinkedList<Node> temp = que1;
				que1 = que2;
				que2 = temp;
				System.out.println();
			}
		}
	}

}
