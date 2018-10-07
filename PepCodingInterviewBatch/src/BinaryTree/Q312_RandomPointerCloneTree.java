package BinaryTree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Q312_RandomPointerCloneTree {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	private static class Node {
		int data;
		Node left;
		Node right;
		Node random;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " => " + node.data + "[R:" + node.random.data + "] <= ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) throws IOException {
		int[] arr = new int[scn.scanInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.scanInt();
		}

		int size = 0;
		HashMap<Integer, Node> randomMap = new HashMap<>();

		Node[] nodes = new Node[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				size++;
				nodes[i] = new Node(arr[i], null, null);

				if (i > 0) {
					int pi = (i - 1) / 2;

					if (i == 2 * pi + 1) {
						nodes[pi].left = nodes[i];
					} else {
						nodes[pi].right = nodes[i];
					}
				}

				randomMap.put(nodes[i].data, nodes[i]);
			}
		}

		for (int i = 0; i < size; i++) {
			int from = scn.scanInt();
			int to = scn.scanInt();
			randomMap.get(from).random = randomMap.get(to);
		}

//		 Node cloneRoot = Clone1(nodes[0]);
		Node cloneRoot = Clone2(nodes[0]);
		display(cloneRoot);
	}

	// Clone1===================================================================================================

	private static Node Clone1(Node node) {

		Node root = clone1Worst(node);
		HashMap<Node, Node> map = new HashMap<>();
		clone1PopulateRandom(map, root, node);
		clone1SetRandom(map, root, node);

		return root;
	}

	private static void clone1SetRandom(HashMap<Node, Node> map, Node root, Node node) {
		if (node == null) {
			return;
		}
		root.random = map.get(node.random);
		clone1SetRandom(map, root.left, node.left);
		clone1SetRandom(map, root.right, node.right);
	}

	private static void clone1PopulateRandom(HashMap<Node, Node> map, Node root, Node node) {
		if (node == null) {
			return;
		}
		map.put(node, root);
		clone1PopulateRandom(map, root.left, node.left);
		clone1PopulateRandom(map, root.right, node.right);

	}

	private static Node clone1Worst(Node node) {
		if (node == null) {
			return null;
		}
		Node nnode = new Node(node.data, null, null);

		nnode.left = clone1Worst(node.left);
		nnode.right = clone1Worst(node.right);

		return nnode;

	}

	// clone2======================================================================================================

	private static Node Clone2(Node node) {

		clone2Best(node);
		SetRandoms(node);
		return ExtractTree(node);

	}

	private static void clone2Best(Node node) {

		if (node == null) {
			return;
		}

		clone2Best(node.left);
		clone2Best(node.right);

		Node newLeftchild = new Node(node.data, node.left, null);
		node.left = newLeftchild;

	}

	private static void SetRandoms(Node node) {

		if (node == null) {
			return;
		}

		node.left.random = node.random.left;
		SetRandoms(node.left.left);
		SetRandoms(node.right);

	}

	private static Node ExtractTree(Node onode) {

		Node CloneNode = onode.left;
		Node lcnode = null;
		Node rcnode = null;
		if (onode.left != null && onode.left.left != null) {
			lcnode = ExtractTree(onode.left.left);
		}

		if (onode.right != null) {
			rcnode = ExtractTree(onode.right);
		}

		
		onode.left = CloneNode.left;
		CloneNode.left = lcnode;
		CloneNode.right = rcnode;
		return CloneNode;

	}

	// ------------------------------------------------------------------------------------------------------------------------

	private static class Scan {
		private InputStream in;
		private byte[] buf = new byte[1024 * 1024];
		private int index;
		private int total;

		public Scan(InputStream in) {
			this.in = in;
		}

		public int scan() throws IOException {
			if (total < 0)
				throw new InputMismatchException();
			if (index >= total) {
				index = 0;
				total = in.read(buf);
				if (total <= 0)
					return -1;
			}
			return buf[index++];
		}

		public int scanInt() throws IOException {
			int integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			return neg * integer;
		}

		public long scanLong() throws IOException {
			long integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			return neg * integer;
		}

		public double scanDouble() throws IOException {
			double doub = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n) && n != '.') {
				if (n >= '0' && n <= '9') {
					doub *= 10;
					doub += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			if (n == '.') {
				n = scan();
				double temp = 1;
				while (!isWhiteSpace(n)) {
					if (n >= '0' && n <= '9') {
						temp /= 10;
						doub += (n - '0') * temp;
						n = scan();
					} else
						throw new InputMismatchException();
				}
			}
			return doub * neg;
		}

		public String scanString() throws IOException {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			while (!isWhiteSpace(n)) {
				sb.append((char) n);
				n = scan();
			}
			return sb.toString();
		}

		public String scanStringLine() throws IOException {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpaceModified(n))
				n = scan();
			while (!isWhiteSpaceModified(n)) {
				sb.append((char) n);
				n = scan();
			}
			return sb.toString();
		}

		private boolean isWhiteSpace(int n) {
			if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}

		private boolean isWhiteSpaceModified(int n) {
			if (n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}
	}

	private static class Print {
		private final BufferedWriter bw;

		public Print() {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(String str) throws IOException {
			bw.append(str);
		}

		public void printLine(String str) throws IOException {
			print(str);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}

}
/*
15 
1 2 3 4 5 6 7 -1 -1 8 9 -1 -1 -1 -1
1 8
2 6
3 9
4 4 
5 9
6 7
7 6
8 4
9 2
2 => 1[R:8] <= 3
4 => 2[R:6] <= 5
. => 4[R:4] <= .
8 => 5[R:9] <= 9
. => 8[R:4] <= .
. => 9[R:2] <= .
6 => 3[R:9] <= 7
. => 6[R:7] <= .
. => 7[R:6] <= .
*/

//test case 2
/*
7
1 2 3 4 -1 5 -1
1 5
2 5
3 4
4 2
5 1
2 => 1[R:5] <= 3
4 => 2[R:5] <= .
. => 4[R:2] <= .
5 => 3[R:4] <= .
. => 5[R:1] <= .
*/