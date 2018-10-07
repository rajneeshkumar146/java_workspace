package Array;

import java.util.Arrays;

public class Q03_Find_largest_three_elements {

	public static void main(String[] args) {
		int[] arr = { 10, 4, 3, 50, 23, 90 };
		int[] ra1 = LargestThreeRec(arr, 0);
		int[] ra = LargestThreeIrr(arr);
		display(ra);

	}

	private static void display(int[] arr) {
		System.out.print("[");
		for (int i : arr) {
			System.out.print(i + ",");
		}
		System.out.println("]");

	}

	public static int[] LargestThreeRec(int[] arr, int vidx) {

		if (vidx == arr.length) {
			int[] ra = new int[3]; // recursive_array
			Arrays.fill(ra, Integer.MIN_VALUE);
			return ra;
		}

		int[] ra = LargestThreeRec(arr, vidx + 1);

		if (arr[vidx] > ra[0]) {
			ra[2] = ra[1];
			ra[1] = ra[0];
			ra[0] = arr[vidx];
		} else if (arr[vidx] > ra[1]) {
			ra[2] = ra[1];
			ra[1] = arr[vidx];
		} else if (arr[vidx] > ra[2]) {
			ra[2] = arr[vidx];
		}

		return ra;
	}

	public static int[] LargestThreeIrr(int[] arr) {

		int[] ra = new int[3];
		Arrays.fill(ra, Integer.MIN_VALUE);

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > ra[0]) {
				ra[2] = ra[1];
				ra[1] = ra[0];
				ra[0] = arr[i];
			} else if (arr[i] > ra[1]) {
				ra[2] = ra[1];
				ra[1] = arr[i];
			} else if (arr[i] > ra[2]) {
				ra[2] = arr[i];
			}

		}

		return ra;

	}

}
