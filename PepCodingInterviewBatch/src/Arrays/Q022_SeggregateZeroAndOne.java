package Arrays;

import java.util.Scanner;

public class Q022_SeggregateZeroAndOne {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		Seggregate(ArrayInput(scn.nextInt()));

	}

	private static void Seggregate(int[] arr) {
		int itr = 0;
		int poin = -1;
		while (itr < arr.length) {
			if (arr[itr] < 1) {
				poin++;
				swap(arr, itr, poin);
			}
			itr++;
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
