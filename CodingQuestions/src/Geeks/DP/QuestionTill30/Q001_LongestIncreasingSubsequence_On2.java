package Geeks.DP.QuestionTill30;

import java.util.Scanner;

public class Q001_LongestIncreasingSubsequence_On2 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		// 10 10 22 9 33 21 50 41 60 45 1
		int[] arr = ArrayInput(scn.nextInt());

		int ans = LIS(arr);
		System.out.println(ans);

		int ans_r = LIS_Rec(arr, arr.length);
		System.out.println(ans_r);
	}

	private static class Pair {
		private int max = 0;
	}

	public static int LIS_Rec(int[] arr, int vidx) {
		Pair pair = new Pair();
		LIS_helper(arr, vidx, pair, new int[arr.length + 1]);

		return pair.max;
	}

	private static int LIS_helper(int[] arr, int vidx, Pair pair, int[] dp) {

		if (vidx == 0) {
			return 1;
		}

		if (dp[vidx] != 0) {
			return dp[vidx];
		}

		int max = 1;
		for (int i = 1; i < vidx; i++) {
			int res = LIS_helper(arr, i, pair, dp);
			if (arr[vidx - 1] > arr[i - 1]) {
				max = Math.max(max, res + 1);
			}
		}

		pair.max = Math.max(pair.max, max);

		dp[vidx] = max;

		return max;

	}

	// DP.==============================================================================================

	private static int LIS(int[] arr) {
		int[] dp = new int[arr.length];

		dp[0] = 1;
		int overAllMax = 1;
		for (int i = 1; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

			overAllMax = Math.max(dp[i], overAllMax);
		}

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
