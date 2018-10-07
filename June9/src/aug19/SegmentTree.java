package aug19;

public class SegmentTree {
	private class Node {
		int data;
		int ssi;
		int sei;
		Node left;
		Node right;
	}
	
	Node root;
	ISegmentOperator operator;
	
	public SegmentTree(int[] arr, ISegmentOperator operator){
		this.operator = operator;
		this.root = this.construct(arr, 0, arr.length - 1);
	}
	
	private Node construct(int[] arr, int lo, int hi){
		if(lo == hi){
			Node node = new Node();
			node.ssi = lo;
			node.sei = hi;
			node.data = arr[lo];
			return node;
		}
		
		Node node = new Node();
		node.ssi = lo;
		node.sei = hi;
		
		int mid = (lo + hi) / 2;
		
		node.left = construct(arr, lo, mid);
		node.right = construct(arr, mid + 1, hi);
		
		node.data = operator.operation(node.left.data, node.right.data);		
		return node;
	}

	public void display(){
		display(root);
	}
	
	private void display(Node node){
		if(node == null){
			return;
		}
		
		String str = node.left == null? "." : node.left.data  + "";
		str += " <- " + node.data + "[" + node.ssi + "_" + node.sei + "] -> ";
		str += node.right == null? "." : node.right.data  + "";
		
		System.out.println(str);
		
		display(node.left);
		display(node.right);
	}

	public int query(int qsi, int qei){
		return query(root, qsi, qei);
	}
	
	private int query(Node node, int qsi, int qei){
		if(node.ssi >= qsi && node.sei <= qei){
			// node is completely inside the query
			return node.data;
		} else if(node.sei < qsi || node.ssi > qei){
			// node is completely inside the query
			return operator.identity();
		} else {
			int lc = query(node.left, qsi, qei);
			int rc = query(node.right, qsi, qei);
			return operator.operation(lc, rc);
		}
	}
	
	public void update(int idx, int nv){
		update(root, idx, nv);
	}
	
	private void update(Node node, int idx, int nv){
		if(node.ssi == idx && node.sei == idx){
			node.data = nv;
			return;
		}
		
		if(idx >= node.ssi && idx <= node.sei){
			update(node.left, idx, nv);
			update(node.right, idx, nv);
			
			node.data = operator.operation(node.left.data, node.right.data);
		}
	}
}
