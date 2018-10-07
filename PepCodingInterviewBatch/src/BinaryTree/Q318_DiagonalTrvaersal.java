
package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Q318_DiagonalTrvaersal {
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
		// DiagonalTrversalREC(nodes[0]);
		DiaggonalTraversalItr(nodes[0]);
	}

	private static void DiagonalTrversalREC(Node node, HashMap<Integer, HashSet<Integer>> map, int count) {
		if (node == null) {
			return;
		}

		if (!map.containsKey(count)) {
			map.put(count, new HashSet<>());
			map.get(count).add(node.data);
		} else {
			map.get(count).add(node.data);
		}
		
		 
		DiagonalTrversalREC(node.right, map, count);
		DiagonalTrversalREC(node.left, map, count + 1);

	}

	private static void DiaggonalTraversalItr(Node node) {

		LinkedList<Node> que1 = new LinkedList<>();// addLast,removeFirst.
		LinkedList<Node> que2 = new LinkedList<>();

		que1.addFirst(node);

		while (!que1.isEmpty()) {
			node = que1.removeFirst();

			while (node != null) {
				if (node.left != null) {
					que2.addFirst(node.left);
				}
				System.out.print(node.right + " ");
				node = node.right;
			}

			LinkedList<Node> temp = que1;
			que1 = que2;
			que2 = temp;
			System.out.println();
		}

	}

}
