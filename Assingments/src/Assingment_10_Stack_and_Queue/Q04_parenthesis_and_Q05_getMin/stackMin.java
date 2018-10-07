package Assingment_10_Stack_and_Queue.Q04_parenthesis_and_Q05_getMin;

import java.util.Stack;

public class stackMin {
	private Stack<Integer> s = new Stack<>();
	private int min;

	public void push(int num) {
		if (isEmpty()) {
			this.min = num;
			this.s.push(num);
			return;
		}
		if (num < min) {
			int temp = 2 * num - min;
			this.s.push(temp);
			this.min = num;
		} else {
			this.s.push(num);
		}
	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		int temp = this.s.pop();
		if (temp < min) {
			int rv = min; // return_value
			min = 2 * min - temp;
			return rv;
		}
		return temp;

	}

	public int top() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		int temp = this.s.peek();
		if (temp < min) {
			return min;
		}
		return this.s.peek();
	}

	public int getMin() {
		return this.min;
	}

	public void display() {
		System.out.println(s);
	}

	public int size() {
		return this.size();
	}

	public boolean isEmpty() {
		return this.s.isEmpty();
	}

}
