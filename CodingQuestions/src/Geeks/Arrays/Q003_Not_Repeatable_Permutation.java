package Geeks.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Q003_Not_Repeatable_Permutation {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] arr = { 1, 2, 3, 3, 2, 3 };
		System.out.println(permutation(arr, 0, new ArrayList<>(), new boolean[arr.length]));
	}

	private static List<List<Integer>> permutation(int[] arr, int vidx, ArrayList<Integer> list, boolean[] isdone) {
		if (vidx == arr.length) {
			List<List<Integer>> base = new ArrayList<>();
			ArrayList<Integer> ll = new ArrayList<>();

			ll.addAll(list);
			base.add(ll);
			return base;
		}

		List<List<Integer>> ans = new ArrayList<>();

		HashSet<Integer> processed = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			if (isdone[i] || processed.contains(arr[i])) {
				continue;
			}

			isdone[i] = true;
			processed.add(arr[i]);
			list.add(arr[i]);

			ans.addAll(permutation(arr, vidx + 1, list, isdone));

			list.remove(list.size() - 1);
			isdone[i] = false;

		}

		return ans;
	}

}
