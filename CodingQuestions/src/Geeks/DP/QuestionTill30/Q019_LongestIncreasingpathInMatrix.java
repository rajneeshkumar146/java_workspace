package Geeks.DP.QuestionTill30;

import java.util.Scanner;

public class Q019_LongestIncreasingpathInMatrix {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int mat[][] = { { 1, 2, 3, 4 }, { 2, 2, 3, 4 }, { 4, 5, 6, 7 }, { 5, 6, 3, 4 } };
		// int mat[][] = { { 1, 2 }, { 3, 4 } };

		int[][] strg = new int[mat.length][mat[0].length];
		System.out.println(LongestPath_Rec(mat, 0, 0, strg));

		displayMatrix(strg);
	}

	private static int LongestPath_Rec(int[][] mat, int i, int j, int[][] strg) {
		if (i > mat.length || j > mat[0].length) {
			return 0;
		}

		if (strg[i][j] != 0) {
			return strg[i][j];
		}

		int horizontal = 0, vertical = 0;
		if ((i + 1) < mat.length && mat[i][j] < mat[i + 1][j]) {
			horizontal = LongestPath_Rec(mat, i + 1, j, strg);
		}
		
		if ((j + 1) < mat[0].length && mat[i][j] < mat[i][j + 1]) {
			vertical = LongestPath_Rec(mat, i, j + 1, strg);
		}

		strg[i][j] = Math.max(horizontal, vertical) + 1;
		return strg[i][j];
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
