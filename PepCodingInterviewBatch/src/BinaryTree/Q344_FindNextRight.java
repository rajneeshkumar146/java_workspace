package BinaryTree;

import java.util.LinkedList;
import java.util.Scanner;

public class Q344_FindNextRight {
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
		FindNextRight(scn.nextInt(), root);
		// display(root);

	}

	// ==========================================================================================================================

	private static void FindNextRight(int data, Node node) {
		LinkedList<Node> que = new LinkedList<>();

		que.addLast(node);
		while (!que.isEmpty()) {
			int size = que.size();

			while (size-- > 0) {
				Node rem = que.removeFirst();

				if (rem.data == data) {
					if (size > 0) {
						System.out.println(que.getFirst().data + " ");
					} else {
						System.out.println("Not Found");
						break;
					}
				}

				if (rem.left != null) {
					que.addLast(rem.left);
				}

				if (rem.right != null) {
					que.addLast(rem.right);
				}

			}

		}

	}
	
	/* Test case 1 
	12 
	1 2 3 4 5 6 7 8 9 10 11 12 
	5
	6 
	*/

	/* Test case 2 
	12 
	1 2 3 -1 4 5 -1 -1 -1 6 7 8
	8
	Not Found
	*/

	/* Test case 3 
	12 
	1 2 3 4 -1 -1 5 6 7 -1 -1 -1
	4
	5
	*/

	/* Test case 4
	12 
	1 2 3 4 -1 -1 5 6 7 -1 -1 -1
	5
	Not Found
	*/

}
