package Geeks.DP;

import java.util.Scanner;

public class Q013_Printing_knapSack_01 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] weight = { 2, 3, 3, 1, 4, 3 };
		int[] cost = { 40, 30, 20, 30, 10, 50 };
		int cap = 7;

		 Pair pair = PrintingKanpSack_Rec(weight, cost, cap, 0);
		 System.out.println(pair.Psf + "\n" + pair.Wsf + "\n" + pair.ans);

		PrintKanpSack(weight, cost, cap);

	}

	private static class Pair implements Comparable<Pair> {
		private String Wsf;
		private String Psf;
		private int ans = 0;

		public Pair(String Wsf, String Psf, int ans) {
			this.Wsf = Wsf;
			this.Psf = Psf;
			this.ans = ans;
		}

		@Override
		public int compareTo(Pair o) {
			return this.ans - o.ans;
		}

	}

	private static Pair PrintingKanpSack_Rec(int[] weight, int[] cost, int cap, int vidx) {
		if (vidx == cost.length || cap == 0) {
			return new Pair("", "", 0);
		}

		Pair Coming = new Pair("", "", 0);

		if ((cap - weight[vidx]) >= 0) {
			Coming = PrintingKanpSack_Rec(weight, cost, cap - weight[vidx], vidx + 1);

			Coming.ans += cost[vidx];
			Coming.Psf += cost[vidx] + " ";
			Coming.Wsf += weight[vidx] + " ";
		}
		Pair NotComing = PrintingKanpSack_Rec(weight, cost, cap, vidx + 1);

		if (Coming.compareTo(NotComing) >= 0) {
			return Coming;
		} else {
			return NotComing;
		}
	}

	private static void PrintKanpSack(int[] weight, int[] cost, int cap) {

		int[][] dp = new int[weight.length + 1][cap + 1];

		for (int i = 0; i < dp.length; i++) { // Weight Loop
			for (int j = 0; j < dp[0].length; j++) { // Cap Loop
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					int NotComingCost = dp[i - 1][j];
					int ComingCost = 0;

					if (j - weight[i - 1] >= 0) {
						ComingCost = cost[i - 1] + dp[i - 1][j - weight[i - 1]];
					}

					dp[i][j] = Math.max(ComingCost, NotComingCost);

				}

			}
		}

		int res = dp[weight.length][cap];
		// System.out.println(res);

		int j = cap;
		for (int i = dp.length; i > 0 || res > 0; i--) {

			int NotComing = dp[i - 1][j];
			if (res == NotComing) {
				continue;
			} else {
				System.out.print(weight[i-1] + " ");
				res -= cost[i - 1];
				j-=weight[i-1];
				
			}

		}

	}
}