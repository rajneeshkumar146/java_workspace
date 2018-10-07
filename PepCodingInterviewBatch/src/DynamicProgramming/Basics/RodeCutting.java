package DynamicProgramming.Basics;

public class RodeCutting {
	// public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] cost = { 3, 5, 8, 9, 10, 17, 17, 20 };
		RodeCuttingDP(cost);
		System.out.println(RodeCuttingRecu(cost, cost.length));
	}

	private static int RodeCuttingRecu(int[] arr, int n) {
		if (n <= 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, arr[i] + RodeCuttingRecu(arr, n -1- i));
		}

		return Math.max(max, arr[n-1]);

	}

	private static void RodeCuttingDP(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0, k = i - 1; j <= k; j++, k--) {
				max = Math.max(max, arr[j] + arr[k]);
			}

			arr[i] = Math.max(max, arr[i]);
		}
		displayArray(arr);
	}

	private static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// pnter.print(arr[i] + " ");
			System.out.print(arr[i] + " ");
		}
		// pnter.printLine("");
		System.out.println();
	}

}
