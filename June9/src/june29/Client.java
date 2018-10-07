package june29;

public class Client {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		boolean[][] board = new boolean[3][3];
		// printnqueensproactive(board, 0, "", 0);
		printnknightsboxchoices(board, 0, 1, "");
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

	static int counter = 0;

	private static void printnqueens(boolean[][] board, int qpsf, String csf, int lqpc) {
		if (qpsf == board.length) {
			counter++;
			if (isTheBoardSafe(board)) {
				System.out.println(counter + ". " + csf);
			}
			return;
		}

		for (int i = lqpc + 1; i <= board.length * board.length; i++) {
			int ir = (i - 1) / board.length;
			int ic = (i - 1) % board.length;

			if (board[ir][ic] == false) {
				board[ir][ic] = true;
				printnqueens(board, qpsf + 1, csf + "->" + i, i);
				board[ir][ic] = false;
			}
		}
	}

	private static void printnqueensproactive(boolean[][] board, int qpsf, String csf, int lqpc) {
		if (qpsf == board.length) {
			counter++;
			System.out.println(counter + ". " + csf);
			return;
		}

		for (int i = lqpc + 1; i <= board.length * board.length; i++) {
			int ir = (i - 1) / board.length;
			int ic = (i - 1) % board.length;

			if (board[ir][ic] == false && isTheQueenSafe(board, ir, ic) == true) {
				board[ir][ic] = true;
				printnqueensproactive(board, qpsf + 1, csf + "->" + i, i);
				board[ir][ic] = false;
			}
		}
	}

	private static void printnqueensboxchoices(boolean[][] board, int qpsf, int cno, String csf) {
		if (qpsf == board.length) {
			counter++;
			System.out.println(counter + ". " + csf);
			return;
		}

		if (cno > board.length * board.length) {
			return;
		}

		printnqueensboxchoices(board, qpsf, cno + 1, csf);

		int r = (cno - 1) / board.length;
		int c = (cno - 1) % board.length;
		if (board[r][c] == false && isTheQueenSafe(board, r, c) == true) {
			board[r][c] = true;
			printnqueensboxchoices(board, qpsf + 1, cno + 1, csf + " " + cno);
			board[r][c] = false;
		}
	}

	private static void printnknightsboxchoices(boolean[][] board, int qpsf, int cno, String csf) {
		if (qpsf == board.length) {
			counter++;
			System.out.println(counter + ". " + csf);
			return;
		}

		if (cno > board.length * board.length) {
			return;
		}

		printnknightsboxchoices(board, qpsf, cno + 1, csf);

		int r = (cno - 1) / board.length;
		int c = (cno - 1) % board.length;
		if (board[r][c] == false && isTheKnightSafe(board, r, c) == true) {
			board[r][c] = true;
			printnknightsboxchoices(board, qpsf + 1, cno + 1, csf + " " + cno);
			board[r][c] = false;
		}
	}

	private static boolean isTheBoardSafe(boolean[][] board) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board.length; c++) {
				if (board[r][c] == true) { // does the cell have a queen
					if (isTheQueenSafe(board, r, c) == false) {
						return false;
					}
				}
			}
		}

		return true;
	}

	private static boolean isTheQueenSafe(boolean[][] board, int r, int c) {
		int[][] dirs = { { -1, 0 }, // north
				{ -1, +1 }, // ne
				{ 0, +1 }, // e
				{ +1, +1 }, // se
				{ +1, 0 }, // s
				{ +1, -1 }, // sw
				{ 0, -1 }, // w
				{ -1, -1 } // nw
		};

		for (int rad = 1; rad < board.length; rad++) {
			for (int dir = 0; dir < dirs.length; dir++) {
				int renemy = r + rad * dirs[dir][0];
				int cenemy = c + rad * dirs[dir][1];

				if (renemy >= 0 && renemy < board.length && cenemy >= 0 && cenemy < board.length
						&& board[renemy][cenemy] == true) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean isTheKnightSafe(boolean[][] board, int r, int c) {
		int[][] dirs = { { -1, 2 }, // north
				{ -1, -2 }, // ne
				{ -2, +1 }, // e
				{ -2, -1 }, // se
				{ 1, 2 }, // s
				{ +1, -2 }, // sw
				{ 2, 1 }, // w
				{ 2, -1 } // nw
		};

		for (int dir = 0; dir < dirs.length; dir++) {
			int renemy = r + dirs[dir][0];
			int cenemy = c + dirs[dir][1];

			if (renemy >= 0 && renemy < board.length && cenemy >= 0 && cenemy < board.length
					&& board[renemy][cenemy] == true) {
				return false;
			}
		}

		return true;
	}

}
