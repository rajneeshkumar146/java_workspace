import java.util.Scanner;

public class Kite {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter Bridth: ");
		int n = scn.nextInt();
		kite(n);

	}

	public static void kite(int n) {
		int nsp = n / 2;
		int nst = 1;

		for (int row = 1; row <= n; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print("  ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(" *");
			}

			if (row <= n / 2) {
				nsp--;
				nst += 2;
			} else {
				nsp++;
				nst -= 2;
			}
			System.out.println();

		}

		nsp = n / 2 - 1;
		nst = 3;
		n=n/4;
		
		for (int row = 1; row <= n; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print("  ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(" *");
			}

			
				nsp--;
				nst += 2;
			
			System.out.println();

		}
		

	}

}
