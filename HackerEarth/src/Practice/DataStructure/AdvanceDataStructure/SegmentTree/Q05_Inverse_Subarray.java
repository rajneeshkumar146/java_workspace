package Practice.DataStructure.AdvanceDataStructure.SegmentTree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Q05_Inverse_Subarray {
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();
	private static HashMap<Integer, Integer> hm = new HashMap<>();

	public static void main(String[] args) throws Exception {

		int T = scn.scanInt();
		while (T-- > 1) {
			pnter.printLine(solve() + "");
		}
		pnter.print(solve() + "");
		pnter.close();

	}

	public static int solve() throws Exception {
		int n = scn.scanInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.scanInt();
		}

		int left = 0;
		int right = n - 1;
		int max = -1;

		if (arr[left] >= arr[right]) {
			return right - left + 1; // 1 for Size.
		}

		while (left <= right) {
			int le = left + 1;

			while (le <= right) {
				if (arr[le] < arr[right]) {
					le++;
				} else {
					break;
				}
			}
			int max1 = right - le + 1;

			int re = right - 1;
			while (left <= re) {
				if (arr[left] < arr[re]) {
					re--;
				} else {
					break;
				}
			}

			int max2 = re - left + 1;

			le = left + 1;
			re = right - 1;
			while (le <= re) {
				if (arr[le] < arr[re]) {
					le++;
					re--;
				} else {
					break;
				}
			}

			int max3 = re - le + 1;

			max = Math.max(Math.max(max1, max), Math.max(max2, max3));

			left++;
			right--;
		}

		return max;

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
