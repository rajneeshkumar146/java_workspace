
import java.util.Scanner;

public class Question_15 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of row's between 1 to 9 ");
		int n = scn.nextInt();

		pint_pattern1(n);
		pint_pattern2(n);

	}

	public static void pint_pattern1(int n) {
		int nst = 1, nsp = 2 * n - 3;
		for (int row = 1; row <= n; row++) {
			int val = 1;
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val);
				val++;

			}
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}
			if (row <= n - 1) {
				for (int cst = 1; cst <= nst; cst++) {
					val--;
					System.out.print(val);
				}

				nsp -= 2;
				nst++;
			} else {
				val--;
				for (int cst = 1; cst <= (nst - 1); cst++) {
					val--;
					System.out.print(val);
				}
			}
			System.out.println();
		}

	}

	public static void pint_pattern2(int n) {

		int nst = 1, nsp = 2 * n - 3;
		for (int row = 1; row <= n; row++) {
			int val = 1;
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val);

				if (cst < n) {
					val++;
				}
			}

			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				if (cst < n) {
					val--;
					System.out.print(val);
				}
			}
			

			nst++;
			nsp -= 2;
			System.out.println();
		}

	}

}
