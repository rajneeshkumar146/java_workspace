package Assingment_05_String;

import java.util.Scanner;

public class Q04_Replace_char_Higerlower_ASCII_code {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		String s;
		s = scn.nextLine();
		replace(s);

	}

	public static void replace(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (i % 2 == 0) {
				ch = (char) (ch + 1);
				sb.append(ch);

			}else{
				ch = (char) (ch - 1);
				sb.append(ch);
			}

		}
		System.out.println(sb);

	}

}
