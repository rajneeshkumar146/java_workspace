package Binary_Search_Irr_and_Rec;

import java.util.Arrays;
import java.util.Scanner;

public class Binary_Search {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr = { -5, -9, -6, -4, -1, 0, 4, 9, 8, 7, 17, 18, 12, 15, 17, 19, 21, 25, 25, 23, 24, 29, 27, 6, 5, 65,
				66, 36 };
		Arrays.sort(arr);
		display(arr);
		int res = bs(arr, 66);
		System.out.println(res);

	}

	public static int[] input(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;

	}

	public static void display(int[] arr) {
		for (int i : arr) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

	public static int bs(int[] arr, int n) {
		int le = 0;
		int re = arr.length - 1;
		int idx = -1;
		for (int i = 0; true; i++) {
			int mid = (le + re) / 2;

			if (arr[mid] < n) {
				le = mid + 1;
			} else if (arr[mid] > n) {
				re = mid - 1;
			} else if (arr[mid] == n) {
				idx = mid;
				break;
			}
		}

		return idx;
	}

}
