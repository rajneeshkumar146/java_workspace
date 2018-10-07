package july19.queues;

public class Client {

	public static void main(String[] args) throws Exception {
		Queue q = new DynamicQueue(5);
		
		q.enqueue(10);
		q.display();
		
		q.enqueue(20);
		q.display();
		
		q.enqueue(30);
		q.display();
		
		q.enqueue(40);
		q.display();
		
		System.out.println(q.dequeue());
		q.display();
		
		System.out.println(q.dequeue());
		q.display();
		
		q.enqueue(50);
		q.display();
		
		q.enqueue(60);
		q.display();
		
		q.enqueue(70);
		q.display();
		
		q.enqueue(80);
		q.display();
		
		System.out.println(q.dequeue());
		q.display();
		
		System.out.println(q.dequeue());
		q.display();
		
		System.out.println(q.dequeue());
		q.display();
		
		System.out.println(q.dequeue());
		q.display();
	}

}
