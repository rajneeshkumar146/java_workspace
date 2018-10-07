package june9;

import java.util.Scanner;

public class D2AB {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter a number");
		int dec = scn.nextInt();
		
		System.out.println("Enter destination base");
		int db = scn.nextInt();
		
		int bin = 0;
		int pow = 1;
		
		while(dec != 0){
			int rem = dec % db;
			dec = dec / db;
			bin = bin + rem * pow;
			pow = pow * 10;
		}
		
		System.out.println(bin);
	}

}
