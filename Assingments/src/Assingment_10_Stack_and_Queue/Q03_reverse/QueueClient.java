package Assingment_10_Stack_and_Queue.Q03_reverse;

public class QueueClient {

	public static void main(String[] args) throws Exception {
		queue q = new queue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);
		q.dequeue();
		q.dequeue();
		q.display();
		q.reverse();
		q.display();
		
	}

}
