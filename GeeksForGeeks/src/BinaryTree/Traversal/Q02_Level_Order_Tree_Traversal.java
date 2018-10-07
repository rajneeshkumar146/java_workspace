package BinaryTree.Traversal;

import java.util.LinkedList;

public class Q02_Level_Order_Tree_Traversal {

	public class Node {
		private int data;
		private Node left;
		private Node right;

	}

		private Node root;
	

	public void levelOder() {
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node node = queue.removeFirst();
			System.out.print(node.data + " ");
			if (node.left != null) {
				queue.addLast(node.left);
			}
			if (node.right != null) {
				queue.addLast(node.right);
			}
		}
	}
}
