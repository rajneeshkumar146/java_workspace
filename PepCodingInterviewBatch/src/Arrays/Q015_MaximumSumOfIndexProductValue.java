package Arrays;

import java.util.Scanner;

public class Q015_MaximumSumOfIndexProductValue {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] arr = ArrayInput(scn.nextInt());
		int sum = 0;
		int product = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			product += i * arr[i];
		}

		int maxsum = product;
		for (int i = 0; i < arr.length; i++) {
			product = product - sum + arr.length * arr[i];
			maxsum = Math.max(product, maxsum);
		}
		System.out.println(maxsum);

	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

}