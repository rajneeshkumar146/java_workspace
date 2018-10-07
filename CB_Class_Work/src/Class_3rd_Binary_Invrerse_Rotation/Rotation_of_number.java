package Class_3rd_Binary_Invrerse_Rotation;

import java.util.Scanner;

public class Rotation_of_number {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter your Number\t");
		int n = scn.nextInt(); // n stand for number.
		System.out.println("Enter Number Of Rotaion's\t");
		int r = scn.nextInt(); // r stand for rotaion. v
		int len = 0; // len=length of number
		int temp_n = n, rem = 0;
		for (len = 0; temp_n != 0; len++) // For Calculating length of Number.
		{
			temp_n = temp_n / 10;
		}

		r = r % len;
		if(r < 0){
			r = r + len;
		}
		
		temp_n = n;
		for (int num = 1; num <= r; num++) {
			rem = temp_n % 10;
			temp_n = temp_n / 10;
			temp_n = temp_n + rem * (int) Math.pow(10, len - 1);

		}
		System.out.println("Your rotated number is:" + temp_n);

	}

}
