
package Irr_and_Rec;

import java.util.Scanner;

public class Bubble_Sort {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = { 33, 11, 55, 22, 44 };
		 bs_Ir(arr);
//		bs_rec(arr);
		display(arr);

	}

	public static int[] input(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;

	}

	public static void display(int[] arr) {
		for (int i : arr) {
			System.out.print(i + ",");
		}
	}

	public static void bs_Ir(int[] arr) {
		for (int count = 1; count < arr.length; count++) {
			for (int i = 0; i < arr.length - count; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static void bs_rec(int[] arr) {
		bs_rec(arr, arr.length - 1);
	}

	private static void bs_rec(int[] arr, int k) {
		if (k == 1) {
			return;
		}
		for (int i = 0; i < k; i++) {
			if (arr[i] > arr[i + 1]) {
				swap(arr, i, i + 1);
			}
		}

		bs_rec(arr, k - 1);

	}

}
