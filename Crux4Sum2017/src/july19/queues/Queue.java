package july19.queues;

public class Queue {
	int[] data;
	int front;
	int size;

	Queue(int cap) {
		data = new int[cap];
	}

	public void enqueue(int val) throws Exception {
		if (size == data.length) {
			throw new Exception("Queue is full");
		}

		int tail = (front + size) % data.length;
		data[tail] = val;
		size++;
	}

	public int dequeue() throws Exception {
		if (size == 0) {
			throw new Exception("Queue is empty");
		}

		int temp = data[front];

		data[front] = 0;
		front = (front + 1) % data.length;
		size--;

		return temp;
	}

	public int front() throws Exception {
		if (size == 0) {
			throw new Exception("Queue is empty");
		}

		return data[front];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		} else {
			return false;
		}
	}

	public void display(){
		System.out.println("---------------------------------");
		for(int i = 0; i < size; i++){
			System.out.print(data[(i + front) % data.length] + ", ");
		}
		System.out.println(".");
		System.out.println("---------------------------------");
	}
}
