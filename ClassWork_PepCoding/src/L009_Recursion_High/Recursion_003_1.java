package L009_Recursion_High;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Recursion_003_1 {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		// 1.3 permutations, combinations, coinChangp&c/CrossWord_and_Sudoku.
		// 1.4 printNQueens (reactive, proactive, row-wise, alternate),
		// printNKnights

		solve();
		pnter.close();
	}

	public static void solve() throws Exception {
		
		 boolean[] boxes = new boolean[5];
//				 NQueenPermutation(boxes, 3, 0, "");
//				 NQueenCombination(boxes, 3, 0, "", -1);

				// int n = 10;
				// char[][] box = new char[n][n];
				// for (int i = 0; i < n; i++) {
				// box[i] = scn.scanString().toCharArray();
				// }
				// String[] Dictionary = scn.scanString().split(";");
				// CrossWord(box, Dictionary, 0);

//				boolean[][] board = new boolean[4][4];
				// NQueenSlow(board, 0, 0, "");
				// NQueenFast(board, 0, 0, "");
				// NQueenSubSequences(board, 0, 1, "");

	}
	

	static int count = 0;

	private static void NQueenPermutation(boolean[] boxes, int tnq, int qpsf, String csf) throws IOException {
		// tnq_total_n_queen.

		if (qpsf == tnq) {
			count++;
			pnter.printLine(count + " " + csf);
			return;
		}

		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				NQueenPermutation(boxes, tnq, qpsf + 1, csf + "q" + qpsf + "b" + i);
				boxes[i] = false;
			}
		}

	}

	private static void NQueenCombination(boolean[] boxes, int tnq, int qpsf, String csf, int lqpb) throws IOException {
		// tnq_total_n_queen.
		// lqpb_LastQueenPlaceBox.

		if (qpsf == tnq) {
			count++;
			pnter.printLine(count + " " + csf);
			return;
		}

		for (int i = lqpb + 1; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				NQueenCombination(boxes, tnq, qpsf + 1, csf + "q" + qpsf + "b" + i, i);
				boxes[i] = false;
			}
		}

	}

	private static void CrossWord(char[][] box, String[] dictionary, int windex) throws IOException {

		if (windex == dictionary.length) {
			printCrrosWord(box);
			return;
		}

		String word = dictionary[windex];
		for (int r = 0; r < box.length; r++) {
			for (int c = 0; c < box[0].length; c++) {
				if (box[r][c] == '-' || box[r][c] == word.charAt(0)) {

					if (CanPlaceTheWordHorizontally(box, word, r, c)) {
						boolean[] reset = PlaceTheWordHorizontally(box, word, r, c);
						CrossWord(box, dictionary, windex + 1);
						UnplaceTheWordHorizontally(box, word, reset, r, c);
					}

					if (CanPlaceTheWordVertically(box, word, r, c)) {
						boolean[] reset = PlaceTheWordVertically(box, word, r, c);
						CrossWord(box, dictionary, windex + 1);
						UnplaceTheWordVertically(box, word, reset, r, c);
					}

				}
			}

		}
	}

	private static boolean[] PlaceTheWordHorizontally(char[][] box, String word, int r, int c) {
		boolean[] reset = new boolean[word.length()];

		for (int i = 0; i < word.length(); i++) {
			if (box[r][c + i] == '-') {
				box[r][c + i] = word.charAt(i);
				reset[i] = true;
			}
		}

		return reset;

	}

	private static boolean[] PlaceTheWordVertically(char[][] box, String word, int r, int c) {
		boolean[] reset = new boolean[word.length()];

		for (int i = 0; i < word.length(); i++) {
			if (box[r + i][c] == '-') {
				box[r + i][c] = word.charAt(i);
				reset[i] = true;
			}
		}

		return reset;

	}

	private static void UnplaceTheWordHorizontally(char[][] box, String word, boolean[] reset, int r, int c) {
		for (int i = 0; i < word.length(); i++) {
			if (reset[i] == true) {
				box[r][c + i] = '-';
			}
		}
	}

	private static void UnplaceTheWordVertically(char[][] box, String word, boolean[] reset, int r, int c) {
		for (int i = 0; i < word.length(); i++) {
			if (reset[i] == true) {
				box[r + i][c] = '-';
			}
		}
	}

	private static boolean CanPlaceTheWordHorizontally(char[][] box, String word, int r, int c) {
		for (int i = 0; i < word.length(); i++) {
			if ((c + i) >= box[0].length) {
				return false;
			}
			if (box[r][c + i] != '-' && box[r][c + i] != word.charAt(i)) {
				return false;
			}
		}
		return true;

	}

	private static boolean CanPlaceTheWordVertically(char[][] box, String word, int r, int c) {
		for (int i = 0; i < word.length(); i++) {
			if ((r + i) >= box.length) {
			}
			if (box[r + i][c] != '-' && box[r + i][c] != word.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private static void printCrrosWord(char[][] box) throws IOException {

		for (int r = 0; r < box.length; r++) {
			for (int c = 0; c < box[0].length; c++) {
				pnter.print(box[r][c] + " ");
			}
			pnter.printLine("");
		}

	}

	private static void NQueenSlow(boolean[][] board, int qpsf, int cellno, String csf) throws IOException {

		if (qpsf == board.length) {
			if (IsBoardSafe(board)) {
				pnter.printLine(csf + "");
				return;
			}
		}

		for (int i = cellno + 1; i < board[0].length * board.length; i++) {
			int r = (i - 1) / board.length;
			int c = (i - 1) % board.length;

			if (!board[r][c]) {
				board[r][c] = true;
				NQueenFast(board, qpsf + 1, i, csf + "(" + r + ", " + c + "), ");
				board[r][c] = false;
			}

		}

	}

	private static void NQueenFast(boolean[][] board, int qpsf, int cellno, String csf) throws IOException {
		if (qpsf == board.length) {
			pnter.printLine(csf + "");
			return;
		}

		for (int i = cellno + 1; i < board[0].length * board.length; i++) {
			int r = (i - 1) / board.length;
			int c = (i - 1) % board.length;

			if (!board[r][c] && IsQueenSafe(board, r, c)) {
				board[r][c] = true;
				NQueenFast(board, qpsf + 1, i, csf + "(" + r + ", " + c + "), ");
				board[r][c] = false;
			}

		}

	}

	private static boolean IsBoardSafe(boolean[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == true) {
					if (!IsQueenSafe(board, i, j)) {
						return false;
					}
				}
			}
		}

		return true;

	}

	private static boolean IsQueenSafe(boolean[][] board, int r, int c) {
		int[][] dirc = Eightdirction();

		for (int rad = 1; rad < board.length; rad++) { // Explore_all_radius.
			for (int i = 0; i < dirc.length; i++) { // wrt._to_all_direction.
				int x = r + rad * dirc[i][0];
				int y = c + rad * dirc[i][1];

				if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y]) {
					return false;
				}
			}
		}

		return true;

	}

	private static void NQueenSubSequences(boolean[][] board, int qpsf, int bno, String csf) throws IOException {
		if (qpsf == board.length) {
			pnter.printLine(csf + "");
			return;
		}

		if (bno > board.length * board[0].length) {
			return;
		}

		NQueenSubSequences(board, qpsf, bno + 1, csf); // BoxRefuseToTakeQueen.

		int r = (bno - 1) / board.length;
		int c = (bno - 1) % board.length;

		if (!board[r][c] && IsQueenSafe(board, r, c)) {
			board[r][c] = true;
			NQueenSubSequences(board, qpsf + 1, bno + 1, csf + "(" + r + ", " + c + "), ");
			board[r][c] = false;
		}

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
