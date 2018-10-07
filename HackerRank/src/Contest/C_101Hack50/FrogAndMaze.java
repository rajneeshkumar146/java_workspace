package Contest.C_101Hack50;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FrogAndMaze {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	private static class Pair {
		private int wrongPath = 0;
		private int CorrectPath = 0;
		private ArrayList<String> wpath = new ArrayList<>();
		private ArrayList<String> cpath = new ArrayList<>();
	}

	public static void main(String[] args) throws Exception {
		solve();
		pnter.close();

	}

	public static void solve() throws Exception {

		int row = scn.scanInt();
		int col = scn.scanInt();
		int tunnels = scn.scanInt();

		// wrongPlace.
		int obstacle = -10;
		int mine = -1000;

		// start.
		int sr = -1;
		int sc = -1;

		int[][] board = new int[row + 1][col + 1];
		for (int r = 1; r < board.length; r++) {
			String str = scn.scanString();
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				if (ch == '#') { // obstacle.
					board[r][j + 1] = obstacle;
				} else if (ch == '*') { // Mine.
					board[r][j + 1] = mine;
				} else if (ch == '%') { // End Position.
					board[r][j + 1] = Integer.MAX_VALUE;
				} else if (ch == 'A') { // Start Position.
					sr = r;
					sc = j + 1;
				} else { // freeCellForMoving.
					board[r][j + 1] = -1;
				}
			}
		}

		for (int i = 0; i < tunnels; i++) {
			int slr = scn.scanInt();
			int slc = scn.scanInt();
			int elr = scn.scanInt();
			int elc = scn.scanInt();

			int cellNo1 = slr * board[0].length + slc + 1;
			int cellNo2 = elr * board[0].length + elc + 1;

			board[slr][slc] = cellNo2;
			board[elr][elc] = cellNo1;
		}

		Pair pair = new Pair();
		boolean[][] isdone = new boolean[board.length][board[0].length];

		PossiblPaths(board, isdone, sr, sc, mine, obstacle, pair, "");

		// Display
		pnter.printLine(pair.CorrectPath + " " + pair.wrongPath);
		pnter.printLine(pair.cpath + "");
		pnter.printLine(pair.wpath + "");
	}

	private static void PossiblPaths(int[][] arr, boolean[][] isdone, int r, int c, int mine, int obstacle, Pair pair,
			String ans) { // endRow,endCol.
		if (arr[r][c] == Integer.MAX_VALUE) {
			pair.CorrectPath++;
			pair.cpath.add(ans + "(" + r + "," + c + ") ");
			return;
		}

		if (arr[r][c] > 0) {
			int tr = (arr[r][c] - 1) / arr[0].length; // tunnelRow.
			int tc = (arr[r][c] - 1) % arr[0].length; // tunnelCol.
			if (!isdone[tr][tc]) {
				isdone[r][c] = true;
				PossiblPaths(arr, isdone, tr, tc, mine, obstacle, pair, ans + "(" + r + "," + c + ") ");

				isdone[r][c] = false;
			}
		}

		Integer[][] dirc = Eightdirction();

		for (int i = 0; i < dirc.length; i++) {
			int x = r + (1 * dirc[i][0]);
			int y = c + (1 * dirc[i][1]);

			if (IsValid(arr, isdone, x, y, mine, obstacle, pair, ans)) {
				isdone[r][c] = true;
				PossiblPaths(arr, isdone, x, y, mine, obstacle, pair, ans + "(" + r + "," + c + ") ");
				isdone[r][c] = false;
			}
		}

	}

	private static boolean IsValid(int[][] arr, boolean[][] isdone, int r, int c, int mine, int obstacle, Pair pair,
			String ans) {
		if (r >= arr.length || c >= arr[0].length || r < 1 || c < 1 || isdone[r][c] || arr[r][c] == obstacle) {
			return false;
		}

		if (arr[r][c] == mine) {
			pair.wrongPath++;
			pair.wpath.add(ans + "(" + r + "," + c + ") ");
			return false;
		}

		return true;

	}

	// -------------------------------------------------------------------------------------------------------------

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
