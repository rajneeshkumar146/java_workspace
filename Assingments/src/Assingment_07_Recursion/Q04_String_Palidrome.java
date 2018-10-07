package Assingment_07_Recursion;

import java.util.Scanner;

public class Q04_String_Palidrome {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		System.out.println("Enter Your String1");
		String s1 = scn.next();

		System.out.println(palidrome(s1, 0, s1.length() - 1));

	}

	public static boolean palidrome(String s, int str, int end) {
		if (str >= end) {
			return true;
		}

		char ch1 = (char) (s.charAt(str) < 97 ? s.charAt(str) + 32 : s.charAt(str));
		char ch2 = (char) (s.charAt(end) < 97 ? s.charAt(end) + 32 : s.charAt(end));

		if (ch1 != ch2) {
			return false;

		}

		boolean result = palidrome(s, str + 1, end - 1);
		return result;
	}

}
