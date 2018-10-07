package Rishabh.L001_Array;

import java.util.Scanner;

public class Array_001 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// . Lecture 4
		// 1.1 Arrays demo
		// 1.2 Arrays questions
		// 1.2.1 takeinput
		// 1.2.2 display
		// 1.2.3 max
		// 1.2.4 linearSearch
		// 1.2.5 binarySearch
		// 1.2.6 bubbleSort
		// 1.2.7 selectionSort
		// 1.2.8 insertionSort
		// 1.2.9 reverse
		// 1.2.10 inverse
		// 1.2.11 isInverse
		// 1.2.12 isMirrorInverse
		// 1.2.13 rotate
		// 1.2.14 kadane's algorithm

		solve();
	}

	public static void solve() throws Exception {

	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	private static int LinearSearch(int[] arr, int data) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == data) {
				return i;
			}
		}

		return -1;
	}

	private static void reverse(int[] arr) {
		for (int i = 0, j = arr.length - 1; i <= j; i++, j--) {
			swap(arr, i, j);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void Inverse(int[] arr) {

	}

	private static void IsInverse(int[] arr) {

	}

	private static void Rotate(int[] arr) {

	}

}
