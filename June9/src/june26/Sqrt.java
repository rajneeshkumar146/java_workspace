package june26;

import java.util.Scanner;

public class Sqrt {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter a number ");
		int n = scn.nextInt();
		
		System.out.println("Enter precision");
		int p = scn.nextInt();
		
		double sqrt = 0;
		double increment = 1;
		
		int mult = 1;
		double div = 1.0;
		
		for(int i = 0; i <= p; i++){
			while(sqrt * sqrt <= n){
				sqrt += increment;
				System.out.println(((int)(sqrt * mult) / div));
			}
			
			sqrt -= increment;
			System.out.println(((int)(sqrt * mult) / div));
			increment *= 0.1;
			
			mult *= 10;
			div *= 10.0;
		}
		
		sqrt = sqrt - increment;
		mult /= 10;
		div /= 10.0;
		
		System.out.println(((int)(sqrt * mult) / div));
	}

}
