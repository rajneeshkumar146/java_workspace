package Q001_030;

import java.util.Scanner;

public class Q003_WhoDaresToBeAMillionare_WDTBAM {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int t = Integer.parseInt(scn.nextLine());
		while (t-- > 0) {
			int n = Integer.parseInt(scn.next());
			String s1 = scn.next();
			String s2 = scn.next();
			int[] arr = ArrayInput(n + 1);

			int correct = 0;
			for (int i = 0; i < n; i++) {
				if (s1.charAt(i) == s2.charAt(i)) {
					correct++;
				}
			}

			int max = arr[correct];
			if (correct != n) {

				for (int i = correct; i >= 0; i--) {
					max = Math.max(max, arr[i]);
				}
			}
			System.out.println(max);

		}
	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(scn.next());
		}
		return arr;
	}

}
