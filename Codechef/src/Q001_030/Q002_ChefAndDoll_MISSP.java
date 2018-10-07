package Q001_030;

import java.util.Scanner;

public class Q002_ChefAndDoll_MISSP {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int[] arr = ArrayInput(n);
			System.out.println(ChefAndDoll(arr, n));
		}
	}

	private static int ChefAndDoll(int[] arr, int n) {
		int xor = 0;
		for (int i = 0; i < n; i++) {
			xor ^= arr[i];
		}

		return xor;

	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

}
