
package BitManipulation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Q468_NonRepeatingElement {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		solve();
		pnter.close();
	}

	public static void solve() throws Exception {

		int n = scn.scanInt();
		int[] arr = takeArrayInput(n);

		int xor = arr[0]; // For_finding_xor_of_array.
		for (int i = 1; i < n; i++) {
			xor ^= arr[i];
		}

		int setBit = xor & -xor;

		int a = 0;
		int b = 0;
		for (int i = 0; i < n; i++) {
			if ((arr[i] & setBit) == 0) {
				a ^= arr[i];
			} else {
				b ^= arr[i];
			}
		}

		pnter.print(a + ", " + b);

	}

	// -------------------------------------------------------------------------------------------------------------

	private static int NumberLength(int n) {
		int length = 0;
		while (n != 0) {
			length++;
			n = n / 10;
		}

		return length;
	}

	private static void ReverseArray(int[] arr, int st, int en) {
		for (int i = st; st <= en; st++, en--) {
			swap(arr, st, en);
		}
	}

	private static int[] PrifixSumArray(int le, int ri, int[] arr) {
		for (int i = le + 1; i < ri; i++) {
			arr[i] += arr[i - 1];
		}

		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	private static int maxInArray(int[] arr) {
		int max = arr[0];
		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}

		return max;
	}

	private static int[] takeArrayInput(int n) throws IOException {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.scanInt();
			// arr[i] = scn.nextInt();
		}
		return arr;
	}

	private static int[][] takeMatrixInput(int n, int m) throws IOException {
		int[][] arr = new int[n][m];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				arr[row][col] = scn.scanInt();
				// arr[row][col] = scn.nextInt();
			}
		}
		return arr;
	}

	private static void displayArray(int le, int ri, int[] arr) throws IOException {
		for (int i = le; i <= ri; i++) {
			pnter.print(arr[i] + " ");
			// System.out.print(arr[i]+" ");
		}
		pnter.printLine("");
		// System.out.println();
	}

	private static void displayMatrix(int[][] arr) throws IOException {
		for (int[] i : arr) {
			for (int el : i) {
				pnter.print(el + " ");
				// System.out.print(el+" ");
			}
			pnter.printLine("");
			// System.out.println();
		}
	}

	private static void cloneArray(int[] arr, int[] Oarr, int n) {
		for (int i = 0; i < n; i++) {
			arr[i] = Oarr[i];
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
