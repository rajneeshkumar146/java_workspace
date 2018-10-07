package july9;

import java.awt.HeadlessException;

public class LinkedList {
	private class Node {
		int data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	// o1
	public void addLast(int val) {
		if (size == 0) {
			handleAddWhenSize0(val);
			return;
		}
		// 1. create
		Node node = new Node();

		// 2. set data
		node.data = val;

		// 3. set next

		// 4. connect
		tail.next = node;

		// 5. summary
		tail = node;
		size++;
	}

	private void handleAddWhenSize0(int val) {
		Node node = new Node();
		node.data = val;
		tail = head = node;
		size++;
	}

	// on
	public void display() {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " -> ");
		}

		System.out.println(".");
	}

	// o1
	public int getFirst() {
		if (size == 0) {
			System.out.println("List is empty");
			return -1;
		}
		return head.data;
	}

	// o1
	public int getLast() {
		if (size == 0) {
			System.out.println("List is empty");
			return -1;
		}
		return tail.data;
	}

	// on
	public int getAt(int idx) throws LinkedListException {
		if (size == 0) {
			System.out.println("List is empty");
			throw new LinkedListException();
		} else if (idx < 0 || idx >= size) {
			System.out.println("Index out of bound");
			return -1;
		}

		Node node = head;
		for (int i = 0; i < idx; i++) {
			node = node.next;
		}
		return node.data;
	}

	// on
	private Node getNodeAt(int idx) {
		if (size == 0) {
			System.out.println("List is empty");
			return null;
		} else if (idx < 0 || idx >= size) {
			System.out.println("Index out of bound");
			return null;
		}

		Node node = head;
		for (int i = 0; i < idx; i++) {
			node = node.next;
		}
		return node;
	}

	public void addFirst(int val) {
		if (size == 0) {
			handleAddWhenSize0(val);
			return;
		}
		Node node = new Node();
		node.data = val;
		node.next = head;
		head = node;
		size++;

	}

	// on
	public void addAt(int val, int idx) {
		if (idx < 0 || idx > size) {
			System.out.println("Index out of bound");
			return;
		} else if (idx == 0) {
			this.addFirst(val);
		} else if (idx == size) {
			this.addLast(val);
		} else {
			Node node = new Node();
			node.data = val;

			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;

			nm1.next = node;
			node.next = np1;
			size++;
		}
	}

	// o1
	public int removeFirst() {
		if (size == 0) {
			System.out.println("List is empty");
			return -1;
		} else if (size == 1) {
			return handleRemovalWhenSizeIs1();
		}

		int rv = head.data;

		Node second = head.next;
		head = second;
		size--;

		return rv;
	}

	// on
	public int removeLast() {
		if (size == 0) {
			System.out.println("List is empty");
			return -1;
		} else if (size == 1) {
			return handleRemovalWhenSizeIs1();
		}

		int rv = tail.data;

		Node secondLast = getNodeAt(size - 2);
		tail = secondLast;
		tail.next = null;
		size--;

		return rv;
	}

	private int handleRemovalWhenSizeIs1() {
		int rv = head.data;

		head = tail = null;
		size = 0;

		return rv;
	}

	// on
	public int removeAt(int idx) {
		if (size == 0) {
			System.out.println("List is empty");
			return -1;
		} else if (idx < 0 || idx >= size) {
			System.out.println("Index out of bound");
			return -1;
		} else if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size - 1) {
			return this.removeLast();
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			size--;

			return n.data;
		}
	}

	// on^2
	public void reverseDataIterative() {
		int li = 0;
		int ri = size - 1;

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
		Node prev = head;
		Node curr = prev.next;

		while (curr != null) {
			Node ocn = curr.next;

			curr.next = prev;

			prev = curr;
			curr = ocn;
		}

		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;
	}

	// on
	public void displayReverse() {
		displayReverseHelper(head);
		System.out.println(".");
	}

	private void displayReverseHelper(Node node) {
		if (node == null) {
			System.out.print(".");
			return;
		}
		displayReverseHelper(node.next);
		System.out.print(" <- " + node.data);
	}

	public void reversePointerRecursive() {
		reversePointerRecursiveHelper(head);
		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;
	}

	private void reversePointerRecursiveHelper(Node node) {
		if (node == tail) {
			return;
		}

		reversePointerRecursiveHelper(node.next);
		node.next.next = node;
	}

	// on
	// public void reverseDataRecursiveNW(){
	// reverseDataRecursiveHelperNW(head, head);
	// }
	//
	// private void reverseDataRecursiveHelperNW(Node left, Node right){
	// if(right == null){
	// return;
	// }
	// reverseDataRecursiveHelper(left, right.next);
	//
	// int temp = left.data;
	// left.data = right.data;
	// right.data = temp;
	//
	// left = left.next;
	// }

	private class HeapMover {
		Node node;
	}

	public void reverseDataRecursiveW() {
		HeapMover left = new HeapMover();
		left.node = head;
		reverseDataRecursiveW(left, head, 0);
	}

	private void reverseDataRecursiveW(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		reverseDataRecursiveW(left, right.next, floor + 1);

		// swap
		if (floor >= size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;
		}

		left.node = left.node.next;
	}

	public boolean IsPalindrome() {
		HeapMover mover = new HeapMover();
		mover.node = head;
		return IsPalindrome(mover, head);
	}

	private boolean IsPalindrome(HeapMover left, Node right) {
		if (right == null) {
			return true;
		}
		boolean res = IsPalindrome(left, right.next);
		if (res == false) {
			return false;
		} else {
			if (left.node.data == right.data) {
				left.node = left.node.next;
				return true;
			} else {
				return false;
			}
		}
	}

	public void fold() {
		HeapMover left = new HeapMover();
		left.node = head;
		fold(left, head, 0);
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
			tail = right;
			tail.next = null;
		}
	}

	public int kthFromLast(int k) {
		Node fast = head;
		Node slow = head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow.data;
	}

	public int mid() {
		Node fast = head;
		Node slow = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	public void kreverse(int k) {
		LinkedList prev = new LinkedList();
		LinkedList curr = new LinkedList();

		while (this.size != 0) {
			for (int i = 0; i < k; i++) {
				curr.addFirstNode(this.removeFirstNode());
			}

			if (prev.size == 0) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}

			curr = new LinkedList();
		}

		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;
	}

	private Node removeFirstNode() {
		if (size == 0) {
			System.out.println("List is empty");
			return null;
		} else if (size == 1) {
			return handleRemovalOfNodeWhenSizeIs1();
		}

		Node rv = head;

		Node second = head.next;
		head = second;
		size--;
		rv.next = null;

		return rv;
	}

	private Node handleRemovalOfNodeWhenSizeIs1() {
		Node rv = head;

		head = tail = null;
		size = 0;

		return rv;
	}

	private void addFirstNode(Node node) {
		if (size == 0) {
			handleAddNodeWhenSize0(node);
			return;
		}
		node.next = head;
		head = node;
		size++;

	}

	private void handleAddNodeWhenSize0(Node node) {
		tail = head = node;
		size++;
	}

	public void addLastNode(Node node) {
		if (size == 0) {
			handleAddNodeWhenSize0(node);
			return;
		}
		tail.next = node;
		tail = node;
		size++;
	}

	public void removeDuplicates() {
		LinkedList list = new LinkedList();
		while (this.size != 0) {
			Node node = this.removeFirstNode();

			if (list.size == 0 || list.tail.data != node.data) {
				list.addLastNode(node);
			}
		}

		this.head = list.head;
		this.tail = list.tail;
		this.size = list.size;
	}

	public void oddEvenSplit() {
		LinkedList odd = new LinkedList();
		LinkedList even = new LinkedList();

		while (this.size != 0) {
			Node node = this.removeFirstNode();

			if (node.data % 2 == 0) {
				even.addLastNode(node);
			} else {
				odd.addLastNode(node);
			}
		}

		this.head = even.size > 0 ? even.head : odd.head;
		this.tail = odd.size > 0 ? odd.tail : even.tail;
		this.size = even.size + odd.size;

		if (even.size > 0) {
			even.tail.next = odd.head;
		}
	}

	public static LinkedList mergesort(LinkedList list) {
		if(list.size == 1){
			return list;
		}
		
		LinkedList fh = new LinkedList();
		LinkedList sh = new LinkedList();
		
		Node node = list.head;
		for(int i = 0; i < list.size; i++){
			if(i < list.size / 2){
				fh.addLast(node.data);
			} else {
				sh.addLast(node.data);
			}
			
			node = node.next;
		}
		
		fh = mergesort(fh);
		sh = mergesort(sh);
		
		LinkedList sorted = merge(fh, sh);
		return sorted;
		
	}

	public static LinkedList merge(LinkedList list1, LinkedList list2) {
		LinkedList list = new LinkedList();

		Node l1temp = list1.head;
		Node l2temp = list2.head;

		while (l1temp != null && l2temp != null) {
			if (l1temp.data < l2temp.data) {
				list.addLast(l1temp.data);
				l1temp = l1temp.next;
			} else {
				list.addLast(l2temp.data);
				l2temp = l2temp.next;
			}
		}

		while (l1temp != null) {
			list.addLast(l1temp.data);
			l1temp = l1temp.next;
		}

		while (l2temp != null) {
			list.addLast(l2temp.data);
			l2temp = l2temp.next;
		}
		
		return list;
	}

}

class LinkedListException extends Exception {
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Index out of bounds in linked list";
	}
}
