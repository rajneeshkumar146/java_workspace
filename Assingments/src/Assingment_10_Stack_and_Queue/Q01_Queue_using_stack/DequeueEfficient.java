package Assingment_10_Stack_and_Queue.Q01_Queue_using_stack;

import java.util.Stack;

public class DequeueEfficient {

	public class StackRecord {
		Stack<Integer> stk1 = new Stack<>();
		Stack<Integer> stk2 = new Stack<>();
	}

	private StackRecord q = new StackRecord();

	public void enqueue(int num) {
		reverse();
		this.q.stk1.push(num);
		reverse();
	}

	private void reverse() {
		while (!isEmpty()) {
			int temp = this.q.stk1.pop();
			this.q.stk2.push(temp);
		}

		Stack<Integer> temp = this.q.stk1;
		this.q.stk1 = this.q.stk2;
		this.q.stk2 = temp;
	}

	public int dequeue() throws Exception {
		if (this.q.stk1.isEmpty()) {
			throw new Exception("Queue is empty");
		}
		int res = this.q.stk1.pop();
		return res;

	}

	public void display() {
		reverse();
		System.out.println(this.q.stk1);
	}

	public int size() {
		return this.q.stk1.size();
	}

	public boolean isEmpty() {
		return (size() == 0);

	}

}
