package Assingment_09_LinkedList;

public class LinkedList {

	static class Node {
		private int data;
		private Node next;
	}

	private class HeapMover {
		private Node node;
	}

	private Node head; // default null
	private Node tail;// default null
	private int size;// default 0

	// getNodeAt

	private Node getNodeAt(int index) throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is empty");
		}
		if (index < 0 || index >= this.size) {
			throw new Exception("Out of bound");
		}

		Node cnode = this.head;
		int count = 0;
		while (count < index) {
			cnode = cnode.next;
			count++;
		}

		return cnode;

	}

	// addFunction's

	private void addFisrtAtSize0(int n) {
		Node node = new Node();
		node.data = n;
		node.next = null;
		this.head = node;
		this.tail = node;
		this.size = 1;
	}

	public void addFirst(int n) {
		if (this.size == 0) {
			this.addFisrtAtSize0(n);

		} else {
			Node node = new Node();
			node.data = n;
			node.next = this.head;
			this.head = node;
			this.size++;

		}
	}

	public void addLast(int n) {
		if (this.size == 0) {
			this.addFisrtAtSize0(n);
		} else {
			Node node = new Node();
			node.data = n;
			node.next = null;

			this.tail.next = node;
			this.tail = node;
			this.size++;

		}
	}

	public void addAt(int n, int index) throws Exception {
		if (index < 0 || index > this.size + 1) {
			throw new Exception("Out of bound");
		}

		if (index == 0) {
			this.addFirst(n);
		} else if (index == this.size) {
			this.addLast(n);
		} else {
			Node node = new Node();
			node.data = n;

			Node m1 = this.getNodeAt(index - 1);
			node.next = m1.next;
			m1.next = node;
			this.size++;
		}

	}

	// getFuntion's

	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is empty");
		}

		return this.head.data;

	}

	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is empty");
		}
		return this.tail.data;
	}

	public int getAt(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Out of bound");
		}

		if (this.size == 0) {
			return this.getFirst();
		} else if (index == this.size) {
			return this.getLast();
		} else {
			Node temp = this.getNodeAt(index - 1);
			return temp.next.data;
		}

	}

	// removeFuntion's

	private int removeFisrtatSize0() {
		int rv = this.tail.data;
		this.head = null;
		this.tail = null;
		this.size = 0;

		return rv;
	}

	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is empty");
		}
		if (this.size == 1) {
			return this.removeFisrtatSize0();

		} else {

			int rv = this.head.data;
			this.head = this.head.next;
			this.size--;
			return rv;

		}
	}

	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is empty");
		}
		if (this.size == 1) {
			return this.removeFisrtatSize0();

		} else {

			int rv = this.tail.data;
			Node temp = this.getNodeAt(this.size - 2);

			this.tail = temp;
			temp.next = null;
			this.size--;
			return rv;

		}

	}

	public int removeAt(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Index out of bounds.");
		}
		if (index == 0) {
			return this.removeFisrtatSize0();

		} else if (index == size - 1) {
			return removeLast();
		} else {
			/*
			 * Node m1 = getNodeAt(index - 1); // m1=minus1 Node at = m1.next;
			 * // at Node p1 = at.next; // plus1
			 * 
			 * int rv=at.data;
			 * 
			 * at=p1
			 */

			Node temp = this.getNodeAt(index - 1);
			int rv = temp.next.data;
			temp.next = temp.next.next;

			this.size--;
			return rv;
		}
	}

	// GeneralFuntion's

	public boolean IsEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	// reverseData_and_display

	public void reverseDataIrr() throws Exception {

		int lidx = 0, ridx = this.size - 1;

		while (lidx < ridx) {

			Node lnode = this.getNodeAt(lidx); // lnode=leftNode
			Node rnode = this.getNodeAt(ridx); // rnode=rightNode

			swap(lnode, rnode);

			lidx++;
			ridx--;
		}

	}

	public void reverseDataRecu() {

		HeapMover left = new HeapMover();
		left.node = this.head;

		reverseDataRecu(left, this.head, 0);
	}

	private void reverseDataRecu(HeapMover left, Node rnode, int floor) {
		if (rnode == null) {
			return;
		}

		reverseDataRecu(left, rnode.next, floor + 1);
		if (floor > (this.size + 1) / 2) {
			int temp = left.node.data;
			left.node.data = rnode.data;
			rnode.data = temp;

			left.node = left.node.next;
		}
	}

	public void displayReverseDataIrr() throws Exception {

		int ridx = this.size - 1;

		while (ridx >= 0) {
			Node tempNode = this.getNodeAt(ridx);
			System.out.print(tempNode.data + ",");
			ridx--;
		}

	}

	public void displayReverseDataRecu() {

		displayReverseDataRecu(this.head);

	}

	private void displayReverseDataRecu(Node node) {
		if (node == null) {
			return;
		}
		displayReverseDataRecu(node.next);
		System.out.print(node.data + ",");
	}

	// reversePointer_and_display

	public void reversePointerIrr() {
		/*
		 * Node prev = this.head; Node curr = prev.next; Node forw = curr.next;
		 * while (curr != null) { curr.next = prev; prev = curr; curr = forw;
		 * forw=forw.next; // common_mistake_because_forward_move_2step_then_pre
		 * _so_when_prevevious_at_last_then_forward_atNull_of_Null(
		 * Which_is_not_possible) }
		 */

		Node prev = this.head;
		Node curr = prev.next;
		while (curr != null) {
			Node forw = curr.next;

			curr.next = prev;
			prev = curr;
			curr = forw;
		}

		this.head.next = null;
		Node n = this.tail;
		this.tail = this.head;
		this.head = n;
	}

	public void reversePointerBetterIrr() throws Exception {
		LinkedList temp = new LinkedList();

		while (this.size != 0) {
			int num = this.removeFirst();
			temp.addFirst(num);
		}

		this.head = temp.head;
		this.tail = temp.tail;
		this.size = temp.size;

	}

	public void reversePointerRecu1() {

		this.reversePointerRecu1(this.head, this.head.next);
		this.head.next = null;
		Node n = this.tail;
		this.tail = this.head;
		this.head = n;

	}

	private void reversePointerRecu1(Node prev, Node curr) {
		if (curr == null) {
			return;
		}
		reversePointerRecu1(prev.next, curr.next);
		curr.next = prev;

	}

	public void reversePointerRecu2() {

		this.reversePointerRecu2(this.head, this.head.next);

	}

	private void reversePointerRecu2(Node prev, Node curr) {
		if (curr == null) {
			this.head.next = null;
			Node n = this.tail;
			this.tail = this.head;
			this.head = n;
			return;
		}

		Node forw = curr.next;

		curr.next = prev;
		prev = curr;
		curr = forw;

		reversePointerRecu2(prev, curr);

	}

	// palindrome_and_Fold_OfLinkedList

	public boolean palindromeRecu() {
		HeapMover left = new HeapMover();
		left.node = this.head;
		return palindromeRecu(left, this.head, 0);

	}

	private boolean palindromeRecu(HeapMover left, Node rnode, int floor) {
		if (rnode == null) {
			return true;
		}

		boolean result = palindromeRecu(left, rnode.next, floor + 1);
		if (floor > (this.size + 1) / 2) {
			if (left.node.data != rnode.data) {
				return false;
			}
			left.node = left.node.next;
		}
		return result;

	}

	public boolean palindromeIrr() throws Exception {

		int lidx = 0, ridx = this.size - 1;
		while (lidx < ridx) { // O(n/2) overall O(n^2)
			Node lnode = this.getNodeAt(lidx); // lnode=LeftNode O(n)
			Node rnode = this.getNodeAt(ridx); // rnode=RighrNode O(n)

			if (lnode.data != rnode.data) {
				return false;
			}

			lidx++;
			ridx--;
		}

		return true;

	}

	public void fold() {
		HeapMover left = new HeapMover();
		left.node = this.head;
		fold(left, this.head, 0);

	}

	private void fold(HeapMover left, Node rnode, int floor) {
		if (rnode == null) {
			return;
		}

		fold(left, rnode.next, floor + 1);
		if (floor > this.size / 2) {
			Node fnode = left.node.next;
			left.node.next = rnode;
			rnode.next = fnode;
			left.node = fnode;
		} else if (floor == this.size / 2) {
			this.tail = rnode;
			this.tail.next = null;
		}

	}

	// Kth_Node,element,ReverseInKthMultiple_and_midNode_and_element

	public int Kthelement(int n) { // Kth_element_means_from_last
		return KthNode(n).data;
	}

	private Node KthNode(int n) {
		Node slow = this.head;
		Node fast = this.head;

		for (int i = 1; i < n; i++) {
			fast = fast.next;
		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

	public int midElement() {

		return getMidNode().data;

	}

	private Node getMidNode() {
		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;

	}

	public void ReverseInKthMultiple(int k) throws Exception {
		LinkedList curr = null, prev = null;

		if (k == 0) {
			return;
		}

		while (this.size != 0) {
			curr = new LinkedList();
			int count = 0;
			while (count < k) {
				if (this.size != 0) {
					int remove = this.removeFirst();
					curr.addFirst(remove);
				}else{
					break;
				}
				count++;
			}

			if (prev == null) {
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

	// All_type_of_Sorting

	private void swap(Node prev, Node curr) {
		int num = prev.data;
		prev.data = curr.data;
		curr.data = num;
	}

	public LinkedList mergeSortTwoLL(LinkedList other) { // Shpould_be_sorted_linkedList
		Node poin1 = this.head;
		Node poin2 = other.head;

		LinkedList result = new LinkedList();

		while (poin1 != null && poin2 != null) {
			if (poin1.data < poin2.data) {
				result.addLast(poin1.data);
				poin1 = poin1.next;
			} else {
				result.addLast(poin2.data);
				poin2 = poin2.next;
			}
		}

		while (poin1 != null) {
			result.addLast(poin1.data);
			poin1 = poin1.next;
		}

		while (poin2 != null) {
			result.addLast(poin2.data);
			poin2 = poin2.next;
		}

		return result;
	}

	public void mergeSort() {
		LinkedList result = mergeSortInner();
		this.head = result.head;
		this.tail = result.tail;
		this.size = result.size;

	}

	private LinkedList mergeSortInner() {
		if (this.size == 1) {
			return this; // LinkedList_at_that_point_is_represented_by_this.

		}

		Node mid = this.getMidNode();
		Node nnam = mid.next; // next_Node_After_Mid

		LinkedList fhalf = new LinkedList();
		fhalf.head = this.head;
		fhalf.tail = mid;
		mid.next = null;
		fhalf.size = (this.size + 1) / 2;

		LinkedList shalf = new LinkedList();
		shalf.head = nnam;
		shalf.tail = this.tail;
		shalf.size = this.size / 2;

		LinkedList fhalfsort = fhalf.mergeSortInner();
		LinkedList shalfsort = shalf.mergeSortInner();

		return fhalfsort.mergeSortTwoLL(shalfsort);
	}

	public void bubblleSortIrr() throws Exception {
		Node lnfbs = null;

		while (lnfbs != this.head) {
			Node prev = this.head;
			Node curr = prev.next;
			while (curr != lnfbs) { // lnfbs=Last_node_for_binary_sort.
				if (prev.data > curr.data) {
					swap(prev, curr);

				}
				prev = prev.next;
				curr = curr.next;
			}

			lnfbs = prev; // always_put_lastNode_in_lnfbs.

		}

	}

	public void bubblleSortBetterIrr() throws Exception {
		Node lnfbs = null;
		boolean flag;
		do {
			flag = false;
			Node prev = this.head;
			Node curr = prev.next;
			while (curr != lnfbs) { // lnfbs=Last_node_for_binary_sort.
				if (prev.data > curr.data) {
					swap(prev, curr);
					flag = true;

				}
				prev = prev.next;
				curr = curr.next;
			}

			lnfbs = prev; // always_put_lastNode_in_lnfbs.

		} while (flag);

	}

	public void selectionSortIrr() throws Exception {

		Node curr = this.head;
		while (curr.next != null) {
			Node mover = curr.next;

			while (mover != null) {
				if (curr.data > mover.data) {
					this.swap(curr, mover);
				}
				mover = mover.next;
			}
			curr = curr.next;
		}
	}

	public void bubblleSortRecu() {
		bubbleSortRecu(this.head, null);
		System.out.println(this.bubbleSortRecuCount(this.head, null, 0));
	}

	private void bubbleSortRecu(Node prev, Node lnfbs) { // lnfsb=last_node_for_bubble_sort
		if (lnfbs == this.head) {
			return;
		}
		if (prev.next == lnfbs) {
			bubbleSortRecu(this.head, prev);
			return;
		}

		Node curr = prev.next;
		if (prev.data > curr.data) {
			this.swap(prev, curr);
		}

		bubbleSortRecu(prev.next, lnfbs);
	}

	private int bubbleSortRecuCount(Node prev, Node lnfbs, int count) { // lnfsb=last_node_for_bubble_sort
		if (lnfbs == this.head) {
			return count;
		}
		if (prev.next == lnfbs) {
			int result = bubbleSortRecuCount(this.head, prev, count);
			return result;
		}

		Node curr = prev.next;
		if (prev.data > curr.data) {
			this.swap(prev, curr);
		}

		int result = bubbleSortRecuCount(prev.next, lnfbs, count + 1);
		return result;
	}

	public void bubbleSortBetterRecu() {
		bubbleSortBetterRecu(this.head, null, false);
		System.out.println(this.bubbleSortBetterRecuCount(this.head, null, 0, false));
	}

	private void bubbleSortBetterRecu(Node prev, Node lnfbs, boolean flag) { // lnfsb=last_node_for_bubble_sort
		if (lnfbs == this.head) {
			return;
		}
		if (prev.next == lnfbs) {
			if (flag == false) {
				return;
			}
			bubbleSortBetterRecu(this.head, prev, flag);
			return;
		}

		Node curr = prev.next;
		if (prev.data > curr.data) {
			this.swap(prev, curr);
		}

		bubbleSortBetterRecu(prev.next, lnfbs, flag);
	}

	private int bubbleSortBetterRecuCount(Node prev, Node lnfbs, int count, boolean flag) { // lnfsb=last_node_for_bubble_sort
		if (lnfbs == this.head) {
			return count;
		}
		if (prev.next == lnfbs) {
			if (flag == false) {
				return count;
			}
			int result = bubbleSortBetterRecuCount(this.head, prev, count, flag);
			return result;
		}

		Node curr = prev.next;
		if (prev.data > curr.data) {
			this.swap(prev, curr);
			flag = true;
		}

		int result = bubbleSortBetterRecuCount(prev.next, lnfbs, count + 1, flag);
		return result;
	}

	public void selectionSortRecu() {
		selectionSortRecu(this.head, this.head.next);
	}

	private void selectionSortRecu(Node prev, Node curr) {
		if (prev.next == null) {
			return;
		}

		if (curr == null) {
			selectionSortRecu(prev.next, prev.next.next);
			return;
		}

		if (prev.data > curr.data) {
			this.swap(prev, curr);
		}

		selectionSortRecu(prev, curr.next);

	}

	public void insertionSortIrr() throws Exception {

		LinkedList temp = new LinkedList();

		temp.addFirst(this.removeFirst());

		while (this.size != 0) {
			temp.addFirst(this.removeFirst());
			Node mover = temp.head;
			while (mover.next != null) {
				if (mover.data > mover.next.data) {
					swap(mover, mover.next);
				} else {
					break;
				}
				mover = mover.next;
			}

		}

		this.head = temp.head;
		this.tail = temp.tail;
		this.size = temp.size;
	}

	// removeDuplicates_and+OddEvenArrange_in_linkList

	public void removeDupli() {

		Node prev = this.head;
		Node mover = prev.next;
		while (mover != null) {

			if (prev.data == mover.data) {
				prev.next = mover.next;
				mover = mover.next;
				this.size--;

			} else {
				prev = prev.next;
				mover = prev.next;
			}
		}
	}

	public void OddEvenArrange() throws Exception {
		LinkedList odd = new LinkedList();
		LinkedList even = new LinkedList();
		Node mover = this.head;

		while (this.size != 0) {
			if (mover.data % 2 != 0) {
				mover = mover.next;
				odd.addLast(this.removeFirst());
			} else {
				mover = mover.next;
				even.addLast(this.removeFirst());
			}
		}
		if (odd.head != null && even.head != null) {
			this.head = odd.head;
			odd.tail.next = even.head;
			this.tail = even.tail;
			this.size = odd.size + even.size;
		} else if (odd.head != null) {
			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size;
		} else {
			this.head = even.head;
			this.tail = even.tail;
			this.size = even.size;
		}
	}

	// rotatation_of_elements_by_using_CircularLinkedList

	public void rotate(int n) throws Exception {
		n = n % this.size;

		if (n < 0) {
			n = this.size + n;
		}

		this.tail.next = this.head;
		Node curr = this.getNodeAt((this.size - 1) - n);
		this.head = curr.next;
		this.tail = curr;
		this.tail.next = null;

	}
}
