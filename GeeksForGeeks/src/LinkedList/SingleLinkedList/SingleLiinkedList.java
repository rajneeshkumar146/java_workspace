package LinkedList.SingleLinkedList;

public class SingleLiinkedList {
	private class Node {
		private Node next;
		private long data;
	}

	private Node head;
	private Node tail;
	private long size;

	// Q09_GetNodeAT-------------------------------------------------------------------------------------------

	private Node getNodeAt(long n) {
		Node node = this.head;
		for (long i = 0; i < n; i++) {
			node = node.next;
		}

		return node;

	}

	// Q07_SizeFunctions----------------------------------------------------------------------------------------

	public long size() {
		return this.size;
	}

	public long Recsize() {
		return Recsize(this.head);
	}

	private long Recsize(Node node) {
		if (node.next == null) {
			return 1;
		}

		return Recsize(node.next) + 1;
	}

	public long Iresize() {

		Node node = this.head;
		long size = 0;
		while (node != null) {
			node = node.next;
			size++;
		}

		return size;
	}

	// IsEmpty_Delete_clone------------------------------------------------------------------------------------

	public boolean IsEmpty() {
		return this.size == 0;
	}

	public void delete() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public SingleLiinkedList clone() {
		SingleLiinkedList ll = new SingleLiinkedList();

		ll.head = this.head;
		ll.tail = this.tail;
		ll.size = this.size;

		return ll;
	}

	// Display-----------------------------------------------------------------------------------------------------

	public void display() {
		Node node = this.head;

		while (node != null) {
			System.out.println(node.data + ", ");
			node = node.next;
		}

		System.out.println();
	}

	// AddFunctions------------------------------------------------------------------------------------------------

	public void AddFirst(long data) {

		Node node = new Node();
		node.data = data;

		if (this.size == 0) {
			this.head = node;
			this.tail = node;
			node.next = null;
		} else {
			node.next = this.head;
			this.head = node;
		}

		this.size++;
	}

	public void AddLast(long data) {
		Node node = new Node();
		node.data = data;

		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;

		}

		node.next = null;
		this.size++;
	}

	public void AddAt(long pos, long data) throws Exception {
		if (pos < 0 || pos > this.size) {
			throw new Exception("Index out of bound");
		}

		if (pos == 0) {
			AddFirst(data);
		} else if (pos == this.size) {
			AddLast(data);
		} else {
			Node node = new Node();
			node.data = data;

			Node getnode = getNodeAt(pos - 1);

			node.next = getnode.next;
			getnode.next = node;
			this.size++;
		}
	}

	// RemoveFunctions---------------------------------------------------------------------------------------------

	public long RemoveFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("NullPointException");
		}

		long data = this.head.data;
		this.head = this.head.next;

		if (this.size == 1) {
			this.tail = null;
		}
		this.size--;

		return data;
	}

	public long RemoveLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("NullPointException");
		}

		long data = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
			return data;
		}
		Node node = getNodeAt(this.size - 2);

		this.tail = node;
		node.next = null;
		this.size--;

		return data;
	}

	public long RemoveAt(int index) throws Exception {
		if (index < 0 && index > this.size) {
			throw new Exception("IndexOutOfBound");
		} else if (this.size == 0) {
			throw new Exception("NullPointException");
		}
		if (index == 0) {
			return RemoveFirst();
		} else if (index == this.size) {
			return RemoveLast();
		} else {
			Node remove = getNodeAt(index - 1);
			long rv = remove.next.data;
			remove.next = remove.next.next;
			this.size--;
			return rv;
		}
	}

	// GetFunctions----------------------------------------------------------------------------------------------------

	public long getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("NullPointException");
		}

		return this.head.data;
	}

	public long GetLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("NullPointException");
		}

		return this.tail.data;
	}

	public long GetAt(int index) throws Exception {
		if (index < 0 && index > this.size) {
			throw new Exception("IndexOutOfBound");
		} else if (this.size == 0) {
			throw new Exception("NullPointException");
		}

		if (index == 0) {
			return getFirst();
		} else if (index == this.size) {
			return GetLast();
		} else {
			Node temp = getNodeAt(index);
			return temp.data;
		}
	}

	// Q08_Searching--------------------------------------------------------------------------------------------------------

	public boolean IrrSearch(long data) {

		Node node = this.head;

		while (node != null) {
			if (node.data == data) {
				return true;
			}
			node = node.next;
		}

		return false;

	}

	public boolean RecSearch(long data) {
		return RecSearch(this.head, data);
	}

	private boolean RecSearch(Node node, long data) {
		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		}

		return RecSearch(node.next, data);

	}

	// Q10_Nth_Node_From_End-------------------------------------------------------------------------------------------------

	public Node NthNodeFromEnd(long n) {
		if (n > this.size) {
			return null;
		}

		Node curr = this.head;
		Node prev = this.head;

		for (long i = 0; i < n; i++) {
			curr = curr.next;
		}

		while (curr != null) {
			curr = curr.next;
			prev = prev.next;
		}

		return prev;
	}

	// Q11_Mid_Of_List---------------------------------------------------------------------------------------------------------

	public Node MidNode() {

		Node curr = this.head;
		Node prev = this.head;

		while (curr != null) {
			prev = prev.next;
			curr = curr.next.next;
		}

		return prev;

	}

	public Node MidNode2() {

		Node node = this.head;
		Node mid = this.head;
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
			if ((count & 1) == 1) {
				mid = mid.next;
			}
		}

		return mid;
	}

	// Q12_Number_Of_Times_data_Occur-------------------------------------------------------------------------------------------

	public long numberOfTimes(long data) {
		Node node = this.head;
		long freq = 0;
		while (node != null) {
			if (node.data == data) {
				freq++;
			}
			node = node.next;
		}

		return freq;
	}

	public long numberOfTimesRecu(long data) {
		return numberOfTimesRecu(this.head, data);
	}

	private long numberOfTimesRecu(Node node, long data) {

		if (node == null) {
			return 0;
		}

		if (node.data == data) {
			return 1 + numberOfTimesRecu(node.next, data);
		} else {
			return numberOfTimesRecu(node.next, data);
		}

	}

	
}
