package june13;

import java.util.Scanner;

public class Rotate {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter number");
		int n = scn.nextInt();
		
		System.out.println("Enter rotations");
		int r = scn.nextInt();
		
		int dig = 0;
		int temp = n;
		while(temp != 0){
			dig++;
			temp = temp / 10;
		}
		
		r = r % dig;
		if(r < 0){
			r = r + dig;
		}
		
		int div = (int)Math.pow(10, r);
		int mult = (int)Math.pow(10, dig - r);
		
		int q = n / div;
		int rem = n % div;
		
		int ans = rem * mult + q;
		System.out.println(ans);
	}

}
