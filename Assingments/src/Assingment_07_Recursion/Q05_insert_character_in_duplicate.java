package Assingment_07_Recursion;

import java.util.Scanner;

public class Q05_insert_character_in_duplicate {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
//		System.out.println("Enter your String");
		String s = scn.next();
		int i=scn.nextInt();

		System.out.println(insert_btw_duplicate(s).charAt(i));
		btr_insert_btw_duplicate(s,"");

	}

	public static String insert_btw_duplicate(String str) {
		if (str.length() == 1) {
			return str.substring(0, 1);
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		String result = insert_btw_duplicate(ros);
		if (ch != result.charAt(0)) {
			result = ch + result;
		} else {
			result = ch + "*" + result;
		}

		return result;
	}

	public static void btr_insert_btw_duplicate(String ques, String ans) {  // ques+ans_approach
		if (ques.length() == 1) {
			System.out.println(ans + ques.charAt(0));
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);  //roq=rest_of_question

		if (ques.charAt(0) == ques.charAt(1)) {
			btr_insert_btw_duplicate(roq, ans + ch + '*');
		} else {
			btr_insert_btw_duplicate(roq, ans + ch);
		}

	}

}
