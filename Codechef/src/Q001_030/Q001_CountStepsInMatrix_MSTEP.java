package Q001_030;

import java.util.*;

public class Q001_CountStepsInMatrix_MSTEP {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int[][] arr = MatrixInput(n, n);
			System.out.println(CountMatrix(arr, n));
		}
	}

	private static long CountMatrix(int[][] arr, int n) {
		int[][] store = new int[n * n + 1][2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int val = arr[i][j];
				store[val][0] = i;
				store[val][1] = j;
			}
		}

		long ans = 0;
		for (int i = 2; i < store.length; i++) {
			for (int j = 0; j < store[0].length; j++) {
				ans += Math.abs(store[i][j] - store[i - 1][j]);
			}
		}

		return ans;
	}

	private static int[][] MatrixInput(int n, int m) {
		int[][] arr = new int[n][m];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				arr[row][col] = scn.nextInt();
			}
		}
		return arr;
	}

}
