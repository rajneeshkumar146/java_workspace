package Recursion_1and2;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class Q08_changeXY {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
	    String str=scn.next();
	    
	    System.out.println(changeXY(str));

	}
	
	public static String changeXY(String str){
		if(str.length()==0){
			return "";
		}
		
		char ch=str.charAt(0);
		String roq=str.substring(1);
		String result=changeXY(roq);
		if(ch=='x'&& ch>='a' && ch<='z'){
		result=(char)(ch+1)+result;	
		}else{
			result=ch+result;	
		}
		
		return result;
		
	}

}
