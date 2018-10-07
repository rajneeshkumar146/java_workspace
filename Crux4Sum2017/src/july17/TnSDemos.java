package july17;

import java.util.Arrays;

public class TnSDemos {
	public static long start = 0;
	
	public static void startWatch(String algo, int n){
		start = System.currentTimeMillis();
		System.out.println(algo + "[input=" + n + "] starts");
	}
	
	public static void endWatch(String algo, int n){
		long end = System.currentTimeMillis();
		System.out.println(algo + "[input=" + n + "] took " + (end - start) + " ms.");
	}
	
	public static void main(String[] args) {
		// int[] one = {10, 20, 30, 40, 50};
		// int[] two = {11, 15, 35, 42, 47};
		// int[] merged = mergeTwoSortedArrays(one, two);

//		int[] arr = { 10, 3, 45, 15, 7, 18, -1, 19 };
//		arr = mergeSort(arr, 0, arr.length - 1);
//		quickSort(arr, 0, arr.length - 1);
//		july4.ArraysCtd.display(arr);
//		int n = 10000000;
//		
//		startWatch("Normal", n);
//		printprimes(n);
//		endWatch("Normal", n);
		
//		startWatch("SOE", n);
//		printprimessoe(n);
//		endWatch("SOE", n);
		
//		int[] arr = new int[n];
//		for(int i = 0; i < arr.length; i++){
//			arr[i] = n - i;
//		}
//		
//		startWatch("MS", n);
//		quickSort(arr, 0, arr.length - 1);
//		endWatch("MS", n);
		
//		startWatch("BS", n);
//		bubbleSort(arr);
//		endWatch("BS", n);
		
		System.out.println(countPalindromicSS("abbaba"));
	}
	
	public static void bubbleSort(int[] arr) {
		int counter = 1;

		while (counter <= arr.length - 1) {
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i] > arr[i + 1]) {
					Swap(arr, i, i + 1);
				}
			}

			counter++;
		}
	}
	
	public static void Swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {
		int[] result = new int[one.length + two.length];

		int i = 0, j = 0, k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				result[k] = one[i];
				i++;
				k++;
			} else {
				result[k] = two[j];
				j++;
				k++;
			}
		}

		while (i < one.length) {
			result[k] = one[i];
			i++;
			k++;
		}

		while (j < two.length) {
			result[k] = two[j];
			j++;
			k++;
		}

		return result;
	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;
		int[] fhalf = mergeSort(arr, lo, mid);
		int[] shalf = mergeSort(arr, mid + 1, hi);

		int[] sorted = mergeTwoSortedArrays(fhalf, shalf);
		return sorted;
	}

	public static void quickSort(int[] arr, int lo, int hi) {
		if(lo >= hi){ // why >? [10, 20]
			return;
		}
		
		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		int left = lo, right = hi;
		while (left <= right) { // why crossover? [10, 20]
			while (arr[left] < pivot) { // why not equal? [10, 20, 100, 50, 60]
				left++;
			}

			while (arr[right] > pivot) { // why not equal? [10, 20, -10, 50, 60]
				right--;
			}

			if (left <= right) { // clear?
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}

		//smaller
		quickSort(arr, lo, right);
		// larger
		quickSort(arr, left, hi);
	}

	public static void printprimessoe(int n){
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		
		primes[0] = false;
		primes[1] = false;
		
		for(int i = 2; i * i <= n; i++){
			if(primes[i] == false){
				continue;
			}
			
			for(int za = 2; i * za <= n; za++){
				primes[i * za] = false;
			}
		}
		
		for(int i = 0; i <= n; i++){
			if(primes[i]){
//				System.out.println(i);
			}
		}
	}
	
	public static void printprimes(int n){
		for(int i = 2; i <= n; i++){
			boolean result = IsPrime(i);
			
			if(result == true){
//				System.out.println(i);
			}
		}
	}
	
	public static boolean IsPrime(int num){
		for(int div = 2; div * div <= num; div++){
			if(num % div == 0){
				return false;
			}
		}
		
		return true;
	}
	
	public static int countPalindromicSS(String s){
		// odd
		int count = 0;
		for(int axis = 0; axis < s.length(); axis++){
			for(int orbit = 0; axis + orbit < s.length() && axis - orbit >= 0; orbit++){
				if(s.charAt(axis + orbit) == s.charAt(axis - orbit)){
					count++;
				} else {
					break;
				}
			}
		}
		
		// even
		for(double axis = 0.5; axis < s.length(); axis++){
			for(double orbit = 0.5; axis + orbit < s.length() && axis - orbit >= 0; orbit++){
				if(s.charAt((int)(axis + orbit)) == s.charAt((int)(axis - orbit))){
					count++;
				} else {
					break;
				}
			}
		}
		
		return count;
	}
	
}
