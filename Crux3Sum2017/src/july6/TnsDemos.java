package july6;

import java.util.Arrays;

public class TnsDemos {
	static long startTime = 0;
	static long endTime = 0;
	
	public static void startWatch(){
		startTime = System.currentTimeMillis();
	}
	
	public static void endWatch(String algo, int n){
		endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println(algo + " took " + duration + " ms for n = " + n);
	}
	
	public static void main(String[] args) {
//		int n = 10000000;
//		
//		startWatch();
//		printPrimesRegular(n);
//		endWatch("SOE", n);
		
		System.out.println(countPalindromicSS("nitin"));
	}
	
	public static void printPrimesRegular(int n){
		for(int i = 2; i <= n; i++){
			boolean isPrime = IsPrime(i);
			if(isPrime){
//				System.out.println(i);
			}
		}
	}
	
	public static boolean IsPrime(int n2test){
		for(int div = 2; div * div <= n2test; div++){
			if(n2test % div == 0){
				return false;
			}
		}
		
		return true;
	}

	public static void printPrimesSOE(int n){
		boolean[] primes = new boolean[n + 1];
		
		Arrays.fill(primes, true);
		
		primes[0] = false;
		primes[1] = false;
		
		for(int i = 2; i * i <= n; i++){
			if(primes[i] == false){
				continue;
			}
			
			for(int j = 2; i * j <= n; j++){
				primes[i * j] = false;
			}
		}
		
//		for(int i = 2; i <= n; i++){
//			if(primes[i] == true){
//				System.out.println(i);
//			}
//		}
	}

	public static int countPalindromicSS(String s){
		int count = 0;
		
		// odd
		for(int axis = 0; axis < s.length(); axis++){
			for(int orbit = 0; (axis - orbit) >= 0 && (axis + orbit) < s.length(); orbit++){
				if(s.charAt(axis - orbit) == s.charAt(axis + orbit)){
					count++;
				} else {
					break;
				}
			}
		}
		
		// even
		for(double axis = 0.5; axis < s.length(); axis++){
			for(double orbit = 0.5; (axis - orbit) >= 0 && (axis + orbit) < s.length(); orbit++){
				if(s.charAt((int)(axis - orbit)) == s.charAt((int)(axis + orbit))){
					count++;
				} else {
					break;
				}
			}
		}
		
		return count;
	}

	
}
