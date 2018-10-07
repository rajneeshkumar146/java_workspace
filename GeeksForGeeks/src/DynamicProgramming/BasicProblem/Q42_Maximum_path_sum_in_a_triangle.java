package DynamicProgramming.BasicProblem;

public class Q42_Maximum_path_sum_in_a_triangle {

	public static void main(String[] args) {
		int[][] tri = { { 3, 0, 0, 0 }, { 7, 4, 0, 0 }, { 2, 4, 6, 0 }, { 8, 5, 9, 3 } };
		int row = tri.length - 1;
		int col = tri[0].length - 1;
		System.out.println(maxPathSum(tri, row, col));

	}

	private static int maxPathSum(int[][] tri, int m, int n) {
		int[][] arr = new int[m + 1][n + 1];
		arr[0][0] = tri[0][0];
		for (int row = 0; row < m; row++) {
			int col = 0;
			while (col <= row) {
				if (col == 0) {
					arr[row + 1][col] = tri[row + 1][col] + Math.max(arr[row][col], arr[row][col + 1]);
				} else {
					arr[row + 1][col] = tri[row + 1][col]
							+ Math.max(arr[row][col - 1], Math.max(arr[row][col], arr[row][col + 1]));
				}
				col++;
			}

			arr[row + 1][col] = tri[row + 1][col] + arr[row][col - 1];

		}
		int max = arr[m][0];
		for (int i = 1; i < arr[m].length; i++) {
			if (arr[m][i] > max) {
				max = arr[m][i];
			}
		}

		return max;
	}

}
