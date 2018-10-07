package Assingment_06_Recursion;

import java.util.Scanner;

public class Q01_odd_even {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		System.out.println("enter your limit value");
		int n = scn.nextInt();
		odd_even(n);

	}

	public static void odd_even(int n) {
		if (n == 0) {
			return;
		}
		if (n % 2 != 0) {
			System.out.println(n);
		}
		odd_even(n - 1);
		if (n % 2 == 0) {
			System.out.println(n);
		}
	}

}
