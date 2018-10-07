package L005_Matrix;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Matrix_001 {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		// 1. Lecture 5
		// 1.1 2D Arrays demo and memory
		// 1.2 2D Arrays questions
		// 1.2.1 takeinput
		// 1.2.2 display
		// 1.2.3 matrixMultiplication
		// 1.2.4 waveDisplay
		// 1.2.5 spiralDisplay
		// 1.2.6 exitPoint
		// 1.2.7 90 rotate

		solve();
		pnter.close();
	}

	public static void solve() throws Exception {
		 int n = scn.scanInt();
		 int m = scn.scanInt();
		 int[][] arr = takeMatrixInput(n, m);

		// int[][] arr = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 }, { 12, 13, 14
		// }, { 15, 16, 17 } };
//		int[][] arr = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
		// MatrixMult(arr, arr.length, arr[0].length, two, two.length,
		// two[0].length);

		// WaveUpDown(arr);
		// WaveForwardBackward(arr);

		// Spiral(arr);

		 ExitPoint(arr);

//		RotateBy90(arr);

//		displayMatrix(arr);
	}

	private static void MatrixMult(int[][] one, int n, int m, int[][] two, int n1, int m1) throws IOException {
		if (n != m1) {
			pnter.print("Not Possibe ");
			return;
		}

		int nr = m;
		int nc = m1;
		int[][] rmatrix = new int[nr][nc];

		for (int r = 0; r < nr; r++) {
			for (int cc = 0; cc < nc; cc++) { // count_col.
				for (int cr = 0; cr < nr; cr++) { // count_row.
					rmatrix[r][cc] += one[r][cr] * two[cr][cc];
				}
			}
		}

		displayMatrix(rmatrix);

	}

	private static void TransposeOfMatrix(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr[0].length; j++) {
				Swap2DEle(arr, i, j, j, i);
			}
		}
	}

	private static void WaveUpDown(int[][] arr) throws IOException {

		for (int col = 0; col < arr[0].length; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < arr.length; row++) {
					pnter.print(arr[row][col] + " ");
				}
			} else {
				for (int row = arr.length - 1; row >= 0; row--) {
					pnter.print(arr[row][col] + " ");
				}
			}
		}
	}

	private static void WaveForwardBackward(int[][] arr) throws IOException {
		for (int row = 0; row < arr.length; row++) {
			if (row % 2 == 0) {
				for (int col = 0; col < arr[0].length; col++) {
					pnter.print(arr[row][col] + " ");
				}
			} else {
				for (int col = arr[0].length - 1; col >= 0; col--) {
					pnter.print(arr[row][col] + " ");
				}
			}
		}
	}

	private static void Spiral(int[][] arr) throws IOException {

		int rmin = 0;
		int rmax = arr.length - 1;

		int cmin = 0;
		int cmax = arr[0].length - 1;

		int tele = arr.length * arr[0].length;

		while (tele > 0) {

			for (int r = rmin; r <= rmax && tele > 0; r++) {
				pnter.print(arr[r][cmin] + " ");
				tele--;
			}
			cmin++;

			for (int c = cmin; c <= cmax && tele > 0; c++) {
				pnter.print(arr[rmax][c] + " ");
				tele--;
			}
			rmax--;

			for (int r = rmax; r >= rmin && tele > 0; r--) {
				pnter.print(arr[r][cmax] + " ");
				tele--;
			}
			cmax--;

			for (int c = cmax; c >= cmin && tele > 0; c--) {
				pnter.print(arr[rmin][c] + " ");
				tele--;
			}
			rmin++;
		}

	}

	private static void ExitPoint(int[][] arr) throws IOException {
		int dir = 0;
		int row = 0;
		int col = 0;

		while (true) {

			dir = (dir + arr[row][col]) % 4;

			if (dir == 0) { // East.
				col++;

				if (col == arr[0].length) {
					pnter.print(row + ", " + (col - 1) + "");
					break;
				}

			} else if (dir == 1) { // North.
				row++;

				if (row == arr.length) {
					pnter.print((row - 1) + ", " + (col) + "");
					break;
				}

			} else if (dir == 2) { // West.
				col--;

				if (col == -1) {
					pnter.print(row + ", " + (col + 1) + "");
					break;
				}

			} else { // South.
				row--;

				if (row == -1) {
					pnter.print((row + 1) + ", " + (col) + "");
					break;
				}

			}

		}
	}

	private static void RotateBy90(int[][] arr) {
		TransposeOfMatrix(arr);

		for (int le = 0, ri = arr.length - 1; le < ri; le++, ri--) {
			for (int row = 0; row < arr.length; row++) {
				Swap2DEle(arr, row, le, row, ri);
			}

		}

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

	private static void Swap2DEle(int[][] arr, int i1, int j1, int i2, int j2) {
		int temp = arr[i1][j1];
		arr[i1][j1] = arr[i2][j2];
		arr[i2][j2] = temp;
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
