package Assingment_08a_Recursion;

import java.util.Scanner;

public class Q08_lexicographical_order {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		lexcico(1, scn.nextInt());

	}

	public static void lexcico(int start, int end) {
		if (start > end) {
			return;
		}

		System.out.println(start);

		for (int i = 0; i < 10; i++) {
			if (start * 10 + i < end) {
				lexcico(start * 10 + i, end);
			}
		}

		if (start < 9) {
			lexcico(start + 1, end);
		}

	}

	public static void lexcico_efficient(int start, int end) {

		System.out.println(start);
		if (start == end / 10) {
			System.out.println(end);
		}
		if (start < end / 10) {
			for (int i = 0; i < 10; i++) {

				lexcico(start * 10 + i, end);
			}
		}

		if (start < 9) {
			lexcico(start + 1, end);
		}

	}

}
