package DynamicProgramming;

import java.util.Scanner;

public class Q213_numberOfSolutionOfLinearVariable {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int coff[] = { 2, 2, 5 };
		int rhs = 4;

		System.out.println(NoOfSolutions_DP(coff, rhs));
		System.out.println(NoOfSolutions_rec(coff, 0, rhs));
	}

	private static int NoOfSolutions_rec(int[] coff, int vidx, int rhs) {
		if (rhs == 0) { // is RHS become zero then we get one solution all coff
						// become 0.
			return 1;
		}

		if (vidx == coff.length || rhs < 0) {
			return 0;
		}

		return NoOfSolutions_rec(coff, vidx + 1, rhs) + NoOfSolutions_rec(coff, vidx, rhs - coff[vidx]);

	}

	private static int NoOfSolutions_DP(int[] coff, int rhs) {
		int[] dp = new int[rhs + 1];
		dp[0] = 1;
		for (int j = 0; j < coff.length; j++)
			for (int i = 1; i < dp.length; i++) {
				if (i - coff[j] >= 0)
					dp[i] += dp[i - coff[j]];
			}

		return dp[rhs];

	}

}
