package Practice.DataStructure.AdvanceDataStructure.SegmentTree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Q01_Tutorial {
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();
	static int count = 1;

	public static void main(String[] args) throws Exception {

		int size = scn.scanInt();
		int q = scn.scanInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scn.scanInt();
		}

		SegmentTreeArray st = new SegmentTreeArray(arr);

		while (q-- > 0) {
			char ch = scn.scanString().charAt(0);
			int u = scn.scanInt();
			int v = scn.scanInt();
			solve(st, ch, u - 1, v - 1);
			if (q != 0 && ch == 'q') {
				pnter.printLine("");
			}

			count++;
		}
		st.display();
		pnter.close();

	}

	public static void solve(SegmentTreeArray st, char ch, int u, int v) throws Exception {

		if (ch == 'q') {
			pnter.print(st.query(u, v) + "");
		} else {
			st.update(u, v + 1);
		}

	}

	public static class SegmentTreeArray {

		private int[] arr;
		private int height;
		private int InputArrSize;

		public SegmentTreeArray(int[] input) {
			this.height = (int) Math.ceil(Math.log(input.length) / Math.log(2));
			int size = (2 * (int) Math.pow(2, this.height)) - 1;

			this.arr = new int[size];
			this.InputArrSize = input.length;

			construction(input, 0, input.length - 1, 0);
		}

		private void construction(int[] input, int si, int ei, int i) {
			if (ei == si) {
				this.arr[i] = input[si];
				return;
			}

			int mid = (si + ei) / 2;
			construction(input, si, mid, 2 * i + 1);
			construction(input, mid + 1, ei, 2 * i + 2);
			arr[i] = Math.min(arr[2 * i + 1], arr[2 * i + 2]);
		}

		public void display() throws IOException {
			display(this.arr.length, 0);
		}

		private void display(int n, int i) throws IOException {
			if (i >= n) {
				return;
			}

			String str = "";
			if ((2 * i + 1) < n) {
				str += this.arr[2 * i + 1] + "";
			} else {
				str += ".";
			}

			str += " => " + this.arr[i] + " <= ";

			if ((2 * i + 2) < n) {
				str += this.arr[2 * i + 2] + "";
			} else {
				str += ".";
			}

			pnter.printLine(str);
			display(n, 2 * i + 1);
			display(n, 2 * i + 2);
		}

		public long query(int u, int v) {
			if (u < 0 || v >= this.InputArrSize || u > v) {
				return -1;
			}
			return query(0, this.InputArrSize - 1, 0, u, v);
		}

		private long query(int si, int ei, int i, int u, int v) {
			if (si >= u && ei <= v) {
				return this.arr[i];
			} else if (si > v || ei < u) {
				return Integer.MAX_VALUE;
			} else {
				int mid = (ei + si) / 2;
				return Math.min(query(si, mid, 2 * i + 1, u, v), query(mid + 1, ei, 2 * i + 2, u, v));
			}
		}

		public void update(int pos, int delta) {
			if (pos >= this.InputArrSize || pos < 0) {
				return;
			}
			update(0, this.InputArrSize - 1, 0, pos, delta);

		}

		private void update(int si, int ei, int i, int pos, int delta) {

			int mid = (si + ei) / 2;
			if (pos == si && pos == ei) {
				this.arr[i] = delta;
				return;
			} else if (pos >= si && pos <= mid) {
				update(si, mid, 2 * i + 1, pos, delta);
			} else if (pos > mid && pos <= ei) {
				update(mid + 1, ei, 2 * i + 2, pos, delta);
			}

			this.arr[i] = Math.min(this.arr[2 * i + 1], this.arr[2 * i + 2]);

		}

	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------

	static class Scan {
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

		private boolean isWhiteSpace(int n) {
			if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}
	}

	static class Print {
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