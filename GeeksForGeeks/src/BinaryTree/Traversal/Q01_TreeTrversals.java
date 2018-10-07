package BinaryTree.Traversal;

public class Q01_TreeTrversals {
	private class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private Node root;

	public void preOder() {
		preOder(root);
	}

	private void preOder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data + " ");
		preOder(node.left);
		preOder(node.right);

	}
	
	public void postOder() {
		postOder(root);
	}

	private void postOder(Node node) {
		if (node == null) {
			return;
		}
	
		postOder(node.left);
		postOder(node.right);
		System.out.println(node.data + " ");

	}
	
	public void InOder() {
		InOder(root);
	}

	private void InOder(Node node) {
		if (node == null) {
			return;
		}
	
		InOder(node.left);
		System.out.println(node.data + " ");
		InOder(node.right);

	}

}
