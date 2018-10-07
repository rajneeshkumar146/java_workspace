package Recursion_1and2;

import java.util.Scanner;

public class Q10_remove_x_char {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
	    String str=scn.next();
	    
	    System.out.println(removeChar(str));
	}

	public static String removeChar(String str) {
		if (str.length() == 0) {
			return "";
		}
		char ch = str.charAt(0);
		String roq = str.substring(1);
		String res = "";
		if (ch != 'x') {
			res = ch + removeChar(roq);
		} else {
			res = removeChar(roq);
		}

		return res;

	}

}
