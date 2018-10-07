package june22;

public class RecursionClient {

	public static void main(String[] args) {
//		printIncreasing(5);
//		int ins = toh("a", "b", "c", 4);
//		System.out.println(ins);
		
		System.out.println(factorial(5));
		
		System.out.println(powersmarter(1, 1024));
		System.out.println(counter);
//		System.out.println(powersmarter(3, 5));
	}
	
	public static void printDecreasing(int n){
		if(n == 0){
			return;
		}
		
		System.out.println(n);
		printDecreasing(n - 1);
	}
	
	public static void printIncreasing(int n){
		if(n == 0){
			return;
		}
		
		System.out.println("Hi " + n);
		printIncreasing(n - 1);
	}
	
	public static void printDecreasingIncreasing(int n){
		if(n == 0){
			return;
		}
		
		System.out.println(n);
		printDecreasingIncreasing(n - 1);
		System.out.println(n);
	}
	
	public static void printTwoCalls(int n){
		if(n == 0){
			return;
		}
		
		System.out.println("Pre " + n);
		
		printTwoCalls(n - 1);
		
		System.out.println("In " + n);
		
		printTwoCalls(n - 1);
		
		System.out.println("Post " + n);
	}

	// expectation
	// this fn is supposed to print the instructions to move all discs from
	// src to dest, using the helper, and following the rules 
	// rule 1 - move one at a time
	// rule 2 - never put a heavier disc on a lighter one
	// rule 3 - you can pick only the disc at the top
	public static int toh(String src, String dest, 
											   String help, int n){
		if(n == 0){
			return 0;
		}
		
		int c1 = toh(src, help, dest, n - 1); 
		System.out.println("Move " + n + "th disc from " + src + " to " + dest);
		int c2 = toh(help, dest, src, n - 1);
		
		return c1 + 1 + c2;
	}

	public static int factorial(int n){
		if(n == 0){
			return 1;
		}
		
		int fnm1 = factorial(n - 1);
		int fn = n * fnm1;
		
		return fn;
	}
	
	static int counter = 0;
	public static int power(int x, int n){
		if(n == 0){
			return 1;
		}
	
		int xpnm1 = power(x, n - 1);
		int xpn = xpnm1 * x;
		counter++;
		
		return xpn;
	}
	
	public static int powersmarter(int x, int n){
		if(n == 0){
			return 1;
		}
		
		int xpnb2 = powersmarter(x, n / 2);
		int xpn = 1;
		
		if(n % 2 == 0){
			xpn = xpnb2 * xpnb2;
			counter++;
		} else {
			xpn = xpnb2 * xpnb2 * x;
			counter++;
			counter++;
		}
		
		return xpn;
	}
	
	
	
	

}
