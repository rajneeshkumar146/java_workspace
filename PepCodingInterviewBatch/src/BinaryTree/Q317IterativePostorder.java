package BinaryTree;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q317IterativePostorder {
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
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

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

		solve(nodes[0]);
	}

	private static void solve(Node node) {

		ArrayDeque<Node> stack = new ArrayDeque<>();
		ArrayDeque<Node> ans = new ArrayDeque<>();
		stack.addFirst(node);

		while (!stack.isEmpty()) {
			Node rem = stack.removeFirst();
			ans.addFirst(rem);

			if (rem.left != null) {
				stack.addFirst(rem.left);
			}

			if (rem.right != null) {
				stack.addFirst(rem.right);
			}

		}

		while (!ans.isEmpty()) {
			System.out.print(ans.removeFirst().data + " ");
		}

	}

}
/*
15 
1 2 3 4 5 6 7 -1 -1 8 9 -1 -1 -1 -1
4 8 9 5 2 6 7 3 1 
*/

//test case 2
/*
7
1 2 3 4 -1 5 -1
4 2 5 3 1 
*/
