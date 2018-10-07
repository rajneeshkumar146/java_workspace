package june14;

public class ncr {

	public static void main(String[] args) {
		int n = 5;
		int r = 3;
		
		int nfact = factorial(n);
		int rfact = factorial(r);
		int nmrfact = factorial(n - r);
		
		int ncr = nfact / (rfact * nmrfact);
		System.out.println(ncr);
	}
	
	
	private static int factorial(int x){
		int fact = 1;
		
		int cnt = 1;
		while(cnt <= x){
			fact = fact * cnt;
			cnt++;
		}
		
		return fact;
	}

}
