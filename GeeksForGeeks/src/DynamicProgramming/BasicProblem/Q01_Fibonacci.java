package DynamicProgramming.BasicProblem;

import java.util.Scanner;

public class Q01_Fibonacci {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scn.nextInt();

		// System.out.println(fib_R(n));
		System.out.println(fib_MDP(n, new int[n + 1]));
		System.out.println(fib_DP(n));
		System.out.println(fib_DP_SO(n));
		System.out.println(fib_UPOM(n));
		System.out.println(fib_UPOM_btr(n));

	}

	public static int fib_R(int n) { // Use recursion O(2^n)
		if (n <= 1) {
			return n;
		}

		int fibo1 = fib_R(n - 1);
		int fibo2 = fib_R(n - 2);
		return fibo1 + fibo2;

	}

	public static int fib_MDP(int n, int[] stg) {// Use recursion
													// Memoization,,space O(n)

		if (n <= 1) {
			return n;
		}

		if (stg[n] != 0) {
			return stg[n];
		}

		int fibo1 = fib_MDP(n - 1, stg);
		int fibo2 = fib_MDP(n - 2, stg);
		stg[n] = fibo1 + fibo2;
		return stg[n];

	}

	public static int fib_DP(int n) { // Use Dynamic Programming O(n),space O(n)
		int[] arr = new int[n + 1];

		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		return arr[n];
	}

	public static int fib_DP_SO(int n) {// Space Optimized O(n),,space O(1)
		int sum = 0, a = 0, b = 1;
		if (n <= 1) {
			return n;
		}

		for (int i = 2; i <= n; i++) {
			sum = a + b;
			a = b;
			b = sum;
		}

		return sum;

	}

	public static int fib_UPOM(int n) {// Using_power_of_the_matrix_{{1,1},{1,0}}
										// -->O(n)

		if (n <= 1) {
			return n;
		}

		int[][] arr = { { 1, 1 }, { 1, 0 } };
		pow(arr, n - 1);
		return arr[0][0];

	}

	private static void pow(int[][] arr, int n) {
		int[][] aa = { { 1, 1 }, { 1, 0 } }; // actual_Array.
		for (int i = 2; i <= n; i++) {
			multiply(arr, aa);
		}

	}

	private static void multiply(int[][] arr, int[][] aa) {
		int x = arr[0][0] * aa[0][0] + arr[0][1] * aa[1][0];
		int y = arr[0][0] * aa[0][1] + arr[0][1] * aa[1][1];
		int z = arr[1][0] * aa[0][0] + arr[1][1] * aa[1][0];
		int w = arr[1][0] * aa[0][1] + arr[1][1] * aa[1][1];

		arr[0][0] = x;
		arr[0][1] = y;
		arr[1][0] = z;
		arr[1][1] = w;

	}

	public static int fib_UPOM_btr(int n) {
		if (n <= 1) {
			return n;
		}

		int[][] arr = { { 1, 1 }, { 1, 0 } };
		powbtr(arr, n - 1);
		return arr[0][0];

	}

	private static void powbtr(int[][] arr, int n) {

		if (n <= 1) {
			return;
		}

		int[][] aa = { { 1, 1 }, { 1, 0 } }; // actual_Array.

		powbtr(arr, n / 2);
		multiply(arr, arr);
		if (n % 2 != 0) {
			multiply(arr, aa);
		}

	}

}
