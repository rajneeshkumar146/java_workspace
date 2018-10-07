package L010_StackAndQueue;

import L010_StackAndQueue.Queue_001.Queue;

public class DynamicQueue_001 {
	public static void main(String[] args) throws Exception {
		Queue q = new DynamicQueue(3);
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);
		q.enqueue(70);
		q.enqueue(80);
		q.dequeu();
		System.out.println(q);

	}

	public static class DynamicQueue extends Queue_001.Queue {

		public DynamicQueue(int size) {
			super(size);
		}

		@Override
		public void enqueue(int n) throws Exception {
			if (this.size == arr.length) {
				int[] oldarr = this.arr;
				this.arr = new int[2 * oldarr.length];
				for (int i = 0; i < oldarr.length; i++) {
					int index = (this.front + i) % oldarr.length;
					this.arr[i] = oldarr[index];
				}
				this.front = 0;

			}

			super.enqueue(n);
		}
	}

}
