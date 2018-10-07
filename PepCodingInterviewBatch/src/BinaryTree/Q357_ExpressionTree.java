package BinaryTree;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q357_ExpressionTree {
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
		
		InFixExpressionTree(scn.nextLine());

	}

	// ==========================================================================================================================

	private static void InFixExpressionTree(String str) {
		ArrayDeque<Node> stack = new ArrayDeque<>(); // AddFirst,RemoveFirst.

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			Node node = new Node(ch, null, null);
			if (ch >= 'a' && ch <= 'z') {
				stack.addFirst(node);
			} else {
				Node one = stack.removeFirst();
				Node two = stack.removeFirst();

				node.left = two;
				node.right = one;

				stack.addFirst(node);
			}
		}

		display(stack.peekFirst());

	}

}

/*Test Case 1
abc*d*-
a => - <= *
. => a <= .
* => * <= d
b => * <= c
. => b <= .
. => c <= .
. => d <= .
*/

/*Test Case 2
ab+cd-*
+ => * <= -
a => + <= b
. => a <= .
. => b <= .
c => - <= d
. => c <= .
. => d <= .
*/
