import java.util.Scanner;

public class Inverted_Triangle_Pattern {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of row's");
		int n = scn.nextInt();
		for (int row = 1; row <= n; row++) {
			for (int csp = 1; csp <= row - 1; csp++) {
				System.out.print(" ");
			}
			for (int crt = 1; crt <= (n + 1) - row; crt++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
