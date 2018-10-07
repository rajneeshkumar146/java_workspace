package Class_10th_Recursion_2;

import java.util.ArrayList;

public class Key_pad_word {

	public static void main(String[] args) {
		String str="69";
		ArrayList<String> list= get_key_pad_word(str);
		System.out.println(list);

	}
	
	public static String getcode(char ch){
		if(ch=='1'){
			return "abc";
		}
		else if (ch=='2'){
			return "def";
		}
		else if (ch=='3'){
			return "ghi";
		}
		else if (ch=='4'){
			return "gil";
		}
		else if (ch=='5'){
			return "mno";
		}
		else if (ch=='6'){
			return "pqrs";
		}
		else if (ch=='7'){
			return "tuv";
		}
		else if (ch=='8'){
			return "wx";
		}
		else if (ch=='9'){
			return "yz";
		}
		else{
			return "./_";
		}
	}

	public static ArrayList<String> get_key_pad_word(String s){
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		
		
		char ch=s.charAt(0);
		String sb=s.substring(1);
		
		
		ArrayList<String> recu_arr=get_key_pad_word(sb);
		ArrayList<String> result=new ArrayList<>();
		
		for(String rr:recu_arr){
			String code=getcode(ch);
			for(int i=0;i<code.length();i++){
				result.add(code.charAt(i)+rr);
			}
		}
		return result;
		
	}
}
