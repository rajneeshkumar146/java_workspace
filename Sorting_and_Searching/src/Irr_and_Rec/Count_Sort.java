package Irr_and_Rec;

import java.util.Scanner;

public class Count_Sort {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = { 1, 2, 8, 3, 1, 2, 8, 9, 1, 3, 2, 9, 8, 6, 4, 2, 1, 8, 7, 6, 5, 8 }; // count_sort_only_sort_range_and_largly_repeated_number_array.
		cs_Ir(arr);
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

	public static void cs_Ir(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int[] count_arr = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			count_arr[arr[i]]++;
		}
		int size = 0;
		for (int i = 0; i < count_arr.length; i++) { // loop_on_indexes_where_we_store_there_repitation
			for (int j = 0; j < count_arr[i]; j++) { // loop_depend_on_there_occurances_of_element
				arr[size] = i;
				size++;
			}
		}

	}

}
