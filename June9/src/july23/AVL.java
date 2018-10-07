package july23;

import june18.max;

public class AVL {
	private class Node {
		int data;
		Node left;
		Node right;
		int ht;
		int balance;
	}
	
	Node root;
	
	public AVL(int[] sa){
		root = construct(sa, 0, sa.length - 1);
	}
	
	private Node construct(int[] sa, int lo, int hi){
		if(lo > hi){
			return null;
		}
		
		int mid = (lo + hi) / 2;
		
		Node node = new Node();
		node.data = sa[mid];
		node.left = construct(sa, lo, mid - 1);
		node.right = construct(sa, mid + 1, hi);
		node.ht = getHeight(node);
		node.balance = getBalance(node);
		
		return node;
	}
	
	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str = node.left != null ? node.left.data + " " : "-1 ";
		str += "<- " + node.data + "[" + node.ht + ", " + node.balance + "] ->";
		str += node.right != null ? " " + node.right.data : " -1";

		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	private int getHeight(Node node){
		if(node == null){
			return -1;
		}
		
		int lht = -1;
		int rht = -1;
		
		if(node.left != null){
			lht = node.left.ht;
		}
		
		if(node.right != null){
			rht = node.right.ht;
		}
		
		return Math.max(lht, rht) + 1;
	}
	
	private int getBalance(Node node){
		if(node == null){
			return 0;
		}
		
		int lht = -1;
		int rht = -1;
		
		if(node.left != null){
			lht = node.left.ht;
		}
		
		if(node.right != null){
			rht = node.right.ht;
		}
		
		return lht - rht;
	}
	
	public void add(int data){
		root = add(root, data);
	}
	
	private Node add(Node node, int data){
		if(node == null){
			Node base = new Node();
			base.data = data;
			base.ht = 0;
			base.balance = 0;
			return base;
		}
		
		if(data > node.data){
			node.right = add(node.right, data);
		} else if(data < node.data){
			node.left = add(node.left, data);
		} else {
			// nothing
		}
		
		node.ht = getHeight(node);
		node.balance = getBalance(node);
		
		// avl
		if(node.balance > 1){ // ll or lr
			if(getBalance(node.left) > 0){ // ll
				node = rightRotate(node);
			} else { // lr
				node.left = leftRotate(node.left);
				node = rightRotate(node);
			}
		} else if(node.balance < -1){ // rr or rl
			if(getBalance(node.right) < 0){ // rr
				node = leftRotate(node);
			} else { // rl
				node.right = rightRotate(node.right);
				node = leftRotate(node);
			}
		}
		
		return node;
	}

	private Node leftRotate(Node z) {
		Node y = z.right;
		z.right = y.left;
		y.left = z;
		
		z.ht = getHeight(z);
		z.balance = getBalance(z);
		y.ht = getHeight(y);
		y.balance = getBalance(y);
		
		return y;
	}
	
	private Node rightRotate(Node z) {
		Node y = z.left;
		z.left = y.right;
		y.right = z;
		
		z.ht = getHeight(z);
		z.balance = getBalance(z);
		y.ht = getHeight(y);
		y.balance = getBalance(y);
		
		return y;
	}

	public void remove(int data){
		root = remove(root, data);
	}
	
	private Node remove(Node node, int data){
		if(node == null){
			return null;
		}
		
		if(data > node.data){
			node.right = remove(node.right, data);
		} else if(data < node.data){
			node.left = remove(node.left, data);
		} else {
			if(node.left == null && node.right == null){
				return null;
			} else if(node.left != null && node.right == null){
				return node.left;
			} else if(node.left == null && node.right != null){
				return node.right;
			} else {
				int lmax = max(node.left);
				node.data = lmax;
				node.left = remove(node.left, lmax);
			}
		}
		
		node.ht = getHeight(node);
		node.balance = getBalance(node);
		
		// avl
		if(node.balance > 1){ // ll or lr
			if(getBalance(node.left) > 0){ // ll
				node = rightRotate(node);
			} else { // lr
				node.left = leftRotate(node.left);
				node = rightRotate(node);
			}
		} else if(node.balance < -1){ // rr or rl
			if(getBalance(node.right) < 0){ // rr
				node = leftRotate(node);
			} else { // rl
				node.right = rightRotate(node.right);
				node = leftRotate(node);
			}
		}
		
		return node;
	}
	
	private int max(Node node){
		if(node.right == null){
			return node.data;
		} else {
			return max(node.right);
		}
	}
	
	public int lca(int d1, int d2){
		return lca(root, d1, d2);
	}
	
	private int lca(Node node, int d1, int d2){
		if(node.data > d1 && node.data > d2){
			return lca(node.left, d1, d2);
		} else if(node.data < d1 && node.data < d2){
			return lca(node.right, d1, d2);
		} else {
			// path diverges here
			return node.data;
		}
	}
	
}
