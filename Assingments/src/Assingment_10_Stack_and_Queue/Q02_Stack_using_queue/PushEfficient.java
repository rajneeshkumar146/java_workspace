package Assingment_10_Stack_and_Queue.Q02_Stack_using_queue;

import java.util.LinkedList;
import java.util.Queue;

public class PushEfficient {
	public class queuerecord {
		Queue<Integer> que1 = new LinkedList<>();
		Queue<Integer> que2 = new LinkedList<>();
	}

	queuerecord q = new queuerecord();

	public void push(int num) {
		this.q.que1.add(num);
	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		while (size() != 1) {
			int temp = this.q.que1.remove();
			this.q.que2.add(temp);
		}
		int rv = this.q.que1.remove();
		Queue<Integer> q = this.q.que1; // swap_refrence_of_two_queue.
		this.q.que1 = this.q.que2;
		this.q.que2 = q;
		return rv;
	}

	public int peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}

		while (size() != 1) {
			int temp = this.q.que1.remove();
			this.q.que2.add(temp);
		}
		int rv = this.q.que1.peek();
		this.q.que2.add(rv);
		Queue<Integer> q = this.q.que1; // swap_refrence_of_two_queue.
		this.q.que1 = this.q.que2;
		this.q.que2 = q;

		return rv;
	}

	public void display() {
		System.out.println(this.q.que1);
	}

	public int size() {
		return this.q.que1.size();
	}

	public boolean isEmpty() {
		return this.q.que1.isEmpty();
	}
}
