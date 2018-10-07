package DynamicProgramming.set;

import java.util.Scanner;

public class Set04_LongestCommonSubsequence {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "AGGTAB";

		System.out.println(LCSRecu(s1, s2));
		System.out.println(LCSDP(s1, s2));
	}

	private static int LCSRecu(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if (ch1 == ch2) {
			return LCSRecu(ros1, ros2) + 1;
		} else {
			return Math.max(LCSRecu(s1, ros2), LCSRecu(ros1, s2));
		}

	}

	private static int LCSDP(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];

		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					arr[i][j] = arr[i + 1][j + 1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i][j + 1], arr[i + 1][j]);
				}
			}
		}

		return arr[0][0];

	}

}
