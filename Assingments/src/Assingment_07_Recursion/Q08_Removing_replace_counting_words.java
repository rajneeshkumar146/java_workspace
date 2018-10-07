package Assingment_07_Recursion;

import java.util.Scanner;

import org.omg.CORBA.portable.RemarshalException;

public class Q08_Removing_replace_counting_words {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// System.out.println("Enter your string");

		String s = scn.next();
		int n = scn.nextInt();

		System.out.println(replace_word(s).charAt(n));
		replace_word(s, "");

		// System.out.println(count_word(s));
		// System.out.println(removing_word(s).charAt(n));
		// removing_word(s, "");

	}

	public static String replace_word(String ques) {
		if (ques.length() < 2) {
			return ques;
		}

		String suspect = ques.substring(0, 2);
		if (suspect.equals("hi")) {
			String res = replace_word(ques.substring(2));
			res = "pep" + res;
			return res;
		} else {
			String res = replace_word(ques.substring(1));
			res = ques.charAt(0) + res;
			return res;
		}

	}

	public static void replace_word(String ques, String ans) {
		if (ques.length() < 2) {
			System.out.println(ans + ques);
			return;
		}

		String suspect = ques.substring(0, 2);

		if (suspect.equals("hi")) {
			String roq = ques.substring(2);
			replace_word(roq, ans + "pep");
		} else {
			char ch = ques.charAt(0);
			String roq = ques.substring(1);
			replace_word(roq, ans + ch);
		}

	}

	public static String removing_word(String str) {
		if (str.length() < 2) {
			return str.substring(0);
		}

		String chk = str.substring(0, 2);

		if (chk.equals("hi")) {
			String ros = str.substring(2);
			return removing_word(ros);
		} else {
			String ros = str.substring(1);
			char cc = str.charAt(0);

			return cc + removing_word(ros);
		}

	}

	public static void removing_word(String ques, String ans) {
		if (ques.length() < 2) {
			System.out.print(ans + ques);
			return;
		}

		String check = ques.substring(0, 2);
		if (check.equals("hi")) {
			removing_word(ques.substring(2), ans);
		} else {
			removing_word(ques.substring(1), ans + ques.charAt(0));
		}

	}

	public static int count_word(String ques) {

		if (ques.length() < 2) {
			return 0;
		}

		String check = ques.substring(0, 2);
		if (check.equals("hi")) {
			return count_word(ques.substring(2)) + 1;
		} else {
			return count_word(ques.substring(1));
		}

	}

}