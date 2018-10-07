package BST;

import java.util.Scanner;

public class Q383_FindClosestElement {
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

		int k = scn.nextInt();
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Node[] nodes = new Node[arr.length];
		int size = 0;
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				nodes[i] = new Node(arr[i], null, null);
				size++;

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

		root = nodes[0];
		traverse(root, k);
		System.out.println(ele);
	}

	static int mindiffnode = Integer.MAX_VALUE;
	static int ele;

	private static void traverse(Node node, int k) {
		if (node == null) {
			return;
		}

		if (Math.abs(node.data - k) <= mindiffnode) {
			mindiffnode = Math.abs(node.data - k);
			ele = node.data;
		}

		if (node.data > k) {
			traverse(node.left, k);
		} else {
			traverse(node.right, k);
		}
	}

}

/*Test Case 1
42
7
50 25 75 12 37 62 87
37
*/

/*Test Case 2
73
7
50 25 75 12 37 62 87
75
*/

/*Test Case 3
61
12
50 20 70 10 30 60 80 -1 -1 25 36 55
60
*/
