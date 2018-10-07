package june12;

import java.util.Scanner;

public class pat1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter n");
		int n = scn.nextInt();
		
		int r = 1;
		while(r <= n){
			int c = 1;
			while(c <= r){
				System.out.print("*");
				c++;
			}
			
			r++;
			System.out.println();
		}
	}

}
