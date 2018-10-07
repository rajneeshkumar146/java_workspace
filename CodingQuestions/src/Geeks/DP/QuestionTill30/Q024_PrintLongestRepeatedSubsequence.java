package Geeks.DP.QuestionTill30;

import java.util.Scanner;

public class Q024_PrintLongestRepeatedSubsequence {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		String str = "AABEBCDD";
		int[][] dp = LRS(str);
		LRS_Print(dp, str);

	}

	private static int[][] LRS(String str) {
		int[][] dp = new int[str.length() + 1][str.length() + 1];

		for (int i = 1; i <= str.length(); i++) {
			for (int j = 1; j <= str.length(); j++) {
				if (str.charAt(i - 1) == str.charAt(j-1) && i != j) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp;
	}

	private static void LRS_Print(int[][] dp, String str) {

		String res = "";

		int i = str.length();
		int j = str.length();
		while (i > 0 && j > 0) {

			if (dp[i][j] == dp[i - 1][j - 1] + 1) {
				res = str.charAt(i-1)+res;
				i--;
				j--;
			} else {
				if (dp[i][j] == dp[i - 1][j]) {
					i--;
				} else {
					j--;
				}
			}

		}

		System.out.println(res);

	}

}
