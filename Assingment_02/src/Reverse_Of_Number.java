import java.util.Scanner;

public class Reverse_Of_Number {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		if (n >= 0) {
			int reverse = 0;
			while (n != 0) {
				int b = n % 10;
				reverse = reverse * 10 + b;
				n = n / 10;

			}

			System.out.println(reverse);
		} else {
			System.out.println("Please Enter A Positive Number");
		}
	}

}