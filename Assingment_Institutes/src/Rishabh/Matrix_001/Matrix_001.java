package Rishabh.Matrix_001;

import java.util.Scanner;

public class Matrix_001 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		ZigZagMotion(arr);

	}

	private static int[][] MatrixInput(int n, int m) {
		int[][] arr = new int[n][m];

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				arr[row][col] = scn.nextInt();
			}
		}

		return arr;

	}

	private static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}

		// agar beech mai se koi element nahi pick krna to isko use krenge.
		for (int[] ar : arr) {
			for (int val : ar) {
				System.out.print(val + " ");
			}
			System.out.println();
		}

	}

	private static void ZigZagMotion(int[][] arr) {

		int row = 0;
		for (int col = 0; col < arr[0].length; col++) {
			row = col % 2 != 0 ? arr.length - 1 : 0;
			
			while (row < arr.length && row >= 0) {

				if (col % 2 != 0) { // odd
					System.out.print(arr[row][col] + " ");
					row--;
				} else {

					System.out.print(arr[row][col] + " ");
					row++;
				}

			}
		}
	}

}
