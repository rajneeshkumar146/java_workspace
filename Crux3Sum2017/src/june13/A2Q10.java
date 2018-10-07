package june13;

import java.util.Scanner;

public class A2Q10 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter number");
		int n = scn.nextInt();
		
		int row = 1;
		int a = 0, b = 1;
		while(row <= n){
			int col = 1;
			
			while(col <= row){
				System.out.print(a + "\t");
				
				int sum = a + b;
				a = b;
				b = sum;
				
				col++;
			}
			
			System.out.println();
			row++;
		}
	}

}
