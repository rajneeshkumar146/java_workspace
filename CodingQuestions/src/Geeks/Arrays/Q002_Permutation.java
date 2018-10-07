package Geeks.Arrays;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Q002_Permutation {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] arr = { 1, 2, 3 };
		System.out.println(Permutation(arr, 0, new boolean[arr.length], new ArrayList<>()));
	}

	private static List<List<Integer>> Permutation(int[] arr, int vidx, boolean[] isdone, ArrayList<Integer> list) {

		if (vidx == arr.length) {
			List<List<Integer>> base = new ArrayList<>();

			List<Integer> ll = new ArrayList<>();
			ll.addAll(list);
			base.add(ll);
			return base;
		}

		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (isdone[i]) {
				continue;
			}

			isdone[i] = true;
			list.add(arr[i]);

			ans.addAll(Permutation(arr, vidx+1, isdone, list));

			list.remove(list.size() - 1);
			isdone[i] = false;
		}

		return ans;

	}

}
