package PriorityQueue;

import java.util.PriorityQueue;

public class Implimentation {

	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		add(7, queue);
		// add(3, queue);
		// add(25, queue);
		// add(32, queue);
		// add(1, queue);
		// add(10, queue);
		display(queue);
		System.out.println(remove(queue));
		System.out.println(remove(queue));

	}

	public static void add(int i, PriorityQueue<Integer> queue) {
		queue.add(i);
	}

	public static int remove(PriorityQueue<Integer> queue) {
		return queue.remove();
	}

	public static int poll(PriorityQueue<Integer> queue) {
		return queue.poll();
	}

	public static int peek(PriorityQueue<Integer> queue) {
		return queue.peek();
	}

	public static void display(PriorityQueue<Integer> queue) {
		System.out.println(queue);
	}

	public static int size(PriorityQueue<Integer> queue) {
		return queue.size();
	}

}
