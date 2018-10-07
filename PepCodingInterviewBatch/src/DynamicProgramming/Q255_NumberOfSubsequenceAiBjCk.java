package DynamicProgramming;

import java.util.Scanner;

public class Q255_NumberOfSubsequenceAiBjCk {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		// abcabc
		String str = scn.next();
		System.out.println(CountSubsequenece(str));
	}

	private static int CountSubsequenece(String str) {

		int aCount = 0;
		int bCount = 0;
		int cCount = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				aCount = 1 + 2 * aCount;
			} else if (str.charAt(i) == 'b') {
				bCount = aCount + 2 * bCount;
			} else if (str.charAt(i) == 'c') {
				cCount = bCount + 2 * cCount;
			}
		}
		return cCount;
	}

}
