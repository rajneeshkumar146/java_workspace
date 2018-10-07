package Geeks.DP;

import java.util.Scanner;

public class Q028_Longest_Consecutive_Path_In_Character_Matrix {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
//3 3 a c d h b a i g f 
//f
		char[][] arr = MatrixInput(scn.nextInt(), scn.nextInt());
		char ch = scn.next().charAt(0);
		LongestConsecutivePath(arr, ch);
	}

	public static void LongestConsecutivePath(char[][] arr, char ch) {
		int max = 0;
		int[][] strg = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == ch) {
					max = Math.max(max, LongestConsecutivePath(arr, i, j, strg));
				}
			}
		}

		System.out.println(max);

	}

	private static int LongestConsecutivePath(char[][] arr, int i, int j, int[][] strg) {
		if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0) {
			return 0;
		}

		if (strg[i][j] != 0) {
			return strg[i][j];
		}

		int[][] dirc = Eightdirction();
		int max = 0;
		for (int dir = 0; dir < dirc.length; dir++) {
			int x = i + dirc[dir][0];
			int y = j + dirc[dir][1];
			if (IsValid(arr, i, j, x, y)) {
				max = Math.max(max, LongestConsecutivePath(arr, x, y, strg));
			}
		}

		strg[i][j] = max + 1;
		return strg[i][j];

	}

	private static boolean IsValid(char[][] arr, int i, int j, int x, int y) {
		if (x >= arr.length || y >= arr[0].length || x < 0 || y < 0) {
			return false;
		}

		if (arr[x][y] - arr[i][j] == 1) {
			return true;
		} else {
			return false;
		}

	}

	private static int[][] Eightdirction() {
		int[][] dirc = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

		return dirc;

	}

	private static char[][] MatrixInput(int n, int m) {
		char[][] arr = new char[n][m];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				arr[row][col] = scn.next().charAt(0);
			}
		}
		return arr;
	}

}
