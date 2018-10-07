package june30;

public class TimenSpaceDemos {

	public static long start = 0;
	public static long end = 0;

	public static void startWatch() {
		start = System.currentTimeMillis();
	}

	public static void endWatch(String algo, int n) {
		end = System.currentTimeMillis();
		System.out.println(algo + " took " + (end - start) + " ms for n = " + n);
	}

	
	public static void main(String[] args) {
//		int[] one = { 10, 20, 30, 40, 50 };
//		int[] two = { 15, 17, 22, 26, 35, 55 };
//
//		int[] merged = mergeSortedArrays(one, two);
//		for (int val : merged) {
//			System.out.print(val + "\t");
//		}
		
//		int[] arr = {0, 55, 11, 22, 44, 33};
//		quickSort(arr, 0, arr.length - 1);
//		for(int val: arr){
//			System.out.println(val);
//		}
		
		int n = 1000000;
		
//		int[] arr = new int[n];
//		for(int i = 0; i < arr.length; i++){
//			arr[i] = arr.length - i;
//		}
//		
//		startWatch();
//		mergeSort(arr, 0, arr.length - 1);
//		endWatch("Merge Sort", n);
//		
//		startWatch();
//		june12.ArrayOps.bubbleSort(arr);
//		endWatch("Bubble Sort", n);
		
		startWatch();
		System.out.println(Fib(45));
		endWatch("Fib", 45);
		
		
	}

	public static int[] mergeSortedArrays(int[] one, int[] two) {
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

		while (j < two.length) {
			result[k] = two[j];
			j++;
			k++;
		}

		while (i < one.length) {
			result[k] = one[i];
			i++;
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

		int[] fshalf = mergeSort(arr, lo, mid);
		int[] sshalf = mergeSort(arr, mid + 1, hi);

		int[] sorted = mergeSortedArrays(fshalf, sshalf);
		return sorted;
	}

	public static void quickSort(int[] arr, int lo, int hi) {
		if(lo > hi){ // why ==, >=, >
			return;
		}
		
		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		int left = lo, right = hi;

		while (left <= right) { // why cross over, why not <?
			while (arr[left] < pivot) { // why <, why not <=? max and min pivots cause infinite recursion incase of =
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}

		quickSort(arr, lo, right); // smaller
		quickSort(arr, left, hi); // larger
	}

	public static int Fib(int n){
		if(n == 0){
			return 0;
		}
		
		if(n == 1){
			return 1;
		}
		
		int fibnm1 = Fib(n - 1);
		int fibnm2 = Fib(n - 2);
		int fibn = fibnm1 + fibnm2;
		
		return fibn;
	}
	
	
	
}
