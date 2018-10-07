package june9;

import java.util.Scanner;

public class B2D {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter a number");
		int bin = scn.nextInt();
		
		int dec = 0;
		int pow = 1;
		
		while(bin != 0){
			int rem = bin % 10;
			bin = bin / 10;
			dec = dec + rem * pow;
			pow = pow * 2;
		}
		
		System.out.println(dec);
	}

}
