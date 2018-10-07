package BinaryTree.Traversal;

import java.util.Scanner;

public class Q16_Vertical_Oder_print {

	private class Node {
		private int data;
		private Node left;
		private Node right;
		private Node parent;
	}

	private Node root;
	private int size;

	public Q16_Vertical_Oder_print() {
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

	private void FindMinMaxHorizontalDistance(Node node, int d, MinMax store) {
		if (node == null) {
			return;
		}

		store.min = Math.min(store.min, d);
		store.max = Math.max(store.max, d);

		FindMinMaxHorizontalDistance(node.left, d - 1, store);
		FindMinMaxHorizontalDistance(node.right, d + 1, store);

	}

	private void printVerticalLines(Node node, int i, int x) {
		if (node == null) {
			return;
		}
		if (i == x) {
			System.out.print(node.data + " ");
		}
		printVerticalLines(node.left, i - 1, x);
		printVerticalLines(node.right, i + 1, x);

	}

	public void verticaldisplay() {
		MinMax store = new MinMax();
		FindMinMaxHorizontalDistance(root, 0, store);

		for (int i = store.min; i <= store.max; i++) {
			printVerticalLines(root, 0, i);
			System.out.println();
		}

	}

	private class MinMax {
		private int min;
		private int max;
	}

}
