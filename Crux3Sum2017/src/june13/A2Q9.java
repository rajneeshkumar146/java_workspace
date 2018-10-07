package june13;

import java.util.Scanner;

public class A2Q9 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter number");
		int n = scn.nextInt();
		
		int row = 0;
		int val = 1;
		while(row < n){
			int col = 0;
			val = 1;
			
			while(col <= row){
				System.out.print(val + "\t");
				
				int nv = (val * (row - col))/ (col + 1);
				val = nv;
				
				col++;
			}
			
			System.out.println();
			row++;
		}
	}

}
