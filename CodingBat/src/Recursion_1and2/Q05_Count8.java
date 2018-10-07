package Recursion_1and2;

import java.util.Scanner;

public class Q05_Count8 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		System.out.println(count8_2(n));

	}

	public static int count8(int n) {
		if (n == 0) {
			return n;
		}
		int rem = n % 10;
		n = n / 10;
		int rem2 = n % 10;
		int result = count8(n);

		if (rem == 8) {
			result += 1;
		}
		if (rem2 == 8 && rem == 8) {
			result += 1;
		}

		return result;
	}

	public static int count8_2(int n) {
		if (n == 0) {
			return n;
		}
		int rem = n % 10;
		n = n / 10;
		int rem2 = n % 10;
		int result = 0;
		if (rem == 8 && rem2 != 8) {
			result = 1 + count8_2(n);
		} else if (rem == 8 && rem2 == 8) {
			result = 2 + count8_2(n);
		} else {
			result = count8_2(n);
		}

		return result;
	}

}
