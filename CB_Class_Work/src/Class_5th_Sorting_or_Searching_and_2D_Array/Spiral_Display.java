package Class_5th_Sorting_or_Searching_and_2D_Array;

import java.util.Scanner;

public class Spiral_Display {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
	
		
		
		int[][] arr = take_input();
		display(arr);
		spiral(arr);
	}

	public static int[][] take_input() {
		System.out.println("\tEnter Number Of Row's");
		int row = scn.nextInt();

		System.out.println("\tEnter Number Of column's");
		int col = scn.nextInt();

		int[][] rv = new int[row][col];

		for (int i = 0; i < rv.length; i++) {
			for (int j = 0; j < rv[0].length; j++) {
				System.out.println("Enter your " + (i + 1) + (j + 1) + "th element");
				rv[i][j] = scn.nextInt();
			}

		}
		return rv;

	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col]);
			}
		}
	}

	public static void spiral(int[][] arr) {
		int rmin = 0, cmin = 0,rmax=arr.length-1,cmax=arr[0].length-1;
	    int row=0,col=0,count=1;
	    int tne=arr.length*arr[0].length;
		while (count<=tne) {
			row=rmin;
			col=cmin;
			for (row =rmin ; row <= rmax && count<=tne; row++) {
				System.out.print(arr[row][col]+",");
				count++;
			}
            row--;
			for ( col = cmin+1; col <= cmax-1 && count<=tne; col++) {
				System.out.print(arr[row][col]+",");
				count++;

			}
			
			for ( row = rmax; row >= rmin && count<=tne; row--) {
				System.out.print(arr[row][col]+",");
				count++;

			}
            row++;
			for ( col = cmax-1; col > cmin && count<=tne; col--) {
				System.out.print(arr[row][col]+",");
				count++;
				

			}	
			rmax--;
			cmax--;
			rmin++;
			cmin++;

		}

	}

}
