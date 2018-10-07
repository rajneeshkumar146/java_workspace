package Arrays;

import java.util.Scanner;

public class Q001_KCon {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int n = scn.nextInt();
		int k = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		System.out.println(kconcat(arr, k));

	}

	private static long kconcat(int[] arr, int k) {

		long maxsf = arr[0];
		long currsf = arr[0];

		int i = 1;
		while (i < arr.length) {
			maxsf = Math.max(arr[i], maxsf + arr[i]);
			currsf = Math.max(maxsf, currsf);
			i++;
		}

		long FirstMax = currsf;
		if (k == 1) {
			return FirstMax;
		}

		while (i < 2 * arr.length) {
			int j = i % arr.length;
			maxsf = Math.max(arr[j], maxsf + arr[j]);
			currsf = Math.max(maxsf, currsf);
			i++;
		}

		long SecondMax = currsf;
		if (k == 2) {
			return SecondMax;
		}

		while (i < 3 * arr.length) {
			int j = i % arr.length;
			maxsf = Math.max(arr[j], maxsf + arr[j]);
			currsf = Math.max(maxsf, currsf);
			i++;
		}

		long ThirdMax = currsf;
		if (k == 3) {
			return ThirdMax;
		}
		
		long SecondDiff = ThirdMax - SecondMax;

		long APLastTerm = (SecondMax + (k - 2) * SecondDiff);
		return APLastTerm;

	}

}
