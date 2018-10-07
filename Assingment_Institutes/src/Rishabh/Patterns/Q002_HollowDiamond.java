package PepCoding.Patterns;

import java.util.Scanner;

public class Q002_HollowDiamond {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		int n = scn.nextInt();

		int nst = n / 2;
		int nsp = 1;

		for (int row = 1; row <= n; row++) {
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			if (row <= n / 2) {
				nsp += 2;
				nst--;
			} else {
				nsp -= 2;
				nst++;
			}

			System.out.println();
		}
	}

}
