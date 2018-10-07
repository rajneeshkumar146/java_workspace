package july18;

// LinkedList adapted to become a queue
public class QueueUsingLL {
	private LinkedList list;
	
	public QueueUsingLL(){
		list = new LinkedList();
	}
	
	public void enqueue(int val){
		this.list.addLast(val);
	}
	
	public int front() throws Exception{
		try {
			return this.list.getFirst();
		} catch (Exception e) {
			throw new Exception("Queue is empty");
		}
	}
	
	public int dequeue() throws Exception{
		try {
			return this.list.removeFirst();
		} catch (Exception e) {
			throw new Exception("Queue is empty");
		}
	}
	
	public int size(){
		return this.list.size();
	}
	
	public boolean isEmpty(){
		return this.list.isEmpty();
	}
	
	public void display(){
		this.list.display();
	}
}
