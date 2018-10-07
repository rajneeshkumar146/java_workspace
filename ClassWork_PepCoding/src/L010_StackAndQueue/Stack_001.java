package L010_StackAndQueue;

import java.util.Stack;

public class Stack_001 {

	public static void main(String[] args) {

		Stack<Integer> s = new Stack<>();

	}

	protected static class stack {

		protected int[] arr;
		protected int tos = -1;
		protected int ElementCount = 0;

		public stack(int size) {
			this.arr = new int[size];
		}


		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = this.ElementCount - 1; i >= 0; i--) {
				sb.append(this.arr[i] + " ");
			}
			return sb.toString();
		}

		public void push(int data) throws Exception {
			if (this.tos + 1 == arr.length) {
				throw new Exception("StackOverFlow");
			}
			this.arr[this.tos++] = data;
			this.ElementCount++;
		}

		public int pop() throws Exception {
			if (this.tos == -1) {
				throw new Exception("NullPointException: " + tos);
			}

			int rv = this.arr[this.tos];
			this.arr[tos] = 0;
			tos--;
			this.ElementCount--;
			return rv;
		}

		public int peek() throws Exception {
			if (this.tos == -1) {
				throw new Exception("NullPointException: " + tos);
			}

			return this.arr[this.tos];
		}

		private int IndexOf(int data, int Startingindex) {

			for (int i = Startingindex; i < this.ElementCount; i++) {
				if (this.arr[i] == data) {
					return i;
				}
			}
			return -1;
		}

		public void clear() {
			for (int i = 0; i < this.ElementCount; i++) {
				this.arr[i] = 0;
			}
			this.ElementCount = 0;
		}

		public int contains(int data) {
			return IndexOf(data, 0);
		}

		public int Capacity() {
			return this.ElementCount;
		}

		public boolean isEmpty() {

			return this.ElementCount == 0 ? true : false;
		}

	}

	// private static class DynamicStack extends stack {
	//
	// @Override
	// public void push(int data) {
	// if (this.tos + 1 == this.arr.length) {
	// int[] temparr;
	// temparr = Arrays.copyOf(arr, arr.length);
	// this.arr = new int[2 * this.arr.length];
	// for (int i = 0; i < temparr.length; i++) {
	// this.arr[i] = temparr[i];
	// }
	// }
	// this.ElementCount++;
	// this.arr[this.tos++] = data;
	// }
	//
	// }

}
