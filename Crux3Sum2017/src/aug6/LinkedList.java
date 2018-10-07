package aug6;

public class LinkedList<T> {
	private class Node {
		private T data;
		private Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	private void handleAdd0(T data) {
		Node node = new Node();
		node.data = data;
		node.next = null;

		this.head = node;
		this.tail = node;
		this.size = 1;
	}

	// o1
	public void addFirst(T data) {
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
	public void addLast(T data) {
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
	public void addAt(T data, int idx) throws Exception {
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
	public T getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		return this.head.data;
	}

	// o1
	public T getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		return this.tail.data;
	}

	// on
	public T getAt(int idx) throws Exception {
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
	private T handleRemove1() {
		T rv = this.head.data;

		this.head = null;
		this.tail = null;
		this.size = 0;

		return rv;
	}

	// o1
	public T removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}

		if (this.size == 1) {
			return handleRemove1();
		} else {
			T rv = this.head.data;

			this.head = this.head.next;
			this.size--;

			return rv;
		}
	}

	// on
	public T removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}

		if (this.size == 1) {
			return handleRemove1();
		} else {
			T rv = this.tail.data;

			this.tail = this.getNodeAt(this.size - 2);// second last
			this.tail.next = null;
			this.size--;

			return rv;
		}
	}

	// on
	public T removeAt(int idx) throws Exception {
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

	
	
}
