package Geeks.DP.QuestionTill60;

import java.util.Scanner;

public class Q031_ShortestUncommonSubsequence {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		String str1 = "babab";
		String str2 = "babba";

		int[] map = FreqMapOfString(str2);

		for (int i = 0; i < str1.length(); i++) {
			if (map[str1.charAt(i) - 'a'] == 0) {
				System.out.println(1);
				return;
			}
		}

		System.out.println(ShortestUnCommonSubsequnece(str1, str2, 0, 0, new int[str1.length()][str2.length()]));

	}

	private static int[] FreqMapOfString(String str) {
		int[] map = new int[26];

		char ch = 'a';
		for (int i = 0; i < str.length(); i++) {

			int index = str.charAt(i) - ch;
			map[index]++;
		}

		return map;
	}

	private static int ShortestUnCommonSubsequnece(String str1, String str2, int oneidx, int twoidx, int[][] dp) {
		if (oneidx == str1.length()) {
			return (int) 1e9;
		}

		if (twoidx == str2.length()) {
			return 1;
		}

		if (dp[oneidx][twoidx] != 0) {
			return dp[oneidx][twoidx];
		}

		int idx = -1;
		for (int i = twoidx; i < str2.length(); i++) {
			if (str2.charAt(i) == str1.charAt(oneidx)) {
				idx = i;
				break;
			}
		}

		int NotComming = ShortestUnCommonSubsequnece(str1, str2, oneidx + 1, twoidx, dp);
		int Comming = 1 + ShortestUnCommonSubsequnece(str1, str2, oneidx + 1, idx + 1, dp);

		dp[oneidx][twoidx] = Math.min(NotComming, Comming);
		return dp[oneidx][twoidx];
	}

}
