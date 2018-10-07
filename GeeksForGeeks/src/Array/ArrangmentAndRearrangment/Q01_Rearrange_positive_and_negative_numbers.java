package Array.ArrangmentAndRearrangment;

import java.util.Arrays;
import java.util.Scanner;

public class Q01_Rearrange_positive_and_negative_numbers {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		int n = arr.length - 1;

		// Q01_Rearrange_positive_and_negative_numbers-------------------------------------------------------------------------
		// rearrange(arr, n);
		// displayOneD(arr);

		// Q02_reverse_an_array_or_string-------------------------------------------------------------------------------------------
		// reverseArray(arr);
		// displayOneD(arr);
		// reverseArrayRecursion(arr, 0, n);
		// displayOneD(arr);

		// Q03_Sort_an_array_in_wave_form--------------------------------------------------------------------------------------------
		// SortArrayWaveForm(arr);
		// SortArrayWaveForm2(arr);
		// displayOneD(arr);

		// Q04_Rearrange_positive_and_negative_numbers_with_constant_extra_space_And_In_Same_Oder-------------------------------------
		rearrangeInsameOder(arr, n);
		displayOneD(arr);

	}

	// General_Function--------------------------------------------------------------------------------------------------------

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	private static void displayOneD(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static void reverse(int[] arr, int i, int j) {
		while (i <= j) {
			swap(arr, i, j);
			i++;
			j--;
		}
	}

	// Q01_Rearrange_positive_and_negative_numbers-----------------------------------------------------------------------------

	private static void rearrange(int[] arr, int n) {

		int i = -1;
		for (int j = 0; j < n; j++) {
			if (arr[j] < 0) {
				i++;
				swap(arr, i, j);
			}
		}

		int positive = i + 1, neg = 0;

		while (positive < n && neg < positive && arr[neg] < 0) {
			swap(arr, positive, neg);
			positive++;
			neg += 2;
		}

	}

	// Q02_reverse_an_array_or_string---------------------------------------------------------------------------------------------

	private static void reverseArray(int[] arr) {
		int st = 0;
		int la = arr.length - 1;
		while (st < la) {
			swap(arr, st, la);
			st++;
			la--;
		}
	}

	private static void reverseArrayRecursion(int[] arr, int st, int la) {
		if (st >= la) {
			return;
		}
		swap(arr, st, la);
		reverseArrayRecursion(arr, st + 1, la - 1);
	}

	// Q03_Sort_an_array_in_wave_form----------------------------------------------------------------------------------------------

	private static void SortArrayWaveForm(int[] arr) {

		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 1; i += 2) {
			swap(arr, i, i + 1);
		}
	}

	private static void SortArrayWaveForm2(int[] arr) {
		for (int i = 0; i < arr.length; i += 2) {

			if (i > 0 && arr[i - 1] > arr[i]) {
				swap(arr, i - 1, i);
			}

			if (i < arr.length - 2 && arr[i] < arr[i + 1]) {
				swap(arr, i, i + 1);
			}

		}
	}

	// Q04_Rearrange_positive_and_negative_numbers_with_constant_extra_space_And_In_Same_Oder-------------------------------------------------------

	private static void rearrangeInsameOder(int[] arr, int n) {

		rearrangeInsameOder(arr, 0, n);

	}

	private static void rearrangeInsameOder(int[] arr, int le, int ri) {

		if (le < ri) {

			int mid = le + (ri - le) / 2;

			rearrangeInsameOder(arr, le, mid);
			rearrangeInsameOder(arr, mid + 1, ri);

			merge(arr, le, mid, ri);
		}
	}

	private static void merge(int[] arr, int le, int mid, int ri) {

		int i = le;
		while (arr[i] < 0 && i <= mid) {
			i++;
		}

		int j = mid + 1;
		while (arr[j] < 0 && j <= ri) {
			j++;
		}

		reverse(arr, i, mid);
		reverse(arr, mid + 1, j - 1);
		reverse(arr, i, j - 1);

	}

	
}
