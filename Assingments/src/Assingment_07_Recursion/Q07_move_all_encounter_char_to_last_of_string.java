package Assingment_07_Recursion;

import java.util.Scanner;

public class Q07_move_all_encounter_char_to_last_of_string {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// System.out.println("Enter your string");
		String s = scn.next();

		// System.out.println("Enter character which you want to move it last");
		char ch = scn.next().charAt(0);
		int n = scn.nextInt();
		System.out.println(encounterchar_1(s, ch).charAt(n));
		encounterchar_3(s, "", "", ch);

	}

	public static String encounterchar_1(String str, char move) {
		if (str.length() <= 1) {
			return str.substring(0);
		}
		char ch = str.charAt(0);
		String result = encounterchar_1(str.substring(1), move);
		if (move == ch) {
			result = result + move;
		} else {
			result = ch + result;
		}

		return result;
	}

	public static void encounterchar_2(String ques, String ans, char move, int count) {

		if (ques.length() == 0) {
			for (int i = 1; i <= count; i++)
				ans = ans + move;
			System.out.print(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1); // roq=rest_of_question

		if (ch != move) {
			encounterchar_2(roq, ans + ch, move, count);
		} else {
			encounterchar_2(roq, ans, move, count + 1);
		}
	}

	public static void encounterchar_3(String ques, String ans1, String ans2, char move) {

		if (ques.length() == 0) {
			System.out.print(ans1 + ans2);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1); // roq=rest_of_question

		if (ch != move) {
			encounterchar_3(roq, ans1 + ch, ans2, move);
		} else {
			encounterchar_3(roq, ans1, ans2 + move, move);
		}

	}

}
