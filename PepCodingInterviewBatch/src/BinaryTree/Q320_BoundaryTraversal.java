package BinaryTree;

import java.util.Scanner;


public class Q320_BoundaryTraversal {
	public static Scanner scn = new Scanner(System.in);

	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " => " + node.data + " <= ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Node root = null;

		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Node[] nodes = new Node[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				nodes[i] = new Node(arr[i], null, null);

				if (i > 0) {
					int pi = (i - 1) / 2;

					if (i == 2 * pi + 1) {
						nodes[pi].left = nodes[i];
					} else {
						nodes[pi].right = nodes[i];
					}
				}
			}
		}

		// display(nodes[0]);
		
		BoundaryTraversalLeft(nodes[0]);
		BoundaryTraversalLeaf(nodes[0]);
		BoundaryTraversalRight(nodes[0]);

	}

	private static void BoundaryTraversalLeft(Node node) {
		if (node.left == null && node.right == null) {
			return;
		}
		System.out.println(node.data);
		if (node.left != null) {
			BoundaryTraversalLeft(node.left);
		} else if (node.right != null) {
			BoundaryTraversalLeft(node.right);
		}
	}

	private static void BoundaryTraversalLeaf(Node node) {
		if (node == null) {
			return;
		}

		BoundaryTraversalLeaf(node.left);
		if (node.left == null && node.right == null) {
			System.out.println(node.data);
		}
		BoundaryTraversalLeaf(node.right);
	}

	private static void BoundaryTraversalRight(Node node) {
		if (node.left == null && node.right == null) {
			return;
		}

		if (node.right != null) {
			BoundaryTraversalRight(node.right);
		} else if (node.left != null) {
			BoundaryTraversalRight(node.left);
		}
		System.out.println(node.data);

	}

}
