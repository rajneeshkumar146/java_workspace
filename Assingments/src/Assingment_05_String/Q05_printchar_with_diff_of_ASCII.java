package Assingment_05_String;

import java.util.Scanner;

public class Q05_printchar_with_diff_of_ASCII {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		String s;
		s = scn.nextLine();
		diff_of_ascii(s);

	}

	public static void diff_of_ascii(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < (s.length() - 1); i++) {
                int count=s.charAt(i+1)-s.charAt(i);
                sb.append(s.charAt(i));
                sb.append(count);
			}
        sb.append(s.charAt((s.length()-1)));
		System.out.println(sb);
	}

}
