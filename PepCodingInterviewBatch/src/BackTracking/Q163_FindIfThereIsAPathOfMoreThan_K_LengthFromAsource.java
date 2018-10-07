package BackTracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Q163_FindIfThereIsAPathOfMoreThan_K_LengthFromAsource {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		solve();
		pnter.close();
	}

	public static void solve() throws Exception {
		int n = scn.scanInt(); // num vertices
		int e = scn.scanInt(); // num edges

		Integer[][] arr = new Integer[n][n]; // adjacency vertex
		for (int i = 0; i < e; i++) {
			int v1 = scn.scanInt(); // vertex 1
			int v2 = scn.scanInt(); // vertex 2
			int weight = scn.scanInt(); // weight of the edge

			arr[v1][v2] = weight;
			arr[v2][v1] = weight;
		}

		int src = scn.scanInt();// src vertex
		int minWeight = scn.scanInt();// permitted weight

		boolean[] isVisted = new boolean[arr.length];
		boolean res = HashPathLarger(arr, isVisted, minWeight, 0, "", src);
		pnter.print(res + "");
	}

	private static boolean HashPathLarger(Integer[][] arr, boolean[] isVisted, int minwt, int wsf, String psf, int srcx)
			throws IOException {

		if (wsf == minwt) {
			pnter.printLine(psf + " ");
			return true;
		}
		if (wsf > minwt)
			return false;
		
		isVisted[srcx] = true;

		boolean res = false;
		for (int i = 0; i < arr[0].length; i++) {
			if (arr[srcx][i] != null) {
				if (isVisted[i] == false) {
					res = res || HashPathLarger(arr, isVisted, minwt, wsf + arr[srcx][i], psf + i, i);
				}
			}
		}

		isVisted[srcx] = false;

		return res;
	}

	// ------------------------------------------------------------------------------------------------------------------------

	private static Integer[][] Eightdirction() {
		Integer[][] dirc = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		return dirc;

	}

	private static Integer[] FreqMapOfStringof26(String str) {
		Integer[] map = new Integer[26];

		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			map[index]++;
		}

		return map;
	}

	private static Integer[] FreqMapOfStringof91(String str) {
		Integer[] map = new Integer[91];

		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - ' ';
			map[index]++;
		}

		return map;
	}

	private static int NumberLength(int n) {
		int length = 0;
		while (n != 0) {
			length++;
			n = n / 10;
		}

		return length;
	}

	private static <T> void ReverseArray(T[] arr, int st, int en) {
		for (int i = st; st <= en; st++, en--) {
			swap(arr, st, en);
		}
	}

	private static Integer[] PrifixSumArray(Integer[] arr) {
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}

		return arr;
	}

	private static <T> void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static <T> void Swap2DEle(T[][] arr, int i1, int j1, int i2, int j2) {
		T temp = arr[i1][j1];
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

	private static Integer[] takeArrayInput(int n) throws IOException {
		Integer[] arr = new Integer[n];
		// String[] arr = new String[n];
		// Character[] arr = new Character[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.scanInt();
			// arr[i] = scn.scanString();
			// arr[i] = scn.scanString().charAt(0);
		}
		return arr;
	}

	private static <T> void displayArray(T[] arr) throws IOException {
		for (int i = 0; i < arr.length; i++) {
			pnter.print(arr[i] + " ");
			// System.out.print(arr[i]+" ");
		}
		pnter.printLine("");
		// System.out.println();
	}

	private static Integer[][] takeMatrixInput(int n, int m) throws IOException {
		Integer[][] arr = new Integer[n][m];
		// Character[][] arr = new Character[n][m];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				arr[row][col] = scn.scanInt();
				// arr[row][col] = scn.scanString().charAt(0);

			}
		}
		return arr;
	}

	private static <T> void displayMatrix(T[][] arr) throws IOException {
		for (T[] i : arr) {
			for (T el : i) {
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

	private static class Functions<T> {

	}

	private static class Scan {
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

		public String scanStringLine() throws IOException {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpaceModified(n))
				n = scan();
			while (!isWhiteSpaceModified(n)) {
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

		private boolean isWhiteSpaceModified(int n) {
			if (n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}
	}

	private static class Print {
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