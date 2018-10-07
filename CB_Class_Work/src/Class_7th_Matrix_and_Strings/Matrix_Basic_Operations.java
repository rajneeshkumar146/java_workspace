package Class_7th_Matrix_and_Strings;

import java.util.Scanner;

public class Matrix_Basic_Operations {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// int[][] arr = take_input();
		// display(arr);
		//
		// int[][] arr1 = take_input();
		// display(arr);

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr1 = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };

		matrix_a(arr, arr1);

	}

	public static int[][] take_input() {
		System.out.println("\tEnter Number Of Row's");
		int row = scn.nextInt();

		System.out.println("\tEnter Number Of column's");
		int col = scn.nextInt();

		int[][] rv = new int[row][col];

		for (int i = 0; i < rv.length; i++) {
			for (int j = 0; j < rv[0].length; j++) {
				System.out.println("Enter your " + (i + 1) + (j + 1) + "th element");
				rv[i][j] = scn.nextInt();
			}

		}
		return rv;

	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + "\t");
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
					System.out.print(rv[i][j] + "\t");
				}
				System.out.println();
			}
		} else {
			System.out.println("Multiplication can't Proceed please enter a valid matrices");
			System.out.println("For valid Multiplication of matrices \n"
					+ "number of column's of matrix one \nshould be equal to \nnumber of row's of matrix two.");
		}
	}

	public static void matrix_a(int[][] arr1, int[][] arr2) { // Matrix Addition

		if ((arr1.length == arr2.length) && (arr1[0].length == arr2[0].length)) {

			int[][] rv = new int[arr1.length][arr1[0].length];
			for (int row = 0; row < arr1.length; row++) {
				for (int col = 0; col < arr1[0].length; col++) {
					rv[row][col] = arr1[row][col] + arr2[row][col];
					System.out.print(rv[row][col] + "\t");
				}
				System.out.println();
			}

		} else {
			System.out.println("For Matrix Addition matrices should be in same oder.");
		}
	}

	public static void matrix_s(int[][] arr1, int[][] arr2) {   // Matrix Subtraction

		if ((arr1.length == arr2.length) && (arr1[0].length == arr2[0].length)) {

			int[][] rv = new int[arr1.length][arr1[0].length];
			for (int row = 0; row < arr1.length; row++) {
				for (int col = 0; col < arr1[0].length; col++) {
					rv[row][col] = arr1[row][col] - arr2[row][col];
					System.out.print(rv[row][col] + "\t");
				}
				System.out.println();
			}

		} else {
			System.out.println("For Matrix Subtraction matrices should be in same oder.");
		}
	}

}
