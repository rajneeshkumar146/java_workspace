package Recursion_1and2;

import java.util.Scanner;

public class Q03_SumOfDigits {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		System.out.println(sumDigits(n));

	}

	public static int sumDigits(int n) {
		if (n == 0) {
			return 0;
		}
		int rem = n % 10;
		n = n / 10;
		int result = rem+sumDigits(n);
		
		return result;

	}

}
