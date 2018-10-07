package Q001_030;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q007_ONEZERO_OnceAndZero {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			System.out.println(OneZero(n));

		}

	}

	private static class pair {
		int num;
		String str;

		pair(int num, String str) {
			this.num = num;
			this.str = str;
		}
	}

	private static String OneZero(int n) {
		String ans = "";
		ArrayDeque<pair> que = new ArrayDeque<>();
		que.addLast(new pair(1, "1"));

		while (!que.isEmpty()) {
			pair p = que.removeFirst();

			if (p.num % n == 0) {
				ans = p.str;
				break;
			}

			p.num %= n;
			que.addLast(new pair(p.num * 10, p.str + "0"));
			que.addLast(new pair(p.num * 10 + 1, p.str + "1")); // modular_Arithmatic.

		}

		return ans;

	}

}