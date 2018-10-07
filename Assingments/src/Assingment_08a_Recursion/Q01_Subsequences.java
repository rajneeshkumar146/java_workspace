package Assingment_08a_Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Q01_Subsequences {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		System.out.println("Enter your string");
		String s = scn.nextLine();
		
		System.out.println(count_subseq(s));
		
		System.out.println(subsequences02(s));
		
		subsequences03(s, "");
		

	}
	
	public static int count_subseq(String ques){
		if(ques.length()==0){
			return 1;
		}
	
		String roq=ques.substring(1);
		int count_blank=count_subseq(roq);
		int count_contain=count_subseq(roq);
		
		return count_blank+count_contain;
	}

	public static ArrayList<String> subsequences02(String s){
		if(s.length()==0){
			ArrayList<String> recu_res=new ArrayList<>();
			recu_res.add("");
			return recu_res;
		}
		String roq=s.substring(1);
		char ch=s.charAt(0);
		ArrayList<String> result=new ArrayList<>();
		ArrayList<String> recu_res=subsequences02(roq);
		for(String rr:recu_res){
			result.add(rr);
			result.add(ch+rr);
		}
		return result;
		
		
		
	}
	
	public static void subsequences03(String ques,String ans){
		if(ques.length()==0){
			System.out.println(ans);
			return;
		}
		char ch=ques.charAt(0);
		String roq=ques.substring(1);
		subsequences03(roq, ans);
		subsequences03(roq, ans+ch);
		
	}
	
	

}
