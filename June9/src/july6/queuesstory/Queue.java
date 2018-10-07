package july6.queuesstory;

public class Queue {
	int[] arr;
	int front = 0;
	int size = 0;

	public Queue(int cap) {
		arr = new int[cap];
	}

	public void enqueue(int val) {
		if (size == arr.length) {
			System.out.println("Queue overflow");
			return;
		}
		int rear = (front + size) % arr.length;
		arr[rear] = val;
		size++;
	}

	public int dequeue() {
		if (size == 0) {
			System.out.println("Queue underflow");
			return -1;
		}

		int rv = arr[front];

		front = (front + 1) % arr.length;
		size--;

		return rv;
	}

	public int front() {
		if (size == 0) {
			System.out.println("Queue underflow");
			return -1;
		}

		return arr[front];
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		for(int i = 0; i < this.size; i++){
			System.out.print(arr[(front + i) % arr.length] + " ");
		}
		System.out.println(".");
	}
}
