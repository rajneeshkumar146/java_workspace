package Geeks.DP;

import java.util.Scanner;

public class Q020_LongestIncreasingPathFourMovesAllow {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		int mat[][] = { { 1, 2, 9 }, { 5, 3, 8 }, { 4, 6, 7 } };
		LongestIncreasingPath(mat);

	}

	public static void LongestIncreasingPath(int[][] mat) {
		int[][] strg = new int[mat.length][mat[0].length];

		int max = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] != 0) {
					max = Math.max(max, LIP(mat, i, j, strg));
				}
			}
		}

		System.out.println(max);

		displayMatrix(strg);
	}

	private static int LIP(int[][] mat, int i, int j, int[][] strg) {

		if (i > mat.length || j > mat[0].length || i < 0 || j < 0) {
			return 0;
		}

		if (strg[i][j] != 0) {
			return strg[i][j];
		}

		int[][] dirc = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		int max = 0;
		for (int dir = 0; dir < dirc.length; dir++) {
			int x = i + 1 * dirc[dir][0];
			int y = j + 1 * dirc[dir][1];

			if (isValid(mat, i, j, x, y)) {
				max = Math.max(LIP(mat, x, y, strg), max);
			}
		}

		strg[i][j] = max + 1;
		return strg[i][j];
	}

	private static boolean isValid(int[][] mat, int i, int j, int x, int y) {
		if (x >= mat.length || y >= mat[0].length || x < 0 || y < 0 || mat[x][y] - mat[i][j] != 1) {
			return false;
		}
		return true;
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
