package GenericTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Q305_CountNumberOfNodeWhichHaveMoreNumberOfChildren {

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
		int res = CountNumberOfChildren(root, root.children.size());
		System.out.println(res);
		
		scn.close();

	}

	// ==========================================================================================================================

	private static int CountNumberOfChildren(Node node, int ParSize) {
		int count = 0;
		if (node.children.size() > ParSize) {
			count++;
		}

		for (Node child : node.children) {
			count += CountNumberOfChildren(child, node.children.size());
		}

		return count;

	}

}
