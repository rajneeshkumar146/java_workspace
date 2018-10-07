package Lecture2;

import java.util.Scanner;

public class Q6_Roation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long r = scn.nextLong();
		int num = scn.nextInt();
		roation(r, num);

	}

	public static void roation(long r, int num) {
		int order = 0;
		int temp = num;
		while (temp != 0) {
			temp = temp / 10;
			order++;
		}

		r = r % order;
		if (r < 0) {
			r = order + r;
		}

		int quo = num / (int) Math.pow(10, (order - r));
		int rem = num % (int) Math.pow(10, (order - r));

		int result = rem * (int) Math.pow(10, r) + quo;
		System.out.print(result);
	}

}
