package Irr_and_Rec;

public class mergesort {

	public static void main(String[] args) {
		int[] arr = { 10, 55, 60, 100, 57, 19, 37, 24 };
		arr = mergesort(arr, 0, arr.length - 1);
		display(arr);

	}

	private static void display(int[] arr) {
		for (int i : arr) {
			System.out.print(i + ",");
		}

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

}
