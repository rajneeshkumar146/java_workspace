package Class_3rd_Binary_Invrerse_Rotation;

import java.util.Scanner;

public class Decimal_to_any_depend_on_base {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter your Decimal Number\t");
		int n = scn.nextInt();
		System.out.print("Enter Your Base\t");
		int base=scn.nextInt();
		int reverse=0,pow=1;
		for(int row=1;n!=0;row++){
			int rem = n % base;
			n = n / base;
			reverse = reverse + rem * pow;
			pow = pow * 10;

		}
		System.out.println("your Decimal Number is:" + reverse);

	}

}
