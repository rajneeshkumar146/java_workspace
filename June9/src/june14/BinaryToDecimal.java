package june14;

import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter a binary number ");
		int bin = scn.nextInt();
		int dec = 0;

		int mult = 1;
		while (bin != 0) {
			int rem = bin % 10;
			bin = bin / 10;
			dec = dec + rem * mult;
			mult = mult * 2;
		}

		System.out.println(dec);
	}

}
