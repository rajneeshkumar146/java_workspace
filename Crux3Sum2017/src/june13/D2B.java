package june13;

import java.util.Scanner;

public class D2B {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter number");
		int n = scn.nextInt();
		
		int pow = 1; // 10^0
		int bin = 0;
		while(n != 0){
			int rem = n % 2;
			n = n / 2;
			
			bin = bin + rem * pow;
			
			pow = pow * 10;
		}
		
		System.out.println(bin);
	}

}
