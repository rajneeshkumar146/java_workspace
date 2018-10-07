package Backtracking.StandardProblem;

public class Sudoku_set7 {

	public static void main(String[] args) {
		int[][] arr = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		sudoku(arr);
		display(arr);

	}

	private static void display(int[][] arr) {
		for (int[] ra : arr) {
			System.out.print("|");
			for (int i : ra) {
				System.out.print(i + ",");
			}
			System.out.println("|");

		}
	}

	public static boolean sudoku(int[][] arr) {
		int[] ra = UnAssignedCell(arr);

		if (ra[0] == -1) {
			return true;
		}
		int row = ra[0];
		int col = ra[1];
		for (int num = 1; num <= 9; num++) {  // consider_digits_1to9.
			if (checksafe(arr, row, col, num)) { // if_looks_promising
				arr[row][col] = num;  // make_tentative_assignment
				boolean check = sudoku(arr);
				if (check == true) {
					return true;// return,_if_success,_yay!
				}
				arr[row][col] = 0;  // failure, unmake & try again
			}
		}

		return false;// this triggers backtracking

	}

	private static int[] UnAssignedCell(int[][] arr) {//Search_for_first_come_zero_in_the_2D_searching.
		int[] ra = new int[2];
		ra[0] = -1;
		ra[1] = -1;
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (arr[row][col] == 0) {
					ra[0] = row;
					ra[1] = col;
					return ra;
				}
			}
		}

		return ra;
	}

	private static boolean checksafe(int[][] arr, int row, int col, int num) {//if_that_number_is_not_found_in_cell_then_return_true.
		return (!PresentInRow(arr, row, num) && !PresentInCol(arr, col, num)
				&& !PresentInSmallerMatrix(arr, row - row % 3, col - col % 3, num));
	}

	private static boolean PresentInRow(int[][] arr, int row, int num) {//Search_that_number_in_row.
		for (int col = 0; col < arr[0].length; col++) {
			if (arr[row][col] == num) {
				return true;
			}
		}

		return false;
	}

	private static boolean PresentInCol(int[][] arr, int col, int num) {//search _that_number_int_col.
		for (int row = 0; row < arr.length; row++) {
			if (arr[row][col] == num) {
				return true;
			}
		}

		return false;
	}

	private static boolean PresentInSmallerMatrix(int[][] arr, int row, int col, int num) { //Search_that_number_in_matrix.
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (arr[r + row][c + col] == num) {
					return true;
				}
			}
		}

		return false;

	}


}
