package Geeks.DP;

import java.util.Scanner;

public class Q026_LongestCommonSubstring {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		LCSS("GEEKSFORGEEKS", "GEEKS");
	}

	private static void LCSS(String str1, String str2) {
		int dp[][] = new int[str1.length() + 1][str2.length() + 1];

		int max = 0;
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);

				}
			}
		}

		System.out.print(max);
	}

}
