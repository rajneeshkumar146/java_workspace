package Recursion_1and2;

import java.util.Scanner;

public class Q07_countHi {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
	    String str=scn.next();
	    
	    System.out.println(count(str));

	}
	
	public static int count(String str){
		if(str.length()<=1){
			return 0;
		}
		
		
		String roq=str.substring(2);
		String check=str.substring(0, 2);
		int result=0;
		if(check.equals("hi")){
			result=1+count(roq);
		}else{
			String roq1=str.substring(1);
			result=0+count(roq1);
		}
		
		return result;
	}
}
