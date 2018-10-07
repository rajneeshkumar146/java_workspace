package GenericTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Q299_SeriallizeAndDeseriallize {
	public static Scanner scn = new Scanner(System.in);

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
		
		 int[] data = new int[scn.nextInt()];
		 for (int i = 0; i < data.length; i++) {
		 data[i] = scn.nextInt();
		 }
		
		 Node root = construct(data);
		 System.out.println(root);

		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		System.out.println(sb.toString());

//		char[] arr = scn.nextLine().toCharArray();
//		Node root = DeserialLize(arr);
//		System.out.println(root);

	}

	// =======================================================================================================================

	private static void serialize(Node node, StringBuilder sb) {

		sb.append(node.data + "_");

		for (Node child : node.children) {
			serialize(child, sb);
		}

		sb.append("#");

	}

	static int vidx = 0;

	private static Node DeserialLize(char[] arr) {
		if (vidx == arr.length) {
			return null;
		}

		if (arr[vidx] == '#') {
			vidx++;
			return null;
		}

		Node node = new Node(arr[vidx]);
		vidx++;

		while (true) {
			Node child = DeserialLize(arr);
			if (child != null) {
				node.children.add(child);
			} else {
				break;
			}
		}

		return node;

	}

}
