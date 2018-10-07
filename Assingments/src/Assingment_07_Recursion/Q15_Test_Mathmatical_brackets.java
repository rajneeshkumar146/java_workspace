package Assingment_07_Recursion;

import java.util.Scanner;

public class Q15_Test_Mathmatical_brackets {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();

		System.out.println(isbalanced(s, ""));

	}

	public static boolean isbalanced(String ques, String obsf) { // obsf=open_bracket_so_far
		if (ques.length() == 0) {
			if (obsf.length() == 0) {
				return true;
			}
			return false;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
			return isbalanced(roq, obsf + ch);
		} else if (ch == ')' || ch == ']' || ch == '}' || ch == '>') {
			if (obsf.length() == 0) { // more_close_brackets
				return false;
			}

			char lob = obsf.charAt(obsf.length() - 1); //last_Open_Brackets.
			if (ch == ')' && lob != '(') {
				return false;
			} else if (ch == ']' && lob != '[') {
				return false;
			} else if (ch == '}' && lob != '{') {
				return false;
			} else if (ch == '>' && lob != '<') {
				return false;
			}

			String robsf = obsf.substring(0, obsf.length() - 1); // robsf=rest_open_bracket_so_far.

			return isbalanced(roq, robsf);
		}

		else {
			return isbalanced(roq, obsf);
		}

	}

}