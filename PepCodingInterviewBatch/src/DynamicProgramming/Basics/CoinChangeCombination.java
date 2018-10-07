package DynamicProgramming.Basics;

import java.util.Scanner;

public class CoinChangeCombination {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();

	}

	public static void solve() throws Exception {

		// 4 2 3 5 6 10
		int[] coin = ArrayInput(scn.nextInt());
		int target = scn.nextInt();

		int ans = CoinChangeCombination(coin, target);
		System.out.println(ans);

//		int ans1 = CoinChangeCombinationRec(coin, target, 0);
//		System.out.println(ans1);

//		int ans2 = CoinChangeCombination_memo(coin, target, 0, new int[coin.length+1]);
//		System.out.println(ans2);

	}

	private static int CoinChangeCombinationRec(int[] coin, int target, int vidx) {
		if (vidx == coin.length || target <= 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		for (int i = vidx; i < coin.length; i++) {
			int infiniteSupply = CoinChangeCombinationRec(coin, target - coin[vidx], vidx);

			max = Math.max(infiniteSupply + 1, max);

		}

		return max;

	}

	private static int CoinChangeCombination_memo(int[] coin, int target, int vidx, int[] dp) {
		if (vidx == coin.length || target <= 0) {
			return 0;
		}

		if (dp[vidx] != 0) {
			return dp[target];
		}

		int max = Integer.MIN_VALUE;
		for (int i = vidx; i < coin.length; i++) {
			int infiniteSupply = CoinChangeCombination_memo(coin, target - coin[vidx], vidx, dp);

			max = Math.max(infiniteSupply + 1, max);

		}

		dp[target] = max;

		return max;

	}

	private static int CoinChangeCombination(int[] coin, int target) {
		int[] dp = new int[target + 1];

		for (int i = 0; i < coin.length; i++) {
			for (int j = coin[i]; j < dp.length; j++) {

				int stepsBackward = j - coin[i];

				dp[j] = Math.max(dp[j], dp[stepsBackward] + 1);

			}
		}

		return dp[target];

	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}
}
