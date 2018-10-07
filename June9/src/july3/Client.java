package july3;

import java.util.Arrays;

public class Client {

	public static void main(String[] args) {
		// int n = 10000000;

		// long s1 = System.currentTimeMillis();
		// printPrimes(n);
		// long e1 = System.currentTimeMillis();
		// System.out.println(e1 - s1);

		// long s2 = System.currentTimeMillis();
		// printPrimesSOE(n);
		// long e2 = System.currentTimeMillis();
		// System.out.println(e2 - s2);

		// System.out.println(highestFrequencyCharacter("aggbgbcgbaagbccggbbca"));

//		int[] arr1 = { 5, 9, 8, 7, 5, 7, 8 };
//		System.out.println(uniqueNumber(arr1));
//
//		int[] arr2 = { 3, 1, 2, 4, 4, 6, 5 };
//		System.out.println(duplicateNumber(arr2));
		
//		int[] arr = {0, 1, 1, 0, 1, 0, 0, 0, 1};
//		sort01(arr);
		
		int[] arr = {0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0};
		sort012(arr);
		
//		int[] arr = {75, 12, 62, 25, 87, 37, 50};
//		targetSumPair(arr, 99);
	}

	private static void printPrimes(int n) {
		int count = 0;

		for (int i = 2; i <= n; i++) {
			if (isPrime(i) == true) {
				count++;
				// System.out.println(i);
			}
		}

		System.out.println(count);
	}

	private static boolean isPrime(int n) {
		int d = 2;
		while (d * d <= n) {
			if (n % d == 0) {
				return false;
			}
			d++;
		}

		return true;
	}

	private static void printPrimesSOE(int n) {
		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int i = 2; i * i <= n; i++) {
			if (primes[i] == true) {
				for (int j = i; i * j <= n; j++) {
					primes[i * j] = false;
				}
			}
		}

		for (int i = 0; i < primes.length; i++) {
			if (primes[i] == true) {
				System.out.println(i);
			}
		}
	}

	// on
	private static char highestFrequencyCharacter(String str) {
		int[] fmap = new int[26];

		for (int i = 0; i < str.length(); i++) {
			fmap[str.charAt(i) - 97]++;
		}

		int mfidx = 0;
		for (int i = 1; i < fmap.length; i++) {
			if (fmap[i] > fmap[mfidx]) {
				mfidx = i;
			}
		}

		return (char) (mfidx + 97);
	}

	public static int uniqueNumber(int[] arr) {
		int res = 0;

		for (int i = 0; i < arr.length; i++) {
			res = res ^ arr[i];
		}

		return res;
	}

	public static int duplicateNumber(int[] arr) {
		int res = 0;

		for (int i = 0; i < arr.length; i++) {
			res = res ^ arr[i] ^ i;
		}

		return res;
	}

	public static void sort01(int[] arr){
		int i = 0;
		int z = 0;
		
		while( i < arr.length){
			if(arr[i] == 1){
				i++;
			} else {
				swap(arr, i, z);
				i++;
				z++;
			}
		}
		
		for(int val: arr){
			System.out.print(val + " ");
		}
		System.out.println(".");
	}
	
	public static void sort012(int[] arr){
		int i = 0;
		int z = 0;
		int t = arr.length - 1;
		
		// 0 to z - 1 -> 0's
		// z to i - 1 -> 1's
		// i to t -> unknowns
		// t + 1 to arr.length - 1 -> 2's
		while(i <= t){
			if(arr[i] == 1){
				i++;
			} else if(arr[i] == 0){
				swap(arr, i, z);
				i++;
				z++;
			} else if(arr[i] == 2){
				swap(arr, i, t);
				t--;
			}
		}
		
		for(int val: arr){
			System.out.print(val + " ");
		}
		System.out.println(".");
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void targetSumPair(int[] arr, int tar){
		Arrays.sort(arr);
		
		int left = 0;
		int right = arr.length - 1;
		while(left < right){
			if(arr[left] + arr[right] == tar){
				System.out.println(arr[left] + " " + arr[right]);
				left++;
				right--;
			} else if(arr[left] + arr[right] < tar){
				left++;
			} else {
				right--;
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
