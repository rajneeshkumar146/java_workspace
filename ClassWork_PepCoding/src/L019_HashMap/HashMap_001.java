package L019_HashMap;

import java.util.ArrayList;
import java.util.Scanner;

public class HashMap_001 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		HashMap<String, Integer> map = new HashMap<>();

		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 30);
		map.put("D", 40);
		map.put("D", 50);
		System.out.println(map);

		map.put("E", 10);
		map.put("F", 20);
		map.put("G", 30);
		map.put("H", 40);
		map.put("I", 50);
		System.out.println(map);

		// System.out.println(map.KeySet());

	}

	private static class HashMap<K, V> {

		private class Node {
			private K key;
			private V value;

			public Node(K key, V value) {
				this.key = key;
				this.value = value;
			}

		}

		private Linkedlist<Node>[] bucket;
		private int size = 0;

		public String toString() {
			ArrayList<String> list = new ArrayList<>();
			for (int i = 0; i < bucket.length; i++) {

				Linkedlist<Node> nlist = new Linkedlist<>();
				while (bucket[i].size() != 0) {
					Node node = null;

					try {
						node = bucket[i].RemoveFirst();
					} catch (Exception e) {
						e.printStackTrace();
					}

					String str = "(" + node.key + ", " + node.value + ")";
					list.add(str);

					nlist.AddLast(node);
				}

				bucket[i] = nlist;

			}

			return list.toString();
		}

		public HashMap() {
			bucket = new Linkedlist[10];
			for (int i = 0; i < bucket.length; i++) {
				bucket[i] = new Linkedlist<>();
				bucket[i].ElementCount = 0;
			}
		}

		public void put(K key, V value) throws Exception {

			int HC = HashFunction(key);
			Linkedlist<Node> list = bucket[HC];

			Node FoundInBucket = FoundInBucket(list, key);
			if (FoundInBucket == null) {
				Node node = new Node(key, value);
				bucket[HC].AddLast(node);
			} else {
				Node node = FoundInBucket;
				node.value = value;
				this.size++;
			}

			double lambda = (this.size * 1.0) / bucket.length;
			if (lambda > 0.5) {
				Rehash();
			}

		}

		public V get(K key) throws Exception {
			int HC = HashFunction(key);
			Linkedlist<Node> list = bucket[HC];
			Node FoundInBucket = FoundInBucket(list, key);

			if (FoundInBucket == null) {
				return null;
			} else {
				return FoundInBucket.value;
			}

		}

		public V Remove(K key) throws Exception {
			int HC = HashFunction(key);
			Linkedlist<Node> list = bucket[HC];
			int index = FoundInBucketIndex(list, key);

			if (index == -1) {
				return null;
			} else {
				Node node = list.getAt(index);
				this.size--;
				return node.value;
			}

		}

		public boolean ContainsKey(K key) throws Exception {
			int HC = HashFunction(key);
			Linkedlist<Node> list = bucket[HC];
			if (FoundInBucket(list, key) != null) {
				return true;
			}
			return false;

		}

		public ArrayList<K> KeySet() throws Exception {
			ArrayList<K> list = new ArrayList<>();
			for (int i = 0; i < bucket.length; i++) {
				Linkedlist<Node> nlist = new Linkedlist<>();
				while (bucket[i].size() != 0) {
					Node node = bucket[i].RemoveFirst();
					list.add(node.key);
					nlist.AddLast(node);
				}

				bucket[i] = nlist;
			}

			return list;

		}

		public void diplay() throws Exception {
			for (int i = 0; i < bucket.length; i++) {

				Linkedlist<Node> nlist = new Linkedlist<>();
				while (bucket[i].size() != 0) {
					Node node = bucket[i].RemoveFirst();

					String str = "(" + node.key + ", " + node.value + ")";

					nlist.AddLast(node);
				}

				bucket[i] = nlist;

			}

		}

		private void Rehash() throws Exception {
			Linkedlist<Node>[] oldBucket = bucket;

			bucket = new Linkedlist[oldBucket.length * 2];

			for (int i = 0; i < bucket.length; i++) {
				bucket[i] = new Linkedlist<>();
			}
			this.size = 0;

			for (int i = 0; i < oldBucket.length; i++) {
				Linkedlist<Node> list = oldBucket[i];
				while (oldBucket[i].size() != 0) {
					Node node = list.RemoveFirst();
					put(node.key, node.value);
				}
			}

		}

		private Node FoundInBucket(Linkedlist<Node> list, K key) throws Exception {
			Node rNode = null;

			for (int i = 0; i < list.size(); i++) {
				Node node = list.RemoveFirst();
				if (node.key.equals(key)) {
					rNode = node;
				}
				list.AddLast(node);
			}
			return rNode;

		}

		private int FoundInBucketIndex(Linkedlist<Node> list, K key) throws Exception {
			int index = -1;

			for (int i = 0; i < list.size(); i++) {
				Node node = list.RemoveFirst();
				if (node.key.equals(key)) {
					index = -1;
				}
				list.AddLast(node);
			}
			return index;

		}

		private int HashFunction(K key) {
			int hashCode = key.hashCode();
			return Math.abs(hashCode) % bucket.length;
		}

	}

	private static class Linkedlist<T> {

		private class Node {
			private Node next;
			private T data;
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
			T temp = one.data;
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

		// AddFunctions.=========================================================================================

		public void AddFirst(T data) {

			Node node = new Node();
			node.data = data;
			if (this.ElementCount == 0) {
				this.head = node;
				this.tail = node;
			} else {
				node.next = this.head;
			}

			this.head = node;
			this.ElementCount++;
		}

		public void AddLast(T data) {
			Node node = new Node();
			node.data = data;

			if (this.ElementCount == 0) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
			this.ElementCount++;
		}

		// GetFunctions.==========================================================================================

		public T getFirst() throws Exception {
			if (this.ElementCount == 0) {
				throw new Exception("EmptyList");
			}
			return this.head.data;
		}

		public T getLast() throws Exception {
			if (this.ElementCount == 0) {
				throw new Exception("EmptyList");
			}
			return this.tail.data;
		}

		public T getAt(int index) throws Exception {
			if (this.ElementCount == 0) {
				throw new Exception("EmptyList");
			} else if (index < 0 || index >= this.ElementCount) {
				throw new Exception("InvalidIndex");
			}

			return GetNodeAt(index).data;
		}

		// RemoveFunctions.=======================================================================================

		public T RemoveFirst() throws Exception {
			if (this.ElementCount == 0) {
				throw new Exception("EmptyList");
			}

			Node node = this.head;
			this.head = node.next;

			if (this.ElementCount == 1) {
				this.tail = null;
			}

			this.ElementCount--;
			return node.data;
		}

		public T RemoveLast() throws Exception {
			if (this.ElementCount == 0) {
				throw new Exception("EmptyList");
			}

			if (this.ElementCount == 1) {
				this.ElementCount--;
				T rv = this.tail.data;
				this.head = this.tail = null;
				return rv;

			}

			Node node = GetNodeAt(this.ElementCount - 2);
			T rv = node.next.data;
			this.tail = node;
			node.next = null;
			this.ElementCount--;
			return rv;
		}

		public T RemoveAt(int index) throws Exception {
			if (this.ElementCount == 0) {
				throw new Exception("EmptyList");
			} else if (index < 0 || index >= this.ElementCount) {
				throw new Exception("InvalidIndex");
			}

			if (index == 0) {
				return RemoveFirst();

			}

			else if (this.ElementCount == 1) {
				this.ElementCount--;
				T rv = this.tail.data;
				this.head = this.tail = null;
				return rv;
			} else if (index == this.ElementCount - 1) {
				return RemoveLast();
			}

			Node node = GetNodeAt(index - 1);
			T rv = node.next.data;
			node.next = node.next.next;

			this.ElementCount--;
			return rv;

		}

	}

}
