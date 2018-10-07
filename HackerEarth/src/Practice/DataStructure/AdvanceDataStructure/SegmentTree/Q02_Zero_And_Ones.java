package Practice.DataStructure.AdvanceDataStructure.SegmentTree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Q02_Zero_And_Ones {
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		int n = scn.scanInt();
		int[] arr = new int[n];
		Arrays.fill(arr, 1);
		SegmentTreeArray st = new SegmentTreeArray(arr);
		int q = scn.scanInt();
		for (int i = 1; i <= q; i++) {
			int a = scn.scanInt();
			int b = scn.scanInt();
			if (a == 1) {
				if (i < q) {
					pnter.printLine(st.query(b) + "");
				} else {
					pnter.print(st.query(b) + "");
				}
			} else {
				st.update(b - 1);
			}
		}

		pnter.close();
	}

	private static class SegmentTreeArray {

		private long[] arr;
		private int height;
		private int InputArrSize;

		public SegmentTreeArray(int[] input) {
			this.height = (int) Math.ceil(Math.log(input.length) / Math.log(2));
			int size = (2 * (int) Math.pow(2, this.height));

			this.arr = new long[size];
			this.InputArrSize = input.length;

			construction(input, 0, input.length - 1, 0);
		}

		private long construction(int[] input, int si, int ei, int i) {
			if (ei == si) {
				this.arr[i] = input[si];
				return input[si];
			}

			int mid = (si + ei) / 2;
			this.arr[i] = construction(input, si, mid, 2 * i + 1) + construction(input, mid + 1, ei, 2 * i + 2);
			return arr[i];
		}

		public int query(int kth) {
			return query(0, this.InputArrSize - 1, 0, kth);
		}

		private int query(int si, int ei, int i, int kth) {

			int mid = (si + ei) >> 1;
			if (this.arr[i] >= kth) {

				if (si == ei) {
					return si + 1;
				}

				if (arr[(i << 1) + 1] < kth) {
					kth -= arr[(i << 1) + 1];
					return query(mid + 1, ei, (i << 1) + 2, kth);
				} else {
					return query(si, mid, (i << 1) + 1, kth);
				}
			} else {
				return -1;
			}

		}

		public void update(int pos) {
			update(0, this.InputArrSize - 1, 0, pos);

		}

		private void update(int si, int ei, int i, int pos) {

			int mid = (si + ei) >> 1;
			if (pos == si && pos == ei) {
				this.arr[i] = 0;
				return;
			} else if (pos >= si && pos <= mid) {
				update(si, mid, (i << 1) + 1, pos);
			} else if (pos > mid && pos <= ei) {
				update(mid + 1, ei, (i << 1) + 2, pos);
			}

			this.arr[i] = this.arr[(i << 1) + 1] + this.arr[(i << 1) + 2];

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
