package DynamicProgramming;

import java.util.Scanner;

public class Q208_MinimumCharactereInsertedToMakeItPalindrome {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		String str = scn.next();
		int LPS = LPS(str);
		System.out.println(str.length() - LPS);

	}

	private static int LPS(String str) {
		int[][] dp = new int[str.length()][str.length()];

		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = gap + i; j < str.length() && i < str.length(); j++, i++) {

				if (gap == 0) {
					dp[i][j] = 1;
				} else {
					if (str.charAt(i) != str.charAt(j)) {
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
					} else {
						dp[i][j] = dp[i + 1][j - 1] + 2;
					}
				}

			}
		}
		  
		displayMatrix(dp);

		return dp[0][str.length() - 1];
	}

	private static void displayMatrix(int[][] arr) {
		for (int[] i : arr) {
			for (int el : i) {
				System.out.print(el + " ");
			}
			System.out.println();
		}
	}

}
