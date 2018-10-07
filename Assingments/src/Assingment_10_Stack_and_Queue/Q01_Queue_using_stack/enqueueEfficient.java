package Assingment_10_Stack_and_Queue.Q01_Queue_using_stack;

import java.util.Stack;

public class enqueueEfficient {

	public class StackRecord {

		Stack<Integer> stk1 = new Stack<>();
		Stack<Integer> stk2 = new Stack<>();

	}

	private StackRecord q = new StackRecord();

	public int dequeue() throws Exception {
		if (this.q.stk1.isEmpty()) {
			throw new Exception("queue is empty");
		}

		while (!this.q.stk1.isEmpty()) {
			int item = this.q.stk1.pop();
			this.q.stk2.push(item);
		}

		int res = this.q.stk2.pop();

		while (!this.q.stk2.isEmpty()) {
			int item = this.q.stk2.pop();
			this.q.stk1.push(item);
		}

		return res;
	}

	public void enqueue(int num) {
		this.q.stk1.push(num);
	}

	public void display() {
		System.out.println(this.q.stk1);
	}

	public int size() {
		return this.q.stk1.size();
	}

	public boolean isEmpty() {
		return (size() == 0);

	}

}
