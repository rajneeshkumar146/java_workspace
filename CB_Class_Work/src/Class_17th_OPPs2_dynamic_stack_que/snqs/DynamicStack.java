package Class_17th_OPPs2_dynamic_stack_que.snqs;

public class DynamicStack extends Stack {
	@Override
	public void push(int item) throws Exception {
		if (this.tos == this.data.length - 1) {
			int[] datanew = this.data;
			this.data = new int[2 * datanew.length];
			for (int i = 0; i < datanew.length; i++) {
				this.data[i] = datanew[i];
			}

		}

		super.push(item);
	}

}
