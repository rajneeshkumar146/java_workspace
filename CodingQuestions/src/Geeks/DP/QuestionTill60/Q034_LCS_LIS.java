package Geeks.DP.QuestionTill60;

import java.util.Scanner;

public class Q034_LCS_LIS {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		int arr1[] = { 3, 4, 9, 1 };
		int arr2[] = { 5, 3, 8, 9, 10, 2, 1 };
		LCS_LIS(arr1, arr2);
		

	}

	private static void LCS_LIS(int[] arr1, int[] arr2) {

		int[] table = new int[arr2.length + 1];

		for (int i = 0; i < arr1.length; i++) {
			int curr = 0;
			for (int j = 0; j < arr2.length; j++) {

				if (arr1[i] == arr2[j]) {
					if (curr + 1 > table[j]) {
						table[j] = curr + 1;
					}
				}

				if (arr1[i] > arr2[j]) {
					curr = table[j] > curr ? table[j] : curr;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < table.length; i++)
			max = Math.max(max, table[i]);

		System.out.println(max);

	}

}
