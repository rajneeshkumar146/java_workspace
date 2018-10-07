package july2;

public class mergesort {

	public static void main(String[] args) {
//		int[] one = {2, 5, 7, 15, 20};
//		int[] two = {3, 9, 11, 16, 25, 30};
//		int[] sorted = merging(one, two);
//		int[] arr = {2, 8, 1, 0, 5, 3, 9, 7};
//		int[] sarr = mergesort(arr, 0, arr.length - 1);
//		for(int val: sarr){
//			System.out.print(val + " ");
//		}
//		System.out.println(".");
		
		int n = 1000000;
		
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		
		for(int i = 0; i < arr1.length; i++){
			arr1[i] = arr1.length - i;
			arr2[i] = arr2.length - i;
		}
		
		long s1 = System.currentTimeMillis();
		arr1 = mergesort(arr1, 0, arr1.length - 1);
		long e1 = System.currentTimeMillis();
		long d1 = e1 - s1;
		
		System.out.println("Merge sort for n = " + n + " took " + d1 + " ms");
		
		long s2 = System.currentTimeMillis();
		june20.Client.bubbleSort(arr2);
		long e2 = System.currentTimeMillis();
		long d2 = e2 - s2;
		
		System.out.println("Bubble sort for n = " + n + " took " + d2 + " ms");
	}
	
	public static int[] mergesort(int[] arr, int lo, int hi){
		if(lo == hi){
			int[] ba = new int[1];
			ba[0] = arr[lo];
			return ba;
		}
		
		int mid = (lo + hi) / 2;
		int[] lhalf = mergesort(arr, lo, mid);
		int[] rhalf = mergesort(arr, mid + 1, hi);
		int[] sorted = merging(lhalf, rhalf);
		return sorted;
	}
	
	private static int[] merging(int[] one, int[] two){
		int[] sorted = new int[one.length + two.length];
		
		int i = 0, j = 0, k = 0;
		while(i < one.length && j < two.length){
			if(one[i] < two[j]){
				sorted[k] = one[i];
				i++;
				k++;
			} else {
				sorted[k] = two[j];
				j++;
				k++;
			}
		}
		
		while(i < one.length){
			sorted[k] = one[i];
			i++;
			k++;
		}

		while(j < two.length){
			sorted[k] = two[j];
			j++;
			k++;
		}
		
		return sorted;
	}

	private static int loops1(int n, int m){
		int sum = 0;
		
		for(int i = 0; i < n; i = i + m){
			for(int j = 0; j < m; j++){
				sum++;
			}
		}
		
		return sum;
	}
	
	private static int loops2(int n){
		int sum = 0;
		
		for(int i = 1; i <= n; i = i * 2){
				sum++;
		}
		
		return sum;
	}
	
	private static int loops3(int n){
		int sum = 0;
		
		int j = 1;
		for(int i = 1; i <= n;){
			if(j == n){
				j = 1;
				i++;
			}
			
			j++;
		}
		
		return sum;
	}
}
