package Class_11th_recursion_3;

public class N_queen {

	public static void main(String[] args) {
		boolean[][] arr = new boolean[4][4];
		n_queen(arr, 0, "");

	}

	public static void n_queen(boolean[][] arr, int row, String nqsf) { // nqsf=number_of_queen_so_far.
		if (row == arr.length) {
			System.out.println(nqsf);
			return;
		}

		for (int col = 0; col < arr[0].length; col++) {
			if (checksafe(arr, row, col) == true) {
				arr[row][col] = true;
				n_queen(arr, row + 1, nqsf + "[" + row + "-" + col + "]");
				arr[row][col] = false;
			}

		}

	}

	public static boolean checksafe(boolean[][] arr, int row, int col) {

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

		for (int i = row; i >= 0; i--) {// Check_this_col_on_upper_side.
			if (arr[i][col] == true) {
				return false;

			}

		}
		return true;

	}

}
