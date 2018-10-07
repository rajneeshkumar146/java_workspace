package Arrays;

import java.util.Scanner;

public class Q013_searchInSortedAndPivotedArray {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int[] arr = ArrayInput(scn.nextInt());
		int pivote = Pivote(arr, 0, arr.length - 1);
		int data = scn.nextInt();

		if (arr[pivote] == data) {
			System.out.println(pivote);
			return;
		}

		int ansleft = BinarySearch(arr, data, 0, pivote - 1);
		int ansRight = BinarySearch(arr, data, pivote + 1, arr.length - 1);
		System.out.println(ansleft != -1 ? ansleft : ansRight != -1 ? ansRight : -1);
	}

	private static int BinarySearch(int[] arr, int data, int lo, int hi) {
		while (lo <= hi) {
			int mid = (lo + hi) >> 1;

			if (arr[mid] == data) {
				return mid;
			} else if (arr[mid] < data) {
				lo = mid + 1;
			} else if (data < arr[mid]) {
				hi = mid - 1;
			}
		}

		return -1;

	}

	private static int Pivote(int[] arr, int lo, int hi) {
		if (lo == hi) {
			return lo;
		}

		int mid = (lo + hi) >> 1;
		int prev = (mid - 1 + arr.length) % arr.length; // To_Ensure_that_index_in_bound.
		int next = (mid + 1) % arr.length;

		if (arr[mid] > arr[prev] && arr[mid] > arr[next]) {
			return mid;
		} else if (arr[mid] < arr[lo]) { // pivote_in_leftHalf.
			return Pivote(arr, lo, prev);
		} else {
			return Pivote(arr, next, hi); // pivote_in_right_half.
		}

	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

}
