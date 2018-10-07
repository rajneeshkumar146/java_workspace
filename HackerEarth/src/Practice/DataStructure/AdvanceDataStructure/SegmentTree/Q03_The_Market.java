package Practice.DataStructure.AdvanceDataStructure.SegmentTree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Q03_The_Market {
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		int[] arr = ModuleArray();
		int n = scn.scanInt();
		int[] inputarr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			inputarr[i] = scn.scanInt();
		}

		for (int i = 1; i <= n; i++) {
			inputarr[i] = arr[inputarr[i]];
		}

		int[][] danger = new int[250][n + 1];

		for (int row = 1; row < 250; row++) {
			for (int col = 1; col <= n; col++) {
				if (row == inputarr[col]) {
					danger[row][col] = danger[row][col - 1] + 1;
				} else {
					danger[row][col] = danger[row][col - 1];
				}
			}
		}

		int q = scn.scanInt();
		while (q-->0) {
			int left = scn.scanInt();
			int right = scn.scanInt();
			long sum = 0;
			for (int row = 1; row < 250; row++) {

				/*
				 * isne ye btaya ki uss particular range mai vo row kitni bar
				 * repeat hua hai
				 */

				long val = (danger[row][right] - danger[row][left - 1]);

				/*
				 * nC2=n(n-1)/2. ek pair select krne kai itne tarike hote hai.
				 */
				sum += val * (val - 1) / 2;
			}
			pnter.printLine(sum + "");
		}
		
		pnter.close();
	}

	private static int[] ModuleArray() {
		int m = (int) 1e6;
		int[] arr = new int[m + 1];
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j < arr.length; j += i) {
				arr[j]++;
			}
		}
		return arr;
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
