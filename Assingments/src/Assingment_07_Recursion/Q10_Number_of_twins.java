package Assingment_07_Recursion;

import java.util.Scanner;

public class Q10_Number_of_twins {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// System.out.println("Enter your string");
		String s = scn.nextLine();

		System.out.println(twins_with_overlap_count(s));
		System.out.println(twins_without_overlap_count(s));

	}

	public static int twins_with_overlap_count(String ques) {
		if (ques.length() < 3) {

			return 0;
		}

		char cc1 = ques.charAt(0);
		char cc2 = ques.charAt(1);
		char cc3 = ques.charAt(2);

		String roq = ques.substring(1);
		if (cc1 == cc3 && cc1 != cc2) {
			return 1 + twins_with_overlap_count(roq);
		} else {
			return twins_with_overlap_count(roq);
		}

	}

	public static int twins_without_overlap_count(String ques) {
		if (ques.length() < 3) {

			return 0;
		}

		char cc1 = ques.charAt(0);
		char cc2 = ques.charAt(1);
		char cc3 = ques.charAt(2);

		String roq = ques.substring(1);
		if (cc1 == cc3 && cc1 != cc2) {
			return 1 + twins_without_overlap_count(ques.substring(3));
		} else {
			return twins_without_overlap_count(roq);
		}

	}

}
