package BinaryTree;

import java.util.Scanner;

public class Q348_CustomTreeProblem {
	private static class Node {
		char data;
		Node left;
		Node right;

		Node(char data, Node left, Node right) {
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
		// int[] arr = new int[scn.nextInt()];
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = scn.nextInt();
		// }
		//
		// // creation using the level order, seeing it like a heap
		// // -1 says there is no node
		// Node[] nodes = new Node[arr.length];
		// for (int i = 0; i < nodes.length; i++) {
		// if (arr[i] != -1) {
		// nodes[i] = new Node(arr[i], null, null);
		//
		// if (i > 0) {
		// int pi = (i - 1) / 2;
		//
		// if (i == 2 * pi + 1) {
		// nodes[pi].left = nodes[i];
		// } else {
		// nodes[pi].right = nodes[i];
		// }
		// }
		// }
		// }
		// Node root = nodes[0];
		// display(root);

		customtreeProblem(scn.next(), scn.next());

	}
	// ==========================================================================================================================

	private static void customtreeProblem(String parent, String child) {
		boolean[] childs = new boolean[26];
		Node[] trees = new Node[26];

		SetparentNode(trees, parent);

		for (int i = 0; i < child.length(); i++) {
			char chp = parent.charAt(i);
			char chc = child.charAt(i);
			SetTree(trees, childs, chp, chc);
		}

		StringBuilder roots = new StringBuilder(); // Roots.
		for (int i = 0; i < parent.length(); i++) {
			if (childs[parent.charAt(i) - 'a'] == false) {
				roots.append(parent.charAt(i));
				childs[parent.charAt(i) - 'a'] = true;
			}
		}

		// Display.

		for (int i = 0; i < roots.length(); i++) {
			display(trees[roots.charAt(i) - 'a']);
			System.out.println();

		}

	}

	private static void SetparentNode(Node[] trees, String parent) {
		for (int i = 0; i < parent.length(); i++) {
			char p = parent.charAt(i);
			if (trees[p - 'a'] == null) {
				trees[p - 'a'] = new Node(p, null, null);
			}
		}

	}

	private static void SetTree(Node[] trees, boolean[] childs, char p, char c) {
		Node Parentnode = trees[p - 'a'];
		Node Childnode = trees[c - 'a'] == null ? new Node(c, null, null) : trees[c - 'a'];
		if (Parentnode.left == null) {
			Parentnode.left = Childnode;
		} else {
			Parentnode.right = Childnode;
		}
		childs[c - 'a'] = true;
	}

}

//https://www.geeksforgeeks.org/custom-tree-problem/
/* Test case 1 
aabcdczyx
bgcdefyxw
b <= a => g
c <= b => .
d <= c => f
e <= d => .
. <= e => .
. <= f => .
. <= g => .

y <= z => .
x <= y => .
w <= x => .
. <= w => . 
*/

/* Test case 2 
abba
bcde
b <= a => e
c <= b => d
. <= c => .
. <= d => .
. <= e => .
*/
