package Assingment_10_Stack_and_Queue.Q02_Stack_using_queue;

import java.util.LinkedList;
import java.util.Queue;

public class popEfficient {
	public class queuerecord {
		Queue<Integer> que1 = new LinkedList<>();
	}

	queuerecord q = new queuerecord();

	public void push(int num) throws Exception {
		reverse();
		this.q.que1.add(num);
		reverse();
	}

	public void reverse() throws Exception {
		if (isEmpty()) {
			return;
		}

		int item = pop();
		reverse();
		this.q.que1.add(item);
	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}

		return this.q.que1.remove();
	}

	public int peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}

		return this.q.que1.peek();
	}

	public void display() throws Exception {
		reverse();
		System.out.println(this.q.que1);
	}

	public int size() {
		return this.q.que1.size();
	}

	public boolean isEmpty() {
		return this.q.que1.isEmpty();
	}
}
