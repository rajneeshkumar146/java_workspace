package DynamicProgramming.set;

import java.util.Scanner;

public class Set05_EditDistance {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		String s1 = "ABCDGH";
		String s2 = "AEDFHR";

		System.out.println(EditDistance(s1, s2));
		System.out.println(EditDistanceDP(s1, s2));
	}

	private static int EditDistance(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return s1.length() == 0 ? s2.length() : s1.length();
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if (ch1 == ch2) {
			return EditDistance(ros1, ros2);
		} else {

			int insert = EditDistance(s1, ros2);
			int remove = EditDistance(ros1, s2);
			int replace = EditDistance(ros1, ros2);

			return Math.min(Math.min(insert, remove), replace) + 1;

		}

	}

	private static int EditDistanceDP(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < s1.length(); i++) {
			arr[s1.length()][i] = s1.length()-i;
		}

		for (int i = 0; i < s2.length(); i++) {
			arr[i][s2.length()] = s2.length()-i;
		}

		arr[s1.length()][s2.length()] = 0;

		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					arr[i][j] = arr[i + 1][j + 1];
				} else {
					arr[i][j] = Math.min(Math.min(arr[i][j + 1], arr[i + 1][j + 1]), arr[i + 1][j]) + 1;
				}
			}
		}

		return arr[0][0];

	}

}
