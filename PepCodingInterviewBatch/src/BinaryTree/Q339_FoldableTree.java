package BinaryTree;

import java.util.Scanner;

public class Q339_FoldableTree {
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

		System.out.println(Foldable(root, root));
	}

	// ==========================================================================================================================

	private static boolean Foldable(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
			return false;
		}

		if (!Foldable(node1.right, node2.left) || !Foldable(node1.left, node2.right)) {
			return false;
		}

		return true;

	}
}

/* Test case 1 
15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
true
*/

/* Test case 2 
15
1 2 3 -1 4 5 -1 -1 -1 -1 7 8 -1 -1 -1
true
*/

/* Test case 3 
15
1 2 3 -1 4 5 -1 -1 -1 6 7 8 9 -1 -1
true
*/

/* Test case 4
15
1 2 3 -1 4 5 -1 -1 -1 6 -1 8 -1 -1 -1
false
*/
