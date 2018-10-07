package Q001_030;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Q006_PPATH_PrimePath {
	public static Scanner scn = new Scanner(System.in);

	static int SieveSize;
	static boolean[] prime;

	public static void main(String[] args) throws Exception {

		solve();
	}

	public static void solve() throws Exception {
		int t = scn.nextInt();
		SieveOfErathosthenes(1000000);
		while (t-- > 0) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			ppath(a, b);
//			pathFollowed(a, b);

		}
	}

	static int[] pred;

	private static void ppath(int a, int b) {
		ArrayDeque<Integer> que = new ArrayDeque<>();
		boolean[] isdone = new boolean[100000];
		int[] distance = new int[1000000];
		Arrays.fill(distance, 1000000);
		pred = new int[1000000];

		que.addLast(a);

		distance[a] = 0;
		while (!que.isEmpty()) {
			int num = que.removeFirst();

			if (num == b) {
				System.out.println(distance[b]);
				return;
			}

			if (isdone[num]) {
				continue;
			}

			isdone[num] = true;

			for (int i = 0; i < 4; i++) {
				StringBuilder sb = new StringBuilder(num + "");
				for (int digit = 0; digit < 10; digit++) {
					if (i == 0 && digit == 0) {
						continue;
					}

					sb.setCharAt(i, (char) (digit + 48));
					int nnum = Integer.parseInt(sb.toString());

					if (isdone[nnum]) {
						continue;
					}

					if (prime[nnum]) {
						que.addLast(nnum);

						if (distance[num] + 1 < distance[nnum]) {
							distance[nnum] = distance[num] + 1;
							pred[nnum] = num;
						}

					}
				}
			}

		}
	}

	private static void pathFollowed(int a, int b) {
		System.out.println(b);
		int par = pred[b];
		while (pred[par] != 0) {
			System.out.println(par);
			par = pred[par];
		}
	}

	private static void SieveOfErathosthenes(int upperbound) {
		SieveSize = upperbound + 1;
		prime = new boolean[SieveSize];

		Arrays.fill(prime, true);
		prime[0] = prime[1] = false; // not a prime

		for (long i = 2; i < SieveSize; i++) {
			if (prime[(int) i]) { // if it is true then it is a potential prime.
				for (long j = i * i; j < SieveSize; j += i) {
					prime[(int) j] = false;
				}
			}
		}

		// System.out.println(primes);
	}

}
