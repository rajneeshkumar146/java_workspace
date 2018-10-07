package Assingment_07_Recursion;

import java.util.Scanner;

public class Q01_Sum_of_digit_in_string {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

//		String s = "23456789";
		String s = scn.nextLine();
		System.out.println(sum(s));

	}

	public static int sum(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int n = (int) s.charAt(0);
		String ros = s.substring(1);
		int sum = sum(ros) - (char) '0';
		sum += n;
		return sum;

	}

}
