package june9;

import java.util.Scanner;

public class Rotate {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter a number");
		int num = scn.nextInt();
		
		System.out.println("Enter rotations");
		int rot = scn.nextInt();
		
		
		int digits = 0;
		int temp = num;
		while(temp != 0){
			temp = temp / 10;
			digits++;
		}
		
		rot = rot % digits;
		if(rot < 0){
			rot = rot + digits;
		}
		
		int divider = (int)Math.pow(10, rot);
		int multiplier = (int)Math.pow(10, digits - rot);
		
		int quo = num / divider;
		int rem = num % divider;
		
		int rotatednum = rem * multiplier + quo;
		System.out.println(rotatednum);
		
	}
	
	
	
	
	
	
	
	

}
