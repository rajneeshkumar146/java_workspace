package DynamicProgramming;

import java.util.Scanner;

public class Q226_KnapSack {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] weight = { 2, 3, 3, 1, 4, 3 };
		int[] cost = { 40, 30, 20, 30, 10, 50 };
		int cap = 7;

		System.out.println(KnapSack0and1(weight, cost, cap));
		System.out.println(KnapSack0and1_Rec(weight, cost, cap, 0));

	}

	private static int KnapSack0and1(int[] weight, int[] cost, int cap) {
		int[][] dp = new int[weight.length + 1][cap + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				int NotComingCost = dp[i - 1][j];
				int ComingCost = (j - weight[i - 1]) >= 0 ? cost[i - 1] + dp[i - 1][j - weight[i - 1]] : 0;

				dp[i][j] = Math.max(NotComingCost, ComingCost);
			}
		}

		return dp[dp.length - 1][dp.length - 1];
	}

	private static int KnapSack0and1_Rec(int[] weight, int[] cost, int cap, int vidx) {

		if (vidx == cost.length || cap == 0) {
			return 0;
		}

		int NotComingCost = KnapSack0and1_Rec(weight, cost, cap, vidx + 1);
		int ComingCost = 0;

		if (cap - weight[vidx] >= 0) {
			ComingCost = KnapSack0and1_Rec(weight, cost, cap - weight[vidx], vidx + 1);
		}

		return Math.max(NotComingCost, ComingCost);
	}

	private static int UnboundedKnapSack_Rec(int[] weight, int[] cost, int cap, int vidx, int[][] strg) {
		if (vidx == cost.length || cap == 0) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		int notComingCost = UnboundedKnapSack_Rec(weight, cost, cap, vidx + 1, strg);
		int comingCost = 0;
		if (cap - weight[vidx] >= 0) {
			comingCost = cost[vidx] + UnboundedKnapSack_Rec(weight, cost, cap - weight[vidx], vidx + 1, strg);
		}

		strg[vidx][cap] = Math.max(notComingCost, comingCost);
		return strg[vidx][cap];

	}

	private static void UnboundedKanpSack_DP(int[] weight, int[] cost, int cap) {
		int[] dp = new int[cap + 1];

		dp[0] = 0;
		for (int i = 1; i <= cap; i++) {
			dp[i] = 0;
			int max = (int) 1e9;
			for (int j = 0; j < weight.length; j++) {
				if ((i - weight[j]) >= 0) {
					max = Math.max(dp[i - weight[j]] + cost[j], max);
				}
			}
			dp[i] = max;
		}
	}
}
