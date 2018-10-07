package BinaryTree;

import java.util.Scanner;

public class Q331_MaximumEdge {
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

		Pair ans = maximumEdge(root, root);
		System.out.println(ans.breakEdge);

	}

	// ==========================================================================================================================

	private static class Pair {
		private int countNodes = 0;
		private int breakEdge = 0;
	}

	private static Pair maximumEdge(Node node, Node root) {
		if (node == null) {
			return new Pair();
		}

		Pair lp = maximumEdge(node.left, root);
		Pair rp = maximumEdge(node.right, root);
		Pair mp = new Pair();
		mp.countNodes = lp.countNodes + rp.countNodes + 1;
		mp.breakEdge = lp.breakEdge + rp.breakEdge;
		if (mp.countNodes % 2 == 0 && node != root) {
			mp.breakEdge += 1;
		}

		return mp;
	}

}
/* Test case 1 
12 
1 2 3 4 5 6 7 8 9 10 11 12 
2
*/

/* Test case 2 
12 
1 2 3 -1 4 5 -1 -1 -1 6 7 8
2
*/

