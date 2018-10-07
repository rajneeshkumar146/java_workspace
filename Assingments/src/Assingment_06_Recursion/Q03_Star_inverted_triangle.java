package Assingment_06_Recursion;

import java.util.Scanner;

public class Q03_Star_inverted_triangle {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Enter Number Of Row's");
		int row=scn.nextInt();
		inverted_triangle(0,0,row);
		
	}
	
	public static void inverted_triangle(int row,int col,int count){
		if(row==count){
			return;
		}
		if(col>row){
			inverted_triangle(row+1,0,count);
			if(row<count-1){
			System.out.println();
			}
			return;
		}
		
	
		inverted_triangle(row,col+1,count);
		System.out.print("*");
	}
}
