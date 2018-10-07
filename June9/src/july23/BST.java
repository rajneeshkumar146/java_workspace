package july23;

public class BST {
	private class Node  {
		int data;
		Node left;
		Node right;
	}
	
	Node root;
	
	public BST(int[] sa){
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
		str += "<- " + node.data + " ->";
		str += node.right != null ? " " + node.right.data : " -1";

		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public boolean find(int data){
		return find(root, data);
	}
	
	private boolean find(Node node, int data){
		if(node == null){
			return false;
		}
		
		if(data == node.data){
			return true;
		} else if(data > node.data){
			return find(node.right, data);
		} else {
			return find(node.left, data);
		}
	}
	
	public int max(){
		return max(root);
	}
	
	private int max(Node node){
		if(node.right == null){
			return node.data;
		} else {
			return max(node.right);
		}
	}
	
	public int min(){
		return min(root);
	}
	
	private int min(Node node){
		if(node.left == null){
			return node.data;
		} else {
			return min(node.left);
		}
	}	

	public void pir(int lo, int hi){
		pir(root, lo, hi);
		System.out.println(".");
	}
	
	private void pir(Node node, int lo, int hi){
		if(node == null){
			return;
		}
		
		if(node.data < lo){
			pir(node.right, lo, hi);
		} else if(node.data > hi){
			pir(node.left, lo, hi);
		} else {
			pir(node.left, lo, hi);
			System.out.print(node.data + " ");			
			pir(node.right, lo, hi);
		}
	}
	
	public void replaceWithSUmOfLarger(){
		replaceWithSumOfLarger(root);
	}
	
	static int sum = 0;

	private void replaceWithSumOfLarger(Node node){
		if(node == null){
			return;
		}
		
		replaceWithSumOfLarger(node.right);
		
		int temp = node.data;
		node.data = sum;
		sum += temp;
		
		replaceWithSumOfLarger(node.left);
	}

	public void add(int data){
		root = add(root, data);
	}
	
	private Node add(Node node, int data){
		if(node == null){
			Node tba = new Node();
			tba.data = data;
			return tba;
		}
		
		if(data < node.data){
			node.left = add(node.left, data);
		} else if(data > node.data){
			node.right = add(node.right, data);
		}
		
		return node;
	}

	public void removeANode(int data){
		root = removeANode(root, data);
	}
	
	private Node removeANode(Node node, int data){
		if(node == null){
			return null;
		}
		
		if(data > node.data){
			node.right = removeANode(node.right, data);
		} else if(data < node.data){
			node.left = removeANode(node.left, data);
		} else {
			// 0 child
			if(node.left == null && node.right == null){
				return null;
			} else if(node.left != null && node.right == null){
				return node.left;
			} else if(node.left == null && node.right != null){
				return node.right;
			} else {
				int lmax = max(node.left);
				node.data = lmax;
				node.left = removeANode(node.left, lmax);
			}
		}
		
		return node;
	}
	
//	private void add(Node node, int data){
//		if(data > node.data){
//			if(node.right != null){
//				add(node.right, data);
//			} else {
//				node.right = new Node();
//				node.right.data = data;
//			}
//		} else if(data < node.data){
//			if(node.left != null){
//				add(node.left, data);
//			} else {
//				node.left = new Node();
//				node.left.data = data;
//			}
//		} else {
//			// it exists already
//		}
//	}
	
	
	
	
	
	
	
	
}
