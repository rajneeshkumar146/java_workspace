package Geeks.DP;

import java.util.Scanner;

public class Q016_MinJumps {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println(MinJumps(arr, 0, arr.length - 1));
		System.out.println(MinJumpsDp(arr));
	}

	private static int MinJumps(int[] arr, int start, int end) {
		if (start == end) {
			return 0;
		}

		if (arr[start] == 0) {
			return Integer.MAX_VALUE;
		}

		int min = Integer.MAX_VALUE;
		for (int i = start + 1; i <= start + arr[start] && i <= end; i++) {
			int rec_min = MinJumps(arr, i, end);

			if (rec_min != Integer.MAX_VALUE && rec_min + 1 < min) {
				min = rec_min + 1;
			}
		}

		return min;
	}

	private static int MinJumpsDp(int[] arr) {
		int[] dp = new int[arr.length];

		dp[arr.length - 1] = 0;
		for (int i = arr.length - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			if (arr[i] == 0) {
				dp[i] = Integer.MAX_VALUE;
				continue;
			}

			for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
				min = Math.min(dp[j], min);
			}
			dp[i] = min != Integer.MAX_VALUE ? min + 1 : Integer.MAX_VALUE;
		}

		return dp[0];

	}

}