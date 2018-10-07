package Assingment_07_Recursion;

import java.util.Scanner;

public class Q11_Searching_paticular_combination {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String str = scn.nextLine();
		
		System.out.println(countAAAOverlapping(str));
		System.out.println(countAAANoOverlapping(str));
	}
	
	public static int countAAAOverlapping(String str){
		if(str.length() < 3){
			return 0;
		}
		
		String ros = str.substring(1);
		String chk = str.substring(0, 3);
		
		int recResult = countAAAOverlapping(ros);
		int myResult = 0;
		
		if(chk.equals("aaa")){
			myResult = 1 + recResult; 
		} else {
			myResult = recResult;
		}
		
		return myResult;
	}
	
	public static int countAAANoOverlapping(String str){
		if(str.length() < 3){
			return 0;
		}
		
		String chk = str.substring(0, 3);
		int myResult = 0;
		
		if(chk.equals("aaa")){
			String ros = str.substring(3);
			int recResult = countAAANoOverlapping(ros);
			myResult = 1 + recResult; 
		} else {
			String ros = str.substring(1);
			int recResult = countAAANoOverlapping(ros);
			myResult = recResult;
		}
		
		return myResult;
	}

}
