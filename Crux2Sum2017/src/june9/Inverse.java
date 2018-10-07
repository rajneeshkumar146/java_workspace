package june9;

import java.util.Scanner;

public class Inverse {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter a number");
		int num = scn.nextInt();
		
		int inv = 0;
		int place = 1;
		while(num != 0){
			int rem = num % 10;
			
			inv = inv + place * (int)Math.pow(10, rem - 1);
			
			place++;
			num = num / 10;
		}
		
		System.out.println(inv);
	}

}
