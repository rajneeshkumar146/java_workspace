package july17;

public class A7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean Q15(String exp, String obs){
		if(exp.length() == 0){
			if(obs.length() > 0){
				return false;
			} else {
				return true;
			}
		}
		
		char ch = exp.charAt(0);
		String ros = exp.substring(1);
		
		if("({[".indexOf(ch) != -1){
			return Q15(ros, obs + ch);
		} else if(")}]".indexOf(ch) != -1){
			if(obs.length() == 0){
				return false; // extra closing bracket
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
