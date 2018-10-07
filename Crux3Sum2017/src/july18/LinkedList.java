package july18;

public class LinkedList {
	private class Node {
		private int data;
		private Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	private void handleAdd0(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;

		this.head = node;
		this.tail = node;
		this.size = 1;
	}

	// o1
	public void addFirst(int data) {
		if (this.size == 0) {
			this.handleAdd0(data);
		} else {
			Node node = new Node();
			node.data = data;
			node.next = this.head;

			this.head = node;
			this.size++;
		}
	}

	// o1
	public void addLast(int data) {
		if (this.size == 0) {
			this.handleAdd0(data);
		} else {
			Node node = new Node();
			node.data = data;
			node.next = null;

			this.tail.next = node;
			this.tail = node;
			this.size++;
		}
	}

	// on
	public void addAt(int data, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("Out of bound");
		}

		if (idx == 0) {
			this.addFirst(data);
		} else if (idx == this.size) {
			this.addLast(data);
		} else {
			Node m1 = getNodeAt(idx - 1);
			Node p1 = m1.next;

			Node node = new Node();
			node.data = data;

			m1.next = node;
			node.next = p1;

			this.size++;
		}
	}

	// o1
	public int size() {
		return this.size;
	}

	// o1
	public boolean isEmpty() {
		return this.size == 0;
	}

	// on
	public void display() {
		System.out.println("-------------------------------------------------");
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println(".");
		System.out.println("-------------------------------------------------");
	}

