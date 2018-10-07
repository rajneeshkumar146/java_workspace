package Geeks.DP;

import java.util.Scanner;

public class Q030_NumberOfTimeStringOneoccursInString2 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		String str1 = "GeeksforGeeks";
		String str2 = "Gks";
		System.out.println(Occurence_rec(str1, str2, str1.length(), str2.length()));
		System.out.println(Occurence_DP(str1, str2));

	}

	private static int Occurence_rec(String str1, String str2, int i, int j) {
		if (i == 0 && j == 0 || j == 0) { // Empty_String_Also_A_Possible_subsequence.
			return 1;
		}

		if (i == 0) {
			return 0;
		}

		if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
			int contributed = Occurence_rec(str1, str2, i - 1, j - 1);
			int NotContributed = Occurence_rec(str1, str2, i - 1, j);

			return contributed + NotContributed;
		} else {
			return Occurence_rec(str1, str2, i - 1, j);
		}
	}

	private static int Occurence_DP(String str1, String str2) {
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int j = str2.length(); j >= 0; j--) { // if_String1_is_Empty_Then_How_May_ways_string2_occurs_init_zero.
			dp[str1.length()][j] = 0;
		}

		for (int i = str1.length(); i >= 0; i--) { // if_String2_is_Empty_Then_it's_only_1_subsequnece_occurs_init_in_one_way_only_.
			dp[i][str2.length()] = 1;
		}

		for (int i = str1.length() - 1; i >= 0; i--) {
			for (int j = str2.length() - 1; j >= 0; j--) {
				int notContributed = dp[i + 1][j];

				if (str1.charAt(i) == str2.charAt(j)) {
					int contributed = dp[i + 1][j + 1];
					dp[i][j] = contributed + notContributed;
				} else {
					dp[i][j] = notContributed;
				}
			}
		}

		return dp[0][0];

	}

}
