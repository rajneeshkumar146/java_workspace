package L004_Array;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Array_001 {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		// . Lecture 4
		// 1.1 Arrays demo
		// 1.2 Arrays questions
		// 1.2.1 takeinput
		// 1.2.2 display
		// 1.2.3 max
		// 1.2.4 linearSearch
		// 1.2.5 binarySearch
		// 1.2.6 bubbleSort
		// 1.2.7 selectionSort
		// 1.2.8 insertionSort
		// 1.2.9 reverse
		// 1.2.10 inverse
		// 1.2.11 isInverse
		// 1.2.12 isMirrorInverse
		// 1.2.13 rotate
		// 1.2.14 kadane's algorithm

		solve();
		pnter.close();

	}

	public static void solve() throws Exception {
		int n = scn.scanInt();

		int[] arr = takeArrayInput(n);

		// int max = maxInArray(arr);

		// int ele = scn.scanInt();
		// int linearSearchIndex = LinearSerach(arr, n, ele);

		// int ele = scn.scanInt();
		// int binarySearch = binarySearch(arr, n, ele);

		// bubbleSort(arr, n);

		// selectionSort(arr, n);

		// insertionSort(arr, n);

		// ReverseArray(arr, 0, n - 1);

		// inverse(arr, n);

		// int[] arr2 = takeArrayInput(n);
		// boolean ans = isInverse(arr,arr2, n);
		// pnter.print(ans + "");

		// IsMirrorInverse(arr, n);
		// pnter.print(ans + "");

		// int r = scn.scanInt();
		// rotate(arr, n, r);

		// int ans = KadanesAlgoForNegative2(arr, n);
		// pnter.print(ans + "");

		displayArray(0, n - 1, arr);
	}

	private static int LinearSerach(int[] arr, int n, int ele) {
		int indx = -1;
		for (int i = 0; i < n; i++) {
			if (ele == arr[i]) {
				return i;
			}
		}

		return indx;
	}

	private static int binarySearch(int[] arr, int n, int ele) {
		Arrays.sort(arr);

		int i = 0;
		int j = n - 1;
		boolean flag = false;
		int mid = 0;
		while (i <= j) {
			mid = (i + j) >> 1;

			if (arr[mid] < ele) {
				i = mid + 1;
			} else if (arr[mid] > ele) {
				j = mid;
			} else {
				flag = true;
				break;
			}
		}

		return flag ? mid : -1;
	}

	private static void bubbleSort(int[] arr, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n - i; j++) {
				if (arr[j - 1] > arr[j]) {
					swap(arr, j - 1, j);
				}
			}
		}

	}

	private static void selectionSort(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}

			}
		}

	}

	private static void insertionSort(int[] arr, int n) {

		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {

				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				} else {
					break;
				}
			}
		}

	}

	private static void inverse(int[] arr, int n) throws IOException {
		if (maxInArray(arr) > n - 1) {
			pnter.printLine("Not Valid For Inverse");
			return;
		}

		int[] rarr = new int[n];
		for (int i = 0; i < n; i++) {
			rarr[arr[i]] = i;
		}

		cloneArray(arr, rarr, n);
	}

	private static boolean isInverse(int[] arr, int[] arr2, int n) {
		for (int i = 0; i < n; i++) {
			if (arr2[arr[i]] != i) {
				return false;
			}
		}
		return true;
	}

	private static boolean IsMirrorInverse(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			if (arr[arr[i]] != i) {
				return false;
			}
		}
		return true;
	}

	private static void rotate(int[] arr, int n, int r) {
		if (r < 0) {
			r = n + r;
		}
		r = r % n;

		ReverseArray(arr, 0, r - 1);
		ReverseArray(arr, r, n);
		ReverseArray(arr, 0, n);
	}

	private static int KadanesAlgoForNegative1(int[] arr, int n) {
		int max_so_far = Integer.MIN_VALUE;
		int curr_so_far = 0;

		for (int i = 0; i < n; i++) {
			curr_so_far += arr[i];
			if (curr_so_far < 0) {
				curr_so_far = 0;
			} else if (curr_so_far > max_so_far) {
				max_so_far = curr_so_far;
			}
		}
		return max_so_far;

	}

	private static int KadanesAlgoForNegative2(int[] arr, int n) {
		int max_so_far = arr[0];
		int curr_so_far = arr[0];

		for (int i = 1; i < n; i++) {
			curr_so_far = Math.max(curr_so_far + arr[i], curr_so_far);
			max_so_far = Math.max(curr_so_far, max_so_far);
		}

		return max_so_far;
	}
	// -----------------------------------------------------------------------------------------

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
