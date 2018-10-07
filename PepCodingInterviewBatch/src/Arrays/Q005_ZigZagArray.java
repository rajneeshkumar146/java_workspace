package Arrays;

import java.util.Scanner;

public class Q005_ZigZagArray {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		solve(arr);
	}

	private static void solve(int[] arr) {
		for (int i = 1; i < arr.length - 1; i += 2) {

			if (i % 2 != 0) {
				if (arr[i - 1] > arr[i]) {
					swap(arr, i, i - 1);
				}
				if ((i + 1) < arr.length && arr[i] < arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}

		}

		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i] ^ arr[j];
		arr[i] ^= temp;
		arr[j] ^= temp;
	}

}