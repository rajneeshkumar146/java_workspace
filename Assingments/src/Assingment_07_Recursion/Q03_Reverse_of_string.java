package Assingment_07_Recursion;

import java.util.Scanner;

public class Q03_Reverse_of_string {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// System.out.println("Enter Your String1");
		String s1 = scn.next();
		// System.out.println("Enter Your String2");
		String s2 = scn.next();
		int len2 = s2.length() - 1;
		System.out.println(reverse(s1, 0, s2, len2));

	}

	public static boolean reverse(String s1, int idx1, String s2, int idx2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		if (idx1 == s1.length()) {
			return true;

		}

		if (s1.charAt(idx1) != s2.charAt(idx2)) {
			return false;
		}

		boolean result = reverse(s1, idx1 + 1, s2, idx2 - 1);

		return result;
	}

}
