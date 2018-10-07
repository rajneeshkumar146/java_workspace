package TwoDArray.Questions;
import java.util.Scanner;

public class SadalPoint {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = take_input();
		Sadalpoint(arr);

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

	public static void Sadalpoint(int[][] arr) {
		boolean flag = false;
		for (int row = 0; row < arr.length; row++) {
			int min = arr[row][0];
			int c_idx = 0; // column_Index.
			for (int col = 0; col < arr[0].length; col++) {
				if (min > arr[row][col]) {
					min = arr[row][col];
					c_idx = col;
				}
			}

			int max = arr[0][c_idx];
			for (int i = 0; i < arr.length; i++) {
				if (arr[i][c_idx] > max) {
					max = arr[i][c_idx];
				}
			}
			if (min == max) {
				System.out.println(min + " ");
				flag = true;
			}
		}

		if (!flag) {
			System.out.print("No Such Point Exist");

		}

	}

}
