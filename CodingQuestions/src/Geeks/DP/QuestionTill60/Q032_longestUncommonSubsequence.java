package Geeks.DP.QuestionTill60;

import java.util.Scanner;

public class Q032_longestUncommonSubsequence {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		longestUncommonsubsequnece("abc", "abd");
	}

	private static int longestUncommonsubsequnece(String str1, String str2) {

		if (str1.length() != str2.length()) {
			return Math.max(str1.length(), str2.length());
		}

		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return str1.length();
			}
		}

		return -1;

	}

}
