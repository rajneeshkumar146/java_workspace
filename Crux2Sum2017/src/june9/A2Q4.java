package june9;

import java.util.Scanner;

public class A2Q4 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter a number");
		int n = scn.nextInt();
		
		int n2test = 2;
		while(n2test <= n){
			int div = 2;
			while(div < n2test){
				if(n2test % div == 0){
					break;
				}
				div++;
			}
			
			if(div == n2test){
				System.out.println(n2test);
			}
			
			n2test++;
		}
	}

}
