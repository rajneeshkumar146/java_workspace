package AssinQ;

public class Nknights {

	public static void main(String[] args) {

		boolean[][] board = new boolean[3][3];
		nknights(1, board, "", 0);

	}

	public static int count = 0;

	public static void nknights(int cellno, boolean[][] board, String config, int kpsf) {
		if (kpsf == board.length) {
			count++;
			System.out.println(count + "." + config);
			return;
		}

		for (int i = cellno; i <= board.length * board.length; i++) {
			int cr = (i - 1) / board.length;
			int cc = (i - 1) % board.length;

			if (isitsaretoplace(cr, cc, board)) {
				board[cr][cc] = true;
				nknights(i + 1, board, config + "[" + cr + "-" + cc + "],", kpsf + 1);
				board[cr][cc] = false;
			}

		}

	}

	private static boolean isitsaretoplace(int cr, int cc, boolean[][] board) {

		if ((cr - 2) >= 0 && (cc - 1) >= 0 && board[cr - 2][cc - 1] == true) {
			return false;
		}

		if (cr - 2 >= 0 && cc + 1 < board.length && board[cr - 2][cc + 1] == true) {
			return false;
		}

		if (cr - 1 >= 0 && cc - 2 >= 0 && board[cr - 1][cc - 2] == true) {
			return false;
		}

		if (cr - 1 >= 0 && cc + 2 < board.length && board[cr - 1][cc + 2] == true) {
			return false;
		}
		return true;
	}

}
