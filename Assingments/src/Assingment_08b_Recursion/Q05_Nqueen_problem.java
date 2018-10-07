package Assingment_08b_Recursion;

public class Q05_Nqueen_problem {

	public static void main(String[] args) {

		nQueen(new boolean[8][8], 0, "");

	}

	public static void nQueen(boolean[][] arr, int row, String ans) {
		if (row == arr.length) {
			System.out.println(ans);
			return;
		}

		for (int col = 0; col < arr[0].length; col++) {
			if (isitsafe(arr, row, col) == true) {
				arr[row][col] = true;
				nQueen(arr, row + 1, ans + "[" + row + "-" + col + "]");
				arr[row][col] = false;
			}

		}
	}

	public static boolean isitsafe(boolean[][] arr, int row, int col) {

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {// Check_Upper_diagonal_on_left_side.
			if (arr[i][j] == true) {
				return false;
			}

		}

		for (int i = row, j = col; i >= 0 && j < arr[0].length; i--, j++) {// Check_Upper_diagonal_on_Right_side.
			if (arr[i][j] == true) {
				return false;
			}

		}

		for (int i = row, j = col; i >= 0; i--) {// Check_this_col_on_upper_side.
			if (arr[i][j] == true) {
				return false;
			}

		}

		return true;

	}
}
