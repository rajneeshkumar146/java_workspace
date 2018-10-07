package june11extra;

import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sn = new Scanner(System.in) ;
		int n = sn.nextInt();
		int f0 = 0 ;
		int f1= 1 ;
		int sum = 0;
		int counter = 2 ;
		
		while(counter <= n){
			sum = f0 + f1 ;
			
			f0 = f1 ;
			f1 = sum ;
			
		
			counter ++ ;
		}
		
		System.out.println(sum);
	}

}
