package Geeks.DP;

import java.util.Scanner;

public class Q017_MaximumProductCutting {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int len = 12;
		System.out.println(MaximumProductCutting_Rec(len, new int[len + 1]));
		System.out.println(MaximumProductCutting_dp(len));
		System.out.println(MaximumProductCutting_Trick(len));

	}

	private static int MaximumProductCutting_Rec(int len, int[] strg) {
		if (len <= 1) {
			return 0;
		}

		if (strg[len] != 0) {
			return strg[len];
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= len; i++) {
			int rec_max = MaximumProductCutting_Rec(len - i, strg);
			max = Math.max(max, Math.max(rec_max * i, (len - i) * i));
		}

		strg[len] = max;
		return max;
	}

	private static int MaximumProductCutting_dp(int len) {
		int[] dp = new int[len + 1];

		dp[1] = 1;
		for (int i = 2; i <= len; i++) {
			int max = 0;
			for (int le = 1; le < i; le++) {
				max = Math.max(max, Math.max(le * dp[i - le], le * (i - le)));
			}

			dp[i] = max;
		}

		return dp[len];

	}

	private static int MaximumProductCutting_Trick(int len) {
		if (len <= 1) {
			return 0;
		}

		// The maximum product can be obtained be repeatedly cutting parts of
		// size 3 while size is greater than 4, keeping the last part as size of
		// 2 or 3 or 4.For example, n = 10, the maximum product is obtained by
		// 3, 3, 4. For n = 11, the maximum product is obtained by 3, 3, 3, 2.
		// Following is the implementation of this approach.

		int product = 1;
		while (len > 4) {
			len -= 3;
			product *= 3;
		}

		if (len != 0) {
			product *= len;
		}

		return product;

	}

}
