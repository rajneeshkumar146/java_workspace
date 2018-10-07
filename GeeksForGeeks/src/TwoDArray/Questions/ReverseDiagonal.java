package TwoDArray.Questions;

import java.util.Scanner;

public class ReverseDiagonal {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		int r = scn.nextInt();
		int c = scn.nextInt();
		int[][] arr = new int[r][c];

		input(arr, r, c);

		r = 0;
		while (r < c) {
			swap(arr, r, r, c - 1, c - 1);
			swap(arr, r, c - 1, c - 1, r);

			r++;
			c--;
		}

		display(arr);

	}

	private static void input(int[][] arr, int r, int c) {
		for (int row = 0; row < r; row++) {
			for (int col = 0; col < c; col++) {
				arr[row][col] = scn.nextInt();
			}
		}

	}

	private static void display(int[][] arr) {
		for (int[] ar : arr) {
			for (int i : ar) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

	private static void swap(int[][] arr, int i, int j, int k, int l) {
		int temp = arr[i][j];
		arr[i][j] = arr[k][l];
		arr[k][l] = temp;
	}

}
