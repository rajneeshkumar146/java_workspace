package BinaryTree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class Q340_MaximumWidth {
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

		int height = (int) ((Math.log(arr.length + 1) / Math.log(2)));

		int[] arr1 = new int[height + 1];
		MaximumWidthByArray(root, 0, arr1);
		int max = maxInArray(arr1);
		System.out.println(max);

		ByLevelOderTraversal(root);
	}

	// ==========================================================================================================================

	private static int maxInArray(int[] arr) {
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[1] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	private static void MaximumWidthByArray(Node node, int level, int[] arr) {
		if (node == null) {
			return;
		}

		arr[level]++;
		MaximumWidthByArray(node.left, level + 1, arr);
		MaximumWidthByArray(node.right, level + 1, arr);

	}

	private static void ByLevelOderTraversal(Node node) {
		ArrayDeque<Node> que = new ArrayDeque<>();
		que.addLast(node);

		int maxWidth = 0;
		while (!que.isEmpty()) {

			// A new level start.
			int size = que.size();
			if (size > maxWidth) { // Calculate Maximum Width.
				maxWidth = size;
			}

			while (size-- > 0) {
				Node rem = que.removeFirst();
				if (rem.left != null) {
					que.addLast(rem.left);
				}
				if (rem.right != null) {
					que.addLast(rem.right);
				}
			}
		}

		System.out.println(maxWidth);

	}

}
