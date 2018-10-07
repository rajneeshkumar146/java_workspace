package BinaryTree;

import java.util.Scanner;

public class Q349_ReverseAlternateLeves {
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
		display(root);
		System.out.println();

		ReverseAlternateLeaves(root.left, root.right, 1);
		display(root);

	}

	// ==========================================================================================================================

	private static void ReverseAlternateLeaves(Node nodel, Node noder, int level) {
		if (nodel == null || noder == null) { // Assuming_that_tree_is_Mirror_image_of_itself_or_either_i_say_foldable.
			return;
		}

		if (level % 2 == 1) {
			Swap(nodel, noder);
		}
		ReverseAlternateLeaves(nodel.left, noder.right, level + 1);
		ReverseAlternateLeaves(nodel.right, noder.left, level + 1);

	}

	private static void Swap(Node one, Node two) {
		int data = one.data;
		one.data = two.data;
		two.data = data;
	}

}
/* Test case 1 
15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
3 <= 1 => 2
4 <= 3 => 5
15 <= 4 => 14
. <= 15 => .
. <= 14 => .
13 <= 5 => 12
. <= 13 => .
. <= 12 => .
6 <= 2 => 7
11 <= 6 => 10
. <= 11 => .
. <= 10 => .
9 <= 7 => 8
. <= 9 => .
. <= 8 => .
*/

/* Test case 2 
15
1 2 3 -1 4 5 -1 -1 -1 -1 7 8 -1 -1 -1
3 <= 1 => 2
. <= 3 => 4
. <= 4 => 8
. <= 8 => .
5 <= 2 => .
7 <= 5 => .
. <= 7 => .
*/

/* Test case 3 
15
1 2 3 -1 4 5 -1 -1 -1 6 7 8 9 -1 -1
3 <= 1 => 2
. <= 3 => 4
9 <= 4 => 8
. <= 9 => .
. <= 8 => .
5 <= 2 => .
7 <= 5 => 6
. <= 7 => .
. <= 6 => .
*/