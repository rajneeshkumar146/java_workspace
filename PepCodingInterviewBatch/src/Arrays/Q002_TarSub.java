package Arrays;

import java.util.Scanner;

public class Q002_TarSub {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scn.nextInt();
		int tar = scn.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		solve(tar, arr);
	}

	private static void solve(int tar, int[] arr) {
		int start = 0;
		int end = 0;
		int sum = 0;
		boolean flag = false;

		while (start < arr.length && end < arr.length) {
			if (sum < tar) {
				sum += arr[end];
				end++;
			} else if (sum > tar) {

				sum -= arr[start];
				start++;

			} else {
				break;
			}
		}

		if (sum == tar) {

			while (start < end) {
				System.out.print(arr[start] + " ");

				start++;
			}
			flag=true;
		}
		if (!flag) {
			System.out.println("Not found");
		}
	}
}
