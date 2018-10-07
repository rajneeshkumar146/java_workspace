package june14;

import java.util.Scanner;

public class A3Q19 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
//		System.out.println("Enter number of numbers");
		int n = scn.nextInt();
		
//		System.out.println("Enter first number ");
		int prev = scn.nextInt();
		int curr = 0;
		
		int count = 2;
		boolean goingDec = true;
		
		while(count <= n){
//			System.out.println("Enter " + count + " number ");
			curr = scn.nextInt();
			
			// work area
			if(goingDec){
				if(curr < prev){
					// expected
				} else {
					goingDec = false;
				}
			} else {
				if(curr > prev){
					// expected
				} else {
					System.out.println("Invalid");
					return;
				}
			}
			// work area
			
			prev = curr;
			count++;
		}
		
		System.out.println("Valid");
	}

}
