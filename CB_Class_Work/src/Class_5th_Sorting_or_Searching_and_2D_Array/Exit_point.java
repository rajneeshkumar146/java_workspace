package Class_5th_Sorting_or_Searching_and_2D_Array;

import java.util.Scanner;

public class Exit_point {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = take_input();

		exitPoint(arr);

	}

	public static int[][] take_input() {
//		System.out.println("\tEnter Number Of Row's");
		int row = scn.nextInt();

//		System.out.println("\tEnter Number Of column's");
		int col = scn.nextInt();

		int[][] rv = new int[row][col];

		for (int i = 0; i < rv.length; i++) {
			for (int j = 0; j < rv[0].length; j++) {
				rv[i][j] = scn.nextInt();
			}

		}
		return rv;

	}

	 public static void exitPoint(int[][] arr) {
			int dir = 0, row = 0, col = 0;

			while (true) {
				dir = (dir + arr[row][col]) % 4;

				if (dir == 0) { // east
					col++;
					if (col == arr[0].length) {
						System.out.println(row + ", " + (col - 1));
						break;
					}

				} else if (dir == 1) { // south
					row++;
					if (row == arr.length) {
						System.out.println((row - 1) + ", " + (col));
						break;
					}
				} else if (dir == 2) { // west
					col--;
					if (col == -1) {
						System.out.println(row + ", " + (0));
						break;
					}
				} else if (dir == 3) { // north
					row--;
					if (row == -1) {
						System.out.println(0 + ", " + (col));
						break;
					}
				}
			}
		}
}
