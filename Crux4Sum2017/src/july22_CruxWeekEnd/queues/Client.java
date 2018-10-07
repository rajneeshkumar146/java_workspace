package july22_CruxWeekEnd.queues;

public class Client {

	public static void main(String[] args) throws Exception {
		Queue q = new DynamicQueue(5);

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);

		q.display();

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		q.display();

		q.enqueue(50);
		q.enqueue(60);
		q.enqueue(70);

		q.display();

		q.enqueue(80);

//		q.display();
//		displayreverse(q, 0);
//		q.display();

		q.display();
		realreverse(q);
		q.display();
	}

	public static void displayreverse(Queue q, int howmany) throws Exception {
		if (howmany == q.size) {
			return;
		}

		int temp = q.dequeue();
		q.enqueue(temp);
		displayreverse(q, howmany + 1);
		System.out.println(temp);
	}

	public static void realreverse(Queue q) throws Exception {
		if(q.isEmpty()){
			return;
		}
		
		int temp = q.dequeue();
		realreverse(q);
		q.enqueue(temp);
	}
}