package Class_17th_OPPs2_dynamic_stack_que.Queue_reverse;

public class Queue_reverse extends Queue_basic {

	public void displayReverseRecu() throws Exception {
		displayReverseRecu(0);
	}

	private void displayReverseRecu(int vidx) throws Exception {
		if (this.size == 0) {
			throw new Exception("queue is empty");
		}
		if (vidx == this.data.length) {
			return;
		}

		displayReverseRecu(vidx + 1);
		System.out.println(this.data[(this.front + vidx) % data.length]);
	}
	
	public void displayReverseIrr() throws Exception {
		if (this.size == 0) {
			throw new Exception("queue is empty");
		}
		
		for(int i=1;i<=this.size;i++){
			System.out.println(this.data[(this.front +this.size - i) % data.length]);
		}
	}

	public void reverseArgu(Queue_basic q) throws Exception { //dequeue_Exception_handle_this_Exception.

		if (this.size == 0) {
			return;
		}

		int p = dequeue();

		reverseArgu(q);

		enqueue(p);

	}
	
	public void reverse() throws Exception { //dequeue_Exception_handle_this_Exception.

		if (this.size == 0) {
			return;
		}

		int p = dequeue();

		reverse();

		enqueue(p);

	}

}
