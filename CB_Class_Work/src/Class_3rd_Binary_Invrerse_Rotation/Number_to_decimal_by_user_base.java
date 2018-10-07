package Class_3rd_Binary_Invrerse_Rotation;

import java.util.Scanner;

public class Number_to_decimal_by_user_base {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter your Number\t");
		int n = scn.nextInt();
		System.out.println("Enter Your destination Base");
		int dbase=scn.nextInt();
		System.out.println();
		int reverse=0,pow=1;
		for(int row=1;n!=0;row++){
			int rem = n % 10;
			n = n / 10;
			reverse = reverse + rem * pow;
			pow = pow * dbase;

		}
		System.out.println("your Decimal Number is:" + reverse);

	}

}
