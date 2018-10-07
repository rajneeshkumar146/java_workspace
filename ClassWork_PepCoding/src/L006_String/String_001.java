package L006_String;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class String_001 {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		// 1. Lecture 6
		// 1.1 Strings demo and theory functional
		// 1.2 Strings questions
		// 1.2.1 printChars
		// 1.2.2 printSubStrings
		// 1.2.3 isPalindrome
		// 1.2.4 printPalindromicSubstrings
		// 1.3 Strings demo and theory conceptual
		// 1.4 StringBuilder
		// 1.4.1 toggleCase
		// 1.4.2 modify1 - odd pos(char + 1), even pos (char - 1)
		// 1.4.3 modify2 - between chars(difference)
		// 1.4.4 printSubSequence
		// 1.4.5 compress1
		// 1.4.6 compress2Numeric

		solve();
		pnter.close();
	}

	public static void solve() throws Exception {
		String str = scn.scanString();

		// printAllSubstrings(str);

		// AllPalindromicSubstrings(str);

		// AllPermutationByBits(str);

		// ToggleCase(str);

		// Modify1(str);

		// Modify2(str);

		// Compress(str);

		Compress2ByNumeric(str);

	}

	private static void PrintChar(String str) throws IOException {

		for (int i = 0; i < str.length(); i++) {
			pnter.print(str.charAt(i) + "");
		}
	}

	private static void printAllSubstrings(String str) throws IOException {

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				pnter.print(str.substring(i, j) + " ");
			}
			pnter.printLine("");
		}
	}

	private static boolean IsPalindrome(String str) throws IOException {
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}

		return true;
	}

	private static void AllPalindromicSubstrings(String str) throws IOException {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				if (IsPalindrome(str.substring(i, j))) {
					pnter.print(str.substring(i, j) + " ");
				}
			}
			pnter.printLine("");
		}
	}

	private static void AllPermutationByBits(String str) throws IOException {

		ArrayList<String> list = new ArrayList<String>();

		int count = factorial(str.length());
		// pnter.print(count + "");

		for (int i = 0; i < count; i++) {
			int divs = str.length();
			StringBuilder tempstr = new StringBuilder(str);
			StringBuilder CurrResult = new StringBuilder("");
			int divid = i;
			while (divs > 0) {
				int rem = divid % divs;
				int quo = divid / divs;

				divid = quo;

				CurrResult.append(tempstr.charAt(rem));
				tempstr.deleteCharAt(rem);
				divs--;
			}

			list.add(CurrResult.toString());
		}
		// pnter.print(list + "");
		for (String s : list) {
			pnter.printLine(s + "");
		}
	}

	private static void ToggleCase(String str) throws IOException {
		StringBuilder rstr = new StringBuilder("");
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				rstr.append((char) (str.charAt(i) | 32));
			} else {
				rstr.append((char) (str.charAt(i) & ~32));
			}
		}
		pnter.print(rstr.toString());
	}

	private static void Modify1(String str) throws IOException {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (i % 2 == 0) { // Even
				sb.append((char) (ch - 1));
			} else {
				sb.append((char) (ch + 1));
			}
		}

		pnter.printLine(sb.toString() + "");
	}

	private static void Modify2(String str) throws IOException {
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i < str.length(); i++) {
			char ch1 = str.charAt(i - 1);
			char ch2 = str.charAt(i);
			int diff = ch2 - ch1;
			sb.append(ch1);
			sb.append(diff);
		}

		sb.append(str.charAt(str.length() - 1));

		pnter.printLine(sb.toString());
	}

	private static void Compress(String str) throws IOException {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < str.length(); i++) {
			char ch1 = str.charAt(i - 1);
			char ch2 = str.charAt(i);

			if (ch1 != ch2) {
				sb.append(ch1);
			}
		}
		sb.append(str.charAt(str.length() - 1));

		pnter.printLine(sb.toString());
	}

	private static void Compress2ByNumeric(String str) throws IOException {
		int count = 1;

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				count++;
			} else {
				sb.append(str.charAt(i));
				sb.append(count);
				count = 1;
			}
		}

		sb.append(str.charAt(str.length() - 1));
		sb.append(count);

		pnter.printLine(sb.toString());
	}

	private static int factorial(int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}

		return res;
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
