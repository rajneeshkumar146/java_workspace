package Assingment_10_Stack_and_Queue.Q02_Stack_using_queue;

public class pushEfficientClient {

	public static void main(String[] args) throws Exception {
		PushEfficient s = new PushEfficient();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.push(70);
		s.push(80);
		s.pop();
		s.pop();
		System.out.println(s.peek());
		s.display();

	}

}
