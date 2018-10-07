package Class_7th_Matrix_and_Strings;

import java.util.Scanner;

public class String_basic {

	public static void main(String[] args) {
		String s = "hello";
		// printSubstrings(s);
		//System.out.println(palidrome(s));
		//IsPalidrome(s);
		//s=LtoU_vv("rajNEEsh");
		s=cons_dublicate("aabcccdeefg");
		
		s=s_compression("aabcccdeefgggg");
		System.out.println(s);
//		subsequence("abcd");
		

	}

	public static void printSubstrings(String s) {

		for (int i = 0; i < s.length(); i++) {

			for (int j = i; j < s.length(); j++) {
				System.out.println(s.substring(i, j + 1));
			}
		}
	}

	public static boolean palidrome(String s) {
		for (int st = 0, la = s.length() - 1; st <= la; st++, la--) {
			if (s.charAt(st) != s.charAt(la)) {
				return false;

			}
		}
		return true;

	}

	public static void IsPalidrome(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			String ns = "";
			for (int j = i; j < s.length(); j++) {
				ns = s.substring(i, j + 1);
				boolean result = palidrome(ns);
				if (result == true) {
					System.out.println(ns);
					count++;
				}

			}
			System.out.println();
		}
		System.out.println(count);
	}

	public static String LtoU_vv(String s)// Lower to Upper or viceversa
	{
		StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
        	char ch = s.charAt(i);
        	char nch='\0';
        	if(ch>='a' && ch<='z'){
        		nch=(char)(ch-'a'+'A');
        	}
        	else if(ch>='A' && ch<='Z'){
        		nch=(char)(ch-'A'+'a');
        		
        	}
        	
        	sb.append(nch);
        	
        }
        return sb.toString();
	}

    public static String cons_dublicate(String s){
    	
    	StringBuilder sb=new StringBuilder();
    	for(int i=0;i<s.length()-1;i++){
    		
    		if(s.charAt(i)!=s.charAt(i+1)){
    			char nch=s.charAt(i);
    			sb.append(nch);
    		}
    	}
    	sb.append(s.charAt(s.length()-1));
    	return sb.toString();
    }

    public static void nextchar(String s){
    	// StringBuilder sb=new StringBuilder();
    	for(int i=0;i<s.length();i++){
    		char ch=s.charAt(i);
    		if((int)(ch)%2!=0){
    			ch=(char)(ch-1);
    			System.out.println(ch);
    		}
    		
    		else{
    			ch=(char)(ch+1);
    			System.out.println(ch);
    		}
             		
    	}
    	
    }

    public static void ascii(String s){
    	for(int i=0;i<s.length();i++){
    		
    		
    	}
    	
    }
    
    public static String s_compression(String s){
    	StringBuilder sb=new StringBuilder();
    	int count=1;
    	for(int i=0;i<s.length()-1;i++){
    		
            if(s.charAt(i)==s.charAt(i+1)){
    			count++;
    		}
            
            else{
    			char nch=s.charAt(i);
    			sb.append(nch);
    			if(count!=1){
    			sb.append(count);
    			}
    			count=1;
    			
    		}
    
    	}
    	sb.append(s.charAt(s.length()-1));
    	if(count!=1){
			sb.append(count);
			}
    	
    	return sb.toString();
    }
    
}
