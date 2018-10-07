package Arrays;

import java.util.Scanner;

public class Q017_ThreeWayPartioning {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] arr = ArrayInput(scn.nextInt());
		Partioning(arr, scn.nextInt(), scn.nextInt());
	}

	private static void Partioning(int[] arr, int range1, int range2) {
		int poin = -1;
		int itr = 0;
		int poin2 = arr.length;

		while (itr < poin2) {
			if (arr[itr] < range1) {
				poin++;
				swap(arr, itr, poin);
				itr++;
			} else if (arr[itr] > range2) {
				poin2--;
				swap(arr, poin2, itr);
			} else {
				itr++;
			}
		}

		displayArray(arr);
	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	private static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// pnter.print(arr[i] + " ");
			System.out.print(arr[i] + " ");
		}
		// pnter.printLine("");
		System.out.println();
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
/*
12
1 5 6 21 25 26 40 15 18 19 41 10
10 20
################################################################################
1 5 6 10 19 18 15 40 26 41 25 21
--------------------------------------------------------------------------------
Test Case 2 - Real
--------------------------------------------------------------------------------
8
1 5 4 -1 6 8 10 -9
5 8
################################################################################
1 4 -1 -9 6 8 5 10
--------------------------------------------------------------------------------
Test Case 3 - Real
---------------------------------------------------------------------------------
5
1 10 4 5 6
4 4
################################################################################
1 4 5 6 10
*/

