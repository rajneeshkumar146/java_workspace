import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter number");
		int n = scn.nextInt();

		int div = 2;
		while (div < n) {
			if (n % div == 0) {
				break;
			}

			div++;
		}

		if (div == n) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
