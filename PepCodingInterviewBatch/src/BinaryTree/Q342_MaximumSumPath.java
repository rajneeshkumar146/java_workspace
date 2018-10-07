package BinaryTree;

import java.util.Scanner;

public class Q342_MaximumSumPath {
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
		maximumSumPath(root, 0, pair, "");
		System.out.println(pair.psf);
	}

	// ==========================================================================================================================

	private static class Pair {
		int Maximum = Integer.MIN_VALUE;
		String psf;
	}

	private static void maximumSumPath(Node node, int sum, Pair pair, String psf) {
		if (node == null) {
			return;
		}

		sum = sum + node.data;
		psf += node.data + " ";
		if(sum>pair.Maximum){
			pair.Maximum=sum;
			pair.psf=psf;
		}
		

		maximumSumPath(node.left, sum, pair, psf);
		maximumSumPath(node.right, sum, pair, psf);

	}

}

/* Test case 1 
15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
1 3 7 15 .
*/

/* Test case 2 
12
1 2 3 4 5 6 7 8 9 10 11 12
1 3 6 12 .
*/

/* Test case 3 
15
1 2 3 -1 4 5 -1 -1 -1 6 7 8 9 -1 -1
1 3 5 9 .
*/

/* Test case 4
15
9 2 3 -1 8 5 -1 -1 -1 4 7 6 1 -1 -1
9 2 8 7 .
*/
