package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Q007_ChocolateProblem {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		System.out.println(solve(m, arr));
	}

	private static int solve(int m, int[] arr) {
		if (m == 0) {
			return 0;
		}
		Arrays.sort(arr);
		if (m == 1) {
			return arr[0];
		}
		int i = 0;
		int j = m - 1;
		int min = Integer.MAX_VALUE;
		while (j < arr.length) {
			int diff = arr[j] - arr[i];
			min = Math.min(min, diff);
			i++;
			j++;
		}

		return min;

	}

}