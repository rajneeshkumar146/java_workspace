package july16;

public class RecursionCtd {

	public static void main(String[] args) {
		// System.out.println(printBoardPath(0, 10, ""));
//		boolean[][] board = new boolean[4][4];
//		printNQueens(board, 0, "");
		printLexico(1, 1000);
	}

	public static int printBoardPath(int curr, int end, String path) {
		if (curr == end) {
			System.out.println(path);
			return 1;
		}

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			if (curr + dice <= end) {
				int cdice = printBoardPath(curr + dice, end, path + dice);
				count += cdice;
			}
		}
		return count;
	}

	public static void printNQueens(boolean[][] board, int row, String config) {
		if (row == board.length) {
			System.out.println(config);
			return;
		}

		for (int col = 0; col < board.length; col++) {
			if (isItSafeForTheQueen(board, row, col) == true) {
				board[row][col] = true;
				printNQueens(board, row + 1, config + "[" + row + col + "]");
				board[row][col] = false;
			}
		}
	}

	public static boolean isItSafeForTheQueen(boolean[][] board, int row, int col) {
		// column
		int r = row;
		int c = col;
		while (r >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
		}

		// negative diagonal
		r = row;
		c = col;
		while (r >= 0 && c >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c--;
		}

		// positive diagonal
		r = row;
		c = col;
		while (r >= 0 && c < board.length) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c++;
		}

		return true;
	}

	public static void printLexico(int curr, int end) {
		System.out.println(curr);
		for (int i = 0; i < 10; i++) {
			if (curr * 10 + i <= end) {
				printLexico(curr * 10 + i, end);
			}
		}

		if (curr < 9) {
			printLexico(curr + 1, end);
		}
	}

}
