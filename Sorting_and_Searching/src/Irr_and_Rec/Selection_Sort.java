package Irr_and_Rec;

import java.util.Scanner;

public class Selection_Sort {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = { 33, 11, 55, 22, 44 };
		 ss_Ir(arr);
//		ss_rec(arr);
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

	public static void ss_Ir(int[] arr) {
		for (int count = 1; count < arr.length; count++) {
			for (int i = count; i < arr.length; i++) {
				if (arr[count - 1] > arr[i]) {
					swap(arr, count - 1, i);
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static void ss_rec(int[] arr) {
		ss_rec(arr, 0);
	}

	private static void ss_rec(int[] arr, int k) {
		if (k == arr.length - 1) {
			return;
		}
		for (int i = k + 1; i < arr.length; i++) {
			if (arr[k] > arr[i]) {
				swap(arr, k, i);
			}
		}

		ss_rec(arr, k + 1);

	}

}
