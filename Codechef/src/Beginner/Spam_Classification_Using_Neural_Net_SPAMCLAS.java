package Beginner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Spam_Classification_Using_Neural_Net_SPAMCLAS {
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		int i = scn.scanInt();
		while (i-- > 1) {
			solve();
			pnter.printLine("");
		}
		solve();
		pnter.close();

	}

	public static void solve() throws Exception {

		int n = scn.scanInt();
		int minx = scn.scanInt();
		int maxx = scn.scanInt();
		int diff = maxx - minx-1;
		int diffhalve = diff / 2;
		long odd = 0;
		long even = 0;

		if (minx % 2 == 0 && maxx % 2 == 0) {
			odd = diff - diffhalve;
			even = diffhalve + 2;
		} else if (minx % 2 != 0 && maxx % 2 != 0) {
			odd = diffhalve + 2;
			even = diff - diffhalve;
		} else {
			odd = diffhalve + 1;
			even = diffhalve + 1;
		}

		long countOdd = 0;
		long countEven = 0;
		for (int i = 0; i < n; i++) {
			int w = scn.scanInt();
			int b = scn.scanInt();
			if (w % 2 == 0 && b % 2 == 0) {
				/*
				 * y=w*x + b; agar dono even hai toh total evencount is odd+even
				 * or oddcount is 0.because even*even always be even or
				 * even+even always be even.
				 */
				countEven = odd + even;
				countOdd = 0;
			} else if (w % 2 != 0 & b % 2 != 0) {
				/* odd*even=even, odd*odd=odd and odd+odd=odd, even+odd=odd */
				countOdd = even;
				countEven = odd;
			} else if (w % 2 == 0 && b % 2 != 0) {
				/* even*even=even, odd*even=even and even+odd=odd */
				countOdd = even + odd;
				countEven = 0;
			} else if (w % 2 != 0 && b % 2 == 0) {
				/*
				 * odd*even=even, odd*odd=odd and even+even=even, even+odd=odd.
				 */
				countOdd = odd;
				countEven = even;
			}
			odd = countOdd;
			even = countEven;
		}

		pnter.print(countEven + " " + countOdd);

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
