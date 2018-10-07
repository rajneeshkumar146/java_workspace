package Geeks.DP;

import java.util.Scanner;

public class Q007_LongestPalindromicSubsequence {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		// geeksskeeg
		String str = scn.next();
		System.out.println(LPS_DP(str));
	}

	private static int LPS_DP(String str) {
		int[][] dp = new int[str.length()][str.length()];

		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = gap + i; i < str.length() && j < str.length(); j++, i++) {
				if (i == j) {
					dp[i][j] = 1;
				} else if (str.charAt(gap + i) == str.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
			}
		}
		displayMatrix(dp);
		return dp[0][str.length() - 1];

	}

	private static void displayMatrix(int[][] arr) {
		for (int[] i : arr) {
			for (int el : i) {
				System.out.print(el + " ");
			}
			System.out.println();
		}
	}
}
