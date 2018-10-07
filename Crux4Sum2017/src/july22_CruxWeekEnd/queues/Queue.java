package july22_CruxWeekEnd.queues;

public class Queue {
	int[] data;
	int front;
	int size;

	public Queue(int cap) {
		data = new int[cap];
	}

	public void enqueue(int item) throws Exception {
		if (size == data.length) {
			throw new Exception("Queue is full");
		}

		int last = (front + size) % data.length;
		data[last] = item;
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

	public boolean isEmpty() {
		if(size == 0){
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		System.out.println("---------------------------------");
		for(int i = 0; i < size; i++){
			System.out.print(data[(front + i) % data.length] + ", ");
		}
		System.out.println(".");
		System.out.println("---------------------------------");
	}
}
