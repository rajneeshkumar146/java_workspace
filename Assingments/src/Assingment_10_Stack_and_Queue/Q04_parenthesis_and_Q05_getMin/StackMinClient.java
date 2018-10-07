package Assingment_10_Stack_and_Queue.Q04_parenthesis_and_Q05_getMin;

public class StackMinClient {

	public static void main(String[] args) throws Exception {
		stackMin s = new stackMin();
		s.push(4);
		s.push(40);
		s.push(3);
		s.push(2);
		s.push(40);
		s.push(-6);
		s.push(30);
		s.push(20);
		s.push(10);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println("-----------------------");
		System.out.println(s.getMin());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());

	}

}
