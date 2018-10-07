package Arrays;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Q025_StockSell2times {
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {

		int n = scn.scanInt();
		int[] price = Takeinput1DArray(n);

		int profit[] = new int[n];

		/*
		 * Get the maximum profit with only one transaction allowed. After this
		 * loop, profit[i] contains maximum profit from price[i..n-1] using at
		 * most one trans.
		 */

		int max_price = price[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (price[i] > max_price) {
				max_price = price[i];
			}

			// we can get profit[i] by taking maximum of:
			// a) previous maximum, i.e., profit[i+1]
			// b) profit by buying at price[i] and selling at
			// max_price

			profit[i] = Math.max(profit[i + 1], max_price - price[i]);

		}

		// Get the maximum profit with two transactions allowed After this loop,
		// profit[n-1] contains the result

		int min_price = price[0];
		for (int i = 1; i < n; i++) {

			if (price[i] < min_price) {
				min_price = price[i];
			}

			// Maximum profit is maximum of:
			// a) previous maximum, i.e., profit[i-1]
			// b) (Buy, Sell) at (min_price, price[i]) and add
			// profit of other trans. stored in profit[i]

			profit[i] = Math.max(profit[i - 1], profit[i] + price[i] - min_price);

		}

		int result = profit[n - 1];
		pnter.print(result + "");
		pnter.close();

	}

	private static int[] Takeinput1DArray(int n) throws IOException {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.scanInt();
		}
		return arr;
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
