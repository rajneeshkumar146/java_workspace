package Geeks.DP;

import java.util.Scanner;

public class Q014_UnboundedKnapSack {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		// int[] weight = { 2, 3, 3, 1, 4, 3 };
		// int[] cost = { 40, 30, 20, 30, 10, 50 };
		// int cap = 7;

		// int[] weight = { 1, 50 };
		// int[] cost = { 1, 30 };
		// int cap = 100;

		int[] weight = { 1, 3, 4, 5 };
		int[] cost = { 10, 40, 50, 70 };
		int cap = 8;

		System.out.println(UnboundedKnapSack(cost, weight, cap, 0,new int[weight.length+1][cap+1]));
		System.out.println(UnboundedKnapSack_DP(weight, cost, cap));

	}

	private static int UnboundedKnapSack(int[] cost, int[] weight, int cap, int vidx, int[][] strg) {

		if (vidx == cost.length || cap == 0) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		int ComingCost = 0;
		if (cap - weight[vidx] >= 0) {
			ComingCost = cost[vidx] + UnboundedKnapSack(cost, weight, cap - weight[vidx], vidx, strg);
		}
		int NotComingCost = UnboundedKnapSack(cost, weight, cap, vidx + 1, strg);

		int ans = Math.max(ComingCost, NotComingCost);

		strg[vidx][cap] = ans;
		return ans;

	}

	private static int UnboundedKnapSack_DP(int[] weight, int[] cost, int cap) {

		int[] dp = new int[cap + 1];

		// Comination_and_permutation_give_same_answer.
		dp[0] = 0;
		for (int i = 1; i <= cap; i++) {
			dp[i] = 0;
			int ans = 0;
			for (int j = 0; j < weight.length; j++) {
				if ((i - weight[j]) >= 0) {
					ans = Math.max(dp[i - weight[j]] + cost[j], ans);
				}
			}

			dp[i] = ans;
		}

		return dp[cap];
	}

}