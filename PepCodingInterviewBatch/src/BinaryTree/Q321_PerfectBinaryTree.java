package BinaryTree;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q321_PerfectBinaryTree {
	private static class Node {
		int data;
		Node left;
		Node right;
		Node nextRight;

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
		str += " <= " + node.data + " => ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	// ==============================================================================================================================

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		// creation using the level order, seeing it like a heap
		// -1 says there is no node
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
		Node root = nodes[0];
		// display(root);
		perfectBinaryTree(root);
//		display(root);
	}

	private static void perfectBinaryTree(Node node) {

		ArrayDeque<Node> que1 = new ArrayDeque<>();
		ArrayDeque<Node> que2 = new ArrayDeque<>();

		que1.addLast(node.left);
		que1.addLast(node.right);
		System.out.println(node.data);

		while (!que1.isEmpty()) {
			Node rem1 = que1.remove();
			Node rem2 = que1.remove();
			System.out.print(rem1.data + " " + rem2.data + " ");

			if (rem1.left != null) {
				que2.addLast(rem1.left);
			}

			if (rem2.right != null) {
				que2.addLast(rem2.right);
			}

			if (rem1.right != null) {
				que2.addLast(rem1.right);
			}

			if (rem2.left != null) {
				que2.addLast(rem2.left);
			}

			if (que1.isEmpty()) {
				System.out.println();
				ArrayDeque<Node> temp = que1;
				que1 = que2;
				que2 = temp;
			}

		}

	}

	// ==========================================================================================================================

}
