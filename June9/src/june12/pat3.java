package june12;

import java.util.Scanner;

public class pat3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter n");
		int n = scn.nextInt();
		
		int r = 1;
		int a = 0;
		int b = 1;
		while(r <= n){
			int c = 1;
			while(c <= r){
				System.out.print(a + "\t");
				int fib = a + b;
				a = b;
				b = fib;
				c++;
			}
			
			r++;
			System.out.println();
		}
	}

}
