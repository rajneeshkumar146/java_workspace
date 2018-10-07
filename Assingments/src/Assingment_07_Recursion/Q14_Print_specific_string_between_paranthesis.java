package Assingment_07_Recursion;

import java.util.Scanner;

public class Q14_Print_specific_string_between_paranthesis {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		System.out.println("Enter your string");
		String s = scn.nextLine();
		boolean flag = false;
		Print_string(s, "", flag);

	}

	public static void Print_string(String ques, String ans, boolean flag) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		if (ch == '(' && flag==false) {
			flag = true;
			Print_string(roq, ans+'(', flag);
		} else if (ch == ')' && flag==true) {
			flag = false;
			Print_string(roq, ans+')', flag);
		} else if (flag == true) {
			Print_string(roq, ans + ch, flag);
		} else {
			Print_string(roq, ans, flag);
		}
		
	}

}
