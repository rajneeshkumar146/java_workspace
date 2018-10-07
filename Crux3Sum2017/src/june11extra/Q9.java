package june11extra;

import java.util.Scanner;

public class Q9 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter n1");
		int n1 = scn.nextInt();
		
		System.out.println("Enter n2");
		int n2 = scn.nextInt();
		
		int divs = n1;
		int divd = n2;
		
		while(divd % divs != 0){
			int rem = divd % divs;
			
			divd = divs;
			divs = rem;
		}
		
		System.out.println(divs); // gcd
		System.out.println((n1 * n2) / divs); // lcm
	}

}
