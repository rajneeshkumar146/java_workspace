package june13;

import java.util.Scanner;

public class B2D {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter number");
		int n = scn.nextInt();
		
		int pow = 1; // 2^0
		int dec = 0;
		while(n != 0){
			int rem = n % 10;
			n = n / 10;
			
			dec = dec + rem * pow;
			
			pow = pow * 2;
		}
		
		System.out.println(dec);
	}

}
