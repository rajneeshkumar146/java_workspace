package Assingment_06_Recursion;

import java.util.Scanner;

public class Q04_Pattern {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter Number Of Row's");
		int row = scn.nextInt();
		pattern(0, 0, row, 1);
		

	}

	public static void pattern(int row, int col, int count, int val) {

		if (row == count) {
			return;
		}

		if (col > row) {
			System.out.println();
			pattern(row + 1, 0, count, 1);
			return;
		}

		System.out.print(val);
		val = val * (row - col) / (col + 1);
		pattern(row, col + 1, count, val);

	}
	

}
