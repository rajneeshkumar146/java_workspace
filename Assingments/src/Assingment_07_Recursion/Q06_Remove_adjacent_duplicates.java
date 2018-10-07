package Assingment_07_Recursion;

import java.util.Scanner;

public class Q06_Remove_adjacent_duplicates {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// System.out.println("Enter your string");
		String s = scn.next();
		int i = scn.nextInt();

		System.out.println(duplicates(s).charAt(i));

		duplicates_2(s, "");

	}

	public static String duplicates(String s) {
		if (s.length() == 1) {
			return s.substring(s.length() - 1);
		}

		char ch = s.charAt(0);
		String ros = s.substring(1);

		String result = duplicates(ros);

		if (ch != result.charAt(0)) {
			result = ch + result;
		}

		return result;

	}

	public static void duplicates_2(String ques, String ans) { // question_ans_approach
		if (ques.length() == 1) {
			System.out.println(ans + ques.charAt(0));
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1); // roq=rest_of_question

		if (ch != ques.charAt(1)) {
			duplicates_2(roq, ans + ch);
		} else {
			duplicates_2(roq, ans);
		}

	}

}
