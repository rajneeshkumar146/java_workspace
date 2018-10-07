package Arrays;

import java.util.Scanner;

public class Q014_TargetSumInSortedAndRotatedArray {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int[] arr = ArrayInput(scn.nextInt());
		targetSum(arr, pivote(arr, 0, arr.length-1), scn.nextInt());
	}

	private static void targetSum(int[] arr, int pivote, int target) {
		int count = 1;
		int lo = (pivote + 1) % arr.length;
		int hi = (pivote) % arr.length;

		while (count <= arr.length) {
			lo = (lo) % arr.length;
			hi = (hi + arr.length) % arr.length;

			if ((arr[lo] + arr[hi]) == target) {
				System.out.println(arr[lo] + " " + arr[hi]);
				lo++;
				hi--;
				count += 2;
			} else if (arr[lo] + arr[hi] > target) {
				hi--;
				count++;
			} else if (arr[lo] + arr[hi] < target) {
				lo++;
				count++;
			}
		}
	}

	private static int pivote(int[] arr, int lo, int hi) {
		int pivote = -1;
		while (lo <= hi) {
			pivote = (lo + hi) >> 1;
			int prev = (pivote - 1 + arr.length) % arr.length;
			int next = (pivote + 1) % arr.length;

			if (arr[pivote] > arr[prev] && arr[pivote] > arr[next]) {
				break;
			} else if (arr[pivote] < arr[lo]) {
				hi = prev;
			} else if (arr[pivote] < arr[hi]) {
				lo = next;
			}
		}

		return pivote;
	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

}
