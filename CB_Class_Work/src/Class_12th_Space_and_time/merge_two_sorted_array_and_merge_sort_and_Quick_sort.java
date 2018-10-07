package Class_12th_Space_and_time;

import java.util.Scanner;

public class merge_two_sorted_array_and_merge_sort_and_Quick_sort {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] one = { 5, 10, 15, 20, 25, 30 };
		int[] two = { 12, 14, 16, 17, 18, 19, 21, 24 };

		int[] arr = { 10, 55, 60, 100, 57, 19, 37, 24 };

		// display(merge_two_sorted_array(one,two));
		// display(mergesort(two, 0, two.length - 1));
		quicksort(arr, 0, arr.length - 1);
		display(arr);

	}

	public static int[] take_input(int n) {
		int[] rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}

		return rv;

	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + "\t");
		}
		System.out.println();

	}

	public static int[] merge_two_sorted_array(int[] one, int[] two) {

		int[] merge = new int[one.length + two.length];

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				merge[k] = one[i];
				k++;
				i++;
			} else {
				merge[k] = two[j];
				j++;
				k++;
			}
		}

		while (i < one.length) {
			merge[k] = one[i];
			k++;
			i++;
		}

		while (j < two.length) {
			merge[k] = two[j];
			k++;
			j++;
		}

		return merge;

	}

	public static int[] mergesort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;

		int[] mergefhalf = mergesort(arr, lo, mid);
		int[] mergeshalf = mergesort(arr, mid + 1, hi);

		return merge_two_sorted_array(mergefhalf, mergeshalf);

	}

	public static void quicksort(int[] arr, int lo, int hi) {

		if (lo >= hi) {// why ==? why not >? try {10, 20} make (0,-1).
			return;
		}

		int mid = (lo + hi) / 2;
		int pivot = arr[mid];
		int left = lo, right = hi;

		while (left <= right) {// why <=? why not <? try {10, 20}
			while (arr[left] < pivot) {// why not <=? max value at pivot
				left++;
			}

			while (arr[right] > pivot) {// why not >=? min value at pivot
				right--;
			}

			if (left <= right) {// maybe crossover happened after enterng the top while
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				right--;
				left++;
			}

		}
		
		quicksort(arr, lo, right);
		quicksort(arr, left, hi);


	}

}
