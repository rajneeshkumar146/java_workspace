package june11extra;

import java.util.Scanner;

public class Q5 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter 1 number");
		int n1 = scn.nextInt();
		System.out.println("Enter 2 number");
		int n2 = scn.nextInt();

		int n = n1;

		while (n <= n2) {

			int div = 2;
			while (div < n) {
				if (n % div == 0) {
					break;
				}

				div++;
			}

			if (div == n) {
				System.out.println(n);
			} 
//			else {
//				System.out.println("No");
//			}
			n++;

		}

	}

}
