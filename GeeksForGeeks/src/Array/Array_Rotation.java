package Array;

import java.util.Scanner;

public class Array_Rotation {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("Entre Rotaion: ");
		int r = scn.nextInt();
		arr = Reversal_algo(arr, r);
		display(arr);

	}

	private static void display(int[] arr) {
		System.out.print("[");
		for (int e : arr) {
			System.out.print(e + ",");
		}
		System.out.println("]");

	}

	public static int[] Reversal_algo(int[] arr, int r) {

		r = r % arr.length;
		if (r < 0) {
			r = arr.length + r;
		}

		for (int i = 0, j = r - 1; i <= j; i++, j--) {
			swap(arr, i, j);
		}

		for (int i = r, j = arr.length - 1; i <= j; i++, j--) {
			swap(arr, i, j);
		}

		for (int i = 0, j = arr.length - 1; i <= j; i++, j--) {
			swap(arr, i, j);
		}

		return arr;

	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
