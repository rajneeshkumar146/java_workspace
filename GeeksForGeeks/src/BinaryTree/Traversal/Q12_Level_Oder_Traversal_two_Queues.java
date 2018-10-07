package BinaryTree.Traversal;

import java.util.LinkedList;
import java.util.Scanner;

public class Q12_Level_Oder_Traversal_two_Queues {
	private class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	public Q12_Level_Oder_Traversal_two_Queues() {
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

	public void levelOder() {
		LinkedList<Node> que1 = new LinkedList<Node>();
		LinkedList<Node> que2 = new LinkedList<Node>();

		que1.addLast(root);
		while (!que1.isEmpty() || !que2.isEmpty()) {
			while (!que1.isEmpty()) {
				Node oper = que1.removeFirst();
				if (oper.left != null) {
					que2.addLast(oper.left);
				}

				if (oper.right != null) {
					que2.addLast(oper.right);
				}

				System.out.print(oper.data + " ");
			}
			System.out.println();
			while (!que2.isEmpty()) {
				Node oper = que2.removeFirst();
				if (oper.left != null) {
					que1.addLast(oper.left);
				}

				if (oper.right != null) {
					que1.addLast(oper.right);
				}

				System.out.print(oper.data + " ");
			}
			System.out.println();
		}
	}

}
