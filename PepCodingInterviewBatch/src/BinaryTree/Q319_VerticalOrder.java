package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Q319_VerticalOrder {
	public static Scanner scn = new Scanner(System.in);

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

		// display(nodes[0]);

		// VerticalOderSet1(nodes[0]);

		HashMap<Integer, HashSet<Integer>> set = new HashMap<>();
		VerticalOderSet2(nodes[0], 0, set);
		pair p = new pair();
		GetWidth(nodes[0], 0, p);
		for (int i = p.min; i <= p.max; i++) {
			System.out.println(set.get(i));
		}

	}

	private static class pair {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
	}

	private static void VerticalOderSet1(Node node) {
		pair p = new pair();
		GetWidth(node, 0, p);

		for (int i = p.min; i <= p.max; i++) {
			widthPrintset1(node, i, 0);
		}

	}

	private static void widthPrintset1(Node node, int lineNo, int width) {
		if (node == null) {
			return;
		}

		if (lineNo == width) {
			System.out.print(node.data + " ");
		}

		widthPrintset1(node.left, lineNo, width - 1);
		widthPrintset1(node.right, lineNo, width + 1);

	}

	private static void GetWidth(Node node, int width, pair p) {
		if (node == null) {
			return;
		}

		if (width > p.max) {
			p.max = width;
		}

		if (width < p.min) {
			p.min = width;
		}

		GetWidth(node.left, width - 1, p);
		GetWidth(node.right, width + 1, p);
	}

	private static void VerticalOderSet2(Node node, int width, HashMap<Integer, HashSet<Integer>> set) {

		if (node == null) {
			return;
		}

		if (!set.containsKey(width)) {
			set.put(width, new HashSet<>());
			set.get(width).add(node.data);
		} else {
			set.get(width).add(node.data);
		}

		VerticalOderSet2(node.left, width, set);
		VerticalOderSet2(node.right, width, set);
	}

}
