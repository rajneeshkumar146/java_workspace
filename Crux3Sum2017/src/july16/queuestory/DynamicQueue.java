package july16.queuestory;

public class DynamicQueue extends Queue {
	@Override
	public void enqueue(int value) throws Exception {
		if(this.size == data.length){
			int[] oa = data;
			data = new int[2 * oa.length];
			
			for(int i = 0; i < this.size; i++){
				data[i] = oa[(front + i) % oa.length];
			}
			
			this.front = 0;
		}
		
		super.enqueue(value);
	}
}
