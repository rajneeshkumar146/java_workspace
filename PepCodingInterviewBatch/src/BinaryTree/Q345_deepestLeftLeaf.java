package BinaryTree;

import java.util.Scanner;

public class Q345_deepestLeftLeaf {
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
		Pair pair = new Pair();
		DeepestLeftLeaf(root, 0, false, pair);
		System.out.println(pair.node.data);

	}

	// ==========================================================================================================================

	private static class Pair {
		private int Maxdepth = Integer.MIN_VALUE;
		private Node node;
	}

	private static void DeepestLeftLeaf(Node node, int depth, boolean ilc, Pair pair) { // ilc:IsLeftChild
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			if (ilc) {
				if (depth > pair.Maxdepth) {
					pair.Maxdepth = depth;
					pair.node = node;
				}
			}
			return;
		}

		DeepestLeftLeaf(node.left, depth + 1, true, pair);
		DeepestLeftLeaf(node.right, depth + 1, false, pair);

	}

}

/* Test case 1 
12 
1 2 3 4 5 6 7 8 9 10 11 12 
8
*/

/* Test case 2 
12 
1 2 3 -1 4 5 -1 -1 -1 6 7 8
6
*/

/* Test case 3 
12 
1 2 3 4 -1 -1 5 6 7 -1 -1 -1
6
*/

/* Test case 4
12 
1 2 3 4 -1 -1 5 -1 7 -1 -1 -1
6
*/
