package july19.stacks;

public class DynamicStack extends Stack {
	public DynamicStack(int cap) {
		super(cap);
	}
	
	public void push(int value) throws Exception {
		if (this.tos == this.data.length - 1) {
			int[] oa = this.data;
			this.data = new int[2 * oa.length];
			for(int i = 0; i < oa.length; i++){
				data[i] = oa[i];
			}
		}
		this.tos++;
		this.data[this.tos] = value;
	}

}
