import java.util.Scanner;

public class HorizontalPTPperamid {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HorizontalPTPperamid(n);
	}

	public static void HorizontalPTPperamid(int n) { // vertical_Point_to_point_pramid

		int nsp = 3 * n;
		int nst = 1;
		for (int row = 1; row <= n; row++) {

			for (int cst = 1; cst <= nst; cst++) {
				if (row % 2 == 0) {
					System.out.print("  ");
				}
				System.out.print("*");
			}

			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			if (row % 2 == 0) {
				nst++;
			}
			if (row % 2 != 0) {
				nsp = nsp - 2 * nst - 4;
			} else {

			}
			System.out.println();
		}

	}
}
