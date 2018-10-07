package Geeks.DP.QuestionTill30;

import java.util.Scanner;

public class Q022_PrintLongestCommonSubsequence {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";

		LCSPrint(str1, str2);
	}

	private static int[][] LCS(String str1, String str2) {
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 1; i <= str1.length(); i++) {
			char ch1 = str1.charAt(i - 1);
			for (int j = 1; j <= str2.length(); j++) {
				char ch2 = str2.charAt(j - 1);

				if (ch1 == ch2) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		// for (int[] ar : dp) {
		// for (int val : ar) {
		// System.out.print(val + " ");
		// }
		// System.out.println();
		// }

		return dp;
	}

	private static void LCSPrint(String str1, String str2) {

		int[][] dp = LCS(str1, str2);
		int i = dp.length - 1;
		int j = dp[0].length - 1;
		StringBuilder ans = new StringBuilder();
		while (i > 0) {
			if (dp[i - 1][j - 1] + 1 == dp[i][j]) {
				ans.append(str1.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i - 1][j] == dp[i][j]) {
				i--;
			} else {
				j--;
			}
		}

		System.out.println(ans.toString());

	}

}
