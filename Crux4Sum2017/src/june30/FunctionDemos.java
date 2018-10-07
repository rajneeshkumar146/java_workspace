package june30;

public class FunctionDemos {
	
	public static int GLOBAL = 20;
	
	public static void main(String[] args) {
		// Part 1 - Normal Function
//		System.out.println("Hello World");
//		HelloFun();
		
		// Part 2 - Multiple calls
//		System.out.println("Hello World");
//		HelloFun();
//		System.out.println("Hello World");
//		HelloFun();
		
		// Part 3 - Multiple functions
//		System.out.println("Hello World");
//		HelloFun();
//		HelloGun();
		
		// Part 4 - Function making call to another function
//		System.out.println("Hello World");
//		HelloNestedFun();
//		System.out.println("Hello World");
//		HelloNestedFun();
		
		// Part 5 - Function with parameters
//		System.out.println("Hello World");
//		HelloFunWithParams("Hello from main");
		
		// Part 6 - Function with return value
//		System.out.println("Hello World");
//		String value = HelloFunWithReturns("Hello from main");
//		System.out.println(value);
		
		// Part 7 - Function to demo scope of variables
		int one = 10, two = 20;
		int sum = DemoScopes(one, two);
		System.out.println(sum);
		
		// Part 8 - Global scopes
		System.out.println(GLOBAL);
		int GLOBAL = 200;
		System.out.println(GLOBAL);
		System.out.println(FunctionDemos.GLOBAL);
		DemoGlobalScopes(one);
		
		// Part 9 - Scopes in blocks
		if(one < two){
//			int one = 20;
			int three = 30;
		}
//		System.out.println(three);
		
		// Part 10 - Pass by value
		System.out.println(one + ", " + two);
		Swap(one, two);
		System.out.println(one + ", " + two);
	}
	
	private static void Swap(int one, int two) {
		System.out.println(one + ", " + two);
		
		int temp = one;
		one = two;
		two = temp;
		
		System.out.println(one + ", " + two);
	}
	
	private static int DemoGlobalScopes(int one) {
		int sum = one + GLOBAL;
		return sum;
	}
	
	public static int DemoScopes(int one, int another){
//		int one = 10;
//		int sum = one + two;
		int sum = one + another;
		return sum;
	}
	
	public static String HelloFunWithReturns(String msg){
		String retVal = "I did your work";
		
		HelloFunWithParams(msg);
		
		return retVal;
	}
	
	public static void HelloFunWithParams(String msg){
		System.out.println("Your message is : " + msg);
	}
	
	public static void HelloNestedFun(){
		System.out.println("Hello Nested Fun");
		HelloFun();
		
		System.out.println("Hello Nested Fun");
		HelloGun();
	}
	
	public static void HelloFun(){
		System.out.println("Hello Fun");
	}
	
	public static void HelloGun(){
		System.out.println("Hello Gun");
	}

}
