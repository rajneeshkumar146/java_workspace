package Assingment_10_Stack_and_Queue.Q03_reverse;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class queue {

	Queue<Integer> que1 = new LinkedList<>();

	public void enqueue(int num) {
		this.que1.add(num);
	}

	public int dequeue() throws Exception {
		if (this.que1.size() == 0) {
			throw new Exception("Queue is Empty");
		}
		return this.que1.remove();
	}

	// Reverse_Queue_using_recursion.

	public void reverse() throws Exception {
		if (isEmpty()) {
			return;
		}

		int item = dequeue();
		reverse();
		enqueue(item);
	}

	public void display() {
		System.out.println(this.que1);
	}

	public int size() {
		return this.que1.size();
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

}
