package june14;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter a decimal number ");
		int dec = scn.nextInt();
		int bin = 0;

		int mult = 1;
		while (dec != 0) {
			int rem = dec % 2;
			dec = dec / 2;
			bin = bin + rem * mult;
			mult = mult * 10;
		}

		System.out.println(bin);
	}

}
