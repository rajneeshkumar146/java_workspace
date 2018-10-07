package LongChallenge.Jan5th2017;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class MaximumScore {

	private static Scan scn = new Scan(System.in);
	private static Print pntr = new Print();

	public static void main(String[] args) throws Exception {
		int T = scn.scanInt();
		while (T-- > 1) {
			pntr.printLine(solve() + "");
		}
		pntr.print(solve() + "");
		pntr.close();
	}

	public static long solve() throws Exception {
		int size = scn.scanInt();
		int[][] arr = new int[size][size];
		int[] arrSum = new int[size];
		if (!takeinput(arr, size)) {
			boolean[][] isdone = new boolean[size][size];
			if (MaxScore(arr, arrSum, isdone,0, size)) { // Iss_conndition_ne_negative_array_ko_bhi_handel_krliya.
				return GetSum(arrSum, size);
			} else {
				return -1;
			}
		} else {
			return -1;
		}

	}

	private static boolean takeinput(int[][] arr, int size) throws IOException {
		boolean flag = false;
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				arr[row][col] = scn.scanInt();
			}

			Arrays.sort(arr[row]);

			if (row > 0) {
				int maxcurr = arr[row][size - 1];
				int minprev = arr[row - 1][0];
				if (maxcurr < minprev) {
					flag = true;
				}
			}

		}

		return flag;
	}

	private static boolean MaxScore(int[][] arr, int[] arrSum,boolean[][] isdone, int vidx, int size) {

		int prevMax = Integer.MIN_VALUE;
		for (int i = size - 1; i >= 0; i--) {
			if(isdone[vidx][i]){
				continue;
			}
			
			
			if (vidx > 0) {
				prevMax = arrSum[vidx - 1];
			}

			if (arr[vidx][i] > prevMax) {
				arrSum[vidx] = arr[vidx][i];
				isdone[vidx][i]=true;

				if (vidx == size - 1) {
					return true;
				}

				if (vidx < size - 1 && arr[vidx + 1][size - 1] > arr[vidx][i]) {

					if (MaxScore(arr, arrSum, isdone,vidx + 1, size)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static long GetSum(int[] arrSum, int size) {
		long rv = 0;
		for (int i = 0; i < size; i++) {
			rv += arrSum[i];
		}

		return rv;
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
