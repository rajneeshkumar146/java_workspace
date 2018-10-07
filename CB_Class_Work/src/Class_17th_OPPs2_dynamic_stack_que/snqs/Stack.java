package Class_17th_OPPs2_dynamic_stack_que.snqs;

public class Stack {
	protected int[] data;
	protected int tos = -1;

	Stack() {
		this(5);
	}

	Stack(int cap) {
		this.data = new int[cap];
	}

	public void push(int item) throws Exception { // add
		if (this.tos == this.data.length - 1) {
			throw new Exception("Stack over flow");
		}

		this.tos++;
		this.data[this.tos] = item;
	}

	public int top() throws Exception { // show
		if (this.tos == -1) {
			throw new Exception("Stack is empty");
		}

		int rv = this.data[this.tos];
		return rv;
	}

	public int pop() throws Exception { // remove
		if (this.tos == -1) {
			throw new Exception("Stack is empty");
		}

		int rv = this.data[this.tos];
		this.tos--;
		return rv;
	}

	public int search(int item) {

		int idx = 0;
		while (idx <= this.tos) {
			if (this.data[idx] == item) {
				return idx;
			}
		}

		return -1;

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
		for (int i = this.tos; i >= 0; i--) {
			System.out.print(this.data[i] + ", ");
		}
		System.out.println(".");
	}

}
