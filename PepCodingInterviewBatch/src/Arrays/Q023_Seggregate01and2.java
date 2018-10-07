package Arrays;

import java.util.Scanner;

public class Q023_Seggregate01and2 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		seggregate(ArrayInput(scn.nextInt()));
	}

	private static void seggregate(int[] arr) {
		int itr = 0;
		int poin = -1;
		int poin2 = arr.length;

		while (itr < poin2) {
			if (arr[itr] < 1) {
				poin++;
				swap(arr, itr, poin);
				itr++;
			} else if (arr[itr] > 1) {
				poin2--;
				swap(arr, poin2, itr);
			} else {
				itr++;
			}
		}

		displayArray(arr);
	}

	private static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// pnter.print(arr[i] + " ");
			System.out.print(arr[i] + " ");
		}
		// pnter.printLine("");
		System.out.println();
	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

}
