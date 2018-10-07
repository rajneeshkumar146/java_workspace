package L011_LinkedList;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class LinkedList_001 {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		solve();
		pnter.close();
	}

	public static void solve() throws Exception {
		Linkedlist ll = new Linkedlist();

		ll.AddFirst(10);
		ll.AddFirst(20);
		ll.AddFirst(30);
		ll.AddFirst(40);
		ll.AddFirst(50);
		ll.AddFirst(60);
		ll.AddFirst(70);

		// pnter.printLine(ll + "");
		// pnter.printLine(ll.getAt(2) + "");
		// pnter.printLine(ll + "");

		// pnter.printLine(ll + "");
		// ll.ReverseDataItr();
		// pnter.printLine(ll + "");
		// ll.ReversePointerItr();
		// pnter.printLine(ll + "");

		// pnter.printLine(ll + "");
		// ll.ReversePointerRec();
		// pnter.printLine(ll + "");
		// ll.ReversePointerRec2();
		// pnter.printLine(ll + "");

		// ll.AddFirst(10);
		// ll.AddFirst(20);
		// ll.AddFirst(30);
		// ll.AddFirst(40);
		// ll.AddFirst(20);
		// ll.AddFirst(10);
		// pnter.printLine(ll.Palindrome() + "");

		ll.Fold();
		ll.UnFold();
		System.out.println(ll);

	}

	private static class Linkedlist {

		private class Node {
			private Node next = null;
			private int data = -1;
		}

		private int ElementCount;
		private Node head;
		private Node tail;

		// GeneralFunctions.=====================================================================================

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (Node node = this.head; node != null; node = node.next) {
				sb.append(node.data + " ");
			}
			return sb.toString();
		}

		public int size() {
			return ElementCount;
		}

		public boolean isEmpty() {
			return (this.ElementCount == 0);
		}

		private Node GetNodeAt(int index) throws Exception {
			if (index > this.ElementCount || index < 0) {
				throw new Exception("NullPointException: " + index);
			}

			if (index == 0) {
				return this.head;
			}

			if (index == this.ElementCount - 1) {
				return this.tail;
			}

			Node node = this.head;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		}

		private void swap(Node one, Node two) {
			int temp = one.data;
			one.data = two.data;
			two.data = temp;
		}

		private class HeapMover {
			Node node;
		}

		private Node Mid() {

			Node slow = this.head;
			Node fast = this.head;

			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
		}

		// delete a Linked List
		public void Clear() throws Exception {
			if (this.ElementCount == 0) {
				throw new Exception("LIst is Already empty");
			}
			this.head = null;
			this.tail = null;
			this.ElementCount = 0;
		}

		// AddFunctions.=========================================================================================

		public void AddFirst(int data) {
			Node node = new Node();
			node.data = data;
			AddFirstNode(node);
		}

		private void AddFirstNode(Node node) {
			if (this.ElementCount == 0) {
				this.head = node;
				this.tail = node;
			} else {
				node.next = this.head;
			}

			this.head = node;
			this.ElementCount++;
		}

		public void AddLast(int data) {
			Node node = new Node();
			node.data = data;
			AddLastNode(node);
		}

		private void AddLastNode(Node node) {
			if (this.ElementCount == 0) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
			this.ElementCount++;
		}

		// GetFunctions.==========================================================================================

		public int getFirst() throws Exception {
			if (this.ElementCount == 0) {
				throw new Exception("EmptyList");
			}
			return this.head.data;
		}

		public int getLast() throws Exception {
			if (this.ElementCount == 0) {
				throw new Exception("EmptyList");
			}
			return this.tail.data;
		}

		public int getAt(int index) throws Exception {
			if (this.ElementCount == 0) {
				throw new Exception("EmptyList");
			} else if (index < 0 || index >= this.ElementCount) {
				throw new Exception("InvalidIndex");
			}

			return GetNodeAt(index).data;
		}

		// RemoveFunctions.=======================================================================================

		public int RemoveFirst() throws Exception {
			if (this.ElementCount == 0) {
				throw new Exception("EmptyList");
			}

			return RemoveFirstNode().data;

		}

		private Node RemoveFirstNode() throws Exception {
			Node node = this.head;
			this.head = node.next;

			if (this.ElementCount == 1) {
				this.tail = null;
			}

			this.ElementCount--;
			return node;
		}

		public int RemoveLast() throws Exception {
			if (this.ElementCount == 0) {
				throw new Exception("EmptyList");
			}

			return RemoveLastNode().data;
		}

		private Node RemoveLastNode() throws Exception {

			if (this.ElementCount == 1) {
				this.ElementCount--;
				Node rv = this.tail;
				this.head = this.tail = null;
				return rv;

			}

			Node node = GetNodeAt(this.ElementCount - 2);
			Node rv = node.next;
			this.tail = node;
			node.next = null;
			this.ElementCount--;
			return rv;
		}

		public int RemoveAt(int index) throws Exception {
			if (this.ElementCount == 0) {
				throw new Exception("EmptyList");
			} else if (index < 0 || index >= this.ElementCount) {
				throw new Exception("InvalidIndex");
			}

			return RemoveAtNode(index).data;
		}

		private Node RemoveAtNode(int index) throws Exception {
			if (index == 0) {
				return RemoveFirstNode();
			}

			else if (this.ElementCount == 1) {
				this.ElementCount--;
				Node rv = this.tail;
				this.head = this.tail = null;
				return rv;
			} else if (index == this.ElementCount - 1) {
				return RemoveLastNode();
			}

			Node node = GetNodeAt(index - 1);
			Node rv = node.next;
			node.next = node.next.next;

			this.ElementCount--;
			return rv;

		}

		// Reverse.=================================================================================================

		public void ReverseDataItr() throws Exception {
			int le = 0;
			int ri = this.size() - 1;
			while (le < ri) {
				Node prev = GetNodeAt(le);
				Node curr = GetNodeAt(ri);
				swap(prev, curr);
				le++;
				ri--;
			}
		}

		public void ReversePointerItr() {
			Node prev = null;
			Node curr = this.head;
			while (curr != null) {
				Node temp = curr.next;

				curr.next = prev;

				prev = curr;
				curr = temp;
			}

			Node temp = this.head;
			this.head = this.tail;
			this.tail = temp;

		}

		public void DisplayReversedata() throws IOException {
			DisplayReversedata(this.head);
		}

		private void DisplayReversedata(Node node) throws IOException {
			if (node != null) {
				return;
			}

			DisplayReversedata(node.next);
			pnter.printLine(node.data + "");

		}

		public void ReverseDataRec() {
			HeapMover hp = new HeapMover();
			hp.node = this.head;
			ReverseDataRec(hp, this.head, 0);
		}

		private void ReverseDataRec(HeapMover hp, Node node, int count) {
			if (node == null) {
				return;
			}

			ReverseDataRec(hp, node.next, count + 1);
			if (count >= (this.ElementCount / 2)) {
				swap(hp.node, node);
				hp.node = hp.node.next;
			}

		}

		public void ReversePointerRec() {
			ReversePointerRec(this.head);
			this.tail.next = null;
		}

		private void ReversePointerRec(Node node) {
			if (node == this.tail) {
				Node temp = this.head;
				this.head = this.tail;
				this.tail = temp;

				return;
			}

			ReversePointerRec(node.next);
			node.next.next = node;
		}

		public void ReversePointerRec2() {
			ReversePointerRec2(this.head);
		}

		private Node ReversePointerRec2(Node node) {
			if (node == this.tail) {
				Node temp = this.head;
				this.head = this.tail;
				this.tail = temp;
				this.tail.next = null;

				return node;
			}

			Node Recnode = ReversePointerRec2(node.next);
			Recnode.next = node;

			return node;
		}

		// palindrome_and_Fold_OfLinkedList.=============================================================================

		public boolean Palindrome() {
			HeapMover hp = new HeapMover();
			hp.node = this.head;
			return palindrome(hp, this.head);

		}

		private boolean palindrome(HeapMover hp, Node node) {
			if (node == null) {
				return true;
			}

			if (!palindrome(hp, node.next)) {
				return false;
			} else {
				if (hp.node.data == node.data) {
					hp.node = hp.node.next;
					return true;
				} else {
					return false;
				}
			}

		}

		public void Fold() {
			HeapMover hp = new HeapMover();
			hp.node = this.head;
			Fold(hp, this.head, 0);
		}

		private void Fold(HeapMover hp, Node right, int floor) {
			if (right == null) {
				return;
			}

			Fold(hp, right.next, floor + 1);
			if (floor > this.ElementCount / 2) {
				Node temp = hp.node.next;
				hp.node.next = right;
				right.next = temp;
				hp.node = temp;

			} else if (floor == this.ElementCount / 2) {
				this.tail = right;
				this.tail.next = null;
			}
		}

		public void UnFold() {
			UnFold(this.head);
		}

		private Node UnFold(Node node) {

			if (node.next == null || node.next.next == null) {
				return node;
			}

			Node prev = node;
			Node PartialUnfold = UnFold(node.next.next);

			Node temp = prev.next;
			prev.next = PartialUnfold;
			this.tail.next = temp;
			this.tail = temp;
			temp.next = null;

			return prev;
		}

		// KthNodeFromBack,ReverseInKthMultiple_and_MidElement.=====================================================

		public int KthFromBack(int k) {
			return KthNodeFromBack(k).data;
		}

		public Node KthNodeFromBack(int k) {

			Node slow = this.head;
			Node fast = this.head;

			for (int i = 0; i < k; i++) {
				fast = fast.next;
			}

			while (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}

			return slow;

		}

		public int MidEle() {
			return Mid().data;
		}

		// Sorting.=====================================================================================================

		private Linkedlist MergeTwoList(Linkedlist other) throws Exception {
			Linkedlist nl = new Linkedlist();

			while (this.ElementCount != 0 && other.ElementCount != 0) {
				if (getFirst() < other.getFirst()) {
					nl.AddFirstNode(RemoveFirstNode());
				} else {
					nl.AddFirstNode(other.RemoveFirstNode());
				}
			}

			while (this.ElementCount != 0) {
				nl.AddFirstNode(RemoveFirstNode());
			}

			while (other.ElementCount != 0) {
				nl.AddFirstNode(other.RemoveFirstNode());
			}

			return nl;
		}

		// removeDuplicates_and_OddEvenArrange_in_linkList-------------------------------------------------------------------------

		public void OddEven() throws Exception {
			Linkedlist odd = new Linkedlist();
			Linkedlist even = new Linkedlist();

			while (this.ElementCount != 0) {
				if ((getFirst() & 1) == 0) {
					even.AddFirstNode(RemoveFirstNode());
				} else {
					odd.AddFirstNode(RemoveFirstNode());
				}
			}

			if (odd.head != null && even.head != null) {
				this.head = odd.head;
				odd.tail.next = even.head;
				this.tail = even.tail;
			} else if (odd.head != null) {
				this.head = odd.head;
				this.tail = odd.tail;
			} else {
				this.head = even.head;
				this.tail = even.tail;
			}

			this.ElementCount = odd.ElementCount + even.ElementCount;

		}

	}

	// ------------------------------------------------------------------------------------------------------------------------

	private static class Scan {
		private InputStream in;
		private byte[] buf = new byte[1024 * 1024];
		private int index;
		private int total;

		public Scan(InputStream in) {
			this.in = in;
		}

		public int scan() throws IOException {
			if (total < 0)
				throw new InputMismatchException();
			if (index >= total) {
				index = 0;
				total = in.read(buf);
				if (total <= 0)
					return -1;
			}
			return buf[index++];
		}

		public int scanInt() throws IOException {
			int integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			return neg * integer;
		}

		public long scanLong() throws IOException {
			long integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			return neg * integer;
		}

		public double scanDouble() throws IOException {
			double doub = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n) && n != '.') {
				if (n >= '0' && n <= '9') {
					doub *= 10;
					doub += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			if (n == '.') {
				n = scan();
				double temp = 1;
				while (!isWhiteSpace(n)) {
					if (n >= '0' && n <= '9') {
						temp /= 10;
						doub += (n - '0') * temp;
						n = scan();
					} else
						throw new InputMismatchException();
				}
			}
			return doub * neg;
		}

		public String scanString() throws IOException {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			while (!isWhiteSpace(n)) {
				sb.append((char) n);
				n = scan();
			}
			return sb.toString();
		}

		public String scanStringLine() throws IOException {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpaceModified(n))
				n = scan();
			while (!isWhiteSpaceModified(n)) {
				sb.append((char) n);
				n = scan();
			}
			return sb.toString();
		}

		private boolean isWhiteSpace(int n) {
			if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}

		private boolean isWhiteSpaceModified(int n) {
			if (n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}
	}

	private static class Print {
		private final BufferedWriter bw;

		public Print() {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(String str) throws IOException {
			bw.append(str);
		}

		public void printLine(String str) throws IOException {
			print(str);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}

}