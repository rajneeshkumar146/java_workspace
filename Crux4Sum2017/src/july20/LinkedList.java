package july20;

public class LinkedList {
	private class Node {
		private int data;
		private Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// o1
	public void addLast(int value) {
		Node node = new Node();
		node.data = value;
		node.next = null;

		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}

		this.size++;
	}

	// o1
	public void addFirst(int value) {
		Node node = new Node();
		node.data = value;

		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			node.next = this.head;
			this.head = node;
		}

		this.size++;
	}

	// on
	public void addAt(int value, int idx) throws Exception {
		if (idx < 0 || idx > size) {
			throw new Exception("Out of bound");
		}

		if (idx == 0) {
			addFirst(value);
		} else if (idx == size) {
			addLast(value);
		} else {
			Node node = new Node();
			node.data = value;

			Node m1 = getNodeAt(idx - 1);
			Node p1 = m1.next;

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
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	// on
	public void display() {
		System.out.println("---------------------------------------");

		Node node = this.head;
		while (node != null) {
			System.out.print(node.data + ", ");
			node = node.next;
		}
		System.out.println(".");

		System.out.println("---------------------------------------");
	}

	// o1
	public int getFirst() throws Exception {
		if (size == 0) {
			throw new Exception("List is empty");
		}
		return head.data;
	}

	// o1
	public int getLast() throws Exception {
		if (size == 0) {
			throw new Exception("List is empty");
		}
		return tail.data;
	}

	// on
	public int getAt(int idx) throws Exception {
		if (size == 0) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Out of bound");
		}

		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	// on
	private Node getNodeAt(int idx) throws Exception {
		if (size == 0) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Out of bound");
		}

		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp;
	}

	// o1
	public int removeFirst() throws Exception {
		if (size == 0) {
			throw new Exception("List is empty");
		}

		int rv = this.head.data;

		if (size == 1) {
			this.head = this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;

		return rv;
	}

	// on
	public int removeLast() throws Exception {
		if (size == 0) {
			throw new Exception("List is empty");
		}

		int rv = this.tail.data;

		if (size == 1) {
			this.head = this.tail = null;
		} else {
			this.tail = getNodeAt(size - 2);
			this.tail.next = null;
		}

		this.size--;

		return rv;
	}

	// on
	public int removeAt(int idx) throws Exception {
		if (size == 0) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Out of bound");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == size - 1) {
			return removeLast();
		} else {
			Node m1 = getNodeAt(idx - 1);
			Node curr = m1.next;
			Node p1 = curr.next;

			m1.next = p1;
			this.size--;

			return curr.data;
		}

	}

	// on2
	public void reverseDataIterative() throws Exception {
		int li = 0, ri = size - 1;

		while (li < ri) {
			Node left = getNodeAt(li);
			Node right = getNodeAt(ri);

			int temp = left.data;
			left.data = right.data;
			right.data = temp;

			li++;
			ri--;
		}
	}

	// on
	public void reversePointerIterative() {
		Node p = head, c = head.next;
		while (c != null) {
			Node n = c.next;

			c.next = p;

			p = c;
			c = n;
		}

		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;
	}

	// on
	public void reversePointerRecursive() {
		reversePointerRecursiveHelper(head);

		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;
	}

	public void reversePointerRecursiveHelper(Node node) {
		if (node.next == null) {
			return;
		}
		reversePointerRecursiveHelper(node.next);
		node.next.next = node;
	}

	// on
	public void reverseDataRecursive_NW() {
		this.reverseDataRecursive_NW(head, head);
	}

	private void reverseDataRecursive_NW(Node left, Node right) {
		if (right == null) {
			return;
		}
		reverseDataRecursive_NW(left, right.next);

		int temp = left.data;
		left.data = right.data;
		right.data = temp;

		left = left.next;
	}

	public void reverseDataRecursive_W() {
		HeapMover left = new HeapMover();
		left.node = head;
		this.reverseDataRecursive_W(left, head, 0);
	}

	private void reverseDataRecursive_W(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		reverseDataRecursive_W(left, right.next, floor + 1);

		if (floor >= size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;

			left.node = left.node.next;
		}
	}

	private class HeapMover {
		Node node;
		int counter;
		int kthFromLast;
	}

	public void displayReverse() {
		this.displayReverseHelper(this.head);
		System.out.println(".");
	}

	private void displayReverseHelper(Node node) {
		if (node == null) {
			return;
		}
		displayReverseHelper(node.next);
		System.out.print(node.data + ", ");
	}

	public int kthFromLast(int k){
		HeapMover left = new HeapMover();
		kthFromLast(left, head, k);
		return left.kthFromLast;
	}
	
	private void kthFromLast(HeapMover left, Node node, int k){
		if(node == null){
			return;
		}
		kthFromLast(left, node.next, k);
		
		left.counter++;
		if(left.counter == k){
			left.kthFromLast = node.data;
		}
	}

	public boolean IsPalin() {
		HeapMover left = new HeapMover();
		left.node = head;
		return this.IsPalin(left, head);
	}

	private boolean IsPalin(HeapMover left, Node right) {
		if (right == null) {
			return true;
		}
		boolean res = IsPalin(left, right.next);
		if(res == true && left.node.data == right.data){
			left.node = left.node.next;
			return true;
		} else {
			return false;
		}
	}

	public void fold(){
		HeapMover left = new HeapMover();
		left.node = head;
		fold(left, head, 0);
	}
	
	private void fold(HeapMover left, Node right, int floor){
		if(right == null){
			return;
		}
		fold(left, right.next, floor + 1);
		
		if(floor > size / 2){
			right.next = left.node.next;
			left.node.next = right;
			left.node = right.next;
		} else if(floor == size / 2){
			tail = right;
			tail.next = null;
		}
	}

	private Node midNode(){
		Node slow = head, fast = head;
		
		while(true){
			if(fast.next == null || fast.next == tail){
				break;
			}
			
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}

	public LinkedList mergedTwoSortedLists(LinkedList other){
		LinkedList merged = new LinkedList();
		
		Node tt = this.head, ot = other.head;
		while(tt != null && ot != null){
			if(tt.data < ot.data){
				merged.addLast(tt.data);
				tt = tt.next;
			} else {
				merged.addLast(ot.data);
				ot = ot.next;
			}
		}
		
		while(tt != null){
			merged.addLast(tt.data);
			tt = tt.next;
		}
		
		while(ot != null){
			merged.addLast(ot.data);
			ot = ot.next;
		}
		
		return merged;
	}
	
	public LinkedList mergeSort(){
		if(head == tail){
			return this;
		}
		
		Node mid = midNode();
		Node midn = mid.next;
		
		LinkedList fh = new LinkedList();
		LinkedList sh = new LinkedList();
		
		fh.head = this.head;
		fh.tail = mid;
		fh.tail.next = null;
		
		sh.head = midn;
		sh.tail = tail;
		sh.tail.next = null;
		
		LinkedList sfh = fh.mergeSort();
		LinkedList ssh = sh.mergeSort();
		
		LinkedList sortedfull = sfh.mergedTwoSortedLists(ssh);
		return sortedfull;
	}
}
