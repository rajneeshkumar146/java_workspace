package july5.stacksstory;

public class Client {

	public static void main(String[] args) {
		Stack s = new Stack(5);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.display();
		s.push(50);
		s.display();
		s.push(60);
		s.display();
		
		System.out.println(s.pop());
		s.display();
		
		System.out.println(s.pop());
		s.display();
		
		System.out.println(s.pop());
		s.display();
		
		System.out.println(s.pop());
		s.display();
		
		System.out.println(s.pop());
		s.display();
		
		System.out.println(s.pop());
		s.display();
	}

}
