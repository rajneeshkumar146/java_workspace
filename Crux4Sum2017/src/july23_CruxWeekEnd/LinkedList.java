package july23_CruxWeekEnd;


public class LinkedList {
	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// o1
	public void addFirst(int data) {
		Node node = new Node();
		node.data = data;
		node.next = this.head;

		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.head = node;
		}

		this.size++;
	}

	// o1
	public void addLast(int data) {
		Node node = new Node();
		node.data = data;
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

	// on
	public void addAt(int data, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("Index out of bounds.");
		}

		if (idx == 0) {
			addFirst(data);
		} else if (idx == size) {
			addLast(data);
		} else {
			Node natidxm1 = getNodeAt(idx - 1);
			Node natidxp1 = natidxm1.next;

			Node node = new Node();
			node.data = data;
			node.next = natidxp1;
			natidxm1.next = node;

			this.size++;
		}
	}

	// o1
	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty.");
		}

		return this.head.data;
	}

	// o1
	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty.");
		}

		return this.tail.data;
	}

	// on
	public int getAt(int idx) throws Exception {
		Node natidx = getNodeAt(idx);
		return natidx.data;
	}

	// on
	private Node getNodeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Index is out of bounds.");
		}

		Node node = this.head;
		for (int i = 0; i < idx; i++) {
			node = node.next;
		}

		return node;
	}

	// o1
	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty.");
		}

		int rv = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}
		this.size--;

		return rv;
	}

	// on
	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty.");
		}

		int rv = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node sm2 = this.getNodeAt(size - 2);
			this.tail = sm2;
			this.tail.next = null;
		}
		this.size--;

		return rv;
	}

	// on
	public int removeAt(int idx) throws Exception {
		if (idx < 0 || idx >= this.size) {
			throw new Exception("Index out of bounds.");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == size - 1) {
			return removeLast();
		} else {
			Node nm1 = getNodeAt(idx - 1);
			Node node = nm1.next;
			Node np1 = node.next;

			nm1.next = np1;
			this.size--;

			return node.data;
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		System.out.println("--------------------------------------------");
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " => ");
			temp = temp.next;

		}
		System.out.println(".");
		System.out.println("--------------------------------------------");
	}

	// on2
	public void reverseDataIterative() throws Exception {
		int left = 0, right = this.size - 1;

		while (left <= right) {
			Node leftNode = getNodeAt(left);
			Node rightNode = getNodeAt(right);

			int temp = leftNode.data;
			leftNode.data = rightNode.data;
			rightNode.data = temp;

			left++;
			right--;
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
		this.reversePointerRecursive(this.head);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void reversePointerRecursive(Node node) {
		if (node == tail) {
			return;
		}
		reversePointerRecursive(node.next);
		node.next.next = node;
	}

	// on
	public void reverseDataRecursive() {
		HeapMover left = new HeapMover();
		left.node = this.head;
		this.reverseDataRecursive(left, this.head, 0);
	}

	private void reverseDataRecursive(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		this.reverseDataRecursive(left, right.next, floor + 1);

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

	// on
	public void displayReverse() {
		this.displayReverse(this.head);
		System.out.println(".");
	}

	private void displayReverse(Node node) {
		if (node == null) {
			return;
		}
		displayReverse(node.next);
		System.out.print(node.data + " => ");
	}

	public boolean IsPalin() {
		HeapMover left = new HeapMover();
		left.node = this.head;
		return IsPalin(left, this.head);
	}

	private boolean IsPalin(HeapMover left, Node right) {
		if (right == null) {
			return true;
		}
		boolean result = IsPalin(left, right.next);

		if (result == true) {
			if (left.node.data != right.data) {
				return false;
			} else {
				left.node = left.node.next;
				return true;
			}
		} else {
			return false;
		}
	}

	public void fold() {
		HeapMover left = new HeapMover();
		left.node = this.head;
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
		}

		if (floor == size / 2) {
			this.tail = right;
			this.tail.next = null;
		}
	}

	public int kthFromLast(int k) {
		Node slow = this.head, fast = this.head;
		
		for(int i = 0; i < k; i++){
			fast = fast.next;
		}
		
		while(fast != null){
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow.data;
	}

	public int midElement() {
		Node slow = this.head, fast = this.head;

		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow.data;
	}
	
	private Node midNode() {
		Node slow = this.head, fast = this.head;

		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

	public LinkedList mergeTwoSortedLinkedList(LinkedList other){
		LinkedList merged = new LinkedList();
		
		Node thisTemp = this.head, otherTemp = other.head;
		while(thisTemp != null && otherTemp != null){
			if(thisTemp.data < otherTemp.data){
				merged.addLast(thisTemp.data);
				thisTemp = thisTemp.next;
			} else {
				merged.addLast(otherTemp.data);
				otherTemp = otherTemp.next;
			}
		}
		
		while(thisTemp != null){
			merged.addLast(thisTemp.data);
			thisTemp = thisTemp.next;
		}
		
		while(otherTemp != null){
			merged.addLast(otherTemp.data);
			otherTemp = otherTemp.next;
		}
		
		return merged;
	}

	public LinkedList mergeSort(){
		if(this.size == 1){
			return this;
		}
		
		Node mid = this.midNode();
		Node midNext = mid.next;
		
		LinkedList fh = new LinkedList();
		fh.head = this.head;
		fh.tail = mid;
		fh.tail.next = null;
		fh.size = (this.size + 1) / 2;
		
		LinkedList sh = new LinkedList();
		sh.head = midNext;
		sh.tail = this.tail;
		sh.tail.next = null;
		sh.size = this.size / 2;
		
		fh = fh.mergeSort();
		sh = sh.mergeSort();
		
		LinkedList merged = fh.mergeTwoSortedLinkedList(sh);
		return merged;
	}

	public void kReverse(int k) throws Exception{
		LinkedList prev = null, curr = null;
		
		while(this.size != 0){
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

	public void remmoveDuplicates() throws Exception{
		LinkedList list = new LinkedList();
		
		while(this.size != 0){
			int data = this.removeFirst();
			
			if(list.isEmpty() || list.tail.data != data){
				list.addLast(data);
			}
		}
		
		this.head = list.head;
		this.tail = list.tail;
		this.size = list.size;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
