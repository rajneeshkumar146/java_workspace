package trees;

import java.util.LinkedList;

public class BST {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public BST(int[] pre, int[] in){
		this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}
	
	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi){
		if(plo > phi){
			return null;
		}
		
		// create and attach data
		Node node = new Node();
		this.size++;
		
		node.data = pre[plo];
		
		// search in ino -> to know the number of elements on left side
		int srchIdx = -1;
		for(int i = ilo; i <= ihi; i++){
			if(in[i] == pre[plo]){
				srchIdx = i;
				break;
			}
		}
		
		int nelOnls = srchIdx - ilo;
		
		// set left
		node.left = this.construct(pre, plo + 1, plo + nelOnls, in, ilo, srchIdx - 1);
		
		// set right
		node.right = this.construct(pre, plo + nelOnls + 1, phi, in, srchIdx + 1, ihi);
		
		return node;
	}
	
	public BST(int[] sa){
		this.root = this.construct(sa, 0, sa.length - 1);
	}
	
	private Node construct(int[] sa, int lo, int hi){
		if(lo > hi){
			return null;
		}
		
		int mid = (lo + hi) / 2;
		
		Node node = new Node();
		this.size++;
		node.data = sa[mid];
		
		node.left = this.construct(sa, lo, mid - 1);
		node.right = this.construct(sa, mid + 1, hi);
		
		return node;
	}
	
	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}

		str += " => " + node.data + " <= ";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}

		System.out.println(str);

		this.display(node.left);
		this.display(node.right);
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}

		int ls = this.size2(node.left);
		int rs = this.size2(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if(node.right != null){
			return this.max(node.right);
		} else {
			return node.data;
		}
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int lh = this.height(node.left);
		int rh = this.height(node.right);
		return Math.max(lh, rh) + 1;
	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		if(data > node.data){
			return find(node.right, data);
		} else if(data < node.data){
			return find(node.left, data);
		} else  // equal
		{
			return true;
		}
	}

	public int diameter() {
		return this.diameter(this.root);
	}

	public int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int ld = this.diameter(node.left); // on the left subtree what is
											// maximum edge distance between any
											// pair of nodes
		int rd = this.diameter(node.right); // on the right subtree what is
											// maximum edge distance between any
											// pair of nodes

		int lh = this.height(node.left);
		int rh = this.height(node.right);

		int rootFactor = lh + rh + 2;
		return Math.max(rootFactor, Math.max(ld, rd));
	}

	public int diameter2() {
		return this.diameter2(this.root).diameter;
	}

	public DiaPair diameter2(Node node) {
		if (node == null) {
			DiaPair bp = new DiaPair();

			bp.height = -1;
			bp.diameter = 0;

			return bp;
		}

		DiaPair lp = this.diameter2(node.left);
		DiaPair rp = this.diameter2(node.right);

		DiaPair mp = new DiaPair();

		mp.height = Math.max(lp.height, rp.height) + 1;
		mp.diameter = Math.max(lp.height + rp.height + 2, Math.max(lp.diameter, rp.diameter));

		return mp;
	}

	private class DiaPair {
		int height;
		int diameter;
	}

	public boolean IsBalanced() {
		return this.IsBalanced(this.root).isBalanced;
	}

	private BalancedPair IsBalanced(Node node) {
		if (node == null) {
			BalancedPair bp = new BalancedPair();

			bp.height = -1;
			bp.isBalanced = true;

			return bp;
		}

		BalancedPair lp = IsBalanced(node.left);
		BalancedPair rp = IsBalanced(node.right);

		BalancedPair mp = new BalancedPair();

		mp.height = Math.max(lp.height, rp.height) + 1;

		if (lp.isBalanced && rp.isBalanced && Math.abs(lp.height - rp.height) <= 1) {
			mp.isBalanced = true;
		} else {
			mp.isBalanced = false;
		}

		return mp;
	}

	private class BalancedPair {
		int height;
		boolean isBalanced;
	}

	public void preOrder() {
		this.preOrder(this.root);
		System.out.println(".");
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + ", ");
		this.preOrder(node.left);
		this.preOrder(node.right);
	}

	public void postOrder() {
		this.postOrder(this.root);
		System.out.println(".");
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}

		this.postOrder(node.left);
		this.postOrder(node.right);
		System.out.print(node.data + ", ");
	}

	public void inOrder() {
		this.inOrder(this.root);
		System.out.println(".");
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}

		this.inOrder(node.left);
		System.out.print(node.data + ", ");
		this.inOrder(node.right);
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);

		while (queue.size() != 0) {
			Node temp = queue.removeFirst();

			System.out.print(temp.data + ", ");

			if (temp.left != null) {
				queue.addLast(temp.left);
			}

			if (temp.right != null) {
				queue.addLast(temp.right);
			}
		}

		System.out.println("");
	}

	public void preOrderI() {
		LinkedList<OrderPair> stack = new LinkedList<>();

		stack.addFirst(new OrderPair(this.root));
		while (stack.size() != 0) {
			OrderPair temp = stack.getFirst();

			if (temp.selfDone == false) {
				System.out.print(temp.node.data + ", ");
				temp.selfDone = true;
			} else if (temp.leftDone == false) {
				if (temp.node.left != null) {
					OrderPair leftPair = new OrderPair(temp.node.left);
					stack.addFirst(leftPair);
				}
				temp.leftDone = true;
			} else if (temp.rightDone == false) {
				if (temp.node.right != null) {
					OrderPair rightPair = new OrderPair(temp.node.right);
					stack.addFirst(rightPair);
				}
				temp.rightDone = true;
			} else {
				stack.removeFirst();
			}
		}
		System.out.println();
	}

	public void inOrderI() {
		LinkedList<OrderPair> stack = new LinkedList<>();

		stack.addFirst(new OrderPair(this.root));
		while (stack.size() != 0) {
			OrderPair temp = stack.getFirst();

			if (temp.leftDone == false) {
				if (temp.node.left != null) {
					OrderPair leftPair = new OrderPair(temp.node.left);
					stack.addFirst(leftPair);
				}
				temp.leftDone = true;
			} else if (temp.selfDone == false) {
				System.out.print(temp.node.data + ", ");
				temp.selfDone = true;
			} else if (temp.rightDone == false) {
				if (temp.node.right != null) {
					OrderPair rightPair = new OrderPair(temp.node.right);
					stack.addFirst(rightPair);
				}
				temp.rightDone = true;
			} else {
				stack.removeFirst();
			}
		}
		System.out.println();
	}

	public void postOrderI() {
		LinkedList<OrderPair> stack = new LinkedList<>();

		stack.addFirst(new OrderPair(this.root));
		while (stack.size() != 0) {
			OrderPair temp = stack.getFirst();

			if (temp.leftDone == false) {
				if (temp.node.left != null) {
					OrderPair leftPair = new OrderPair(temp.node.left);
					stack.addFirst(leftPair);
				}
				temp.leftDone = true;
			} else if (temp.rightDone == false) {
				if (temp.node.right != null) {
					OrderPair rightPair = new OrderPair(temp.node.right);
					stack.addFirst(rightPair);
				}
				temp.rightDone = true;
			} else if (temp.selfDone == false) {
				System.out.print(temp.node.data + ", ");
				temp.selfDone = true;
			} else {
				stack.removeFirst();
			}
		}
		System.out.println();
	}

	private class OrderPair {
		Node node;

		boolean selfDone;
		boolean leftDone;
		boolean rightDone;

		OrderPair(Node node) {
			this.node = node;
		}
	}

	public void printrange(int lo, int hi){
		this.printrange(this.root, lo, hi);
	}
	
	private void printrange(Node node, int lo, int hi){
		if (node == null) {
			return;
		}
		
		if(node.data < lo){
			printrange(node.right, lo, hi);
		} else if(node.data > hi){
			printrange(node.left, lo, hi);
		} else if(node.data >= lo && node.data <= hi){
			printrange(node.left, lo, hi);
			System.out.println(node.data);
			printrange(node.right, lo, hi);
		}
	}
	
	private class HeapMover{
		int sum = 0;
	}
	
	public void replaceWSumLarger(){
		HeapMover mover = new HeapMover();
		this.replaceWSumLarger(this.root, mover);
	}
	
	private void replaceWSumLarger(Node node, HeapMover mover){
		if(node == null){
			return;
		}
		
		replaceWSumLarger(node.right, mover);
		
		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;
		
		replaceWSumLarger(node.left, mover);
	}
	
	public void replaceWSumLarger1(){
		this.replaceWSumLarger1(this.root, 0);
	}
	
	private int replaceWSumLarger1(Node node, int sum){
		if(node == null){
			return sum;
		}
		
		int orsplusrsf = replaceWSumLarger1(node.right, sum);
		
		int temp = node.data;
		node.data = orsplusrsf;
		
		int finalSum = replaceWSumLarger1(node.left, orsplusrsf + temp);
		return finalSum;
	}

	public void addNode(int data){
		addNode(root, data);
	}
	
	public void addNode(Node node, int data){
		if(data > node.data){
			if(node.right == null){
				node.right = new Node();
				node.right.data = data;
				size++;
			} else {
				addNode(node.right, data);
			}
		} else if(data < node.data){
			if(node.left == null){
				node.left = new Node();
				node.left.data = data;
				size++;
			} else {
				addNode(node.left, data);
			}
		} else {
			
		}
	}
	
	public void removeNode(int data){
		this.removeNode(data, null, this.root, true);
	}
	
	private void removeNode(int data, Node parent, Node child, boolean ilc){
		if(data > child.data){
			removeNode(data, child, child.right, false);
		} else if(data < child.data){
			removeNode(data, child, child.left, true);
		} else {
			if(child.left != null && child.right != null){
				int lmax = this.max(child.left);
				child.data = lmax;
				this.removeNode(lmax, child, child.left, true);
			} else if(child.left != null){
				if(ilc){
					parent.left = child.left;
				} else {
					parent.right = child.left;
				}
				
				this.size--;
			} else if(child.right != null){
				if(ilc){
					parent.left = child.right;
				} else {
					parent.right = child.right;
				}
				
				this.size--;
			} else {
				if(ilc){
					parent.left = null;
				} else {
					parent.right = null;
				}
				
				this.size--;
			}
		}
	}
	
}
