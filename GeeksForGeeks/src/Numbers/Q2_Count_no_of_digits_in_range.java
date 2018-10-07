package Numbers;

import java.util.Scanner;

public class Q2_Count_no_of_digits_in_range {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		long n = scn.nextInt();
		digits(n);
	}

	public static void digits(long n) {

		long ans = 0;
		long i = 9;
		long count = 0;
		while (n > 0) {
			n = n - i;
			count++;
			ans += count * i;
			i *= 10;

		}

		if (n < 0) {
			ans += count * n;
		}

		System.out.println(ans);

	}

}
