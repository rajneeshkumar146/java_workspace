package Assingment_07_Recursion;

import java.util.Scanner;

public class Q09_Removing_replace_counting_words_which_is_not_followed_by_aspecific_characcter {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		System.out.println("Enter your string");
		String s = scn.next();
		int n=scn.nextInt();

//		System.out.println(countHi(s));
//		System.out.println(removeHi(s).charAt(n));
//		System.out.println(removeHi(s + ""));
		
		System.out.println(replaceHipep(s).charAt(n));
		replaceHi(s, "");

	}

	public static int countHi(String str) {
		if (str.length() < 2) {
			return 0;
		}

		String chkHi = str.substring(0, 2);
		String chkHit = "";

		if (str.length() >= 3) {
			chkHit = str.substring(0, 3);
		}

		if (chkHi.equals("hi") && !chkHit.equals("hit")) {
			String ros = str.substring(2);
			return 1 + countHi(ros);
		} else {
			String ros = str.substring(1);
			return countHi(ros);
		}
	}

	public static String removeHi(String str) {
		if (str.length() < 2) {
			return str;
		}

		String chkHi = str.substring(0, 2);
		String chkHit = "";

		if (str.length() >= 3) {
			chkHit = str.substring(0, 3);
		}

		if (chkHi.equals("hi") && !chkHit.equals("hit")) {
			String ros = str.substring(2);
			return removeHi(ros);
		} else {
			String ros = str.substring(1);
			char cc = str.charAt(0);

			return cc + removeHi(ros);
		}
	}

	public static void removeHi(String ques, String ans) {
		if (ques.length() < 2) {
			System.out.print(ans + ques);
			return;
		}

		String chkHi = ques.substring(0, 2);
		String chkHit = "";

		if (ques.length() >= 3) {
			chkHit = ques.substring(0, 3);
		}

		if (chkHi.equals("hi") && !chkHit.equals("hit")) {
			removeHi(ques.substring(2), ans);
		} else {
			removeHi(ques.substring(1), ans + ques.charAt(0));
		}

	}

	public static String replaceHipep(String str) {
		if (str.length() < 2) {
			return str;
		}

		String chkHi = str.substring(0, 2);
		String chkHit = "";

		if (str.length() >= 3) {
			chkHit = str.substring(0, 3);
		}

		if (chkHi.equals("hi") && !chkHit.equals("hit")) {
			String ros = str.substring(2);
			return "pep" + replaceHipep(ros);
		} else {
			String ros = str.substring(1);
			char cc = str.charAt(0);

			return cc + replaceHipep(ros);
		}
	}
	
	public static void replaceHi(String ques, String ans) {
		if (ques.length() < 2) {
			System.out.print(ans + ques);
			return;
		}

		String chkHi = ques.substring(0, 2);
		String chkHit = "";

		if (ques.length() >= 3) {
			chkHit = ques.substring(0, 3);
		}

		if (chkHi.equals("hi") && !chkHit.equals("hit")) {
			replaceHi(ques.substring(2), ans + "pep");
		} else {
			replaceHi(ques.substring(1), ans + ques.charAt(0));
		}

	}

}
