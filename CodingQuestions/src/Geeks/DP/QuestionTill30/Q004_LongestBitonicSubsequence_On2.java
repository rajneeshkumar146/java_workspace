package Geeks.DP.QuestionTill30;

import java.util.Scanner;

public class Q004_LongestBitonicSubsequence_On2 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		// 10 10 22 9 33 21 50 41 60 45 1
		int[] arr = ArrayInput(scn.nextInt());

		System.out.println(LBS(arr));
	}

	private static int LBS(int[] arr) {
		int[] LIS = LIS(arr);
		int[] LDS = LDS(arr);

		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, LIS[i] + LDS[i] - 1);
		}

		return max;
	}

	private static int[] LIS(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				} else {
					dp[i] = 1;
				}
			}
		}

		return dp;
	}

	private static int[] LDS(int[] arr) {
		int[] dp = new int[arr.length];
		dp[arr.length - 1] = 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				} else {
					dp[i] = 1;
				}
			}
		}

		return dp;
	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

}
