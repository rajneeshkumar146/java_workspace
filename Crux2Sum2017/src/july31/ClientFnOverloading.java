package july31;

import java.util.Arrays;

public class ClientFnOverloading {

	public static void main(String[] args) {
		int sum = Add(1, 2);
	}
	
	public static int Add(int one, int two){
		return one + two;
	}
//	
//	public static double Add(double one, double two){
//		return one + two;
//	}
//	
//	public static String Add(String one, String two){
//		return one + two;
//	}
	
	public static int Add(int... numbers){
		int rv = 0;
		
		for(int i = 0; i < numbers.length; i++){
			rv = numbers[i];
		}
		
		return rv;
	}
	
	

}
