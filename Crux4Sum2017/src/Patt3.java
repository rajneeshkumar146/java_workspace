import java.util.Scanner;

public class Patt3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Number of rows please?");
		int n = scn.nextInt();

		int row = 1;
		int stpr = 1, cst = 1;
		int sppr = n / 2, csp = 1;
		int val = 1;
		while (row <= n) {
			if (row <= n / 2) {
				val = row;
			} else {
				val = n + 1 - row;
			}

			// spaces
			csp = 1;
			while (csp <= sppr) {
				System.out.print(" ");
				csp++;
			}

			// stars
			cst = 1;
			while (cst <= stpr) {
				System.out.print(val);

				if (cst <= stpr / 2) {
					val++;
				} else {
					val--;
				}

				cst++;
			}

			// spaces
			csp = 1;
			while (csp <= sppr) {
				System.out.print(" ");
				csp++;
			}

			// next row prep
			if (row <= n / 2) {
				sppr = sppr - 1;
				stpr = stpr + 2;
			} else {
				sppr = sppr + 1;
				stpr = stpr - 2;
			}

			System.out.println();
			row++;
		}
	}

}
