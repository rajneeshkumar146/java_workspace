package Practice_Easy;

import java.util.Arrays;
import java.util.Scanner;

public class Smallest_number_in_one_swap {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int testcase = scn.nextInt();
		for (int i = 1; i <= testcase; i++) {
			StringBuilder sb = new StringBuilder(scn.next());
			int min = sb.charAt(0) - 48;
			int mini = 0;

			for (int j = 0; j < sb.length(); j++) {
				if (sb.charAt(j) - 48 <= min && (sb.charAt(j) - 48) != 0) {

					min = sb.charAt(j) - 48;
					mini = j;

				}
			}

			int temp = sb.charAt(0) - 48;
			sb.setCharAt(0, (char) (min + 48));
			sb.setCharAt(mini, (char) (temp + 48));

			System.out.println(sb.toString());

		}

	}

}
