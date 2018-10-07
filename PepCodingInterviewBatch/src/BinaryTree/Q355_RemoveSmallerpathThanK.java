package BinaryTree;

import java.util.Scanner;

public class Q355_RemoveSmallerpathThanK {
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

		// RemoveSmallerPathThanK(root, scn.nextInt(), 0);

		// RemoveSmallerPathThanK_ParentType(root, null, false, scn.nextInt(),
		// 0);

		display(root);

	}

	// ==========================================================================================================================

	private static Node RemoveSmallerPathThanK(Node node, int k, int level) { // Nice_method.

		if (node == null) {
			return null;
		}

		node.left = RemoveSmallerPathThanK(node.left, k, level + 1);
		node.right = RemoveSmallerPathThanK(node.right, k, level + 1);

		// Path_Smalller_Than_K_and_Also_It_is_Not_the_Part_Of_Any_Tree:_A_Pure_Leaf.
		if (level <= k && node.left == null && node.right == null) {
			return null;
		}

		return node;

	}

	private static void RemoveSmallerPathThanK_ParentType(Node node, Node parent, boolean ilc, int k, int level) {
		if (node == null) {
			return;
		}

		RemoveSmallerPathThanK_ParentType(node.left, node, true, k, level + 1);
		RemoveSmallerPathThanK_ParentType(node.right, node, false, k, level + 1);

		if (level <= k && node.left == null && node.right == null) {
			if (ilc) {
				parent.left = null;
			} else {
				parent.right = null;
			}

		}

	}

}

/*
 * Test case 1 12 1 2 3 -1 4 5 10 -1 -1 6 7 8 2 2 <= 1 => 3 . <= 2 => 4 6 <= 4
 * => 7 . <= 6 => . . <= 7 => . 5 <= 3 => . 8 <= 5 => . . <= 8 => .
 */

/*
 * Test case 2 12 1 2 3 11 4 5 10 -1 -1 6 7 8 2 2 <= 1 => 3 . <= 2 => 4 6 <= 4
 * => 7 . <= 6 => . . <= 7 => . 5 <= 3 => . 8 <= 5 => . . <= 8 => .
 */
