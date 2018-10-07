import java.util.Scanner;

public class Cross {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Number of rows please?");
		int n = scn.nextInt();

		int row = 1;
		while (row <= n) {
			int col = 1;
			while (col <= n) {
				if (col == row || col + row == n + 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
				col++;
			}

			System.out.println();
			row++;
		}
	}

}
