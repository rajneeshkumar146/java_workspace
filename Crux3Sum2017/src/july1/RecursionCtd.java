package july1;

public class RecursionCtd {

	public static void main(String[] args) {
		// boolean[][] board = new boolean[4][4];
		// printNQueens(board, 0, "");

		// printLexico(1, 1000);
		// printRows(1, 5);
		// printColumns(1, 5);

		printTriangle(1, 1, 5);
	}

	public static void printNQueens(boolean[][] board, int row, String qpsf) {
		if (row == board.length) {
			System.out.println(qpsf);
			return;
		}

		for (int col = 0; col < board[row].length; col++) {
			if (isItSafeForQueen(board, row, col) == true) {
				board[row][col] = true;
				printNQueens(board, row + 1, qpsf + "[" + row + "-" + col + "]");
				board[row][col] = false;
			}
		}
	}

	private static boolean isItSafeForQueen(boolean[][] board, int row, int col) {
		// column
		int r = row, c = col;
		while (r >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
		}

		// positive diagonal
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < board.length) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c++;
		}

		// negative diagonal
		r = row - 1;
		c = col - 1;
		while (r >= 0 && c >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c--;
		}

		return true;
	}

	public static void printLexico(int num, int max) {
		System.out.println(num);
		for (int i = 0; i <= 9; i++) {
			if (num * 10 + i <= max) {
				printLexico(num * 10 + i, max);
			}
		}

		if (num < 9) {
			printLexico(num + 1, max);
		}
	}

	public static void printRows(int row, int num) {
		if (row > num) {
			return;
		}

		System.out.println("hello");
		printRows(row + 1, num);
	}

	public static void printColumns(int col, int num) {
		if (col > num) {
			return;
		}

		System.out.print("*");
		printColumns(col + 1, num);
	}

	public static void printBox(int row, int col, int num) {
		if (row > num) {
			return;
		}

		if (col > num) {
			System.out.println();
			printBox(row + 1, 1, num);
			return;
		}

		System.out.print("*");
		printBox(row, col + 1, num);
	}

	public static void printTriangle(int row, int col, int num) {
		if (row > num) {
			return;
		}

		if (col > row) {
			printTriangle(row + 1, 1, num);
			System.out.println();
			return;
		}

		printTriangle(row, col + 1, num);
		System.out.print("*");
	}
}
