package DynamicProgramming.BasicProblem;

import java.util.Scanner;

public class Q45_Minimum_steps_to_minimize_n_as_per_given_condition {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("entre: ");
		int n = scn.nextInt();
		// System.out.println(MinStepsRec(n));
		// System.out.println(MinStepsRecDP(n, new int[n + 1]));
		//// System.out.println(wrongMethod(n));
		// System.out.println(MinStepsDP(n));
	}

	public static int MinStepsRec(int n) {
		if (n == 1) {
			return 0;
		}
		int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;

		if (n % 3 == 0) {
			c = MinStepsRec(n / 3);
		}
		if (n % 2 == 0) {
			b = MinStepsRec(n / 2);
		}
		a = MinStepsRec(n - 1);

		return Math.min(a, Math.min(c, b)) + 1;

	}

	public static int MinStepsRecDP(int n, int[] strg) { // Space_O(n)
		if (n == 1) {
			return 0;
		}
		if (strg[n] != 0) {
			return strg[n];
		}

		int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;

		if (n % 3 == 0) {
			c = MinStepsRecDP(n / 3, strg);
		}
		if (n % 2 == 0) {
			b = MinStepsRecDP(n / 2, strg);
		}
		a = MinStepsRecDP(n - 1, strg);

		strg[n] = Math.min(a, Math.min(c, b)) + 1;
		return strg[n];

	}

	public static int wrongMethod(int n) { // Greedy_Approach_(Doesn’t_work_always)_:_for_10_it_gives_4_but_ans_is_3.
		int count = 0;

		while (n != 1) {
			if (n % 3 == 0) {
				n = n / 3;
				count++;
			} else if (n % 2 == 0) {
				n = n / 2;
				count++;
			} else {
				n = n - 1;
				count++;
			}
		}

		return count;
	}

	public static int MinStepsDP(int n) { // Space O(n).
		int[] arr = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;

			if (i % 3 == 0) {
				a = arr[i / 3];
			}
			if (i % 2 == 0) {
				b = arr[i / 2];
			}
			c = arr[i - 1];
			arr[i] = Math.min(a, Math.min(c, b)) + 1;
		}

		return arr[n];
	}

}
