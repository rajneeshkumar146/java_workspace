package Class_18and19th_LinkedList;

public class LinkedList_simple {

	private class Node {
		private int data;
		private Node next;

	}

	private class HeapMover {
		private Node node;
	}

	private Node head;
	private Node tail;
	private int size;

	private void handelat0(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;

		this.head = node;
		this.tail = node;
		this.size = 1;

	}

	private Node getNodeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is Empty");
		}

		if (idx < 0 || idx > this.size - 1) {
			throw new Exception("Out of bound");
		}

		int cidx = 0; // cidx=count_index
		Node cnode = this.head; // cnode=count_node

		while (cidx < idx) {
			cnode = cnode.next;
			cidx++;
		}

		return cnode;

	}

	private int removeAtLast() {
		int rv = this.tail.data;

		this.head = null;
		this.tail = null;
		this.size = 0;

		return rv;
	}

	public void addfirst(int data) {
		if (size == 0) {
			this.handelat0(data);

		} else {
			Node node = new Node();
			node.data = data;
			node.next = this.head;

			this.head = node;
			this.size++;

		}

	}

	public void addlast(int data) {
		if (this.size == 0) {
			this.handelat0(data);

		} else {
			Node node = new Node();
			node.data = data;
			node.next = null;

			this.tail.next = node;
			this.tail = node;
			this.size++;
		}

	}

	public void addAt(int data, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("Out of bound");
		}

		if (this.size == 0) {
			this.handelat0(data);
		} else if (idx == this.size) {
			this.addlast(data);
		} else {
			Node m1 = getNodeAt(idx - 1);
			Node p1 = m1.next;

			Node node = new Node();
			node.data = data;
			node.next = p1;
			m1.next = node;
			this.size++;
		}

	}

	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}

		if (this.size == 1) {
			return removeAtLast();
		}

		int rv = this.head.data;
		this.head = this.head.next;
		this.size--;

		return rv;
	}

	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}

		if (this.size == 1) {
			return removeAtLast();
		}

		int rv = this.tail.data;
		this.tail = this.getNodeAt(size - 2);
		this.tail.next = null;
		this.size--;

		return rv;
	}

	public int removeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}

		if (this.size == 1) {
			return removeAtLast();
		}

		Node m1 = getNodeAt(idx - 1);
		Node at = m1.next;
		Node p1 = m1.next.next; // Node p1=at.next;

		int rv = at.data;
		m1.next = p1;
		return rv;
	}

	public int getfirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is Emplt");
		}

		return this.head.data;
	}

	public int getlast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is Empty");
		}

		return this.tail.data;
	}

	public int getAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is Empty");
		}

		if (idx < 0 || idx > this.size - 1) {
			throw new Exception("Out of bound");
		}

		int cidx = 0; // cidx=count_index
		Node cnode = this.head; // cnode=count_node

		while (cidx < idx) {
			cnode = cnode.next;
			cidx++;
		}

		return cnode.data;

	}

	public void reverseDataIter() throws Exception { // O(n^2) overall

		int lidx = 0, ridx = this.size - 1;

		while (lidx <= ridx) { // O(n)
			Node left = getNodeAt(lidx); // O(n)
			Node right = getNodeAt(ridx); // O(n)

			int temp = left.data;
			left.data = right.data;
			right.data = temp;

			lidx++;
			ridx--;

		}

	}

	public void reversePointerIter() throws Exception {

		Node prev = this.head;
		Node curr = prev.next;

		while (curr != null) {
			Node nex = curr.next;

			curr.next = prev;
			prev = curr;

			curr = nex;
		}
		Node temp = this.head;
		this.head = tail;
		this.tail = temp;
		this.tail.next = null;

	}

	public void reversePointerRecur() throws Exception {

		this.reversePointerRecur(this.head, this.head.next);

	}

	private void reversePointerRecur(Node prev, Node curr) throws Exception {
		if (curr == null) {
			Node temp = this.head;
			this.head = tail;
			this.tail = temp;
			this.tail.next = null;
			return;
		}

		Node nex = curr.next;

		curr.next = prev;
		prev = curr;

		curr = nex;

		reversePointerRecur(prev, curr);
	}

	public void displayReverse() {
		this.displayReverse(this.head);

	}

	private void displayReverse(Node node) { // O(n)
		if (node == null) {
			return;
		}

		displayReverse(node.next);
		System.out.println(node.data);

	}

	public void reverseDataRecur() {

		HeapMover left = new HeapMover(); // formed_at_heap_but_refernce_at_Stack
		left.node = head;
		reverseDataRecur(left, this.head, 0);

	}

	private void reverseDataRecur(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}

		reverseDataRecur(left, right.next, floor + 1);
		if (floor > this.size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;
			left.node = left.node.next;
		}

	}

	public boolean palidromeRecur() {
		HeapMover left = new HeapMover(); // formed_at_heap_but_refernce_at_Stack
		left.node = head;
		return palidromeRecur(left, this.head, 0);

	}

	private boolean palidromeRecur(HeapMover left, Node right, int floor) {
		if (right == null) {
			return true;
		}

		boolean result = palidromeRecur(left, right.next, floor + 1);

		if (result == false) {
			return false;
		}
		if (floor >= this.size / 2) {
			if (left.node.data == right.data) {
				return true;
			}
		}

		return result;
	}

	public void fold() {
		HeapMover left = new HeapMover(); // formed_at_heap_but_refernce_at_Stack
		left.node = head;
		fold(left, this.head, 0);
	}

	private void fold(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}

		fold(left, right.next, floor + 1);
		if (floor > this.size / 2) {
			Node oln = left.node.next;
			left.node.next = right;
			right.next = oln;
			left.node = oln;
		} else if (floor == size / 2) {
			this.tail = right;
			this.tail.next = null;
		}

	}

	public int Kth_element(int n) {
		Node fast = this.head;
		Node slow = this.head;

		for (int i = 1; i < n; i++) {
			fast = fast.next;
		}

		while (true) {
			if (fast.next == null) {
				break;
			}
			fast = fast.next;
			slow = slow.next;
		}

		return slow.data;

	}

	public int midInt() {
		Node fast = this.head;
		Node slow = this.head;

		while (true) {
			if (fast.next == null || fast.next.next == null) {
				break;
			}
			fast = fast.next.next;
			slow = slow.next;

		}

		return slow.data;

	}

	private Node getMidNode() {
		Node fast = this.head;
		Node slow = this.head;

		while (true) {
			if (fast.next == null || fast.next.next == null) {
				break;
			}
			fast = fast.next.next;
			slow = slow.next;

		}

		return slow;

	}

	public LinkedList_simple mergedSortTwoLL(LinkedList_simple other) {

		Node tt = this.head, ot = other.head;

		LinkedList_simple result = new LinkedList_simple();

		while (tt != null && ot != null) {
			if (tt.data < ot.data) {
				result.addlast(tt.data);
				tt = tt.next;
			} else {
				result.addlast(ot.data);
				ot = ot.next;
			}
		}

		while (tt != null) {
			result.addlast(tt.data);
			tt = tt.next;
		}

		while (ot != null) {
			result.addlast(ot.data);
			ot = ot.next;
		}

		return result;

	}

	public LinkedList_simple mergedSortLL() {

		if (this.size == 1) {
			return this;
		}

		Node mid = this.getMidNode();
		Node tempmid = mid.next;

		LinkedList_simple fhalf = new LinkedList_simple();
		fhalf.head = this.head;
		fhalf.tail = mid;
		mid.next = null;
		fhalf.size = (this.size + 1) / 2;

		LinkedList_simple shalf = new LinkedList_simple();
		shalf.head = tempmid;
		shalf.tail = this.tail;
		shalf.size = this.size / 2;

		LinkedList_simple fhalf_recu = fhalf.mergedSortLL();
		LinkedList_simple shalf_recu = shalf.mergedSortLL();

		LinkedList_simple result = fhalf_recu.mergedSortTwoLL(shalf_recu);
		return result;

	}

	public void ReverseInKthMultiple(int n) throws Exception {
		LinkedList_simple prev = null,curr=null;
		
		while (!this.isempty()) {
			curr = new LinkedList_simple();
			for (int i = 1; i <= n; i++) {
				int temp=this.removeFirst();
				curr.addfirst(temp);
			}
			if(prev==null){
				prev=curr;
		}else{
			prev.tail.next=curr.head;
			prev.tail=curr.tail;
			prev.size+=curr.size;
		}

	}
		this.head=prev.head;
		this.tail=prev.tail;
		this.size=prev.size;

	}

	public int size() {
		return this.size;
	}

	public boolean isempty() {
		return this.size == 0;
	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + ",");
			temp = temp.next;
		}

	}
	
}
