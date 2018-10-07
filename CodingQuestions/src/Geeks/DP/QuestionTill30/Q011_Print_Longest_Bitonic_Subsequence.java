package Geeks.DP;

import java.util.ArrayList;
import java.util.Scanner;

public class Q011_Print_Longest_Bitonic_Subsequence {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		// 10 10 22 9 33 21 50 41 60 45 1
		int[] arr = ArrayInput(scn.nextInt());
		ArrayList<Integer> ans = printLongestBitonicSubsequence(arr);
		System.out.println(ans);
	}

	private static ArrayList<Integer> printLongestBitonicSubsequence(int[] arr) {

		ArrayList<Integer>[] LIS = new ArrayList[arr.length];
		ArrayList<Integer>[] LDS = new ArrayList[arr.length];

		for (int i = 0; i < arr.length; i++) {
			LIS[i] = new ArrayList<>();
			LDS[i] = new ArrayList<>();
		}

		// LIS
		LIS[0].add(arr[0]);
		int maxIndexLIS = 0;
		for (int i = 1; i < arr.length; i++) {
			int index = -1;
			int len = LIS[i].size();
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					if (LIS[j].size() > len) {
						len = LIS[j].size();
						index = j;
					}
				}
			}

			if (index != -1) {
				LIS[i].addAll(LIS[index]);
				LIS[i].add(arr[i]);
				maxIndexLIS = LIS[i].size() > LIS[maxIndexLIS].size() ? i : maxIndexLIS;
			} else {
				LIS[i].add(arr[i]);
			}
		}

		// System.out.println(LIS[maxIndexLIS]);

		// LDS
		LDS[arr.length - 1].add(arr[arr.length - 1]);
		int maxIndexLDS = 0;
		for (int i = arr.length - 2; i >= 0; i--) {
			int index = -1;
			int len = LDS[i].size();
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					if (LDS[j].size() > len) {
						len = LDS[j].size();
						index = j;
					}
				}
			}

			if (index != -1) {
				LDS[i].add(arr[i]);
				LDS[i].addAll(LDS[index]);
				maxIndexLDS = LDS[i].size() > LDS[maxIndexLDS].size() ? i : maxIndexLDS;
			} else {
				LDS[i].add(arr[i]);
			}
		}

		// System.out.println(LDS[maxIndexLDS]);

		// Get_max_Bitonic_subsequence_length.
		int maxsize = 1;
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (LIS[i].size() + LDS[i].size() > maxsize) {
				maxsize = LIS[i].size() + LDS[i].size();
				index = i;
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();
		for (Integer val : LIS[index]) {
			ans.add(val);
		}

		for (Integer val : LDS[index]) {
			if (val == arr[index]) {
				continue;
			}
			ans.add(val);
		}

		return ans;
	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

}
