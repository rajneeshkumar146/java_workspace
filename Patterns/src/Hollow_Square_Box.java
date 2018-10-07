import java.util.Scanner;

public class Hollow_Square_Box {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of row's");
		int n = scn.nextInt();
		for (int row = 1; row <= n; row++) {

			if (row > 1 && row < n) { //2nd row to (n-1)th row we have to print space and star.
				for (int cst = 1; cst <= 1; cst++) {  //cst=counter star
					System.out.print("*");
				}
				for (int csp = 1; csp < n - 1; csp++) { // csp=counter star
					System.out.print(" ");
				}
				for (int cst = 1; cst <= 1; cst++) {
					System.out.print("*");
				}
			} else {
				for (int cst = 1; cst <= n; cst++) { // cst=counter star
					System.out.print("*");
				}
			}

			System.out.println();
		}
	}

}
