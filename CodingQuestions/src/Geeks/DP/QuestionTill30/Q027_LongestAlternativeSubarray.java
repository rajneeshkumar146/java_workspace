package Geeks.DP;

import java.util.Scanner;

public class Q027_LongestAlternativeSubarray {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int arr[] = { -5, -1, -1, 2, -2, -3 };
		LASarray(arr);
	}

	private static void LASarray(int[] arr) {

		int[] dp = new int[arr.length];
		dp[arr.length - 1] = 1;

		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] * arr[i + 1] < 0) {
				dp[i] = dp[i + 1] + 1;
			} else {
				dp[i] = 1;
			}
		}

		for (int val : dp) {
			System.out.print(val + " ");
		}

	}

}
