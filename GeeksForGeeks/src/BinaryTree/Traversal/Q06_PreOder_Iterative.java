package BinaryTree.Traversal;

import java.util.LinkedList;
import java.util.Scanner;

public class Q06_PreOder_Iterative {
	public class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	public Q06_PreOder_Iterative() {
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

	public void preOder() {
		if (root == null) {
			return;
		}
		LinkedList<traversal> stack = new LinkedList<traversal>();
		traversal ft = new traversal(); // First_Traversal
		ft.node = root;
		stack.addFirst(ft); // stack_type_Stored
		while (!stack.isEmpty()) {
			traversal oper = stack.peek();
			
			if (!oper.selfdone) {
				System.out.print(oper.node.data+ " ");
				oper.selfdone = true;
			} else if (!oper.leftdone) {
				if (oper.node.left != null) {
					traversal nt = new traversal();
					nt.node = oper.node.left;
					stack.addFirst(nt);
				}
				oper.leftdone = true;

			} else if (!oper.rightdone) {
				if (oper.node.right != null) {
					traversal nt = new traversal();
					nt.node = oper.node.right;
					stack.addFirst(nt);
				}
				oper.rightdone = true;
			} else {
				stack.removeFirst();
			}
		}
	}

	private class traversal {
		private Node node;
		private boolean selfdone;
		private boolean leftdone;
		private boolean rightdone;
	}
}
