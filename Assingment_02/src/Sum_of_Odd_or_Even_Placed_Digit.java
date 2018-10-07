import java.util.Scanner;

public class Sum_of_Odd_or_Even_Placed_Digit {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Your Number");
		long n = scn.nextLong();
		long sum_even = 0, sum_odd = 0;

		long temp = n, val = 0;
		while (temp != 0) {
			long rem = temp % 10;
			temp = temp / 10;
			val++;
			if (val % 2 == 0) {
				sum_even += rem;
			} else {
				sum_odd += rem;
			}

		}
		System.out.println("sum of odd number is" + sum_odd);
		System.out.println("sum of even number is" + sum_even);
	}

}
