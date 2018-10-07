package BinaryTree.Traversal;

import java.util.Scanner;

public class Q14_Inoder_NonThreaded_NonRecursive {
	public static Scanner scn = new Scanner(System.in);

	private class Node {
		private int data;
		private Node left;
		private Node right;
		private Node parent;
	}

	private Node root;
	private int size;

	public Q14_Inoder_NonThreaded_NonRecursive() {
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

	public void Inoder() {
		Node curr = root;
		boolean flag = false;
		while (curr != null) {
			if (!flag) {
				while (curr.left != null) { // Leftmost_node.
					curr = curr.left;
				}
			}
			flag = true; // If_Leftmost_node_is_visited_and_also_printed_then_mark_it_true.

			System.out.print("curr.data ");

			if (curr.right != null) {
				curr = curr.right;
				flag = false;
			} else if (curr.parent != null) {

				while (curr.parent != null && curr == curr.parent.right) {
					curr = curr.parent;
				}
				if (curr.parent == null) {
					break;
				}

				curr = curr.parent;
			} else {
				break;
			}

		}

	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------

}
