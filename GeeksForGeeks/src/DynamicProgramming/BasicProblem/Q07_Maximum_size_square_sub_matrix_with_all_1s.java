package DynamicProgramming.BasicProblem;

public class Q07_Maximum_size_square_sub_matrix_with_all_1s {

	public static void main(String[] args) {
		int[][] arr = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		subMatrix(arr);
	}

	public static void display(int[][] arr) {
		for (int[] i : arr) {
			for (int j : i) {
				System.out.print(j + ",");
			}
			System.out.println();
		}
	}

	public static void subMatrix(int[][] arr) {
		int lr = arr.length;
		int lc = arr[0].length;
		int[][] sumarr = new int[lr][lc];

		for (int i = 0; i < lc; i++) { // Set_first_row
			sumarr[0][i] = arr[0][i];
		}

		for (int i = 0; i < lr; i++) {// set_first_column
			sumarr[i][0] = arr[i][0];
		}

		for (int row = 1; row < lr; row++) {
			for (int col = 1; col < lc; col++) {
				if (arr[row][col] == 1) {
					int min = Math.min(sumarr[row - 1][col - 1], Math.min(sumarr[row - 1][col], sumarr[row][col - 1]));
					sumarr[row][col] = min + 1; // min_of_cell_left_or_cell_upper_and_upper_cell_diagonal_135.
				}
			}
		}

		int mn = sumarr[0][0], mr = 0, mc = 0;
		for (int row = 0; row < lr; row++) {
			for (int col = 0; col < lc; col++) {
				if (sumarr[row][col] > mn) {
					mn = sumarr[row][col];
					mr = row;
					mc = col;
				}
			}
		}

		for (int i = mr; i > mr - mn; i--) {
			for (int j = mc; j > mc - mn; j--) {
				System.out.print(arr[i][j]+",");
			}

			System.out.println();
		}
	}

}
