package Assingment_04_Array;

import java.util.Scanner;

public class Q17_Wave_Print_Column_Wise {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[][] arr = take_input();
		display(arr);
		
		waveC(arr);

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
				System.out.print(arr[row][col]);
			}
		}
	}

	public static void waveC(int[][] arr) {
		for (int col = 0; col < arr[0].length; col++) {
			if (col % 2 != 0) {
				for (int row = arr.length-1; row >= 0; row--) {
					System.out.println(arr[row][col]+" ");
				
				}
			} else {
					for (int row = 0; row < arr.length; row++) {
						System.out.print(arr[row][col]+" ");
				}
			}
		}

	}
}
