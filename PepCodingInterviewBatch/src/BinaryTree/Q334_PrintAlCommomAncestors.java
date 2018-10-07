package BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Q334_PrintAlCommomAncestors {
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

		LCAPath(root, scn.nextInt(), scn.nextInt());

	}

	// ==========================================================================================================================

	private static void LCAPath(Node node, int data1, int data2) {

		ArrayList<Integer> list1 = LCA(node, data1);
		ArrayList<Integer> list2 = LCA(node, data2);

//		System.out.println(list1);
//		System.out.println(list2);

		if (list1.size() > 0 && list2.size() > 0) {
			int i = list1.size() - 1;
			int j = list2.size() - 1;
			int ele = 0;
			while (i >= 0 && j >= 0) {
				ele = list1.get(i);

				if (list1.get(i) == list2.get(j)) {
					System.out.print(ele + " ");
				} else {
					break;
				}

				i--;
				j--;
			}

//			System.out.println(ele);
		} else {
			System.out.println("no common ancestor");
		}

	}

	private static ArrayList<Integer> LCA(Node node, int data) {
		if (node == null) {
			return new ArrayList<>();
		}

		if (node.data == data) {
			ArrayList<Integer> res = new ArrayList<>();
			res.add(node.data);
			return res;
		}

		ArrayList<Integer> lres = LCA(node.left, data);
		if (lres.size() > 0) {
			lres.add(node.data);
			return lres;
		}

		ArrayList<Integer> rres = LCA(node.right, data);
		if (rres.size() > 0) {
			rres.add(node.data);
			return rres;
		}

		return new ArrayList<>();
	}

}

/* Test case 1 
12 
1 2 3 4 5 6 7 8 9 10 11 12 
4 11
2 1
*/

/* Test case 2 
12 
1 2 3 -1 4 5 -1 -1 -1 6 7 8
7 8
1
*/

/* Test case 3 
12 
1 2 3 4 -1 -1 5 6 7 -1 -1 -1
6 7
4 2 1
*/
