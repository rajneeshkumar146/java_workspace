import java.util.Scanner;

public class Hollow_rombus {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int l = scn.nextInt();

		hollowRombus(l);

	}

	public static void hollowRombus(int l) {

		int nst = l;
		int nspi = l-2; //no of space inside
		int nspa= 0; //no of space adjust

		for (int row = 1; row <= l; row++) {
			for (int csp = 1; csp <= nspa; csp++) {
				System.out.print(" ");
			}
			if (row == 1 || row == l) {
				for (int cst = 1; cst <= nst; cst++) {
					System.out.print("*");
				}
			} else {
				System.out.print("*");

				for (int csp = 1; csp <= nspi; csp++) {
					System.out.print(" ");
				}

				System.out.print("*");
			}
			nspa++;
			System.out.println();

		}

	}

}
