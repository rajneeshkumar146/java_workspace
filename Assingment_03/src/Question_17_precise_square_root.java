
import java.util.Scanner;

public class Question_17_precise_square_root {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Your Number");
		int n = scn.nextInt();

		int p = scn.nextInt();
		sqp(n, p);

	}

	public static int sqt(int n) {
		int sqrt = 0;
		for (sqrt = 0; sqrt * sqrt <= n; sqrt++) {
		}
		return sqrt - 1;

	}

	public static void sqp(int n, int p) {
		double sqrt = 0;
		double inc = 1;
		int mult = 1;
		double div = 1.0;
		int count = 0;

		while (count <= p) {
			while (sqrt * sqrt <= n) {
				sqrt = sqrt + inc;
			}
			sqrt = sqrt - inc;
			count++;
			inc = inc * 0.1;
			mult = mult * 10;
			div = div * 10.0;
		}

		System.out.print(Math.round(sqrt * mult) / div);
	}


}
