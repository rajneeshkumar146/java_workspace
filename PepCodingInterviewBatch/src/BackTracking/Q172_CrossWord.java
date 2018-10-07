package BackTracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Q172_CrossWord {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		solve();
		pnter.close();
	}

	public static void solve() throws Exception {
		CrossWord();
	}

	private static void CrossWord() throws IOException {

		int n = 10;
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			board[i] = scn.scanString().toCharArray();
		}
		String[] words = scn.scanString().split(";");

		CrossWordSolver(board, words, 0);
	}

	private static void CrossWordSolver(char[][] board, String[] words, int count) throws IOException {
		if (count == words.length) {
			displayMatrix(board);
			return;
		}

		String word = words[count];

		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {

				if (board[r][c] == '-' || board[r][c] == word.charAt(0)) {

					if (CanIPlaceWordHorizontal(board, word, r, c)) {
						boolean[] setPosition = PlaceWordHorizontal(board, word, r, c);
						CrossWordSolver(board, words, count + 1);
						UnplaceWordFromHorizontal(board, word, r, c, setPosition);
					}

					if (CanIPlaceWordVertical(board, word, r, c)) {
						boolean[] setPosition = PlaceWordVertical(board, word, r, c);
						CrossWordSolver(board, words, count + 1);
						UnplaceWordFromVertical(board, word, r, c, setPosition);
					}

				}

			}
		}

	}

	private static boolean CanIPlaceWordHorizontal(char[][] board, String word, int r, int c) {

		for (int i = 0; i < word.length(); i++) {
			if ((r+ i) >= board.length) {
				return false;
			}

			if (board[r + i][c] != '-' && board[r + i][c] != word.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean CanIPlaceWordVertical(char[][] board, String word, int r, int c) {
		for (int i = 0; i < word.length(); i++) {
			if ((c + i) >= board[0].length) {
				return false;
			}

			if (board[r][c + i] != '-' && board[r][c + i] != word.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean[] PlaceWordHorizontal(char[][] board, String word, int r, int c) {
		boolean[] setPosition = new boolean[word.length()];

		for (int i = 0; i < word.length(); i++) {
			if (board[r + i][c] == '-') {
				setPosition[i] = true;
				board[r + i][c] = word.charAt(i);
			}
		}
		return setPosition;
	}

	private static boolean[] PlaceWordVertical(char[][] board, String word, int r, int c) {
		boolean[] setPosition = new boolean[word.length()];

		for (int i = 0; i < word.length(); i++) {
			if (board[r][c + i] == '-') {
				setPosition[i] = true;
				board[r][c + i] = word.charAt(i);
			}
		}
		return setPosition;
	}

	private static void UnplaceWordFromHorizontal(char[][] board, String word, int r, int c, boolean[] setPosition) {
		for (int i = 0; i < word.length(); i++) {
			if (setPosition[i]) {
				board[r + i][c] = '-';
			}
		}
	}

	private static void UnplaceWordFromVertical(char[][] board, String word, int r, int c, boolean[] setPosition) {
		for (int i = 0; i < word.length(); i++) {
			if (setPosition[i]) {
				board[r][c + i] = '-';
			}
		}
	}

	private static void displayMatrix(char[][] arr) throws IOException {
		for (char[] i : arr) {
			for (char el : i) {
				pnter.print(el + " ");
			}
			pnter.printLine("");
		}
	}

	// ------------------------------------------------------------------------------------------------------------------------

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
