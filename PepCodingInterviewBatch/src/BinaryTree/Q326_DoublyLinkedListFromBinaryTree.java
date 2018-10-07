package BinaryTree;

import java.util.Scanner;

public class Q326_DoublyLinkedListFromBinaryTree {
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

	// method to display the linked list
	private static void displayDLL(Pair pair) {
		Node temp;
		for (temp = pair.head; temp != null; temp = temp.right) {
			System.out.print(temp.data + " -> ");
		}
		System.out.println(".");

		for (temp = pair.tail; temp != null; temp = temp.left) {
			System.out.print(temp.data + " -> ");
		}
		System.out.println(".");
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

		Pair pair = DoublyLinkedListFromTree(root);
		displayDLL(pair);
	}

	// ==========================================================================================================================

	private static class Pair {
		private Node head;
		private Node tail;
	}

	private static Pair DoublyLinkedListFromTree(Node node) {
		if (node == null) {
			return null;
		}
		Pair pair = new Pair();
		pair.head = node;
		pair.tail = node;

		Pair leftPart = DoublyLinkedListFromTree(node.left);
		Pair rightPart = DoublyLinkedListFromTree(node.right);

		if (leftPart != null) {
			leftPart.tail.right = pair.head;
			pair.head.left = leftPart.tail;

			pair.head = leftPart.head;
		}

		if (rightPart != null) {
			pair.tail.right = rightPart.head;
			rightPart.head.left = pair.tail;

			pair.tail = rightPart.tail;
		}

		return pair;
	}

}
