package Class_17th_OPPs2_dynamic_stack_que.snqs;

public class dynamicclient {

	public static void main(String[] args) throws Exception {
		Stack st = new DynamicStack();
		
		st.push(10);
		st.display();
		
		st.push(20);
		st.display();
		
		st.push(30);
		st.display();
		
		st.push(40);
		st.display();
		
		st.push(50);
		st.display();
		
		st.push(60);
		st.display();
		
		System.out.println(st.pop());
		st.display();
		
		System.out.println(st.pop());
		st.display();
		
		System.out.println(st.pop());
		st.display();
		
		System.out.println(st.pop());
		st.display();
		
		System.out.println(st.pop());
		st.display();
		
		System.out.println(st.pop());
		st.display();
	}

}

