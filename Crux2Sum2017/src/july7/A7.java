package july7;

public class A7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean IsBalanced(String exp, String obsf){
		if(exp.length() == 0){
			if(obsf.length() != 0){
				return false; // more opening bracks
			}
			return true;
		}
		
		char ch = exp.charAt(0);
		String ros = exp.substring(1);
		
		if(ch == '(' || ch == '{' || ch == '['){
			return IsBalanced(ros, obsf + ch);
		} else if (ch == ')' || ch == '}' || ch == ']'){
			if(obsf.length() == 0){
				return false; // closing is more
			}
			
			char lob = obsf.charAt(obsf.length() - 1);
			if(ch == ')' && lob != '('){
				return false; // mismatach
			} else if(ch == '}' && lob != '{'){
				return false; // mismatach
			} else if(ch == ']' && lob != '['){
				return false; // mismatach
			}
			
			String robsf = obsf.substring(0, obsf.length() - 1);
			return IsBalanced(ros, robsf);
		} else {
			return IsBalanced(ros, obsf);
		}
		
	}

	public static int countTwins(String str){
		if(str.length() <= 2){
			return 0;
		}
		
		String ros = str.substring(1);
		
		if(str.charAt(0) == str.charAt(2)){
			// no overlap
//			String ros3 = str.substring(3);
//			return 1 + countTwins(ros3);
			return 1 + countTwins(ros);
		} else {
			return countTwins(ros);
		}
	}
}
