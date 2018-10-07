package Recursion_1and2;

import java.util.Scanner;

public class Q02_traingle {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		System.out.println(triangle(n));
	}

	public static int triangle(int rows) {
		if (rows == 0) {
			return 0;
		}
		
		if(rows==1){
			return 1;
		}
		int result = rows+triangle(rows - 1);
		return result;

	}

}
