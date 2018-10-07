package Q001_030;

import java.util.Scanner;

public class Q004_FCTRL {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		int n = scn.nextInt();
		while (n-- > 0) {
			int x = scn.nextInt();
			long ans = 0;
			while (x != 0) {
				x = x / 5;
				ans += x;
			}
			
			System.out.println(ans);

		}

	}

}
