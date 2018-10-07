package Recursion_1and2;

import java.util.Scanner;

public class Q04_count7 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(count7_2(n));

	}

	public static int count7(int n) {

		if (n == 0) {
			return 0;
		}
		int rem = n % 10;
		n = n / 10;
		int result = 0;

		if (rem == 7) {
			result = 1 + count7(n);
		} else {
			result = count7(n);
		}
		return result;
	}

	public static int count7_2(int n) {

		if (n == 0) {
			return 0;
		}
		int rem = n % 10;
		n = n / 10;
		int temp = count7_2(n);
		if (rem == 7) {
			temp=temp + 1;
		}

		return temp;
	}

}
