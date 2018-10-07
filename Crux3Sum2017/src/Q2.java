import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter number");
		int n = scn.nextInt();

		int row = 1;
		int nsp = n / 2;
		int nst = 1;
		int val = 1;
		while (row <= n) {
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			int cst = 1;
			if (row <= n / 2) {
				val = row;
			} else {
				val = n + 1 - row;
			}

			while (cst <= nst) {
				System.out.print(val);
				if (cst <= nst / 2) {
					val++;
				} else {
					val--;
				}
				cst++;
			}

			if (row <= n / 2) {
				nsp--;
				nst = nst + 2;
			} else {
				nsp++;
				nst = nst - 2;
			}

			System.out.println();
			row++;
		}
	}

}
