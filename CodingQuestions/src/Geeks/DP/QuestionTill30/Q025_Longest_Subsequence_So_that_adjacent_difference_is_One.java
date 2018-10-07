package Geeks.DP;

import java.util.Scanner;

public class Q025_Longest_Subsequence_So_that_adjacent_difference_is_One {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int arr[] = { 1, 2, 3, 4, 5, 3, 2 };
		LSWADone(arr);
	}

	private static void LSWADone(int[] arr) {
		int[] dp = new int[arr.length + 1];
		dp[0] = 1;
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (Math.abs(arr[i] - arr[j]) == 1) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);

	}
}
