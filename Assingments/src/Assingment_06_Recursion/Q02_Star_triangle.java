package Assingment_06_Recursion;

import java.util.Scanner;

public class Q02_Star_triangle {
	
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Enter Number Of Row's");
		int row=scn.nextInt();
		triangle(0,0,row);
		
	}
	
	public static void triangle(int row,int col,int count){
		if(row==count){
			return;
		}
		if(col>row){
			System.out.println();
			triangle(row+1,0,count);
			return;
		}
		
		System.out.print("*");
		triangle(row,col+1,count);
	}

}
