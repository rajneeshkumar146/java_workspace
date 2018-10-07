package july19.stacks;

public class Stack {
	int[] data;
	int tos = -1;

	// parametrized ctor
	public Stack(int cap) {
		this.data = new int[cap];
	}

	public void push(int value) throws Exception {
		if (this.tos == this.data.length - 1) {
			throw new Exception("Stack is full");
		}
		this.tos++;
		this.data[this.tos] = value;
	}

	public int top() throws Exception {
		if (this.tos == -1) {
			throw new Exception("Stack is empty");
		}
		return this.data[this.tos];
	}

	public int pop() throws Exception {
		if (this.tos == -1) {
			throw new Exception("Stack is empty");
		}
		int temp = this.data[this.tos];
		this.data[this.tos] = 0;
		this.tos--;
		return temp;
	}

	public int size() {
		return this.tos + 1;
	}

	public boolean isEmpty() {
		if (this.tos == -1) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		System.out.println("---------------------------------");
		for (int i = this.tos; i >= 0; i--) {
			System.out.print(this.data[i] + ", ");
		}
		System.out.println(".");
		System.out.println("---------------------------------");
	}
}
