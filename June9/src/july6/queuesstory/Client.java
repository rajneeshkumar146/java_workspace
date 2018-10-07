package july6.queuesstory;

public class Client {

	public static void main(String[] args) {
		Queue q = new DynamicQueue(5);
		
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.display();
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.display();
		
		q.enqueue(60);
		q.enqueue(70);
		q.enqueue(80);
		q.display();
	}

}
