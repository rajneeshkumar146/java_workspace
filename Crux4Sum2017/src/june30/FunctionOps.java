package june30;

public class FunctionOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int x = 3;
//		int n = 5;
//		
//		int pow = Power(x, n);
//		int log = Log(pow, x);
//		
//		System.out.println(pow);
//		System.out.println(log);
		
		System.out.println(IsPrime(7));
		printPrimes(20, 120);
	}
	
	public static int Power(int x, int n){
		// x ^ n
	}
	
	public static int Log(int x, int n){
		// Log (x) to the base n 
	}

	public static boolean IsPrime(int n){
		boolean prime = true;
		
		int div = 2;
		while(div * div <= n){
			if(n % div == 0){
				prime = false;
				break;
			}
			
			div++;
		}
		
		return prime;
	}
	
	public static void printPrimes(int n1, int n2){
		for(int i = n1; i <= n2; i++){
			boolean isprime = IsPrime(i);
			if(isprime){
				System.out.println(i);
			}
		}
	}
}
