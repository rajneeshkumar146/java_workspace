package Assingment_07_Recursion;

import java.util.Scanner;

public class Q12_Print_all_possible_code_of_String {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String ques = scn.nextLine();

		PossibleCode(ques, "");

	}

	public static void PossibleCode(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		Integer ch = Integer.parseInt(ques.substring(0, 1));
		String roq = ques.substring(1);
		PossibleCode(roq, ans + (char) ('a' - 1 + ch));

		if (ques.length() >= 2) {
			Integer ch01 = Integer.parseInt(ques.substring(0, 2));
			String roq1 = ques.substring(2);
			if(ch01<=26)
			PossibleCode(roq1, ans + (char) ('a' - 1 + ch01));
		}

	}

}
