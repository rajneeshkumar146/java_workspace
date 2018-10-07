package june16;

public class RecursionDemos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PrintDI(6);
		System.out.println(PowerBtr(2, 8));
	}

	public static void PrintDecreasing(int n) {
		if (n == 0) {
			return;
		}

		System.out.println(n);
		PrintDecreasing(n - 1);
	}

	public static void PrintIncreasing(int n) {
		if (n == 0) {
			return;
		}

		PrintIncreasing(n - 1);
		System.out.println(n);
	}

	public static void PrintDI(int n) {
		if (n == 0) {
			return;
		}

		if (n % 2 == 1) {
			System.out.println("Hi " + n);
		}

		PrintDI(n - 1);

		if (n % 2 == 0) {
			System.out.println("Bye " + n);
		}
	}

	public static int Factorial(int n){
		if(n == 0){
			return 1;
		}
		
		int fnm1 = Factorial(n - 1);
		int fn = n * fnm1;
		
		return fn;
	}
	
	public static int Power(int x, int n){
		if(n == 0){
			return 1;
		}
		
		int xpnm1 = Power(x, n - 1);
		int xpn = xpnm1 * x;
		
		return xpn;
	}
	
	public static int PowerBtr(int x, int n){
		if(n == 0){
			return 1;
		}
		
		int xpnb2 = PowerBtr(x, n / 2);
		int xpn = xpnb2 * xpnb2;
		
		if(n % 2 == 1){
			xpn = xpn * x;
		}
		
		return xpn;
		
	}
	
	
	
	
	
	
	
	
}
