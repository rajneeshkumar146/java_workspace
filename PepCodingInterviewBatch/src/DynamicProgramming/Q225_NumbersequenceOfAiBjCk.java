package DynamicProgramming;

import java.util.Scanner;

public class Q225_NumbersequenceOfAiBjCk {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		System.out.println(NumberOfSequnece("abcabc"));
	}

	private static int NumberOfSequnece(String str) {

		int acount = 0;
		int bcount = 0;
		int ccount = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'a') {
				acount = 1 + 2 * acount;
			} else if (ch == 'b') {
				bcount = acount + 2 * bcount;
			} else if (ch == 'c') {
				ccount = bcount + 2 * ccount;
			}
		}

		return ccount;

	}

}
