package Recursion_1and2;

import java.util.Scanner;

public class Q01_bunnyEars {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		System.out.println(bunnyEars(n));

	}

	public static int bunnyEars(int bunnies) {
		if (bunnies == 0) {
			return 0;
		}

		int sum = 0;

		if (bunnies % 2 != 0) {
			sum = 2 + bunnyEars(bunnies - 1);
		} else {
			sum = 3 + bunnyEars(bunnies - 1);
		}

		return sum;

	}

}
