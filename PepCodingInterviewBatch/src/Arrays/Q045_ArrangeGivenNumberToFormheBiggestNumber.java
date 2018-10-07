package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Q045_ArrangeGivenNumberToFormheBiggestNumber {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int n = scn.nextInt();
		Pair[] arr = new Pair[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Pair();
			arr[i].val = scn.nextInt();
		}

		BiggestNumber(arr);

	}

	private static class Pair implements Comparable<Pair> {
		private int val;

		@Override
		public int compareTo(Pair o) {
			String xy = "" + this.val + o.val;
			String yx = "" + o.val + this.val;

			if (Integer.parseInt(xy) > Integer.parseInt(yx)) {
				return -1;
			} else {
				return 1;
			}

		}

	}

	private static void BiggestNumber(Pair[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i].val);
		}

	}

}
