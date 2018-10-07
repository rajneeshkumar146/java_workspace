package GenericTree;

import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.Node;

public class Q306_ConstructTreeByUsingPreOderTraversal {

	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.data + " -> ");

			for (Node child : children) {
				sb.append(child.data + " ");
			}

			sb.append(".\n");

			for (Node child : children) {
				String res = child.toString();
				sb.append(res);
			}

			return sb.toString();
		}

	}

	static int idx = 0;

	private static Node construct(int[] data) {
		if (idx == data.length) {
			return null;
		} else if (data[idx] == -1) {
			idx++;
			return null;
		}

		Node node = new Node(data[idx]);
		idx++;

		while (true) {
			Node child = construct(data);
			if (child != null) {
				node.children.add(child);
			} else {
				break;
			}
		}

		return node;
	}

	// ========================================================================================================================

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		// int[] data = new int[scn.nextInt()];
		// for (int i = 0; i < data.length; i++) {
		// data[i] = scn.nextInt();
		// }
		//
		// Node root = construct(data);

		int height = height(scn.nextInt(),3);
		System.out.println(height);

		scn.close();

	}

	// ==========================================================================================================================

	private static void constructor(int[] arr, int k, int idx) {
		Node node = new Node(arr[idx]);

	}

	private static int height(int size,int k) {

		int height = (int) Math.ceil((Math.log10(size*(k-1) +1) / Math.log10(k)-1));

		return height;
	}

}
