package july19.queues;

public class DynamicQueue extends Queue {

	DynamicQueue(int cap) {
		super(cap);
	}
	
	@Override
	public void enqueue(int val) throws Exception {
		if (size == data.length) {
			int[] oa = data;
			data = new int[2 * oa.length];
			
			for(int i = 0; i < size; i++){
				data[i] = oa[(i + front) % oa.length];
			}
			
			front = 0;
		}

		int tail = (front + size) % data.length;
		data[tail] = val;
		size++;
	}

}
