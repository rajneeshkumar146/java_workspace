package july16;

public class Asgn7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean Q15(String str, String obs){
		if(str.length() == 0){
			if(obs.length() > 0){
				return false;
			} else {
				return true;
			}
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		if (ch == '(' || ch == '{' || ch == '['){
			return Q15(ros, obs + ch);
		}
		else if (ch == ')' || ch == '}' || ch == ']'){
			if(obs.length() == 0){
				return false;
			}
			
			char lob = obs.charAt(obs.length() - 1);
			
			if(ch == ')' && lob != '('){
				return false;
			} else if(ch == '}' && lob != '{'){
				return false;
			} else if(ch == ']' && lob != '['){
				return false;
			} else {
				return Q15(ros, obs.substring(0, obs.length() - 1));
			}
		} else {
			return Q15(ros, obs);
		}
		
	}

}
