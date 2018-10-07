package DynamicProgramming.Basics;

import java.util.Scanner;

public class MatrixChainMultiplication {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();

	}

	public static void solve() {
		// 4 10 20 30 40
		int[] arr = ArrayInput(scn.nextInt());

		int ans = MCM_Rec(arr, 0, arr.length - 1);
		System.out.println(ans);

		int ans1 = MCM_DP(arr);
		System.out.println(ans1);

	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	private static int MCM_Rec(int[] dims, int st, int en) {
		if (st + 1 == en) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int i = st + 1; i < en; i++) { // i_basicaly_a_cut_point.
			int cost1 = MCM_Rec(dims, st, i);
			int cost2 = MCM_Rec(dims, i, en);

			int realMultiplicationCost = dims[st] * dims[en] * dims[i];

			min = Math.min(min, cost1 + cost2 + realMultiplicationCost);

		}

		return min;
	}

	private static int MCM_DP(int[] dims) {

		int[][] dp = new int[dims.length][dims.length];

		for (int gap = 2; gap < dp.length; gap++) {
			for (int i = 0, j = gap + i; j < dp.length && i < dp.length; j++, i++) {
				int min = Integer.MAX_VALUE;
				for (int cut = i + 1; cut < j; cut++) {
					int cost1 = dp[i][cut];
					int cost2 = dp[cut][j];

					int realMultiplicationCost = dims[i] * dims[j] * dims[cut];

					min = Math.min(min, (cost1 + cost2 + realMultiplicationCost));
				}

				dp[i][j] = min;

			}
		}

		return dp[0][dp.length - 1];

	}

}
