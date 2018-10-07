package Class_17th_OPPs2_dynamic_stack_que.Queue_reverse;

public class Queue_reverse_client {
	public static void main(String[] args) throws Exception {
		Queue_basic st = new Queue_reverse();

		st.enqueue(10);
		st.enqueue(20);
		st.enqueue(30);
		st.enqueue(40);
		st.dequeue();
		st.dequeue();
		st.enqueue(50);
		st.enqueue(60);
		st.enqueue(20);
		
		st.display();
		
//		System.out.println("______________________________");
//
//		((Queue_reverse) st).displayReverseRecu();
//		
//		System.out.println("______________________________");
//
//		((Queue_reverse) st).displayReverseIrr();
//
//
//		System.out.println("______________________________");
//
//		((Queue_reverse) st).reverseArgu(st);
//		
//		st.display();
		
		System.out.println("______________________________");

		((Queue_reverse) st).reverse();

		st.display();
		
		System.out.println("______________________________");


		
		((Queue_reverse) st).reverse();

		st.display();

	}

}
