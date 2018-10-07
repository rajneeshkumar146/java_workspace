package String.Pattern_searching;

import java.util.Scanner;

public class Native_pattern_searching {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		NativeSearchinf("AAAAAAA", "AAA");
	}

	public static void NativeSearchinf(String str, String s) {

		int m = str.length();
		int n = s.length();

		for (int i = 0; i <= m - n; i++) {
			int j = 0;
			for (; j < n; j++) {
				if (s.charAt(j) != str.charAt(i + j)) {
					break;
				}
			}

			if (j == n) {
				System.out.println("Pattern found at index: " + i);
			}
		}

	}

}
