package PepCoding.Patterns;

import java.util.Scanner;

public class Q003_NumberDiamond {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		int n = scn.nextInt();

		int nsp = n / 2;
		int nst = 1;
		int val = 0;

		for (int row = 1; row <= n; row++) {

			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print("  ");
			}

			if (row <= (n) / 2) {
				val = row;
			} else {
				val=n-row+1;
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val + " ");

				if (cst <= nst / 2) {
					val++;
				} else {
					val--;
				}

			}

			if (row <= n / 2) {
				nst += 2;
				nsp--;
			} else {
				nst -= 2;
				nsp++;
			}

			System.out.println();
		}

	}

}
