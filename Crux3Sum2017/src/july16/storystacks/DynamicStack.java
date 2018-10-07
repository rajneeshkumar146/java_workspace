package july16.storystacks;

public class DynamicStack extends Stack {

	@Override
	public void push(int value) throws Exception {
		if (tos == data.length - 1) {
			int[] oa = this.data;

			this.data = new int[2 * oa.length];
			for (int i = 0; i < oa.length; i++) {
				this.data[i] = oa[i];
			}
		}
		super.push(value);
	}

}
