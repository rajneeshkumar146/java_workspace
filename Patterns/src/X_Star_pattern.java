import java.util.Scanner;

public class X_Star_pattern {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of Row's");
		int n = scn.nextInt();

		int nsp = n - 2;
		int nsp2 = 0;
		for (int row = 1; row <= n; row++) {
			for (int csp2 = 1; csp2 <= nsp2; csp2++) {
				System.out.print(" ");
			}
			if (row != n / 2 + 1) {
				System.out.print("*");
			}
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			System.out.print("*");

			if (row <= n / 2) {
				nsp2++;
				nsp -= 2;
			} else {
				nsp += 2;
				nsp2--;
			}

			System.out.println();

		}

	}

}
