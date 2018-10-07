package LunchTime;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

/*
import java.math.BigInteger;
import java.util.Scanner;

public class Strange_Function {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		int T = scn.nextInt();

		for (int i = 0; i < T; i++) {
			System.out.println();
			solve();
		}

	}

	public static void solve() throws Exception {

		int A = scn.nextInt();
		int N = scn.nextInt();
		BigInteger a = BigInteger.valueOf(A);
		BigInteger num = a.pow(N);
		solution(num);

	}

	private static void solution(BigInteger num) {
		BigInteger SumOfDigits = BigInteger.valueOf(0);
		BigInteger[] bi = null;

		while (!num.divide(BigInteger.valueOf(10)).equals(BigInteger.valueOf(0))) {
			SumOfDigits = BigInteger.valueOf(0);
			do {
				bi = num.divideAndRemainder(BigInteger.valueOf(10));
				SumOfDigits = SumOfDigits.add(bi[1]);
				num = bi[0];
			} while (!bi[0].equals(BigInteger.valueOf(0)));
			num = SumOfDigits;
		}

		System.out.print(SumOfDigits);

	}

}
*/

public class Strange_Function {
	public static Scan scn = new Scan(System.in);
	public static Print pnter = new Print();

	public static void main(String[] args) throws Exception {

		int T = scn.scanInt();

		for (int i = 1; i <= T; i++) {
			int A = scn.scanInt();
			int N = scn.scanInt();
			long num = (long) Math.pow(A, N);
			solve(num, i, T);
		}
		pnter.close();

	}

	public static void solve(long num, int i, int T) throws Exception {
		solution(num, i, T);

	}

	private static void solution(long num, int i, int T) throws IOException {

		long SumOfDigits = 0;
		while (num / 10 != 0) {
			SumOfDigits = 0;
			while (num != 0) {
				SumOfDigits += num % 10;
				num = num / 10;
			}

			num = SumOfDigits;
		}
		String str = "";
		str += SumOfDigits;
		if (i < T)
			pnter.printLine(str);
		else {
			pnter.print(str);
		}
	}

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
