package june11extra;

import java.util.Scanner;

public class Q7 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter n");
		int n = scn.nextInt();
		
		int rev = 0;
		while(n != 0){
			int rem = n % 10;
			
			rev = 10 * rev + rem;
			
			n = n / 10;
		}
		
		System.out.println(rev);
	}

}
