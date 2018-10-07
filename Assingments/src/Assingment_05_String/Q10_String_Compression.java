package Assingment_05_String;

import java.util.Scanner;

public class Q10_String_Compression {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
//		System.out.println("Enter your String");
		String s;
		s = scn.nextLine();
		System.out.println(string_compression(s));

	}

	public static String string_compression(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 0; i < (s.length() - 1); i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				count++;
			} else {
				sb.append(s.charAt(i));
				if (count != 1) {
					sb.append(count);
				}
				count = 1;
			}
		}
		sb.append(s.charAt(s.length() - 1));
		if (count != 1) {
			sb.append(count);
		}
		return sb.toString();

	}

}
