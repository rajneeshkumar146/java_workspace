package june21;

import java.util.Scanner;

public class StringsDemo {

	public static void main(String[] args) {

		// String s;
		// s = "hello";
		//
		// System.out.println(s.length());
		// System.out.println(s.charAt(0));

		// s.charAt(0) = 'g';

		// System.out.println(s.substring(1, 4));
		// System.out.println(s.substring(0, s.length()));
		// System.out.println(s.substring(2));
		// String pos = s.substring(3, 3);
		// System.out.println(pos);

		// System.out.println("Enter a string");
		// Scanner scn = new Scanner(System.in);
		// String str = scn.nextLine();
		//
		// printAllPalindromicSubstrings(str);
//		stringPerformanceSolution();
		
		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello");
		
		System.out.println((s1 == s2) + " " + s1.equals(s2));
		System.out.println((s2 == s3) + " " + s2.equals(s3));
	}

	private static void printCharsOnSeparateLine(String str) {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			System.out.println(ch);
		}
	}

	private static void printAllSubstrings(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				System.out.println(str.substring(i, j));
			}
		}
	}

	private static boolean IsPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	private static void printAllPalindromicSubstrings(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String subs = str.substring(i, j);
				boolean ispalin = IsPalindrome(subs);

				if (ispalin == true) {
					System.out.println(subs);
				}
			}
		}
	}

	private static void stringPerformanceCheck() {
		long start = System.currentTimeMillis();

		int n = 100000;

		String s = "";
		for (int i = 0; i < n; i++) {
			s += i;
		}

		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	private static void stringPerformanceSolution() {
		long start = System.currentTimeMillis();

		int n = 100000;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(i);
		}

		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
