package Q001_030;

import java.util.Scanner;

public class Q002_AddRev {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int n = scn.nextInt();
		while (n-- > 0) {
			long x = scn.nextLong();
			long y = scn.nextLong();
			x=reverse(x);
			y=reverse(y);
			System.out.println(reverse(x+y));
			
		}

	}

	private static long reverse(long x) {
		long ans = 0;
		while (x != 0) {
			long rem = x % 10;
			x = x / 10;
			ans = ans * 10 + rem;
		}
		return ans;
	}

}
