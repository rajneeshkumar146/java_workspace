package DynamicProgramming.Basics;

public class LongestPalindromicSubString {
	// public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		LPSS("abccba");
	}

	private static void LPSS(String str) {
		int[][] dp = new int[str.length()][str.length()];
		int max = 1;

		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length() && i < str.length(); i++, j++) {
				if (gap == 0) {
					dp[i][j] = 1;
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = dp[i + 1][j - 1] + 2;
					}

					max = Math.max(max, dp[i][j]);
				}
			}
		}

		displayMatrix(dp);
		System.out.println(max);

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
