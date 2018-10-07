package july16.queuestory;

public class Queue {
	protected int[] data;
	protected int front;
	protected int size;

	public Queue() {
		this(5);
	}
	
	public Queue(int cap) {
		this.data = new int[cap];
	}

	public void enqueue(int value) throws Exception {
		if(size == data.length){
			
		}
	}

	public int dequeue() {

	}

	public int front() {

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		System.out.println("-------------------------------------------------");
		for(int i = 0; i < this.size; i++){
			System.out.print(data[(front + i) % data.length] + ", ");
		}
		System.out.println(".");
		System.out.println("-------------------------------------------------");
	}
}
