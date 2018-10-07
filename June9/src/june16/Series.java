package june16;

import java.util.Scanner;

// 5 1 2 3 4 5
// 5 5 4 3 2 1
// 7 5 4 3 2 1 2 3
// 8 1 2 3 4 3 2 1 0
// 7 1 2 3 2 1 2 3
// 10 4 3 2 1 2 3 4 3 2 1
public class Series {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the number of elements ");
		int n = scn.nextInt();
		
		System.out.println("Enter the first number ");
		int first = scn.nextInt();
		
		System.out.println("Enter the second number ");
		int second = scn.nextInt();
		
		boolean goingUpwards = second > first;
		for(int i = 3; i <= n; i++){
			if(goingUpwards == false){ // downwards
				if(second > first){
					goingUpwards = true;
				}
			} else { // upwards
				if(second < first){
					System.out.println("Invalid");
					return;
				}
			}
			
			first = second;
			
			System.out.println("Enter the " + i + "th number ");
			second = scn.nextInt();
		}
		
		System.out.println("Valid");
	}

}
