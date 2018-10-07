package L010_StackAndQueue;

public class Queue_001 {

	public static void main(String[] args) throws Exception {

	}

	public static class Queue {

		protected int[] arr;
		protected int front = 0;
		protected int size = 0;

		public Queue(int size) {
			this.arr = new int[size];
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < this.size; i++) {
				int index = (this.front + i) % this.arr.length;
				sb.append(this.arr[index] + " ");
			}

			return sb.toString();
		}

		public void enqueue(int n) throws Exception {
			if (this.size == arr.length) {
				throw new Exception("QueueOverFlow");
			}

			int index = (this.size + this.front) % this.arr.length;
			this.arr[index] = n;
			this.size++;
		}

		public int dequeu() throws Exception {
			if (this.size == 0) {
				throw new Exception("NullPointException");
			}

			int index = this.front;
			int rv = this.arr[index];
			this.size--;
			this.front = (this.front + 1) % this.arr.length;

			return rv;
		}

		public int front() throws Exception {
			if (this.size == 0) {
				throw new Exception("NullPointException");
			}

			return this.arr[this.front];
		}

		public void clear() {
			for (int i = 0; i < this.size; i++) {
				this.arr[i] = 0;
			}
			this.size = 0;
		}

		public int Capacity() {
			return this.size;
		}

		public boolean isEmpty() {
			return this.size == 0 ? true : false;
		}

	}

}