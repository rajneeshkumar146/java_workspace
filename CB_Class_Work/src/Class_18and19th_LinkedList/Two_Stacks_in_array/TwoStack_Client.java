package Class_18and19th_LinkedList.Two_Stacks_in_array;

public class TwoStack_Client {

	public static void main(String[] args)throws Exception {
	
		twoStacks st=new twoStacks(10);
		
		st.push1(10);
		st.push2(50);
		st.push1(20);
		st.push2(60);
		st.push1(30);
		st.push2(70);
		st.push1(40);
		st.push2(80);
		
		st.display1();
		System.out.println();
		st.display2();
		
		

	}

}
