package Assingment_10_Stack_and_Queue.Q01_Queue_using_stack;

public class DequeueEfficientClient {

	public static void main(String[] args) throws Exception {
		DequeueEfficient q = new DequeueEfficient();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.display();

	}

}
