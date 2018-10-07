package BackTracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Q153_sudoku {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		solve();
		pnter.close();
	}

	public static void solve() throws Exception {
		Sudoku();
	}

	private static void Sudoku() throws IOException {
		int[][] board = MatrixInput(scn.scanInt(), scn.scanInt());

		int[] rows = new int[board.length];
		int[] cols = new int[board[0].length];
		int[][] matrix = new int[board.length / 3][board[0].length / 3];

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {

				int num = (1 << board[row][col]);
				rows[row] |= num;
				cols[col] |= num;
				matrix[row / 3][col / 3] |= num;
			}
		}

		sudokuSolver(board, 1, rows, cols, matrix);

	}

	private static boolean sudokuSolver(int[][] board, int cellno, int[] rows, int[] cols, int[][] matrix)
			throws IOException {
		if (cellno > board.length * board[0].length) {
			displayMatrix(board);
			pnter.printLine("");
			return true;
		}

		int r = (cellno - 1) / board[0].length;
		int c = (cellno - 1) % board[0].length;

		boolean flag = false;
		if (board[r][c] == 0) {
			for (int num = 1; num <= 9; num++) {
				if (CheckForValidSpot(board, cellno, rows, cols, matrix, num)) {
					SetNumber(board, cellno, rows, cols, matrix, num);
					flag = flag || sudokuSolver(board, cellno + 1, rows, cols, matrix);
					UnsetNumber(board, cellno, rows, cols, matrix, num);
				}
			}
		} else {
			flag = flag || sudokuSolver(board, cellno + 1, rows, cols, matrix);
		}

		return flag;

	}

	private static boolean CheckForValidSpot(int[][] board, int cellno, int[] rows, int[] cols, int[][] matrix,
			int num) {

		int mask = (1 << num);
		int r = (cellno - 1) / board[0].length;
		int c = (cellno - 1) % board[0].length;

		if ((rows[r] & mask) != 0 || (cols[c] & mask) != 0 || (matrix[r / 3][c / 3] & mask) != 0) {
			return false;
		}
		return true;
	}

	private static void SetNumber(int[][] board, int cellno, int[] rows, int[] cols, int[][] matrix, int num) {

		int mask = (1 << num);
		int r = (cellno - 1) / board[0].length;
		int c = (cellno - 1) % board[0].length;

		board[r][c] = num;
		rows[r] |= mask;
		cols[c] |= mask;
		matrix[r / 3][c / 3] |= mask;

	}

	private static void UnsetNumber(int[][] board, int cellno, int[] rows, int[] cols, int[][] matrix, int num) {

		int mask = ~(1 << num);
		int r = (cellno - 1) / board[0].length;
		int c = (cellno - 1) % board[0].length;

		board[r][c] = 0;
		rows[r] &= mask;
		cols[c] &= mask;
		matrix[r / 3][c / 3] &= mask;

	}

	private static int[][] MatrixInput(int n, int m) throws IOException {
		int[][] arr = new int[n][m];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				arr[row][col] = scn.scanInt();
			}
		}
		return arr;
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
