package june9;

import java.util.Scanner;

public class A2Q6 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter a number");
		int n = scn.nextInt();
		
		int counter = 1;
		int so = 0, se = 0;
		while(n != 0){
			int rem = n % 10;
			n = n / 10;
			
			if(counter % 2 == 0){
				se = se + rem;
			} else {
				so = so + rem;
			}
			
			counter++;
		}
		
		System.out.println(so);
		System.out.println(se);
	}

}
