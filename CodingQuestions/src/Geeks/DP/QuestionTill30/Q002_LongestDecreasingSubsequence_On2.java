package Geeks.DP.QuestionTill30;

import java.util.Scanner;

public class Q002_LongestDecreasingSubsequence_On2 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		// 10 10 22 9 33 21 50 41 60 45 1
		int[] arr = ArrayInput(scn.nextInt());

		int ans = LDS(arr);
		System.out.println(ans);

		System.out.println(LDS_Rec(arr));
	}

	private static class Pair {
		private int max = 0;
	}

	public static int LDS_Rec(int[] arr) {
		Pair pair = new Pair();
		LDS_helper(arr, 0, pair, new int[arr.length]);
		return pair.max;
	}

	private static int LDS_helper(int[] arr, int vidx, Pair pair, int[] dp) {
		if (arr.length == vidx) {
			return 1;
		}
		int max = 1;
		for (int i = vidx + 1; i < arr.length; i++) {
			int res = LDS_helper(arr, i, pair, dp);

			if (arr[vidx] > arr[i]) {
				max = Math.max(max, res + 1);
			}
		}

		pair.max = Math.max(pair.max, max);
		dp[vidx] = max;

		return max;

	}

	// dp.==============================================================================================

	private static int LDS(int[] arr) {
		int[] dp = new int[arr.length];

		dp[arr.length - 1] = 1;
		int overAllMax = 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			dp[i] = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

			overAllMax = Math.max(dp[i], overAllMax);
		}

		// displayArray(dp);

		return overAllMax;

	}

	private static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

}
