package BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Q332_CommonAncestor {
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

		int d1 = scn.nextInt();
		int d2 = scn.nextInt();
		rootToNodePath1(d1, d2, root);
		System.out.println(LCA2(root, d1, d2).data);

	}

	// ==========================================================================================================================

	public static void rootToNodePath1(int data1, int data2, Node root) {

		ArrayList<Integer> list1 = rootToNodePath1(root, data1);
		ArrayList<Integer> list2 = rootToNodePath1(root, data2);

		// System.out.println(list1);
		// System.out.println(list2);

		if (list1.size() > 0 && list2.size() > 0) {
			int i = 0;
			int j = 0;
			int ele = 0;
			while (i < list1.size() && j < list2.size()) {
				ele = list1.get(i);
				if (list1.get(i) != list2.get(j)) {
					break;
				}
				i++;
				j++;
			}
			System.out.println(ele);
		} else {
			System.out.println("no common ancestor");
		}

	}

	private static ArrayList<Integer> rootToNodePath1(Node node, int data) {
		if (node == null) {
			return new ArrayList<>();
		}

		if (node.data == data) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(node.data);
			return list;
		}

		ArrayList<Integer> mylist = new ArrayList<>();

		ArrayList<Integer> llist = rootToNodePath1(node.left, data);
		if (llist.size() > 0) {
			mylist.add(node.data);
			mylist.addAll(llist);
			return mylist;
		}

		ArrayList<Integer> rlist = rootToNodePath1(node.right, data);
		if (rlist.size() > 0) {
			mylist.add(node.data);
			mylist.addAll(rlist);
			return mylist;
		}

		return mylist;

	}

	private static Node LCA2(Node node, int d1, int d2) { // MayBe_give_false_commonAncestor;
		if (node == null) {
			return null;
		}

		if (node.data == d1 || node.data == d2) {
			return node;
		}

		Node lca1 = LCA2(node.left, d1, d2);
		Node lca2 = LCA2(node.right, d1, d2);

		if (lca1 != null && lca2 != null) {
			return node;
		} else if (lca1 != null) {
			return lca1;
		} else if (lca2 != null) {
			return lca2;
		} else {
			return null;
		}
	}

}

/*
 * Test case 1 12 1 2 3 4 5 6 7 8 9 10 11 12 4 11 2
 */

/*
 * Test case 2 12 1 2 3 -1 4 5 -1 -1 -1 6 7 8 7 8 1
 */

/*
 * Test case 3 12 1 2 3 4 -1 -1 5 6 7 -1 -1 -1 2 7 2
 */

/*
 * Test case 4 12 1 2 3 4 -1 -1 5 6 7 -1 -1 -1 1 100 Not Found
 */
