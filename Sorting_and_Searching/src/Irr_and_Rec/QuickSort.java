package Irr_and_Rec;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 11, 3, 7, 32, 34, 26, 78, 9, 6, 7 };
		quicksort(arr, 0, arr.length - 1);
		display(arr);

	}

	private static void display(int[] arr) {
		for(int i:arr){
			System.out.print(i+",");
		}
		
	}

	public static void quicksort(int[] arr, int lo, int hi) {
		if (lo >= hi) {// why ==? why not >? try {10, 20} make (0,-1)
			return;
		}
		int mid = (lo + hi) / 2;
		int pivote = arr[mid];
		int left = lo;
		int right = hi;
		while (left <= right) {// why <=? why not <? try {10, 20}
			while (arr[left] < pivote) {// why not <=? max value at pivot
				left++;
			}

			while (arr[right] > pivote) {// why not >=? max value at pivot
				right--;
			}

			if (left <= right) {// maybe crossover happened after enterng the top while
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}

		quicksort(arr, lo, right);
		quicksort(arr, left, hi);
	}

}
