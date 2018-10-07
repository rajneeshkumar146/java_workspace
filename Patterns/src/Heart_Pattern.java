import java.util.Scanner;

public class Heart_Pattern {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		Heartpattern(x);

	}

	public static void Heartpattern(int n) {

		int nst = n;
		int nsp = 0;
		if (n % 2 != 0) {
			nsp = n;
		} else {
			nsp = n - 1;
		}

		for (int row = 1; row <= n; row += 2) {
			for (int csp = 1; csp < nsp; csp += 2) {
				System.out.print(" ");
			}
			

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			nsp -= 2;
			nst += 2;
			System.out.println();

		}

		nst = 2 * nst - 3;
		nsp = 0;
		int temp = nst;
		for (int row = 1; row <= temp; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			nsp++;
			nst -= 2;
			System.out.println();
		}

		if (nst == 1) {
			return;
		}

	}

}
