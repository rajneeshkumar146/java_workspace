package Geeks.DP.QuestionTill30;

import java.util.Scanner;

public class Q021_LongestCommonSubsequunece {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";

		System.out.println(LCS_Rec(str1, str2, 0, 0, new int[str1.length()][str2.length()]));
		System.out.println(LCS(str1, str2));

	}

	private static int LCS_Rec(String str1, String str2, int i, int j, int[][] strg) {
		if (i == str1.length() || j == str2.length())
			return 0;

		if (strg[i][j] != 0) {
			return strg[i][j];
		}

		char ch1 = str1.charAt(i);
		char ch2 = str2.charAt(j);

		if (ch1 == ch2) {
			strg[i][j] = LCS_Rec(str1, str2, i + 1, j + 1, strg) + 1;
		} else {
			int one = LCS_Rec(str1, str2, i + 1, j, strg);
			int two = LCS_Rec(str1, str2, i, j + 1, strg);

			strg[i][j] = Math.max(one, two);
		}

		return strg[i][j];

	}

	private static int LCS(String str1, String str2) {

		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[str1.length()][str2.length()];

	}

}
