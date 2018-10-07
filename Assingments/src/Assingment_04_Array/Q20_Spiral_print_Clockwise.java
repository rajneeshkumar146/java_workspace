package Assingment_04_Array;

import java.util.Scanner;

public class Q20_Spiral_print_Clockwise {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = take_input();
		// display(arr);

		spiral_c(arr);
		spiral_ac(arr);
	
	}

	public static int[][] take_input() {

		int row = scn.nextInt();
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

	public static void spiral_c(int[][] arr) {
		int rowMin = 0, rowMax = arr.length - 1;
		int colMin = 0, colMax = arr[0].length - 1;
		int numElements = arr.length * arr[0].length;
		int counter = 1;
		while (counter <= numElements) {
			// print min row
			for (int col = colMin; counter <= numElements && col <= colMax; col++) {
				System.out.print(arr[rowMin][col] + " ");
				counter++;
			}
			rowMin++;

			// print max col
			for (int row = rowMin; counter <= numElements && row <= rowMax; row++) {
				System.out.print(arr[row][colMax] + " ");
				counter++;
			}
			colMax--;

			// print row max
			for (int col = colMax; counter <= numElements && col >= colMin; col--) {
				System.out.print(arr[rowMax][col] + " ");
				counter++;
			}
			rowMax--;

			// print min col
			for (int row = rowMax; counter <= numElements && row >= rowMin; row--) {
				System.out.print(arr[row][colMin] + " ");
				counter++;
			}
			colMin++;
		}
		System.out.println();
	}

	public static void spiral_ac(int[][] arr) {
		int count = 1;
		int rmin = 0, rmax = arr.length - 1;
		int cmin = 0, cmax = arr[0].length - 1;
		int tne = arr.length * arr[0].length;
		while (count <= tne) {
			int row = rmin;
			int col = cmin;
			for (row = rmin; row <= rmax && count <= tne; row++, count++) {
				System.out.print(arr[row][cmin] + " ");
			}

			cmin++;
			for (col = cmin; col <= cmax && count <= tne; col++, count++) {
				System.out.print(arr[rmax][col] + " ");
			}
			rmax--;

			for (row = rmax; row >= rmin && count <= tne; row--, count++) {
				System.out.print(arr[row][cmax] + " ");
			}

			cmax--;
			for (col = cmax; col >= cmin && count <= tne; col--, count++) {
				System.out.print(arr[rmin][col] + " ");
			}

			rmin++;
		}
	}
	
}