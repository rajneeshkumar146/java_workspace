package LongChallenge.Jan5th2017;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class K_Concatenation {

	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		int T = scn.scanInt();
		while (T-- > 1) {
			pnter.printLine(solve() + "");
		}
		pnter.print(solve() + "");
		pnter.close();
	}

	public static long solve() throws Exception {
		int size = scn.scanInt();
		long k = scn.scanLong();
		int[] arr = new int[size];
		takeinput(arr, size);

		return KadanesAlgoOpt(arr, k, size);

	}

	private static void takeinput(int[] arr, int size) throws IOException {
		for (int i = 0; i < size; i++) {
			arr[i] = scn.scanInt();
		}
	}

	private static long KadanesAlgo(int[] arr, int k, int size) {
		long maxsf = arr[0]; // Max_So_Far.
		long curr_max = arr[0];

		for (int i = 1; i < k * size; i++) {
			int j = i % size;
			curr_max = Math.max(arr[j], curr_max + arr[j]);
			maxsf = Math.max(maxsf, curr_max);
		}
		return maxsf;
	}

	private static long KadanesAlgoOpt(int[] arr, long k, int size) throws IOException {
		long maxsf = arr[0]; // Max_So_Far.
		long curr_max = arr[0];

		int i = 1;
		while (i < size) {
			curr_max = Math.max(arr[i], curr_max + arr[i]);
			maxsf = Math.max(maxsf, curr_max);
			i++;
		}

		long FirstMax = maxsf;
		if (k == 1) {
			return FirstMax;
		}

		while (i < 2 * size) {
			int j = i % size;
			curr_max = Math.max(arr[j], curr_max + arr[j]);
			maxsf = Math.max(maxsf, curr_max);
			i++;
		}
		long SecondMax = maxsf;

		if (k == 2) {
			return SecondMax;
		}

		while (i < 3 * size) {
			int j = i % size;
			curr_max = Math.max(arr[j], curr_max + arr[j]);
			maxsf = Math.max(maxsf, curr_max);
			i++;
		}
		long ThirdMax = maxsf;
		if (k == 3) {
			return ThirdMax;
		}

		// pnter.printLine(KadanesAlgo(arr, k, size) + "");

		long SecondDiff = ThirdMax - SecondMax;

		long APLastTerm = (SecondMax + (k - 2) * SecondDiff);
		return APLastTerm;

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
