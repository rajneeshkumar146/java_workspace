package Geeks.DP;

import java.util.Scanner;

public class Q015_RodCutting {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int len = 8;

		RodCutting_DP(price, len);
		System.out.println(RodCutting_Rec(price, len, new int[len + 1]));
	}

	private static int RodCutting_Rec(int[] price, int len, int[] strg) {
		if (len <= 0) {
			return 0;
		}

		if (strg[len] != 0) {
			return strg[len];
		}

		int max = price[len - 1];
		for (int i = 0; i < len; i++) {
			int rec_max = price[i] + RodCutting_Rec(price, len - 1 - i, strg);
			max = Math.max(max, rec_max);
		}

		strg[len] = max;

		return max;
	}

	private static void RodCutting_DP(int[] price, int len) {
		int[] dp = new int[len + 1];

		dp[1] = price[0];
		for (int i = 2; i < dp.length; i++) {
			int max = price[i - 1];
			for (int le = 1, ri = i - 1; le <= ri; le++, ri--) {
				max = Math.max(max, dp[le] + dp[ri]);
			}

			dp[i] = max;
		}

		System.out.println(dp[len]);

	}

}
