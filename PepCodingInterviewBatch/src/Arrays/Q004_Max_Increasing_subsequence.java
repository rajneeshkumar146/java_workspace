package Arrays;

import java.util.Scanner;

public class Q004_Max_Increasing_subsequence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		solve(arr);
	}

	private static void solve(int[] arr) {

		int[] msis = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			msis[i] = arr[i];
		}

		int omax = -1;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {

				if (arr[j] < arr[i] && msis[i] < arr[i] + msis[j]) {
					msis[i] = arr[i] + msis[j];
				}
			}
		}

		for (int i = 0; i < msis.length; i++) {
			omax = Math.max(omax, msis[i]);
		}

		System.out.println(omax);

	}

}
