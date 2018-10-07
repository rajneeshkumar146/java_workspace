package june9;

import java.util.Scanner;

public class A2Q8 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter a number");
		int n = scn.nextInt();
		
		int row = 1;
		while(row <= n){
			int col = 1;
			
			while(col <= row){
				if(row == col || col == 1){
					System.out.print(row + "\t");
				} else {
					System.out.print(0 + "\t");
				}
				
				col++;
			}
			
			System.out.println();
			row++;
		}
	}

}
