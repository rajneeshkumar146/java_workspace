package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Q212_NumericKeyPad {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		char mat[][] = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' }, { '*', '0', '#' } };

		System.out.println(NumericKeyPad(mat, 5));

		System.out.println(NumericKeyPad_DP(mat, 5));
	}

	public static int NumericKeyPad(char[][] mat, int n) {

		int ans = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == '*' || mat[i][j] == '#') {
					continue;
				}

				ans += NumericKeyPad(mat, n, i, j);

			}
		}
		return ans;

	}

	private static int NumericKeyPad(char[][] mat, int n, int i, int j) {
		if (n == 1) {
			return 1;
		}

		int[][] dirc = Fourdirction();

		int ans = 0;
		for (int dir = 0; dir < dirc.length; dir++) {
			int x = i + dirc[dir][0];
			int y = j + dirc[dir][1];
			if (isValid(mat, x, y)) {
				ans += NumericKeyPad(mat, n - 1, x, y);
			}
		}

		return ans;

	}

	private static boolean isValid(char[][] mat, int x, int y) {
		if (x >= mat.length || y >= mat[0].length || x < 0 || y < 0 || mat[x][y] == '*' || mat[x][y] == '#') {
			return false;
		} else {
			return true;
		}
	}

	private static int[][] Fourdirction() {
		int[][] dirc = { { 0, 0 }, { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		return dirc;

	}

	private static int NumericKeyPad_DP(char[][] mat, int n) {

		int[][] dp = new int[10][n + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][1] = 1;
		}

		int[][] dirc = Fourdirction();
		HashMap<Integer, HashSet<Integer>> list = new HashMap<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				for (int dir = 0; dir < dirc.length; dir++) {
					int x = i + dirc[dir][0];
					int y = j + dirc[dir][1];
					if (isValid(mat, x, y)) {
						int val = mat[x][y] - '0';
						if (list.containsKey(mat[i][j] - '0')) {
							list.get(mat[i][j] - '0').add(val);
						} else {
							list.put(mat[i][j] - '0', new HashSet<>());
							list.get(mat[i][j] - '0').add(val);
						}
					}
				}
			}
		}

		for (int j = 2; j < dp[0].length; j++) {
			for (int i = 0; i < dp.length; i++) {
				for (int val : list.get(i)) {
					dp[i][j] += dp[val][j - 1];
				}

			}
		}

		int ans = 0;
		for (int i = 0; i < dp.length; i++) {
			ans += dp[i][n];
		}

		//		displayMatrix(dp);

		return ans;

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
