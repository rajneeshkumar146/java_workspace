import java.util.Scanner;

public class Right_and_Left_Arrow {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of Row's");
		int n = scn.nextInt();

		LeftArrow(n);
		System.out.println();
		RightArrow(n);

	}

	public static void LeftArrow(int n) {
		int nsp = 0;
		int nst = n / 2 + 1;
		for (int row = 1; row <= n; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			if (row <= n / 2) {
				nsp += 2;
				nst--;
			} else {
				nsp -= 2;
				nst++;

			}
			System.out.println();
		}
	}

	public static void RightArrow(int n) {
		int nsp = n/2;
		int nst = n / 2 + 1;
		for (int row = 1; row <= n; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			if (row <= n / 2) {
				nsp --;
				nst--;
			} else {
				nsp ++;
				nst++;

			}
			System.out.println();
		}
	}

}
