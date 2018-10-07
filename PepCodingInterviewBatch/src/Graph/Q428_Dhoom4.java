package Graph;

import java.util.Scanner;

public class Q428_Dhoom4 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int key = scn.nextInt();
		int targetKey = scn.nextInt();
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		int ans = dhoom4(arr, 0, key, targetKey, new boolean[arr.length]);
		System.out.println(ans + 1);
	}

	private static int dhoom4(int[] arr, int ans, int key, int targetKey, boolean[] isdone) {

		if (key == targetKey) {
			return ans;
		}

		int OverallMin = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length && !isdone[i]; i++) {
			isdone[i] = true;

			key = (arr[i] * key) % 100000;
			int val = dhoom4(arr, ans + 1, key, targetKey, isdone);
			OverallMin = Math.min(OverallMin, val);
			isdone[i] = false;
		}

		return OverallMin;

	}

}
