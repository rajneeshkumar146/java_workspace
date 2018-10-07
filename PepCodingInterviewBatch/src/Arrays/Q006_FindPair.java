package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Q006_FindPair {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int diff = scn.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		solve(diff, arr);
	}

	private static void solve(int diff, int[] arr) {
		Arrays.sort(arr);

		int start = 1;
		int end = 0;
		boolean found = false;

		while (start < arr.length && end < arr.length) {
			int cdiff = arr[start] - arr[end];

			if (cdiff > diff) {
				if (start - end == 1) {
					start++;
				}
				end++;
			} else if (cdiff < diff) {
				if (start - end == 1) {
					end++;
				}
				start++;
			} else {

				found = true;
				System.out.println(arr[end] + " " + arr[start]);
				start++;

			}
		}

		if (!found) {
			System.out.println(-1);
		}
	}

}