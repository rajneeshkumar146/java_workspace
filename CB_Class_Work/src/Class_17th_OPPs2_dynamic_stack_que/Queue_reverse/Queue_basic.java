package Class_17th_OPPs2_dynamic_stack_que.Queue_reverse;

public class Queue_basic {

	protected int[] data;
	protected int front;
	protected int size;

	Queue_basic(){   // default_constractor
		this(5);
	}
	
	public Queue_basic(int cap) {  // Contractor
		this.data = new int[cap];
	}

	public void enqueue(int value) throws Exception {  // push
		if (this.size == this.data.length) {
			throw new Exception("queue is full now there is no space");
		}
		int tail = (front + size) % data.length;
		this.data[tail] = value;
		size++;
	}

	public int dequeue() throws Exception {  //pop
		if (this.size == 0) {
			throw new Exception("queue is empty");
		}

		int value = this.data[front];
		this.data[front] = 0;
		front = (front + 1) % this.data.length;
		size--;
		return value;
	}

	public int front() throws Exception{  //top
		if (this.size == 0) {
			throw new Exception("queue is empty");
		}
		return data[this.front];
	}

	public void display() throws Exception {
		if (this.size == 0) {
			throw new Exception("queue is empty");
		}
		for (int i = 0; i < this.size; i++) {
			System.out.println(this.data[(this.front + i) % data.length] + ",");
		} 
	}

	public int size() {
		return this.size;
	}

	public boolean IsEmpty() {
		return this.size == 0;
	}

}
