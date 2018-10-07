package DynamicProgramming;

import java.util.Scanner;

public class Q214_waysToTilesTheFloor {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		// 7 4
		int n = scn.nextInt();
		int m = scn.nextInt();

		int ans = TilesTheFloor(n, m);
		System.out.println(ans);

		int ans1 = TilesTheFloor_Memo(n, m, new int[n + 1]);
		System.out.println(ans1);

		int ans2 = TilesTheFloorDP(n, m);
		System.out.println(ans2);

	}

	private static int TilesTheFloor(int n, int m) {
		if (n == m) {
			return 2;
		}

		if (n < m) {
			return 1;
		}

		int x = TilesTheFloor(n - m, m);
		int y = TilesTheFloor(n - 1, m);

		return x + y;

	}

	private static int TilesTheFloor_Memo(int n, int m, int[] dp) {
		if (n == m) {
			return 2;
		}

		if (n < m) {
			return 1;
		}

		if (dp[n] != 0) {
			return dp[n];
		}

		int x = TilesTheFloor_Memo(n - m, m, dp);
		int y = TilesTheFloor_Memo(n - 1, m, dp);

		dp[n] = x + y;

		return x + y;

	}

	private static int TilesTheFloorDP(int n, int m) {
		int[] dp = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			if (i < m) {
				dp[i] = 1;
			} else if (i == m) {
				dp[i] = 2;
			} else {
				dp[i] = dp[i - 1] + dp[i - m];
			}
		}

		return dp[n];
	}

}
