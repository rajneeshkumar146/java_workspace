package june9;

import java.util.Scanner;

public class D2B {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter a number");
		int dec = scn.nextInt();
		
		int bin = 0;
		int pow = 1;
		
		while(dec != 0){
			int rem = dec % 2;
			dec = dec / 2;
			bin = bin + rem * pow;
			pow = pow * 10;
		}
		
		System.out.println(bin);
	}

}
