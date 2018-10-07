package july22_CruxWeekEnd.stacks;

public class DynamicStack extends Stack {

	public DynamicStack(int cap) {
		super(cap);
	}

	@Override
	public void push(int value) throws Exception {
		if (this.tos == this.data.length - 1) {
			int[] oa = data;
			this.data= new int[2 * oa.length];
			
			for(int i = 0; i < oa.length; i++){
				this.data[i] = oa[i];
			}
		}
		this.tos++;
		this.data[this.tos] = value;
	}

}
