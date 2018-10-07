import java.util.Scanner;

public class Centre_missed_line_triangle {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		cmlt(n);
	}

	public static void cmlt(int n) {
		int count = 1;
		for (int row = 1; row <= n; row++) {
			for (int cst = 1; cst <= 2 * row - 1; cst++) {
				if (count == cst) {
					System.out.print(" ");
					continue;
				}

				System.out.print("*");
			}
			count ++;
			System.out.println();
		}

	}

}
