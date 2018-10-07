package Assingment_04_Array;

import java.util.Scanner;

public class Q18_Wave_Print_Row_Wise {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[][] arr = take_input();
		waveR(arr);
		 display(arr);

	}

	public static int[][] take_input() {
		// System.out.println("\tEnter Number Of Row's");
		int row = scn.nextInt();

		// System.out.println("\tEnter Number Of column's");
		int col = scn.nextInt();

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
				System.out.print(arr[row][col]);
			}
		}
	}

	public static void waveR(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			if (row % 2 != 0) {
				for (int col = arr[0].length - 1; col >= 0; col--) {
					System.out.print(arr[row][col] + " ");
				}
			} else {
				for (int col = 0; col < arr[0].length; col++) {
					System.out.print(arr[row][col] + " ");
				}
			}
		}
		System.out.println();

	}
}
