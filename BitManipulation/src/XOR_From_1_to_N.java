import java.util.Scanner;

public class XOR_From_1_to_N {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// Number input
		int N = scn.nextInt();
		System.out.println(computeXOR(N));
	}

	public static int computeXOR(int n) {
		// Logic= first compute xors of first 16 numbers and try to find
		// relation between them
		// If n is a multiple of 4
		if (n % 4 == 0)
			return n;

		// If n%4 gives remainder 1
		if (n % 4 == 1)
			return 1;

		// If n%4 gives remainder 2
		if (n % 4 == 2)
			return n + 1;

		// If n%4 gives remainder 3
		return 0;
	}

}
