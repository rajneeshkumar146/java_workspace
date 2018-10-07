package L010_StackAndQueue;

import java.util.Arrays;

public class DynamicStack_001 extends Stack_001 {
	public static void main(String[] args) {

		stack s = new DynamicStack(10);

	}

	public static class DynamicStack extends Stack_001.stack {

		public DynamicStack(int size) {
			super(size);
		}

		@Override
		public void push(int data) throws Exception {
			if (this.tos + 1 == this.arr.length) {
				int[] temparr = this.arr;
				this.arr = new int[2 * this.arr.length];
				for (int i = 0; i < temparr.length; i++) {
					this.arr[i] = temparr[i];
				}
			}

			super.push(data);
		}

	}

}
