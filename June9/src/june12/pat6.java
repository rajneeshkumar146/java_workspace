package june12;

import java.util.Scanner;

public class pat6 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter n");
		int n = scn.nextInt();
		
		int sp = n / 2;
		int st = 1;
		
		int row = 1;
		while(row <= n){
			int csp = 1;
			while(csp <= sp){
				System.out.print(" ");
				csp++;
			}
			
			int cst = 1;
			while(cst <= st){
				System.out.print("*");
				cst++;
			}
			
			if(row <= n/2){
				sp = sp - 1;
				st = st + 2;
			} else {
				sp = sp + 1;
				st = st - 2;
			}
			
			System.out.println();
			row++;
		}
	}

}
