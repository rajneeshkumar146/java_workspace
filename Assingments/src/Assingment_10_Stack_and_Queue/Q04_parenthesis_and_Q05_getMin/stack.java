package Assingment_10_Stack_and_Queue.Q04_parenthesis_and_Q05_getMin;

import java.util.Stack;

public class stack {
	Stack<Integer> s = new Stack<>();

	public void push(int num) {
		this.s.push(num);
	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return this.s.pop();
	}

	public int top() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return this.s.peek();
	}

	public boolean CheckDupliparenthesis(String str) {
		Stack<Character> stk = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == ')') {
				char check = stk.peek();
				stk.pop();
				if (check == '(') {
					return true; // duplicates_found.
				}
				while (check != '(') {
					check = stk.peek();
					stk.pop();
				}
			} else {
				if (ch != ' ') {
					stk.push(ch);
				}
			}
		}
		return false; // no_duplicates_found.

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
