package Geeks.DP;

import java.util.Scanner;

public class Q006_CoinChangeProblem {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		// 4 2 3 5 6 10
		int[] arr = ArrayInput(scn.nextInt());
		int amount = scn.nextInt();

		System.out.println(CoinChangePermutation(arr, amount));
		System.out.println(CoinChangeCombination(arr, amount));
	}

	private static int CoinChangePermutation(int[] arr, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i - arr[j] >= 0) {
					dp[i] += dp[i - arr[j]];
				}
			}
		}

		return dp[amount];

	}

	private static int CoinChangeCombination(int[] arr, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int j = 0; j < arr.length; j++) {
			for (int i = 1; i < dp.length; i++) {
				if (i - arr[j] >= 0) {
					dp[i] += dp[i - arr[j]];
				}
			}
		}

		return dp[amount];

	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

}
