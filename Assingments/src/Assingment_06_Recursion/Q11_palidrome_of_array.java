package Assingment_06_Recursion;

import java.util.Scanner;

public class Q11_palidrome_of_array {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// System.out.println("enter your size of array");
		int n = scn.nextInt();
		int[] arr = take_input(n);
		System.out.println(palidrome(arr, 0, n - 1));

	}

	public static int[] take_input(int n) {
		int[] rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static boolean palidrome(int[] arr, int vfidx, int vlidx) { // vfidx=virtual_first_infdex_and_vlidx=virtual_last_index
		if (vfidx >= vlidx) {
			return true;
		}

		if (arr[vfidx] != arr[vlidx]) {
			return false;
		}
		if (palidrome(arr, vfidx + 1, vlidx - 1)) {
			return true;
		} else {
			return false;
		}
	}

}