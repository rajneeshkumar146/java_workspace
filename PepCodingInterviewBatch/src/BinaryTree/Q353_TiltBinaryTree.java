package BinaryTree;

import java.util.Scanner;

public class Q353_TiltBinaryTree {
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
		
		Pair res=new Pair();
		res=CalculateTilt(root);
		System.out.println(res.tilt);

	}

	// ==========================================================================================================================

	private static class Pair {
		private int sum = 0;
		private int tilt = 0;
	}

	private static Pair CalculateTilt(Node node) {
		if (node == null) {
			return new Pair();
		}

		Pair lp = CalculateTilt(node.left);
		Pair rp = CalculateTilt(node.right);

		Pair mp = new Pair();

		mp.sum = lp.sum + rp.sum + node.data;
		mp.tilt = lp.tilt + rp.tilt + Math.abs(lp.sum - rp.sum);

		return mp;

	}

}
