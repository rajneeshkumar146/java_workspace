import java.util.Scanner;

public class Question_10 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of row's ");
		int n = scn.nextInt();
		int x = 0, y = 1, sum = 0;
		for (int row = 1; row <= n; row++) {   // loop start from 2nd row. so total (n-1)time loop run.
			for (int crt = 1; crt <= row; crt++) {
				System.out.print(sum);
				x = y;   // Suffling y value goes to x. 
				y = sum; // suffling sum value goes to y.
				sum = x + y;
				System.out.print("\t");  // For better View
			}

			System.out.println();

		}

	}

}
