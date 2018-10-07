package june17;

import java.util.Scanner;

public class A2Q19 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Number of number?");
		int n = scn.nextInt();

		System.out.println("Enter the 1st number");
		int prev = scn.nextInt();
		int curr = 0;

		boolean goingDec = true;

		int count = 2;
		while (count <= n) {
			System.out.println("ENter the " + count + "th number");
			curr = scn.nextInt();

			// logic
			if (goingDec) {
				if (prev >= curr) {
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
			// logic

			prev = curr;
			count++;
		}
		
		System.out.println("Valid");
	}

}
