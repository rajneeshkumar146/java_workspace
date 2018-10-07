package Assingment_05_String;

import java.util.Scanner;

public class Q09_Remving_Consecutive_Duplicate {
	
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
//		System.out.println("Enter your String");
		String s;
		s = scn.nextLine();
		System.out.println(consecutive_duplicate(s));

	}
	
	public static String consecutive_duplicate(String s){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length()-1;i++){
			if(s.charAt(i)!=s.charAt(i+1)){
				sb.append(s.charAt(i));
			}
		}
		sb.append(s.charAt(s.length()-1));
		return sb.toString();
	}

}
