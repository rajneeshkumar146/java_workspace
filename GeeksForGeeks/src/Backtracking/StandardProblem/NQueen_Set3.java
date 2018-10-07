package Backtracking.StandardProblem;

public class NQueen_Set3 {

	public static void main(String[] args) {
		boolean[][] arr = new boolean[4][4];
		Nqueen(arr, 0, "");

	}

	public static void Nqueen(boolean[][] arr, int row, String nqsf) {
		if (row == arr.length) {
			System.out.println(nqsf);
			return;
		}

		for (int col = 0; col < arr[0].length; col++) {
			if (CheckSafe(arr, row, col) == true) {
				arr[row][col] = true;
				Nqueen(arr, row + 1, nqsf + "[" + row + "-" + col + "]");
				arr[row][col] = false;
			}
		}

	}

	private static boolean CheckSafe(boolean[][] arr, int row, int col) {

		for (int r = row, c = col; r >= 0 && c < arr[0].length; r--, c++) { // Check_Upper_diagonal_on_Right_side.
			if (arr[r][c] == true) {
				return false;
			}
		}

		for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) { // Check_Upper_diagonal_on_left_side.
			if (arr[r][c] == true) {
				return false;
			}
		}

		for (int r = row; r >= 0; r--) { // Check_this_col_on_upper_side.
			if (arr[r][col] == true) {
				return false;
			}
		}

		return true;
	}

}
