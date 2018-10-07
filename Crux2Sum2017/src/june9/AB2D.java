package june9;

import java.util.Scanner;

public class AB2D {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter a number");
		int sbnum = scn.nextInt();
		
		System.out.println("Enter source base");
		int sb = scn.nextInt();
		
		int dec = 0;
		int pow = 1;
		
		while(sbnum != 0){
			int rem = sbnum % 10;
			sbnum = sbnum / 10;
			dec = dec + rem * pow;
			pow = pow * sb;
		}
		
		System.out.println(dec);
	}

}
