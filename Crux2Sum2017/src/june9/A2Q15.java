package june9;

import java.util.Scanner;

public class A2Q15 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter a number");
		int n = scn.nextInt();

		int row = 1;
		int nst = 1, cst = 1;
		int nsp = 2 * n - 3, csp = 1;
		int val = 1;
		while (row <= n) {
			cst = 1;
			while (cst <= nst) {
				System.out.print(val);
				val++;
				cst++;
			}

			csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			if (row == n) {
				cst = 2;
				val--;
			} else {
				cst = 1;
			}
			while (cst <= nst) {
				val--;
				System.out.print(val);
				cst++;
			}

			nst = nst + 1;
			nsp = nsp - 2;

			System.out.println();
			row++;
		}
	}

}
