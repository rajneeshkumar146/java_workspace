package Assingment_05_String;

import java.util.Scanner;

public class Q02_Palidrome_Subsstring {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter your String");
		String s;
		s = scn.nextLine();
		palidrome_ss(s);

	}

	public static void palidrome_ss(String s) {

		int count=0;
		for (int i = 0; i < s.length(); i++) {
			String sb="";
			for (int j = i; j < s.length(); j++) {
				sb = s.substring(i, j + 1);
				boolean result=palidrome(sb);
	            if(result==true){
	            	System.out.println(sb);
	            	count++;
			}
			
            }
		}
		System.out.println(count);

	}

	public static boolean palidrome(String s) {
		for (int le = 0, re = (s.length() - 1); le <= re; le++, re--) {
			if (s.charAt(le) != s.charAt(re)) {
				return false;
			}

		}
		return true;

	}

}
