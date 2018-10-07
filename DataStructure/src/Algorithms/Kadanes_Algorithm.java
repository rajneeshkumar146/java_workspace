package Algorithms;

import java.util.Scanner;

public class Kadanes_Algorithm {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// int size = scn.nextInt();
		// int[] arr = new int[size];
		int[] arr = { -2, -3, -4, -2, -5, -3, -4, 4, 5 };
		System.out.println(MaxSubArray(arr, arr.length));
		System.out.println(MaxSubArrayForNegative(arr, arr.length));
		MaxSubArrayIndex(arr, arr.length);

	}

	private static long MaxSubArray(int[] arr, int size) {
		long max_so_far = 0;
		int currMax = 0;
		for (int i = 0; i < size; i++) {
			currMax += arr[i];

			if (currMax < 0) {
				currMax = 0;
			} else if (max_so_far < currMax) {
				max_so_far = currMax;
			}
		}
		return max_so_far;
	}

	private static long MaxSubArrayForNegative(int[] arr, int size) {
		long max_so_far = arr[0];
		int currMax = arr[0];
		for (int i = 1; i < size; i++) {
			currMax = Math.max(currMax + arr[i], arr[i]);
			max_so_far = Math.max(max_so_far, currMax);
		}
		return max_so_far;
	}

	private static void MaxSubArrayIndex(int[] arr, int size) {
		long max_so_far = 0;
		int currMax = 0;
		int si = 0;
		int ei = 0;
		int s = 0;
		for (int i = 0; i < size; i++) {
			currMax += arr[i];

			if (currMax < 0) {
				currMax = 0;
				s = i + 1;
			} else if (max_so_far < currMax) {
				max_so_far = currMax;
				si = s;
				ei = i;
			}
		}
		System.out.println("("+si + "," + ei+") => " + max_so_far);
	}

}