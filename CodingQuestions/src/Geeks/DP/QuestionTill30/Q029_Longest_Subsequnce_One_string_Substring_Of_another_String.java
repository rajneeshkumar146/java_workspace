package Geeks.DP.QuestionTill30;

import java.util.Scanner;

public class Q029_Longest_Subsequnce_One_string_Substring_Of_another_String {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		Function("ABCD", "BACDBDCD");
	}

	private static int Function_rec(String str1, String str2, int i, int j) {

		return 0;
	}

	private static void Function(String str1, String str2) {
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		int max = 0;
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(max);
	}

}
