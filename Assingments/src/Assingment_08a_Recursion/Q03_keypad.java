package Assingment_08a_Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Q03_keypad {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String n = scn.next();

		System.out.println(count_keypad(n));

		System.out.println(keypad03(n));

		keypad02(n, "");

	}

	public static String getcode(char ch) {
		if (ch == '1') {
			return "abc";
		} else if (ch == '2') {
			return "def";
		} else if (ch == '3') {
			return "ghi";
		} else if (ch == '4') {
			return "gil";
		} else if (ch == '5') {
			return "mno";
		} else if (ch == '6') {
			return "pqrs";
		} else if (ch == '7') {
			return "tuv";
		} else if (ch == '8') {
			return "wx";
		} else if (ch == '9') {
			return "yz";
		} else {
			return "./_";
		}
	}

	public static int count_keypad(String ques) {

		if (ques.length() == 0) {

			return 1;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		String code = getcode(ch);
		int count = 0;
		for (int i = 0; i < code.length(); i++) {
			count += count_keypad(roq);
		}
		return count;
	}

	public static void keypad02(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		String code = getcode(ch);

		for (int i = 0; i < code.length(); i++) {
			keypad02(roq, ans + code.charAt(i));
		}
	}

	public static ArrayList<String> keypad03(String ques) {

		if (ques.length() == 0) {
			ArrayList<String> recu_res = new ArrayList<>();
			recu_res.add("");
			return recu_res;

		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		ArrayList<String> result = new ArrayList<>();
		ArrayList<String> recu_res = keypad03(roq);

		for (String rr : recu_res) {
			for (int i = 0; i < getcode(ch).length(); i++) {
				result.add(getcode(ch).charAt(i) + rr);
			}
		}
		return result;

	}

}
