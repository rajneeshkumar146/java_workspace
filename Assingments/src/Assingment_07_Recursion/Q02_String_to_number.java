package Assingment_07_Recursion;

import java.util.Scanner;

public class Q02_String_to_number {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// String s = "23456789";
		String s = scn.next();
		int n=scn.nextInt();

		System.out.println(btr_number(s)/n);
	}

	public static int number(String s, int count) {// by_including_first_character_it_have_a_good_performance
		if (s.length() == 0) {
			return 0;
		}

		char ch = s.charAt(0);
		String ros = s.substring(1);
		int num = number(ros, count - 1) + (ch - (char) '0') * (int) Math.pow(10, count);
		return num;

	}

	public static long btr_number(String s) { // by_including_last_character_it_increase_performance
		if (s.length() == 0) {
			return 0;
		}

		char ch = s.charAt(s.length() - 1);
		String ros = s.substring(0, s.length() - 1);

		long num = btr_number(ros) * 10 + (ch - (char) '0');

		return num;

	}

}
