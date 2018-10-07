package Matrix_operations;

import java.util.Scanner;

public class Matrix_Basic_Operation {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// int[][] arr = take_input();
		// display(arr);
		//
		// int[][] arr1 = take_input();
		// display(arr);

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr1 = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
		// int row = scn.nextInt();
		// int col = scn.nextInt();
		// int[][] arr=take_input(row,col);
		// int[][] arr1=take_input(row,col);

		// System.out.println(trace(arr) + trace(arr1));
		// matrix_m(arr, arr1);

		Transpose(arr1);

		display(arr1);

	}

	public static int[][] take_input(int row, int col) {
		int[][] rv = new int[row][col];

		for (int i = 0; i < rv.length; i++) {
			for (int j = 0; j < rv[0].length; j++) {
				rv[i][j] = scn.nextInt();
			}
		}
		return rv;

	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}

	public static void matrix_m(int[][] arr1, int[][] arr2) { // Matrix
																// Multiplication
		if (arr1[0].length == arr2.length) {
			int[][] rv = new int[arr1[0].length][arr2.length];

			for (int i = 0; i < arr1.length; i++) {
				for (int j = 0; j < arr2[0].length; j++) {
					for (int k = 0; k < arr1[0].length; k++) {
						rv[i][j] = rv[i][j] + arr1[i][k] * arr2[k][j];
					}
					System.out.print(rv[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void matrix_a(int[][] arr1, int[][] arr2) { // Matrix Addition

		if ((arr1.length == arr2.length) && (arr1[0].length == arr2[0].length)) {

			int[][] rv = new int[arr1.length][arr1[0].length];
			for (int row = 0; row < arr1.length; row++) {
				for (int col = 0; col < arr1[0].length; col++) {
					rv[row][col] = arr1[row][col] + arr2[row][col];
					System.out.print(rv[row][col] + " ");
				}
				System.out.println();
			}

		}
	}

	public static void matrix_s(int[][] arr1, int[][] arr2) { // Matrix
																// Subtraction

		if ((arr1.length == arr2.length) && (arr1[0].length == arr2[0].length)) {

			int[][] rv = new int[arr1.length][arr1[0].length];
			for (int row = 0; row < arr1.length; row++) {
				for (int col = 0; col < arr1[0].length; col++) {
					rv[row][col] = arr1[row][col] - arr2[row][col];
					System.out.print(rv[row][col] + "\t");
				}
				System.out.println();
			}

		}
	}

	public static int trace(int[][] arr) {
		int tr = 0;
		for (int i = 0; i < arr.length && i < arr[0].length; i++) {
			tr += arr[i][i];

		}

		return tr;
	}

	public static void Transpose(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr[0].length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;

			}
		}

	}
}
