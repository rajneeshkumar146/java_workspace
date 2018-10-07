package june11extra;

import java.util.Scanner;

public class Q8 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter n");
		int n = scn.nextInt();
		
		int so = 0;
		int se = 0;
		int place = 1;
		
		while(n != 0){
			int rem = n % 10;
			n = n / 10;
			
			if(place % 2 == 0){
				se = se + rem;
			} else {
				so = so + rem;
			}
			
			place++;
		}
		
		System.out.println(so);
		System.out.println(se);
	}

}
