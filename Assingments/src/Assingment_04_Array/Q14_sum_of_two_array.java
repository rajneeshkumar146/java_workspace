package Assingment_04_Array;

import java.util.Scanner;

public class Q14_sum_of_two_array {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// System.out.println("\tEnter size of array");
		int n = scn.nextInt();
		int[] arr = take_input(n);

		// System.out.println("\tEnter size of array");
		int n1 = scn.nextInt();
		int[] arr1 = take_input(n1);

		int nn = n >= n1 ? n + 1 : n1 + 1;

		sum(arr, arr1, nn);

	}

	public static int[] take_input(int n) {
		int[] rv = new int[n];

		for (int i = 0; i < rv.length; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;

	}

	public static void sum(int[] arr1, int[] arr2, int nn) {
		int[] rv = new int[nn];
		int i = arr1.length - 1;
		int j = arr2.length - 1;
		int k = rv.length - 1;
		int carry = 0;

		while (k >= 0) {
			int temp = carry;
			if (i >= 0) {
				temp += arr1[i];
			}

			if (j >= 0) {
				temp += arr2[j];
			}

			rv[k] = temp % 10;
			carry = temp / 10;
			k--;
			i--;
			j--;

		}
		for (int val = 0; val < rv.length; val++) {
			if (val == 0 && rv[val] == 0) {
				continue;
			}
			System.out.print(rv[val] + " ");
		}
	}

}
