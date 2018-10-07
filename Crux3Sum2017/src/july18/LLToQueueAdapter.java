package july18;

public class LLToQueueAdapter {
	private LinkedList list;
	
	public LLToQueueAdapter() {
		list = new LinkedList();
	}
	
	public void enqueue(int value) throws Exception {
		list.addLast(value);
	}

	public int dequeue() {
		return list.removeFirst();
	}

	public int front() {
		return list.getFirst();
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void display() {
		list.display();
	} 
}
