package DynamicProgramming.Basics;

public class LongestPalindromicSubsequence {
	// public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		LPS("pcbcmp");

	}

	private static void LPS(String str) {
		int[][] dp = new int[str.length()][str.length()];

		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = gap + i; j < str.length() && i < str.length(); j++, i++) {
				if (gap == 0) {
					dp[i][j] = 1;
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = dp[i + 1][j - 1] + 2;
					} else {
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
					}
				}
			}
		}

		displayMatrix(dp);

	}

	private static void displayMatrix(int[][] arr) {
		for (int[] i : arr) {
			for (int el : i) {
				// pnter.print(el + " ");
				System.out.print(el + " ");
			}
			// pnter.printLine("");
			System.out.println();
		}
	}

}
