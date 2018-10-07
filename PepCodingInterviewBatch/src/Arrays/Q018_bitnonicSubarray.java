package Arrays;

import java.util.Scanner;

public class Q018_bitnonicSubarray {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int[] arr = ArrayInput(scn.nextInt());
		int[] LISS = LISS(arr);
		int[] LDSS = LDSS(arr);

		int max = -1;
		int st = -1;
		int en = -1;
		for (int i = 0; i < arr.length; i++) {
			if ((LISS[i] + LDSS[i]) > max) {
				st = i - LISS[i];
				en = i + LDSS[i];
				max = LISS[i] + LDSS[i];
			}
		}

		st++;
		en--;
		while (st <= en) {
			System.out.print(arr[st] + " ");
			st++;
		}

	}

	private static int[] LISS(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				dp[i] = dp[i - 1] + 1;
			} else {
				dp[i] = 1;
			}
		}
		return dp;
	}

	private static int[] LDSS(int[] arr) {
		int[] dp = new int[arr.length];
		dp[arr.length - 1] = 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > arr[i + 1]) {
				dp[i] = dp[i + 1] + 1;
			} else {
				dp[i] = 1;
			}
		}
		return dp;
	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

}
