package Class_3rd_Binary_Invrerse_Rotation;

import java.util.Scanner;

public class Binary_to_Decimal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter your Binary Number\t");
		int n = scn.nextInt();
		int reverse=0,pow=1;
		for(int row=1;n!=0;row++){
			int rem = n % 10;
			n = n / 10;
			reverse = reverse + rem * pow;
			pow = pow * 2;

		}
		System.out.println("your Decimal Number is:" + reverse);

	}

}
