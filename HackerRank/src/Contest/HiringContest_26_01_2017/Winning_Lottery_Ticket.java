package Contest.HiringContest_26_01_2017;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Winning_Lottery_Ticket {
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {

		int n = scn.scanInt();
		// String[] arr = new String[5];
		pair[] target = new pair[n];

		for (int i = 0; i < n; i++) {
			String str = scn.scanString();
			int[] a = compression(str);
			// arr[i] = str;
			target[i] = target(a);
		}

		long count = WinnersCount(target, n);
		pnter.print(count + "");

		// for (int row = 0; row < n; row++) {
		// pnter.printLine(arr[row] + " - " + target[row]);
		// }

		pnter.close();

	}

	private static long WinnersCount(pair[] target, int n) {
		long count = 0;

		for (int row = 0; row < n; row++) {
			pair pair1 = target[row];
			for (int i = row + 1; i < n; i++) {
				pair pair2 = target[i];
				boolean flag = false;
				for (int j = 0; j < pair1.str.length(); j++) {
					if (pair2.arr[pair1.str.charAt(j) - '0'] == true) {
						flag = true;
						break;
					}
				}

				if (flag == false) {
					count++;
				}

			}
		}

		return count;
	}

	private static pair target(int[] a) { // yaha_se_jo_string_milegi_usko_dusre_String_mai_dhoondna_hai.
		StringBuilder sb = new StringBuilder();
		pair pair = new pair();
		for (int j = 0; j < 10; j++) {
			if (a[j] == 0) {
				sb.append(j);
				pair.arr[j] = true;
			}
		}

		pair.str = sb.toString();
		return pair;
	}

	private static class pair {
		private String str;
		private boolean[] arr = new boolean[10];

	}

	private static int[] compression(String str) {
		int[] a = new int[10];
		for (int j = 0; j < str.length(); j++) {
			a[str.charAt(j) - '0'] = 1;
		}
		return a;
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
