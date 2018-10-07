import java.util.Scanner;

public class Equal_Sum_and_Z_XOR {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// Number input
		int N = scn.nextInt();
		System.out.println(countValues(N));

	}

	public static int countValues(int n) {
		int countV = 0;

		// Traverse all numbers from 0 to n
		// and increment result only when
		// given condition is satisfied.
		for (int i = 0; i <= n; i++)
			if ((n + i) == (n ^ i))
				countV++;

		return countV;
	}

}
