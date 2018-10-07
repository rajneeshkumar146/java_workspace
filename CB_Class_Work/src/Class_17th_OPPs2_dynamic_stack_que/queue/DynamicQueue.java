package Class_17th_OPPs2_dynamic_stack_que.queue;

public class DynamicQueue extends Queue {
	@Override
	public void enqueue(int value) throws Exception { // push
		if (this.size == this.data.length) {
			int[] datanew = this.data;
			int frontnew = this.front;
			this.data = new int[2 * datanew.length];
			for (int i = 0; i < datanew.length; i++) {
				this.data[i] = datanew[(front+i)%datanew.length];
			}
			this.front = 0;

		}
		super.enqueue(value);
	}

}
