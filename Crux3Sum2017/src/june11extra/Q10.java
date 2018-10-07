package june11extra;

import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter x");
		int x = scn.nextInt();
		
		System.out.println("Enter n");
		int n = scn.nextInt();
		
//		int pow = 1;
//		int count = 1;
//		while(count <= n){
//			pow = pow * x;
//			count++;
//		}
//		
//		System.out.println(pow);
		
		// Log(x) to the base n
		int count = 0;
		while(x != 1){
			x = x / n;
			count++;
		}
		
		System.out.println(count);
	}

}
