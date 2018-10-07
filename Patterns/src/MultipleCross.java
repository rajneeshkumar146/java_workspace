import java.util.Scanner;

public class MultipleCross {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		MultipleCross(n);

	}

	public static void MultipleCross(int n) {
		int ncr = n / 3;
		int nspsi = n-4; // number_of_space_Star_inside.
		int nspo = 1; // number_of_space_outside.
		int nstUL = ncr *n - ncr+1; // number_of_star_for_upper_and_lower_row.
		int nspso = 0; // number_of_space_star_outside.

		for (int cstUL = 1; cstUL <= nstUL; cstUL++) {
			System.out.print("*");
		}
		System.out.println();

		for (int row = 1; row <= n - 2; row++) {

			for (int ccr = 1; ccr <= ncr; ccr++) {

				for (int cspo = 1; cspo <= nspo; cspo++) {
					System.out.print(" ");
				}

				if (row != n / 2) {
					System.out.print("*");
				}
				for (int cspsi = 1; cspsi <= nspsi; cspsi++) {
					System.out.print(" ");
				}

				System.out.print("*");

				for (int cspso = 1; cspso <= nspso; cspso++) {
					System.out.print(" ");
				}

			}
			if (row < n / 2) {
				nspsi -= 2;
				nspo++;
				nspso++;
			} else {
				nspsi += 2;
				nspo--;
				nspso--;
			}
			System.out.println();

		}

		for (int cstUL = 1; cstUL <= nstUL; cstUL++) {
			System.out.print("*");
		}

	}

}
