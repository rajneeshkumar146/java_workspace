package L007_Recursion_Basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Recursion_002 {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		// 1. Lecture 8
		// 1.1 PrintTriangle
		// 1.2 PrintInvertedTriangle
		// 1.2 Array Recursion
		// 1.2.1 display
		// 1.2.2 reverse display
		// 1.2.3 max
		// 1.2.4 find
		// 1.2.5 firstIndex
		// 1.2.6 lastIndex
		// 1.2.7 allIndices
		// 1.2.8 inverse
		// 1.2.9 bubbleSort
		// 1.2.10 selectionSort

		solve();
		pnter.close();
	}

	public static void solve() throws Exception {

		int n = scn.scanInt();
		int[] arr = takeArrayInput(n);
		int vidx = 0;

		// display(arr, vidx);

		// ReverseDisplay(arr, vidx);

		// int max = max(arr, vidx);
		// pnter.print(max + "");

		// int find=find(arr, vidx, 2);
		// pnter.print(find+"");

		// int firstIndex=find(arr, vidx, 2);
		// pnter.print(firstIndex+"");

		// int lastIndex = LastIndex(arr, vidx, 2);
		// pnter.print(lastIndex+"");

		/* 10 2 3 4 2 5 6 2 9 2 1 */
		// int[] rarr = AllIndices(arr, vidx, 2, 0);
		// displayArray(rarr);

		// bubbleSort(arr, 0, n - 1);
		// displayArray(arr);

		// insertionSort(arr, 0, 0);
		// displayArray(arr);
		
		selectionSort(arr, 1, 1);
displayArray(arr);
	}

	private static void display(int[] arr, int vidx) throws IOException {
		if (vidx == arr.length) {
			return;
		}

		pnter.print(arr[vidx] + " ");
		display(arr, vidx + 1);

	}

	private static void ReverseDisplay(int[] arr, int vidx) throws IOException {
		if (vidx == arr.length) {
			return;
		}

		ReverseDisplay(arr, vidx + 1);
		pnter.print(arr[vidx] + " ");

	}

	private static int max(int[] arr, int vidx) {

		if (vidx == arr.length - 1) {
			return arr[vidx];
		}

		int recRes = max(arr, vidx + 1);

		return Math.max(recRes, arr[vidx]);

	}

	private static int find(int[] arr, int vidx, int ele) {
		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == ele) {
			return vidx;
		}

		return find(arr, vidx + 1, ele);
	}

	private static int FirstIndex(int[] arr, int vidx, int ele) {
		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == ele) {
			return vidx;
		}

		return FirstIndex(arr, vidx + 1, ele);

	}

	private static int LastIndex(int[] arr, int vidx, int ele) {
		if (vidx == arr.length) {
			return -1;
		}

		int resRec = LastIndex(arr, vidx + 1, ele);
		if (resRec != -1) {
			return resRec;
		} else if (arr[vidx] == ele) {
			return vidx;
		}

		return resRec;

	}

	private static int[] AllIndices(int[] arr, int vidx, int ele, int count) throws IOException {
		if (arr.length == vidx) {
			int[] rarr = new int[count];
			return rarr;
		}

		if (arr[vidx] == ele) {
			int[] resArr = AllIndices(arr, vidx + 1, ele, count + 1);
			resArr[count] = vidx;
			return resArr;
		} else {
			return AllIndices(arr, vidx + 1, ele, count);
		}

	}

	private static void inverse(int[] arr, int vidx) {
		if (vidx == arr.length - 1) {
			return;
		}

		inverse(arr, vidx + 1);
		arr[arr[vidx]] = vidx;
	}

	private static void TrianglePattern(int n, int i, int j) throws IOException {
		if (i > n) {
			return;
		}
		if (j <= i) {
			pnter.print("* ");
			TrianglePattern(n, i, j + 1);
		} else {
			TrianglePattern(n, i + 1, j);
		}
	}

	private static void bubbleSort(int[] arr, int st, int en) {
		if (en == 0) {
			return;
		}

		if (st == en) {
			bubbleSort(arr, 0, en - 1);
			return;
		}
		if (arr[st] > arr[st + 1]) {
			swap(arr, st, st + 1);
		}
		bubbleSort(arr, st + 1, en);
	}

	private static void insertionSort(int[] arr, int st, int vidx) {
		if (st == arr.length) {
			return;
		}

		if (vidx == arr.length) {
			insertionSort(arr, st + 1, st + 1);
			return;
		}

		if (arr[st] > arr[vidx]) {
			swap(arr, st, vidx);
		}

		insertionSort(arr, st, vidx + 1);
	}

	private static void selectionSort(int[] arr, int st, int vidx) {
		if(st==arr.length){
			return;
		}
		
		
		if(vidx==0){
			selectionSort(arr, st+1, st+1);
			return;
		}
		
		
		if (arr[vidx-1] > arr[vidx]) {
			swap(arr, vidx-1, vidx);
		}else{
			selectionSort(arr, st+1, st+1);
			return;

		}
		
		
		selectionSort(arr, st, vidx-1);

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

	private static int[] PrifixSumArray(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
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

	private static void displayArray(int[] arr) throws IOException {
		for (int i = 0; i < arr.length; i++) {
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
