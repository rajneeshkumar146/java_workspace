package Class_17th_OPPs2_dynamic_stack_que.snqs;

public class StackClient {

	public static void main(String[] args) throws Exception {
//		 Stack st = new Stack(5);

		Stack st = new display_reverse();

		st.push(10);
//		st.display();

		st.push(20);
//		st.display();

		st.push(30);
//		st.display();

		st.push(40);
//		st.display();

		st.push(50);
//		st.display();

//		((display_reverse) st).displayReverseRecu(0);

//		((display_reverse) st).reverseArgu(st, 0);

		st.display();
		
	

		// System.out.println(st.pop());
		// st.display();
		//
		// System.out.println(st.pop());
		// st.display();
		//
		// System.out.println(st.pop());
		// st.display();
		//
		// System.out.println(st.pop());
		// st.display();
		//
		// System.out.println(st.pop());
		// st.display();
		
		((display_reverse) st).reverseRecu(st);
		
		st.display();
		
		
	}

}
