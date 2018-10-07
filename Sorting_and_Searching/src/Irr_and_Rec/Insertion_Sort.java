package Irr_and_Rec;

import java.util.Scanner;

public class Insertion_Sort {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = { 33, 11, 55, 22, 44,-2,3,6,5 };
		is_Ir(arr);
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

	public static void is_Ir(int[] arr) {
		for (int count = 1; count < arr.length; count++) {
			for (int i = count; i > 0; i--) {
				if (arr[i - 1] < arr[i]) {
					swap(arr, i - 1, i);
				} else {
					break;
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

}
