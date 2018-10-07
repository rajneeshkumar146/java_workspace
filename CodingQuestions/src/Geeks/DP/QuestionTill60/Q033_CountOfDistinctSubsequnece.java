package Geeks.DP.QuestionTill60;

import java.util.Scanner;

public class Q033_CountOfDistinctSubsequnece {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		System.out.println(countDistinctSubse_rec("gfg", new int[26], 0));
		System.out.println(countDistinctSubse("gfg"));

	}

	private static int countDistinctSubse_rec(String str, int[] freqmap, int vidx) {
		if (str.length() == vidx) {
			return 1;
		}
		char ch = str.charAt(vidx);

		int count = 2 * countDistinctSubse_rec(str, freqmap, vidx + 1) - (freqmap[ch - 'a']);
		freqmap[ch - 'a']++;

		return count;

	}

	private static int countDistinctSubse(String str) {
		int[] freqMap = new int[26];
		int count = 1;
		for (int i = 0; i < str.length(); i++) {

			count = 2 * count - freqMap[str.charAt(i) - 'a'];
			freqMap[str.charAt(i) - 'a']++;
		}

		return count;

	}

}
