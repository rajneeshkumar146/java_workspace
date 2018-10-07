package june12;

import java.util.Scanner;

public class pat4 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter n");
		int n = scn.nextInt();
		
		int r = 0;
		while(r < n){
			int c = 0;
			int val = 1;
			while(c <= r){
				System.out.print(val + "\t");
				
				val = (val * (r - c)) / (c + 1);
				c++;
			}
			
			r++;
			System.out.println();
		}
	}

}
