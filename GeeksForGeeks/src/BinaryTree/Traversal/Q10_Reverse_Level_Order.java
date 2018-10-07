package BinaryTree.Traversal;

import java.util.LinkedList;
import java.util.Scanner;

public class Q10_Reverse_Level_Order {
	public class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	public Q10_Reverse_Level_Order() {
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

	public void LevelReverseOder() {
		LinkedList<Node> stack = new LinkedList<Node>();
		LinkedList<Node> queue = new LinkedList<Node>();

		queue.addFirst(root);
		while (!queue.isEmpty()) {
			Node oper = queue.removeFirst();
			stack.add(oper);
			if (oper.left != null) {
				queue.addLast(oper.left);
			}

			if (oper.right != null) {
				queue.addLast(oper.right);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.removeFirst() + " ");
		}

	}

}
