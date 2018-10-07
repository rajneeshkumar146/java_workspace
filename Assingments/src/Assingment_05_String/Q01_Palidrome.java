package Assingment_05_String;

import java.util.Scanner;

public class Q01_Palidrome {
	
	public static Scanner scn=new Scanner(System.in);
    
	public static void main(String[] args) {
		String s;
		s=scn.nextLine();
		s=lower_case(s);
		System.out.println(palidrome(s));
		
	}
	
	public static String lower_case(String s){
		StringBuilder sb=new StringBuilder(s);
		for(int i=0;i<sb.length();i++){
			char ch=sb.charAt(i);
			if(ch>='A' && ch<='Z'){
                ch=(char)(ch-'A'+'a');
                sb.setCharAt(i, ch);
                        
			}
		}
		return sb.toString();
		
	}
	
	public static boolean palidrome(String s){
		for(int le=0,re=(s.length()-1);le<=re;le++,re--){  // le=left,re=reight
			if(s.charAt(le)!=s.charAt(re)){
				return false;
			}
			
		}
		return true;
		
		
	}

}
