package BackTracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Q157_FindShortestSafePathWithLandmines {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		solve();
		pnter.close();
	}

	public static void solve() throws Exception {
		landmines();
	}

	private static void landmines() throws IOException {
		int n = scn.scanInt();
		int m = scn.scanInt();

		int[][] board = MatrixInput(n, m);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int num = board[i][j];

				if (num == 0 && (i - 1) >= 0) {
					board[i - 1][j] = 2;
				} else if (num == 0 && (j - 1) >= 0) {
					board[i][j - 1] = 2;
				} else if (num == 0 && (i + 1) < board.length) {
					board[i + 1][j] = 2;
				} else if (num == 0 && (j + 1) < board[0].length) {
					board[i][j + 1] = 2;
				}
			}
		}

		boolean[][] isvisted = new boolean[board.length][board[0].length];

		int min = Integer.MAX_VALUE;
		for (int row = 0; row < board.length; row++) {
			int RecMin = FindShortestSafePathWithLandmines(board, row, 0, 0, isvisted);
			min = Math.min(RecMin, min);
		}

		pnter.print(min + "");

	}

	private static int FindShortestSafePathWithLandmines(int[][] board, int r, int c, int csf, boolean[][] isvisted)
			throws IOException {
		if (c == board[0].length - 1) {
			
			return csf;
		}

		int res = Integer.MAX_VALUE;
		int[][] dirc = Fourdirction();
		for (int i = 0; i < dirc.length; i++) {
			int x = r + 1 * dirc[i][0];
			int y = c + 1 * dirc[i][1];

			if (isSafe(board, x, y, isvisted)) {
				isvisted[r][c] = true;
				int RecRes = FindShortestSafePathWithLandmines(board, x, y, csf + 1, isvisted);
				isvisted[r][c] = false;
				res = Math.min(res, RecRes);

			}
		}

		return res;

	}

	private static int[][] Fourdirction() {
		int[][] dirc = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		return dirc;

	}

	private static boolean isSafe(int[][] board, int r, int c, boolean[][] isvisted) {
		if (r >= board.length || c >= board[0].length || r < 0 || c < 0 || board[r][c] == 0 || board[r][c] == 2
				|| isvisted[r][c]) {
			return false;
		}
		return true;

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

	private static int[][] MatrixInput(int n, int m) throws IOException {
		int[][] arr = new int[n][m];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				arr[row][col] = scn.scanInt();
			}
		}
		return arr;
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
