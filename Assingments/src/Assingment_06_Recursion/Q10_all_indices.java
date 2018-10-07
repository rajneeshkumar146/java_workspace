package Assingment_06_Recursion;

import java.util.Scanner;

public class Q10_all_indices {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// System.out.println("enter your size of array");
		int n = scn.nextInt();
		int[] arr = take_input(n);
		// System.out.println("enter number you want to find");
		int m = scn.nextInt();
		arr = allIndices(arr, 0, m, 0);
		display(arr, 0);
	}

	public static int[] take_input(int n) {
		int[] rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static void display(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}

		System.out.print(arr[vidx] + " ");
		display(arr, vidx + 1);
	}

	public static int[] allIndices(int[] arr, int vidx, int data, int count) {
		if (vidx == arr.length) {
			int[] res_arr = new int[count];
			return res_arr;

		}
		if (arr[vidx] == data) {
			count++;
		}

		int[] recu_arr = allIndices(arr, vidx + 1, data, count);
		if (arr[vidx] == data) {
			recu_arr[count - 1] = vidx;
		}

		return recu_arr;

	}

}
