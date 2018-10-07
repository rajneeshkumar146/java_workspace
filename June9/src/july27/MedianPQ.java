package july27;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPQ {
	PriorityQueue<Integer> lhminpq = new PriorityQueue<>();
	PriorityQueue<Integer> shmaxpq = new PriorityQueue<>(Collections.reverseOrder());
	int size = 0;
	
	// logn
	public void add(int data){
		if(shmaxpq.size() != 0 && data < shmaxpq.peek()){
			shmaxpq.add(data);
		} else if(lhminpq.size() != 0 && data > lhminpq.peek()){
			lhminpq.add(data);
		} else {
			shmaxpq.add(data);
		}
		
		if(shmaxpq.size() - lhminpq.size() > 1){
			lhminpq.add(shmaxpq.remove());
		} else if(lhminpq.size() - shmaxpq.size() > 1){
			shmaxpq.add(lhminpq.remove());
		}
		size++;
	}
	
	// o1
	public int peek(){
		if(size == 0){
			return -1;
		}
		
		return shmaxpq.size() >= lhminpq.size()? shmaxpq.peek(): lhminpq.peek();
	}
	
	// logn
	public int remove(){
		if(size == 0){
			return -1;
		}
		
		size--;
		return shmaxpq.size() >= lhminpq.size()? shmaxpq.remove(): lhminpq.remove();
	}
}
