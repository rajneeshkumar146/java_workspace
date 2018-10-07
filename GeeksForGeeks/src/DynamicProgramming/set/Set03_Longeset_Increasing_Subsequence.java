package DynamicProgramming.set;

import java.util.Scanner;

public class Set03_Longeset_Increasing_Subsequence {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int arr[] = { 50, 3, 10, 7, 8, 9, 40, 80, 90, 3, 4, 5, 6, 7, 100 };
		int n = arr.length;
		System.out.println(LISRECU(arr, n));
		System.out.println(LISDP(arr,n));
	}

	private static int LISRECU(int[] arr, int n) {
		if (n == 1) {
			return 1;
		}

		int res = 0;
		int maxSubse = 1;

		for (int i = 1; i < n; i++) {
			res = LISRECU(arr, i);
			if (arr[i - 1] < arr[n - 1] && res + 1 > maxSubse) {
				maxSubse = res + 1;
			}

		}
		return maxSubse;
	}

	private static int LISDP(int[] arr, int n) {
		int lis[] = new int[n];
		int max = 0;

		for (int i = 0; i < n; i++) {
			lis[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}

			}
		}

		for (int i = 0; i < n; i++) {
			if (max < lis[i]) {
				max = lis[i];
			}
		}
		return max;

	}

}
