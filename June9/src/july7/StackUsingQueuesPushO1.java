package july7;

import july6.queuesstory.*;

public class StackUsingQueuesPushO1 {
	DynamicQueue dq;
	DynamicQueue hq;
	
	public StackUsingQueuesPushO1(int cap){
		dq = new DynamicQueue(cap);
		hq = new DynamicQueue(cap);
	}
	
	public void push(int val){
		dq.enqueue(val);
	}
	
	public int top(){
		while(dq.size() > 1){
			hq.enqueue(dq.dequeue());
		}
		
		int rv = dq.dequeue();
		hq.enqueue(rv);
		
		DynamicQueue temp = dq;
		dq = hq;
		hq = temp;
		
		return rv;
	}
	
	public int pop(){
		while(dq.size() > 1){
			hq.enqueue(dq.dequeue());
		}
		
		int rv = dq.dequeue();
		
		DynamicQueue temp = dq;
		dq = hq;
		hq = temp;
		
		return rv;
	}
	
	public int size(){
		return dq.size();
	}
}
