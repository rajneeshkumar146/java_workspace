package Class_17th_OPPs2_dynamic_stack_que.queue;


public class dynamic_queue_client {
	
	public static void main(String[] args) throws Exception {
		Queue st = new DynamicQueue();
		
		st.enqueue(10);
		st.enqueue(20);
		st.enqueue(30);
		st.enqueue(40);
		st.dequeue();
		st.dequeue();
		st.enqueue(50);
		st.enqueue(60);
		st.enqueue(20);
		st.enqueue(80);
		
		st.display();
		System.out.println(st.size());
	}

}
