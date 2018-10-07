package july4;

public class TnSDemos {
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
//		int[] one = { 10, 20, 30, 40, 50 };
//		int[] two = { 15, 17, 22, 25, 34 };
//		mergeTwoSortedArrays(one, two);
//
//		june15.ArrayOps.display(merged);

		int[] arr = { 33, 22, 66, 44, 55, 11, 77 };
		arr = mergeSort(arr, 0, arr.length - 1);
//		quickSort(arr, 0, arr.length - 1);
//
//		june15.ArrayOps.display(arr);
		
		int n = 45;
		
//		int[] arr = new int[n];
//		for(int i = 0; i < arr.length; i++){
//			arr[i] = arr.length - i;
//		}
//		
//		startWatch();
//		mergeSort(arr, 0, arr.length - 1);
//		endWatch("MS", n);
//		
//		startWatch();
//		june17.ArraysCtd.bubbleSort(arr);
//		endWatch("BS", n);
		
//		startWatch();
//		june24.RecursionDemos.Fib(n);
//		endWatch("Fib", n);
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
		if(lo >= hi){// why >=? why not ==? {10, 20} makes a call (0 to -1)
			return;
		}
		
		int left = lo, right = hi;

		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		while (left <= right) { // why <=? why not <? try {10, 20}
			while (arr[left] < pivot) { // why not =? max value at pivot
				left++;
			}

			while (arr[right] > pivot) { // why not =? min value at pivot
				right--;
			}

			if (left <= right) { // maybe crossover happened after enterng the top while
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}

		// call for smaller than pivot el
		quickSort(arr, lo, right);
		
		// call for larger than pivot el
		quickSort(arr, left, hi);
	}
}
