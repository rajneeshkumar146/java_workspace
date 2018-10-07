package june17;

import java.util.Scanner;

public class A2Q16Q17 {

	public static void main(String[] args) {
//		double d = 4.11;
//		double s = 0.11;
//		d = d + s;
//		System.out.println(Math.round(d * 100)/ 100.0);
				
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter number?");
		int n = scn.nextInt();

		System.out.println("Enter precision?");
		int p = scn.nextInt();

		double sqrt = 0;
		double inc = 1.0;
		int count = 0;
		
		int mult = 1;
		double div = 1.0;

		while (count <= p) {
			while (sqrt * sqrt <= n) {
				sqrt = sqrt + inc;
				System.out.println((Math.round(sqrt * mult) / div));
			}

			sqrt = sqrt - inc;
			System.out.println((Math.round(sqrt * mult) / div));
			inc = inc * 0.1;
			mult = mult * 10;
			div = div * 10.0;
			count++;
		}

		System.out.println((Math.round(sqrt * mult) / div));

	}

}
