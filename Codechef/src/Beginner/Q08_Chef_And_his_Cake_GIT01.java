package Beginner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Q08_Chef_And_his_Cake_GIT01 {
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		int T = scn.scanInt();
		while (T-- > 1) {
			solve();
			pnter.printLine("");
		}
		solve();
		pnter.close();
	}

	public static void solve() throws Exception {
		int n = scn.scanInt();
		int m = scn.scanInt();
		int size = n * m;

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			if (i % 2 != 0) {
				sb.append(scn.scanString());
			} else {
				String str = scn.scanString();
				for (int j = str.length() - 1; j >= 0; j--) {
					sb.append(str.charAt(j));
				}
			}
		}

		int cost1 = 0;
		int cost2 = 0;

		char ch = 'G';
		for (int i = 0; i < size; i++) {

			if (sb.charAt(i) == ch) {
				if (ch == 'G') {
					ch = 'R';
				} else {
					ch = 'G';
				}
			} else {
				if (ch == 'G') {
					cost1 += 5;
					ch = 'R';
				} else {
					cost1 += 3;
					ch = 'G';
				}
			}
		}

		ch = 'R';
		for (int i = 0; i < size; i++) {

			if (sb.charAt(i) == ch) {
				if (ch == 'G') {
					ch = 'R';
				} else {
					ch = 'G';
				}
			} else {
				if (ch == 'G') {
					cost2 += 5;
					ch = 'R';
				} else {
					cost2 += 3;
					ch = 'G';
				}
			}
		}

		pnter.print(Math.min(cost1, cost2) + "");

	}

	// -----------------------------------------------------------------------------------------

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