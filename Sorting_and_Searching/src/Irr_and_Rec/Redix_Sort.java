package Irr_and_Rec;

import java.util.Scanner;

public class Redix_Sort {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = { 300, 201, 210, 202, 600 };
		rs_Ir(arr);
//		display(arr);

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

	public static void rs_Ir(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}

		}

		for (int exe = 1; max / exe != 0; exe *= 10) {
			redix(arr, exe);
		}

	}

	private static void redix(int[] arr, int exe) {
		int[] count_arr = new int[10];
		int[] Sorted_arr = new int[arr.length];

		for (int i = 0; i < arr.length; i++) { // repetation_set_in_count_arr_according_to_there_indexes.
			count_arr[((arr[i]) / exe) % 10]++;
		}

		for (int i = 1; i < count_arr.length; i++) { // count_arr_elements_are_arranged_in_sorted_form.
			count_arr[i] += count_arr[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			int idx = ((arr[i]) / exe) % 10;
			Sorted_arr[count_arr[idx] - 1] = arr[i];
			count_arr[idx]--;
		}

		arr = count_arr.clone();
		display(arr);
		System.out.println();

	}
}
