package DynamicProgramming.BasicProblem;

public class Q09_Min_Cost_Path {

	public static void main(String[] args) {
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		// MinCostDP(cost, 2, 2);
		// System.out.println("minimum cost to reach (2,2) = " + cost[2][2]);
		System.out.println("minimum cost to reach (2,2) = " + MinCostRec_DP(cost, 2, 2));
	}

	public static int MinCostRec(int[][] arr, int er, int ec) {
		return MinCostRec(arr, 0, 0, er, ec, "");

	}

	private static int MinCostRec(int[][] arr, int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans + "(" + cr + "," + cc + ")");
			return arr[er][ec];
		}

		if (cr > er || cc > ec) {
			return Integer.MAX_VALUE;
		}

		int Hpath = MinCostRec(arr, cr, cc + 1, er, ec, ans + "(" + cr + "," + cc + ")=>");
		int vpath = MinCostRec(arr, cr + 1, cc, er, ec, ans + "(" + cr + "," + cc + ")=>");
		int Dpath = MinCostRec(arr, cr + 1, cc + 1, er, ec, ans + "(" + cr + "," + cc + ")=>");

		return arr[cr][cc] + Math.min(vpath, Math.min(Hpath, Dpath));

	}

	public static int MinCostRec_DP(int[][] arr, int er, int ec) {
		return MinCostRec_DP(arr, 0, 0, er, ec, "", new int[er + 1][ec + 1]);
	}

	private static int MinCostRec_DP(int[][] arr, int cr, int cc, int er, int ec, String ans, int[][] strg) {
		if (cr == er && cc == ec) {
			System.out.println(ans + "(" + cr + "," + cc + ")");
			return arr[er][ec];
		}

		if (cr > er || cc > ec) {
			return Integer.MAX_VALUE;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int Hpath = MinCostRec_DP(arr, cr, cc + 1, er, ec, ans + "(" + cr + "," + cc + ")=>", strg);
		int vpath = MinCostRec_DP(arr, cr + 1, cc, er, ec, ans + "(" + cr + "," + cc + ")=>", strg);
		int Dpath = MinCostRec_DP(arr, cr + 1, cc + 1, er, ec, ans + "(" + cr + "," + cc + ")=>", strg);

		strg[cr][cc] = arr[cr][cc] + Math.min(vpath, Math.min(Hpath, Dpath));
		return strg[cr][cc];
	}

	public static void MinCostDP(int[][] arr, int er, int ec) {
		for (int row = 1; row <= er; row++) { // Managing_minimum_cost_path_in_first_row.
			arr[row][0] = arr[row - 1][0] + arr[row][0];
		}

		for (int col = 1; col <= ec; col++) {// Managing_minimum_cost_path_in_first_col.
			arr[0][col] = arr[0][col - 1] + arr[0][col];
		}

		for (int row = 1; row <= er; row++) {// Managing_minimum_cost_path_in_rest_subarray.
			for (int col = 1; col <= ec; col++) {
				arr[row][col] = arr[row][col]
						+ Math.min(arr[row - 1][col], Math.min(arr[row][col - 1], arr[row - 1][col - 1]));

			}
		}
	}

}
