package Class_18and19th_LinkedList;

public class LLtoQueue_Client {

	public static void main(String[] args) throws Exception {
		LinkedList_simple st = new LLtoqueue();

		((LLtoqueue) st).enqueue(10);
		((LLtoqueue) st).enqueue(20);
		((LLtoqueue) st).enqueue(30);
		((LLtoqueue) st).enqueue(40);
		((LLtoqueue) st).dequeue();
		((LLtoqueue) st).dequeue();
		((LLtoqueue) st).enqueue(50);
		((LLtoqueue) st).enqueue(60);
		((LLtoqueue) st).enqueue(20);
		((LLtoqueue) st).enqueue(80);

		((LLtoqueue) st).Display();
		System.out.println(st.size());

	}

}
