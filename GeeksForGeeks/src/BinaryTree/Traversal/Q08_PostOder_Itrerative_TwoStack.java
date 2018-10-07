package BinaryTree.Traversal;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Q08_PostOder_Itrerative_TwoStack {

	public class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	public Q08_PostOder_Itrerative_TwoStack() {
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

	public void postOder() {
		Stack<Node> st1 = new Stack<Node>();
		Stack<Node> st2 = new Stack<Node>();

		st1.add(root);
		while (!st1.isEmpty()) {
			Node oper = st1.pop();
			st2.add(oper);
			if (oper.left != null) {
				st1.add(oper.left);
			}

			if (oper.right != null) {
				st1.add(oper.right);
			}
		}

		while (!st2.isEmpty()) {
			System.out.print(st2.pop().data + " ");
		}
	}

}
