package L009_Recursion_High;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Recursion_003_2 {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		// 1.5 printTargetSum, printEquiSum, printPermutations (gets?)
		// 1.6 String vs StringBuilder or ArrayList in 1.5
		// 1.7 Recursion to Iteration

		solve();
		pnter.close();
		
		System.out.println();
		
	}

	public static void solve() throws Exception {

		// int n = scn.scanInt();
		// int[] arr = takeArrayInput(n);

		// 5 10 20 30 40 50 100
		// int target = scn.scanInt();
		// printTargetSum(arr, 0, target, "");
		// printTargetSumAL(arr, 0, target, new ArrayList<>());

		// ArrayList<Integer> ans = printTargetSumRAL(arr, 0, target);
		// pnter.print(ans + "");

		// 7 10 20 30 40 50 60 70
		// EqualSet(arr, 0, 0, 0, "", "");
		// EqualSetAL(arr, 0, 0, 0, new ArrayList<>(), new ArrayList<>());

		// String str = scn.scanString();
		// permutation(str, "");
		// PermutationSB(new StringBuilder(str), new StringBuilder());

		Sudoku();

	}

	private static void printTargetSum(int[] arr, int vidx, int target, String ans) throws IOException {
		if (arr.length == vidx) {
			if (target == 0)
				pnter.printLine(ans + "");
			return;
		}

		printTargetSum(arr, vidx + 1, target, ans); // SayNo
		printTargetSum(arr, vidx + 1, target - arr[vidx], ans + arr[vidx] + " "); // SayYes

	}

	private static void printTargetSumAL(int[] arr, int vidx, int target, ArrayList<Integer> ans) throws IOException {
		if (arr.length == vidx) {
			if (target == 0) {
				pnter.printLine(ans + "");
			}
			return;
		}

		printTargetSumAL(arr, vidx + 1, target, ans); // SayNo

		ans.add(arr[vidx]);
		printTargetSumAL(arr, vidx + 1, target - arr[vidx], ans); // SayYes
		ans.remove(ans.size() - 1);

	}

	private static ArrayList<Integer> printTargetSumRAL(int[] arr, int vidx, int target) {

		if (arr.length - 1 == vidx) {
			ArrayList<Integer> baseAl = new ArrayList<>();
			if (target - arr[vidx] == 0) {
				baseAl.add(arr[vidx]);
			}

			return baseAl;
		}

		ArrayList<Integer> myRes = new ArrayList<>();
		ArrayList<Integer> RecResWithout = printTargetSumRAL(arr, vidx + 1, target);

		for (Integer i : RecResWithout) {
			myRes.add(i);
		}

		ArrayList<Integer> RecResWith = printTargetSumRAL(arr, vidx + 1, target - arr[vidx]);
		for (Integer i : RecResWith) {
			myRes.add(i);
		}

		return myRes;

	}

	private static void EqualSet(int[] arr, int vidx, int set1, int set2, String set1str, String set2str)
			throws IOException {

		if (vidx == arr.length) {
			if (set1 == set2) {
				pnter.printLine(set1str + " -> " + set2str);
			}
			return;
		}

		EqualSet(arr, vidx + 1, set1 + arr[vidx], set2, set1str + arr[vidx] + " ", set2str);
		EqualSet(arr, vidx + 1, set1, set2 + arr[vidx], set1str, set2str + arr[vidx] + " ");
	}

	private static void EqualSetAL(int[] arr, int vidx, int set1, int set2, ArrayList<Integer> set1str,
			ArrayList<Integer> set2str) throws IOException {

		if (vidx == arr.length) {
			if (set1 == set2) {
				pnter.printLine(set1str + " -> " + set2str);
			}
			return;
		}

		set1str.add(arr[vidx]);
		EqualSetAL(arr, vidx + 1, set1 + arr[vidx], set2, set1str, set2str);
		set1str.remove(set1str.size() - 1);

		set2str.add(arr[vidx]);
		EqualSetAL(arr, vidx + 1, set1, set2 + arr[vidx], set1str, set2str);
		set2str.remove(set2str.size() - 1);
	}

	private static void permutation(String str, String ans) throws IOException {
		if (str.length() == 0) {
			pnter.printLine(ans + " ");
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			permutation(ros, ans + ch);
		}
	}

	private static void PermutationSB(StringBuilder str, StringBuilder ans) throws IOException {

		if (str.length() == 0) {
			pnter.printLine(ans + "");
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			StringBuilder ros = str.deleteCharAt(i);
			ans.append(ch);
			PermutationSB(ros, ans);
			ans.deleteCharAt(ans.length() - 1);
			str.insert(i, ch);

		}

	}

	private static void permutationAnsToQues(StringBuilder str, StringBuilder ans) throws IOException {

		if (str.length() == 0) {
			pnter.print(ans + "");
			return;
		}

		char ch = str.charAt(0);
		str.deleteCharAt(0);

		for (int i = 0; i <= str.length(); i++) {
			ans.append(ch);
			permutationAnsToQues(str, ans);
			ans.deleteCharAt(str.length() - 1);
		}

		str.insert(0, ch);

	}

	public static void Sudoku() throws IOException {

		int[][] board = new int[9][9];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = scn.scanInt();
			}
		}

		int[] rowArr = new int[board.length];
		int[] colArr = new int[board[0].length];
		int[][] SubMatrix = new int[board.length / 3][board[0].length / 3];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				rowArr[i] |= (1 << board[i][j]);
				colArr[j] |= (1 << board[i][j]);
				SubMatrix[i / 3][j / 3] |= (1 << board[i][j]);

			}
		}

		Suduko(board, 1, rowArr, colArr, SubMatrix);

	}

	private static void Suduko(int[][] board, int cellno, int[] rowArr, int[] colArr, int[][] SubMatrix)
			throws IOException {
		if (cellno > board.length * board[0].length) {
			displayMatrix(board);
			return;
		}

		int r = (cellno - 1) / board[0].length;
		int c = (cellno - 1) % board[0].length;

		if (board[r][c] != 0) {
			Suduko(board, cellno + 1, rowArr, colArr, SubMatrix);
		} else {
			for (int num = 1; num <= 9; num++) {
				if (IsNumberAvailable(board, rowArr, colArr, SubMatrix, cellno, num)) {
					placeTheNumber(board, rowArr, colArr, SubMatrix, cellno, num);
					Suduko(board, cellno + 1, rowArr, colArr, SubMatrix);
					UnplaceTheNumber(board, rowArr, colArr, SubMatrix, cellno, num);
				}
			}

		}

	}

	private static boolean IsNumberAvailable(int[][] board, int[] rowArr, int[] colArr, int[][] SubMatrix, int cellno,
			int num) {

		int r = (cellno - 1) / board[0].length;
		int c = (cellno - 1) % board[0].length;

		if ((rowArr[r] & (1 << num)) != 0 || (colArr[c] & (1 << num)) != 0
				|| (SubMatrix[r / 3][c / 3] & (1 << num)) != 0) {
			return false;
		}
		return true;
	}

	private static void placeTheNumber(int[][] board, int[] rowArr, int[] colArr, int[][] SubMatrix, int cellno,
			int num) {

		int r = (cellno - 1) / board[0].length;
		int c = (cellno - 1) % board[0].length;

		board[r][c] = num;
		rowArr[r] |= (1 << num);
		colArr[c] |= (1 << num);
		SubMatrix[r / 3][c / 3] |= (1 << num);
	}

	private static void UnplaceTheNumber(int[][] board, int[] rowArr, int[] colArr, int[][] SubMatrix, int cellno,
			int num) {

		int r = (cellno - 1) / board[0].length;
		int c = (cellno - 1) % board[0].length;

		board[r][c] = 0;
		rowArr[r] &= ~(1 << num);
		colArr[c] &= ~(1 << num);
		SubMatrix[r / 3][c / 3] &= ~(1 << num);

	}
	// -------------------------------------------------------------------------------------------------------------

	private static int[][] Eightdirction() {
		int[][] dirc = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

		return dirc;

	}

	private static int[] FreqMapOfStringof26(String str) {
		int[] map = new int[26];

		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			map[index]++;
		}

		return map;
	}

	private static int[] FreqMapOfStringof91(String str) {
		int[] map = new int[91];

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
