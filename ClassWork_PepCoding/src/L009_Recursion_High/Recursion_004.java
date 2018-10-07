package L009_Recursion_High;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Recursion_004 {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		// 1.1 MergeSort
		// 1.2 Experimental Comparison of MergeSort vs BubbleSort
		// 1.3 QuickSort
		// 1.4 BigO
		// 1.4.1 Theory - O1, Ologn, On, Onlogn, On^2, O2^n
		// 1.4.2 Search - LinearSearch, BinarySearch
		// 1.4.3 Factorial
		// 1.4.4 Sorts - Bubble, Selection, Insertion
		// 1.4.5 Sorts - Merge, Quick, Arrays, Collections
		// 1.4.6 Fibonacci
		// 1.4.7 for * for => n, Sigma (Graphs vertices & edges)
		// 1.4.8 for => n^2
		// 1.4.9 for => logn
		// 1.4.10 ArrayList & StringBuilder
		// 1.5 Solve
		// 1.5.1 Polynomial => 1.x^n + 2.x^(n - 1) + 3.x^(n-2) + ... + n.x^1
		// 1.5.2 Sieve of Eratosthenes
		// 1.5.3 Power - Normal, Smart, FakeSmart (experiment, dry run, maths)
		// 1.5.4 CheckDuplicate
		// 1.5.5 Highest frequency character
		// 1.5.6 Every number duplicated, one not
		// 1.5.7 Every number from 1 to n in array, one duplicated, one missing
		// 1.5.8 Sort 01
		// 1.5.9 Sort 012
		// 1.5.10 Make all 0's go to end preserving the order of non zero's
		// 1.6 Space Complexity

		solve();
		pnter.close();
	}

	public static void solve() throws Exception {

		// 10 10 9 8 7 6 5 4 3 2 1
		// 8 2 1 0 8 7 3 9 5
		// 10 5 2 1 8 3 2 9 7 6 3
		int n = scn.scanInt();
		int[] arr = takeArrayInput(n);

		// int[] ans = mergeSort(arr, 0, arr.length - 1);
		// displayArray(ans);

		// int pivote = scn.scanInt();
		// int pidx = Partitioing(arr, pivote,0,arr.length-1);
		// displayArray(arr);
		// pnter.print(pidx + "");

		 QuickSort(arr, 0, arr.length - 1);
		 displayArray(arr);

		// boolean[] arr = SieveOfEranthoses(n);
		// for (int i = 0; i <= n; i++) {
		// if (!arr[i]) {
		// pnter.printLine(i + "");
		// }
		// }

		// String str = scn.scanString();
		// HighestFrequencyCharacter(str);

		// int num = EveryNumberDuplicateExcept1(arr);
		// pnter.printLine(num + "");

		// FindDplicateNumber(arr);

		// Partion01(arr);
		// displayArray(arr);
		// Partion012(arr);
		// displayArray(arr);

		// 10 1 2 3 4 5 6 7 8 9 10 10

//		TargetSum(arr, scn.scanInt());
//		 TargetDiffrence(arr, scn.scanInt());

	}

	private static int[] MergeTwoSortedArray(int[] one, int[] two) {

		int[] arr = new int[one.length + two.length];

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				arr[k] = one[i];
				i++;
				k++;
			} else {
				arr[k] = two[j];
				j++;
				k++;
			}
		}

		while (i < one.length) {
			arr[k] = one[i];
			i++;
			k++;
		}

		while (j < two.length) {
			arr[k] = two[j];
			k++;
			j++;
		}

		return arr;
	}

	private static int[] mergeSort(int[] arr, int le, int ri) {

		if (le == ri) {
			int[] base = new int[1];
			base[0] = arr[le];
			return base;
		}

		int mid = (le + ri) >> 1;

		int[] leftarr = mergeSort(arr, le, mid);
		int[] rightarr = mergeSort(arr, mid + 1, ri);

		return MergeTwoSortedArray(leftarr, rightarr);

	}

	private static int Partitioing(int[] arr, int pivote, int low, int high) {

		int pi = low; // PartionIndex
		int itr = low; // Iterartor.

		while (itr <= high) {

			if (arr[itr] > pivote) {
				itr++;
			} else {
				swap(arr, pi, itr);
				pi++;
				itr++;
			}
		}

		return pi-1;

	}

	private static void QuickSort(int[] arr, int le, int ri) {
		if (le >= ri) {
			return;
		}
		int pivote = arr[ri];
		int pidx = Partitioing(arr, pivote, le, ri);
		QuickSort(arr, le, pidx - 1);
		QuickSort(arr, pidx + 1, ri);

	}

	private static boolean[] SieveOfEranthoses(int n) {

		boolean[] arr = new boolean[n + 1];

		for (int i = 2; i * i <= n; i++) {

			if (arr[i]) {
				continue;
			}

			for (int j = i; j * i <= n; j++) {
				arr[j * i] = true;
			}
		}

		return arr;

	}

	private static void HighestFrequencyCharacter(String str) throws IOException {
		int[] freqMap = new int[26];

		for (int i = 0; i < str.length(); i++) {
			freqMap[str.charAt(i) - 'a']++;
		}

		int max = freqMap[0];
		int maxIdx = -1;
		for (int i = 1; i < freqMap.length; i++) {
			if (freqMap[i] > max) {
				max = freqMap[i];
				maxIdx = i;
			}
		}

		pnter.print((char) (maxIdx + 'a') + "");

	}

	private static boolean CheckDuplicates(String str) {
		boolean[] freq = new boolean[26];

		for (int i = 0; i < str.length(); i++) {
			if (freq[str.charAt(i) - 'a']) {
				return false;
			}
		}

		return true;

	}

	private static int EveryNumberDuplicateExcept1(int[] arr) {

		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			res ^= arr[i];
		}

		return res;

	}

	private static void FindDplicateNumber(int[] arr) throws IOException {

		int rem = arr.length % 4;
		int oneToNXor = 0;
		if (rem == 0) {
			oneToNXor = arr.length;
		} else if (rem == 1) {
			oneToNXor = 1;
		} else if (rem == 2) {
			oneToNXor = arr.length + 1;
		} else {
			oneToNXor = 0;
		}

		int arrXor = 0;
		for (int i = 0; i < arr.length; i++) {
			arrXor ^= arr[i];
		}

		pnter.print((arrXor ^ oneToNXor) + "");

	}

	private static void Partion01(int[] arr) {

		int pidx = -1;
		int itr = 0;
		int pivote = 0;

		while (itr < arr.length) {
			if (arr[itr] <= pivote) {
				pidx++;
				swap(arr, pidx, itr);
			}

			itr++;
		}

	}

	private static void Partion012(int[] arr) throws IOException {

		int pidx0 = -1;
		int pidx2 = arr.length;
		int itr = 0;
		while (itr < pidx2) {
			if (arr[itr] == 0) {
				pidx0++;
				swap(arr, itr, pidx0);
				itr++;
			} else if (arr[itr] == 2) {
				pidx2--;
				swap(arr, itr, pidx2);
			} else {
				itr++;
			}
		}

		pnter.printLine(pidx0 + " " + itr + " " + pidx2 + "");

	}

	private static void TargetSum(int[] arr, int target) throws IOException {

		int le = 0;
		int ri = arr.length - 1;

		while (le < ri) {
			int sum = arr[le] + arr[ri];

			if (sum == target) {
				pnter.printLine(arr[le] + " " + arr[ri]);
				le++;
				ri--;
			} else if (sum > target) {
				ri--;
			} else {
				le++;
			}
		}
	}

	private static void TargetDiffrence(int[] arr, int target) throws IOException {

		int st = 0;
		int en = 1;

		while (st < arr.length && en < arr.length) {
			int diff = arr[en] - arr[st];

			if (diff == target) {
				pnter.printLine(arr[st] + " " + arr[en]);
				st++;
				en++;
			} else if (diff > target) {
				en--;
			} else {
				st++;
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
