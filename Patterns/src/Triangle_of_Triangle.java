import java.util.Scanner;

public class Triangle_of_Triangle {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		TOT(n);
	}

	public static void TOT(int n) {

		int nspo = 0; // nsp_outside
		int nspi = -1; // nsp_inside
		int nst = n;
		for (int row = 1; row <= n; row++) {

			for (int cspo = 1; cspo <= nspo; cspo++) {
				System.out.print("  ");
			}

			if (row <= n / 2) {
				for (int cst = 1; cst <= nst; cst++) {
					System.out.print(" *");
				}
				for (int cspi = 1; cspi <= nspi; cspi++) {
					System.out.print("  ");
				}
				for (int cst = 1; cst <= nst; cst++) {
					if (row == 1 && cst == 1) {
						continue;
					}
					System.out.print(" *");
				}

				nst -= 2;
				nspi += 2;
			} else {
				for (int cst = 1; cst <= nspi + 2; cst++) {
					System.out.print(" *");
				}

				nspi -= 2;
			}
			nspo++;
			System.out.println();
		}

	}

}
