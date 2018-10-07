package Recursion_1and2;

import java.util.Scanner;

public class Q09_changePi {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
	    String str=scn.next();
	    
	    System.out.println(changePI(str));

	}
	
	public static String changePI(String str){
		if(str.length()<=1){
			return str;
		}
		
		char ch=str.charAt(0);
		String roq=str.substring(2);
		String check=str.substring(0, 2);
		String result="";
		if(check.equals("pi")){
			result=3.14+changePI(roq);

		}else{
			String roq1=str.substring(1);
			result=ch+changePI(roq1);
		}
		
		return result;
		
		
	}

}