	// o1
	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		return this.head.data;
	}

	// o1
	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		return this.tail.data;
	}

	// on
	public int getAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		if (idx < 0 || idx > this.size - 1) {
			throw new Exception("Out of bound");
		}

		int cidx = 0;
		Node cnode = this.head;

		while (cidx < idx) {
			cnode = cnode.next;
			cidx++;
		}

		return cnode.data;
	}

	// on
	private Node getNodeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		if (idx < 0 || idx > this.size - 1) {
			throw new Exception("Out of bound");
		}

		int cidx = 0;
		Node cnode = this.head;

		while (cidx < idx) {
			cnode = cnode.next;
			cidx++;
		}

		return cnode;
	}

	// o1
	private int handleRemove1() {
		int rv = this.head.data;

		this.head = null;
		this.tail = null;
		this.size = 0;

		return rv;
	}

	// o1
	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}

		if (this.size == 1) {
			return handleRemove1();
		} else {
			int rv = this.head.data;

			this.head = this.head.next;
			this.size--;

			return rv;
		}
	}

	// on
	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}

		if (this.size == 1) {
			return handleRemove1();
		} else {
			int rv = this.tail.data;

			this.tail = this.getNodeAt(this.size - 2);// second last
			this.tail.next = null;
			this.size--;

			return rv;
		}
	}

	// on
	public int removeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		if (idx < 0 || idx > this.size - 1) {
			throw new Exception("Out of bound");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size - 1) {
			return this.removeLast();
		} else {
			Node m1 = getNodeAt(idx - 1);
			Node n = m1.next;
			Node p1 = n.next;

			m1.next = p1;
			this.size--;

			return n.data;
		}
	}

	// on2
	public void reverseDataIterative() throws Exception {
		int lidx = 0, ridx = this.size - 1;
		while (lidx <= ridx) {
			Node leftNode = this.getNodeAt(lidx);
			Node rightNode = this.getNodeAt(ridx);

			int temp = leftNode.data;
			leftNode.data = rightNode.data;
			rightNode.data = temp;

			lidx++;
			ridx--;
		}
	}

	// on
	public void reversePointerIterative() {
		Node prev = this.head;
		Node curr = prev.next;

		while (curr != null) {
			Node next = curr.next;

			curr.next = prev;

			prev = curr;
			curr = next;
		}

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	// on
	public void reversePointerRecursive() {
		this.reversePointerRecursive(this.head, this.head.next);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void reversePointerRecursive(Node prev, Node curr) {
		if (curr == null) {
			return;
		}

		Node next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;

		reversePointerRecursive(prev, curr);
	}

	// on
	// public void reverseDataRecursive_NW(){
	// this.reverseDataRecursive_NW(this.head, this.head);
	// }
	//
	// private void reverseDataRecursive_NW(Node left, Node right){
	// if(right == null){
	// return;
	// }
	// reverseDataRecursive_NW(left, right.next);
	//
	// int temp = left.data;
	// left.data = right.data;
	// right.data = temp;
	//
	// left = left.next;
	// }

	public void reverseDataRecursive_W() {
		HeapMover left = new HeapMover();
		left.node = head;
		this.reverseDataRecursive_W(left, this.head, 0);
	}

	private void reverseDataRecursive_W(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		reverseDataRecursive_W(left, right.next, floor + 1);

		if (floor >= this.size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;

			left.node = left.node.next;
		}
	}

	private class HeapMover {
		Node node;
	}

	public void displayReverse() {
		this.displayReverse(this.head);
	}

	private void displayReverse(Node node) {
		if (node == null) {
			return;
		}
		this.displayReverse(node.next);
		System.out.println(node.data);
	}

	public boolean IsPalin() {
		HeapMover left = new HeapMover();
		left.node = head;
		return this.IsPalin(left, this.head);
	}

	private boolean IsPalin(HeapMover left, Node right) {
		if (right == null) {
			return true;
		}
		boolean res = IsPalin(left, right.next);

		if (res == false) {
			return false;
		}

		if (left.node.data == right.data) {
			left.node = left.node.next;
			return true;
		} else {
			return false;
		}

	}

	public void fold() {
		HeapMover left = new HeapMover();
		left.node = head;
		fold(left, this.head, 0);
	}

	private void fold(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}

		fold(left, right.next, floor + 1);

		if (floor > size / 2) {
			Node oln = left.node.next;
			left.node.next = right;
			right.next = oln;
			left.node = oln;
		} else if (floor == size / 2) {
			this.tail = right;
			this.tail.next = null;
		}
	}

	public int mid() {
		Node fast = head, slow = head;

		while (true) {
			if (fast.next == null || fast.next.next == null) {
				break;
			}

			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	private Node midNode() {
		Node fast = head, slow = head;

		while (true) {
			if (fast.next == null || fast.next.next == null) {
				break;
			}

			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public LinkedList mergeSortedLinkedLists(LinkedList other) {
		LinkedList merged = new LinkedList();
		Node tt = this.head, ot = other.head;

		while (tt != null && ot != null) {
			if (tt.data < ot.data) {
				merged.addLast(tt.data);
				tt = tt.next;
			} else {
				merged.addLast(ot.data);
				ot = ot.next;
			}
		}

		while (tt != null) {
			merged.addLast(tt.data);
			tt = tt.next;
		}

		while (ot != null) {
			merged.addLast(ot.data);
			ot = ot.next;
		}

		return merged;
	}

	public LinkedList mergeSort() {
		if(this.size == 1){
			return this;
		}
		
		Node mid = midNode();
		Node midN = mid.next;

		LinkedList fhalf = new LinkedList();
		fhalf.head = this.head;
		fhalf.tail = mid;
		fhalf.tail.next = null;
		fhalf.size = (this.size + 1) / 2;

		LinkedList shalf = new LinkedList();
		shalf.head = midN;
		shalf.tail = this.tail;
		shalf.tail.next = null;
		shalf.size = (this.size) / 2;

		fhalf = fhalf.mergeSort();
		shalf = shalf.mergeSort();

		LinkedList sorted = fhalf.mergeSortedLinkedLists(shalf);
		return sorted;
	}

	public void kreverse(int k) throws Exception{
		LinkedList prev = null, curr = null;
		
		while(!this.isEmpty()){
			curr = new LinkedList();
			
			for(int i = 0; i < k; i++){
				curr.addFirst(this.removeFirst());
			}
			
			if(prev == null){
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}
		}
		
		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;
	}
	
	
	
}
