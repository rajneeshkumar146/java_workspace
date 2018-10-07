package july6.queuesstory;

public class DynamicQueue extends Queue {
	public DynamicQueue(int cap) {
		super(cap);
	}

	public void enqueue(int val) {
		if (size == arr.length) {
			int[] oa = arr;
			
			arr = new int[2 * oa.length];
			
			for(int i = 0; i < this.size; i++){
				arr[i] = oa[(front + i) % oa.length];
			}
			front = 0;
		}
		
		super.enqueue(val);
	}

}
