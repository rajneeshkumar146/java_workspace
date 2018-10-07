package Assingment_05_String;

import java.util.Scanner;

public class Q03_Toggel {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		String s;
		s = scn.nextLine();
		
		toggel(s);

	}

	public static void toggel(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				char ch1 = (char) (ch - 'a' + 'A');
				sb.append(ch1);
			}
			if (ch >= 'A' && ch <= 'Z') {
				char ch1 = (char) (ch - 'A' + 'a');
				sb.append(ch1);
			}

		}
		System.out.println(sb);
	}
}
