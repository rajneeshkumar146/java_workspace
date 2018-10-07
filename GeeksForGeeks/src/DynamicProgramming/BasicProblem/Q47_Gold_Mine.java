package DynamicProgramming.BasicProblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q47_Gold_Mine {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		Queue<Integer> gt=new LinkedList<>();
		
		
		solve();

	}

	public static void solve() throws Exception {
		int row = scn.nextInt();
		int col = scn.nextInt();
		// int[][] arr = new int[row][col];

		// int arr[][] = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0,
		// 6, 1, 2 } };

		// int arr[][] = { { 1, 3, 3 }, { 2, 1, 4 }, { 0, 6, 4 } };

		int arr[][] = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };

		
		
		// for (int i = 0; i < row; i++) {
		// for (int j = 0; j < col; j++) {
		// arr[i][j] = scn.nextInt();
		// }
		// }

		System.out.println(goldmine(arr, row, col));

	}

	private static int goldmine(int[][] arr, int row, int col) {

		int[][] dparr = new int[row][col];

		for (int c = col - 1; c >= 0; c--) {
			for (int r = 0; r < row; r++) {

				// forward

				int forward = (c == (col - 1)) ? 0 : dparr[r][c + 1];

				// forwardUp

				int forwardUp = (r == 0 || c == col - 1) ? 0 : dparr[r - 1][c + 1];

				// forwardDown

				int forwardDown = (r == row - 1 || c == col - 1) ? 0 : dparr[r + 1][c + 1];

				dparr[r][c] = arr[r][c] + Max(forward, forwardDown, forwardUp);

			}
		}

		int max = dparr[0][0];
		for (int r = 1; r < row; r++) {
			if (dparr[r][0] > max) {
				max = dparr[r][0];
			}
		}

		return max;

	}

	private static int Max(int a, int b, int c) {
		int temp = Math.max(Math.max(a, b), c);

		return temp;
	}

	private static void display(int[][] arr) {
		for (int[] r : arr) {
			for (int i : r) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
