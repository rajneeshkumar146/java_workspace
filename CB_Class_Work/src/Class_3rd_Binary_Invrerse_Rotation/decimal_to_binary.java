package Class_3rd_Binary_Invrerse_Rotation;

import java.util.Scanner;

public class decimal_to_binary {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter your Decimal Number\t");
		int n = scn.nextInt();
		int reverse = 0, pow = 1;
		for (int row = 1; n != 0; row++) {
			int rem = n % 2;
			n = n / 2;
			reverse = reverse + rem * pow;
			pow = pow * 10;

		}
		System.out.println("your Binary Number is:" + reverse);

	}

}
