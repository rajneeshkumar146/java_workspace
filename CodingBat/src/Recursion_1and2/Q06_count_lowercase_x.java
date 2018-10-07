package Recursion_1and2;

import java.util.Scanner;

public class Q06_count_lowercase_x {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
	    String str=scn.next();
	    
	    System.out.println(count2(str));

	}
	
	public static int count(String ques){
		if(ques.length()==0){
			return 0;
		}
		char ch=ques.charAt(0);
		String roq=ques.substring(1);
		
		int result=count(roq);
		
		if(ch=='x' && 'z'>=ch && ch>='a'){
			result+=1;
		}
		 return result;
		
	}

	public static int count2(String ques){
		if(ques.length()==0){
			return 0;
		}
		char ch=ques.charAt(0);
		String roq=ques.substring(1);
		
		int result=0;
		
		if(ch=='x' && 'z'>=ch && ch>='a'){
			result=1+count2(roq);
		}else{
			result=count2(roq);
		}
		 return result;
		
	}

}
