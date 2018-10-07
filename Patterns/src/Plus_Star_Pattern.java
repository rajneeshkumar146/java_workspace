import java.util.Scanner;

public class Plus_Star_Pattern {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Length of Plus Symbol: ");
		int x = scn.nextInt();

		int nsp = x / 2;

		for (int row = 1; row <= x; row++) {

			if (row != x / 2 + 1) {
				for (int csp = 1; csp <= nsp; csp++) {
					System.out.print(" ");
				}
			}
			if (row == x / 2 + 1) {
				for (int cst = 1; cst <= x; cst++) {
					System.out.print("+");
				}
			} else {
				System.out.print("+");

			}

			System.out.println();

		}

	}

}
