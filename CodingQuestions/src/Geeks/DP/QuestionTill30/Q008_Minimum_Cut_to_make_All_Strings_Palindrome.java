package Geeks.DP;

import java.util.Scanner;

public class Q008_Minimum_Cut_to_make_All_Strings_Palindrome {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		// abccbc
		String str = scn.next();
		System.out.println(MinimumPalindromicCut_Rec(str, 0, str.length() - 1, new int[str.length()][str.length()]));
		System.out.println(minimumPalindromicCut(str));

	}

	private static int MinimumPalindromicCut_Rec(String str, int st, int en, int[][] strg) {

		if (IsPalindrome(str, st, en)) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		if (strg[st][en] != 0) {
			return strg[st][en];
		}

		for (int cut = st; cut < en; cut++) {

			int lside = MinimumPalindromicCut_Rec(str, st, cut, strg);
			int rside = MinimumPalindromicCut_Rec(str, cut + 1, en, strg);
			min = Math.min(min, lside + rside + 1);
		}

		strg[st][en] = min;

		return min;

	}

	private static boolean IsPalindrome(String str, int st, int en) {
		for (int i = st, j = en; i <= j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}

		return true;
	}

	private static int minimumPalindromicCut(String str) {

		int[][] dp = new int[str.length()][str.length()];
		for (int gap = 1; gap < str.length(); gap++) {
			for (int i = 0, j = gap + i; i < str.length() && j < str.length(); i++, j++) {

				int min = (int) 1e9;
				if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == 0) {
					dp[i][j] = 0;
				} else {
					for (int cut = i; cut < j; cut++) {
						int lside = dp[i][cut];
						int rside = dp[cut + 1][j];
						min = Math.min(min, lside + rside + 1);
					}
					dp[i][j] = min;
				}
			}
		}

		return dp[0][dp[0].length - 1];

	}

}
