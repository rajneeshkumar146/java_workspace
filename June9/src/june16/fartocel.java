package june16;

import java.util.Scanner;

public class fartocel {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter min far");
		int minf = scn.nextInt();
		
		System.out.println("Enter max far");
		int maxf = scn.nextInt();
		
		System.out.println("Enter step size");
		int step = scn.nextInt();

		for(int far = minf; far <= maxf; far += step){
			int cel = (int)((5.0 / 9) * (far - 32));
			System.out.println(far + " " + cel);
		}
	}

}
