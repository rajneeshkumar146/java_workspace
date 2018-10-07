package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Q230_PrintTargetSum {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		// int[] arr = { 2, 3, 5, 6, 8, 10 };
		// int target = 10;
		int[] arr = { 1, 2, 3, 4, 5 };
		int target = 10;

		boolean[][] dp = PrintTargetSum__DpCreation(arr, target);

		 PrintTargetSumWithResult(arr, target);

		PrintTargetSum_UsingDP_rec(dp, arr, dp.length - 1, dp[0].length-1, "");
	}

	private static boolean[][] PrintTargetSum__DpCreation(int[] arr, int target) {
		boolean[][] dp = new boolean[arr.length + 1][target + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j == 0) { // jb_vo_nahi_ayega_to_zero_sum_to_bnaHi_dega.
					dp[i][j] = true;
				} else if (i == 0) { // jb_element_hi_zero_hai_to_ake_bhi_kuch_nahi_Nahi_bna_skta.
					dp[i][j] = false;
				} else {

					dp[i][j] = dp[i - 1][j] || ((j - arr[i - 1]) < 0 ? false : dp[i - 1][j - arr[i - 1]]);
				}
			}
		}

		// displayMatrix(dp);
		return dp;
	}

	private static void PrintTargetSumWithResult(int[] arr, int target) {
		boolean[][] dp = new boolean[arr.length + 1][target + 1];
		ArrayList<String>[][] result = new ArrayList[arr.length + 1][target + 1];

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j == 0) { // jb_vo_nahi_ayega_to_zero_sum_to_bnaHi_dega.
					dp[i][j] = true;
					result[i][j].add("");
				} else if (i == 0) { // jb_element_hi_zero_hai_to_ake_bhi_kuch_nahi_Nahi_bna_skta.
					dp[i][j] = false;
				} else {
					if (dp[i - 1][j]) { // Not_coming.
						dp[i][j] = true;
						result[i][j].addAll(result[i - 1][j]);
					}

					if (j - arr[i - 1] >= 0) {
						if (dp[i - 1][j - arr[i - 1]]) { // AgreeTocome.
							dp[i][j] = true;

							for (String res : result[i - 1][j - arr[i - 1]]) {
								result[i][j].add(arr[i - 1] + " " + res);
							}
						}
					}

				}
			}
		}

		System.out.println(result[arr.length][target]);

		// displayMatrix(dp);
	}

	private static void PrintTargetSum_UsingDP_rec(boolean[][] dp, int[] arr, int i, int j, String ans) {
		if (i < 0 || j < 0) {
			return;
		}

		if (i == 0 && j == 0) {
			System.out.println(ans);
			return;
		}

		if ( dp[i - 1][j]) {
			PrintTargetSum_UsingDP_rec(dp, arr, i - 1, j, ans);
		}
		if ((j - arr[i - 1]) >= 0 && dp[i - 1][j - arr[i - 1]]) {
			PrintTargetSum_UsingDP_rec(dp, arr, i - 1, j - arr[i - 1], arr[i - 1] + ans);
		}

	}

	private static void displayMatrix(boolean[][] arr) {
		for (boolean[] i : arr) {
			for (boolean el : i) {
				System.out.print(el + " ");
			}
			System.out.println();
		}
	}

}
