package july31;

import java.util.Arrays;

public class FnOverloadingClient {

	public static void main(String[] args) {
//		System.out.println(Add(1, 2));
//		System.out.println(Add(11.5, 15.6));
		System.out.println(Add(1, 2));
	}
	
	public static int Add(int one, int two){
		return one + two;
	}

	public static double Add(double one, double two){
		return one + two;
	}
	
	// return types dont' participate in fn overloading
//	public static void Add(int one, int two){
//		
//	}
	
	public static int Add(int... manyargs){
		int sum = 0;
		
		for(int i = 0 ; i < manyargs.length; i++){
			sum += manyargs[i];
		}
		
		return sum;
	}
	
	
}
