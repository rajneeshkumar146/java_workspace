package Class_5th_Sorting_or_Searching_and_2D_Array;

import java.util.Scanner;

public class Waved_Display {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = { { 11, 12, 13, 14, 15 }, 
				        { 21, 22, 23, 24, 25 },
				        { 31, 32, 33, 34, 35 },
				         { 41, 42, 43, 44, 45 } };

		wave_display(arr);
	}

	public static void wave_display(int[][] arr) {
		for (int col = 0; col < arr[0].length; col++) {
			if (col % 2 != 0) {
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.print(arr[row][col] + ",");
				}
			} else {
				for (int row = 0; row < arr.length; row++) {
					System.out.print(arr[row][col] + ",");
				}
			}

		}
		System.out.print(".");
	}
}
