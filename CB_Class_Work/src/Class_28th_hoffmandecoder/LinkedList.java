package Class_28th_hoffmandecoder;

public class LinkedList<T> {

	private class Node {
		private T data;
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

	private void addFisrtAtSize0(T n) {
		Node node = new Node();
		node.data = n;
		node.next = null;
		this.head = node;
		this.tail = node;
		this.size = 1;
	}

	public void addFirst(T n) {
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

	public void addLast(T n) {
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

	public void addAt(T n, int index) throws Exception {
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

	public T getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is empty");
		}

		return this.head.data;

	}

	public T getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is empty");
		}
		return this.tail.data;
	}

	public T getAt(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Out of bound");
		}

		if (this.size == 0) {
			return this.getFirst();
		} else if (index == this.size - 1) {
			return this.getLast();
		} else {
			Node temp = this.getNodeAt(index);
			return temp.next.data;
		}

	}

	// removeFuntion's

	private T removeFisrtatSize0() {
		T rv = this.tail.data;
		this.head = null;
		this.tail = null;
		this.size = 0;

		return rv;
	}

	public T removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is empty");
		}
		if (this.size == 1) {
			return this.removeFisrtatSize0();

		} else {

			T rv = this.head.data;
			this.head = this.head.next;
			this.size--;
			return rv;

		}
	}

	public T removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is empty");
		}
		if (this.size == 1) {
			return this.removeFisrtatSize0();

		} else {

			T rv = this.tail.data;
			Node temp = this.getNodeAt(this.size - 2);

			this.tail = temp;
			temp.next = null;
			this.size--;
			return rv;

		}

	}

	public T removeAt(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Index out of bounds.");
		}

		if (index == 0) {
			return this.removeFisrtatSize0();

		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node temp = this.getNodeAt(index - 1);
			T rv = temp.next.data;
			temp.next = temp.next.next;

			this.size--;
			return rv;
		}
	}

	public boolean IsEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + ",");
			temp = temp.next;
		}
	}

}