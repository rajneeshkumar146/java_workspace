package GenericTree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Q303_SecondLargest {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		solve();
		pnter.close();
	}

	public static void solve() throws Exception {
		// 28 20 2 15 -1 20 25 -1 50 -1 -1 -1 34 30 -1 -1 50 40 -1 100 -1 20 -1
		// -1 60 -1 70 -1 -1
		
		//		13 20 8 4 -1 12 10 -1 14 -1 -1 22 -1 -1


		int[] arr = ArrayInput(scn.scanInt());
		GenericTree gt = new GenericTree(arr);
		// gt.display();
		pnter.printLine(gt.Kthlargest(2) + "");
	}

	private static int[] ArrayInput(int n) throws IOException {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.scanInt();
		}
		return arr;
	}

	static int idx = 0;

	private static class GenericTree {

		private class Node {
			private int data;
			private ArrayList<Node> children = new ArrayList<>();

			Node(int data) {
				this.data = data;
			}

			Node() {

			}
		}

		private Node root;
		private int size;

		// GeneralFuntions.==================================================================================

		public int size() {
			return this.size;
		}

		public boolean isEmpty() {
			return (this.size == 0);
		}

		public void display() {
			display(this.root);
		}

		private void display(Node node) {
			String str = node.data + " => ";
			for (Node child : node.children) {
				str += child.data + ", ";
			}
			str += ".";
			System.out.println(str);

			for (Node child : node.children) {
				display(child);
			}
		}

		public GenericTree(int[] data) {
			this.root = construct(data);
		}

		private Node construct(int[] data) {
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

		// Questions.===================================================================================

		public int Kthlargest(int k) throws IOException {
			int max = Integer.MAX_VALUE;
			for (int i = 0; i < k; i++) {
				max = Math.min(max, Kthlargest(this.root, max));
			}

			return max;
		}

		private int Kthlargest(Node node, int largest) {

			int max = Integer.MIN_VALUE;
			for (Node child : node.children) {
				int val = Kthlargest(child, largest);
				if (val < largest)
					max = Math.max(max, val);
			}

			return node.data < largest ? Math.max(max, node.data) : max;

		}

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
