import java.util.Scanner;

public class Question_15_Precies_Series_with_deleting_term_important {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Your Number of Terms");
		int t = scn.nextInt();

		System.out.println("Enter Your deleting Number");
		int n = scn.nextInt();

		series(t, n);

	}

	public static void series(int t, int n) {
		int j = 1;
		for (int i = 1; j <= t; i++) {
			int rv = 3 * i + 2;
			if (rv % n != 0) {
				System.out.println(rv);
				j++;
			}

		}

	}

}
