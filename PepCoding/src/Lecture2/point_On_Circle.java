package Lecture2;

import java.util.Arrays;
import java.util.Scanner;

public class point_On_Circle {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int N = scn.nextInt();
		int x[] = input(N);
		int y[] = input(N);

		int p[] = new int[N];
		preprocess(p, x, y, N);

		int Q = scn.nextInt();
		for (int i = 1; i <= Q; i++) {
			System.out.println(query(p, N, scn.nextInt()));

		}

	}

	public static int[] input(int N) {
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	public static void preprocess(int p[], int x[], int y[], int n) {
		for (int i = 0; i < n; i++)
			p[i] = x[i] * x[i] + y[i] * y[i];

		Arrays.sort(p);
	}

	public static int query(int p[], int n, int rad) {
		int st = 0, end = n - 1;
		while ((end - st) > 1) {
			int mid = (st + end) / 2;
			double r = Math.sqrt(p[mid]);

			if ((rad * 1.0) > r)
				st = mid;
			else
				end = mid - 1;
		}

		double r1 = Math.sqrt(p[st]);
		double r2 = Math.sqrt(p[end]);

		if (r1 > (rad * 1.0))
			return 0;
		else if (r2 <= (rad * 1.0))
			return end + 1;
		else
			return st + 1;
	}

}
