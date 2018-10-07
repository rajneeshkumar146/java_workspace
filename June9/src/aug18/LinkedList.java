package aug18;

public class LinkedList<T> {
	private class Node {
		T data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	// o1
	public void addLast(T val) {
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

	private void handleAddWhenSize0(T val) {
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
	public T getFirst() {
		if (size == 0) {
			System.out.println("List is empty");
			return null;
		}
		return head.data;
	}

	// o1
	public T getLast() {
		if (size == 0) {
			System.out.println("List is empty");
			return null;
		}
		return tail.data;
	}

	// on
	public T getAt(int idx) {
		if (size == 0) {
			System.out.println("List is empty");
		} else if (idx < 0 || idx >= size) {
			System.out.println("Index out of bound");
			return null;
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

	public void addFirst(T val) {
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
	public void addAt(T val, int idx) {
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
	public T removeFirst() {
		if (size == 0) {
			System.out.println("List is empty");
			return null;
		} else if (size == 1) {
			return handleRemovalWhenSizeIs1();
		}

		T rv = head.data;

		Node second = head.next;
		head = second;
		size--;

		return rv;
	}

	// on
	public T removeLast() {
		if (size == 0) {
			System.out.println("List is empty");
			return null;
		} else if (size == 1) {
			return handleRemovalWhenSizeIs1();
		}

		T rv = tail.data;

		Node secondLast = getNodeAt(size - 2);
		tail = secondLast;
		tail.next = null;
		size--;

		return rv;
	}

	private T handleRemovalWhenSizeIs1() {
		T rv = head.data;

		head = tail = null;
		size = 0;

		return rv;
	}

	// on
	public T removeAt(int idx) {
		if (size == 0) {
			System.out.println("List is empty");
			return null;
		} else if (idx < 0 || idx >= size) {
			System.out.println("Index out of bound");
			return null;
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
}