package BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Q359_ReverseTreePath {
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
		int data = scn.nextInt();
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
		ArrayList<Node> list = new ArrayList<>();
		ReverseTreePath(root, data, list);
		for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
			Node n1 = list.get(i);
			Node n2 = list.get(j);

			int temp = n1.data;
			n1.data = n2.data;
			n2.data = temp;

		}

		display(root);

	}

	// ==========================================================================================================================

	private static boolean ReverseTreePath(Node node, int data, ArrayList<Node> list) {

		if (node == null) {
			return false;
		}

		if (node.data == data) {
			list.add(node);
			return true;
		}

		boolean res = false;
		res = res || ReverseTreePath(node.left, data, list);
		res = res || ReverseTreePath(node.right, data, list);

		if (res) {
			list.add(node);
		}

		return res;

	}

}

//https://www.geeksforgeeks.org/reverse-tree-path/
/*Test Case 1
8
12
1 2 3 -1 4 5 -1 -1 -1 6 7 8
2 => 8 <= 5
. => 2 <= 4
6 => 4 <= 7
. => 6 <= .
. => 7 <= .
3 => 5 <= .
1 => 3 <= .
. => 1 <= .
*/

/*Test Case 2
6
12
1 2 3 -1 4 5 -1 -1 -1 6 7 8
4 => 6 <= 3
. => 4 <= 2
1 => 2 <= 7
. => 1 <= .
. => 7 <= .
5 => 3 <= .
8 => 5 <= .
. => 8 <= .
*/
