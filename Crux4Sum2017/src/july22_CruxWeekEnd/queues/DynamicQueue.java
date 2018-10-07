package july22_CruxWeekEnd.queues;

public class DynamicQueue extends Queue {

	public DynamicQueue(int cap) {
		super(cap);
	}
	
	@Override
	public void enqueue(int item) throws Exception {
		if (size == data.length) {
			int[] oa = data;
			data = new int[2 * oa.length];
			
			for(int i = 0; i < size; i++){
				data[i] = oa[(front + i) % oa.length];
			}
			
			front = 0;
		}

		int last = (front + size) % data.length;
		data[last] = item;
		size++;
	}

	
}
