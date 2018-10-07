package Class_3rd_Binary_Invrerse_Rotation;

import java.util.Scanner;

public class Number_user_base_to_any_user_base_number {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter your Number\t");
		int n = scn.nextInt();
		System.out.println("Enter Your Base");
		int base = scn.nextInt();
		System.out.println("Enter Your Destination Base");
		int des_base = scn.nextInt();
		System.out.println();
		int reverse = 0, pow = 1, n_temp = 0;
		for (int row = 1; n != 0; row++) {
			int rem = n % 10;
			n = n / 10;
			n_temp = n_temp + rem * pow;
			pow = pow * base;

		}
		pow = 1;
		for (int row = 1; n_temp != 0; row++) {
			int rem = n_temp % des_base;
			n_temp = n_temp / des_base;
			reverse = reverse + rem * pow;
			pow = pow * 10;

		}
		System.out.println("your Number is:" + reverse);

	}

}
