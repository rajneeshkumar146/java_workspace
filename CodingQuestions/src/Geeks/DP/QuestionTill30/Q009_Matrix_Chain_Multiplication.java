package Geeks.DP;

import java.util.Scanner;

public class Q009_Matrix_Chain_Multiplication {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();

	}

	public static void solve() {
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		System.out.println(MCM_REC(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println(MCM_DP(arr));
	}

	private static int MCM_DP(int[] dims) {

		int[][] dp = new int[dims.length][dims.length];

		for (int gap = 2; gap < dp.length; gap++) {
			for (int i = 0, j = gap + i; j < dp.length && i < dp.length; i++, j++) {
				int min = Integer.MAX_VALUE;
				for (int cut = i + 1; cut < j; cut++) {
					int lsideCost = dp[i][cut];
					int rsideCost = dp[cut][j];
					int actualCost = dims[i] * dims[cut] * dims[j];
					min = Math.min(min, lsideCost + rsideCost + actualCost);
				}

				dp[i][j] = min;
			}
		}

		return dp[0][dims.length - 1];

	}

	private static int MCM_REC(int[] arr, int st, int en, int[][] strg) {

		if (st + 1 == en) { // one matrix.
			return 0;
		}

		if (strg[st][en] != 0) {
			return strg[st][en];
		}

		int min = Integer.MAX_VALUE;
		for (int cut = st + 1; cut < en; cut++) {

			int lsideCost = MCM_REC(arr, st, cut, strg);
			int rsideCost = MCM_REC(arr, cut, en, strg);

			int ActualCost = arr[st] * arr[cut] * arr[en];
			min = Math.min(min, ActualCost + lsideCost + rsideCost);

		}

		strg[st][en] = min;

		return min;

	}

}
