package Class_18and19th_LinkedList;

public class LLtoStack_Client {

	public static void main(String[] args) throws Exception {
		LinkedList_simple st = new LLtostack();

		((LLtostack) st).push(10);
		((LLtostack) st).push(20);
		((LLtostack) st).push(30);
		((LLtostack) st).push(40);
		((LLtostack) st).push(50);

		((LLtostack) st).pop();
		((LLtostack) st).Display();

		System.out.println(((LLtostack) st).top());
		

		

		
	}

}
