package june12;

import java.util.Scanner;

public class far2cel {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Min far?");
		int minf = scn.nextInt();
		
		System.out.println("Max far?");
		int maxf = scn.nextInt();
		
		System.out.println("Step far?");
		int stepf = scn.nextInt();
		
		int tempf = minf;
		while(tempf <= maxf){
			int tempc = (int)((5.0 / 9)*(tempf - 32));
			System.out.println(tempf + " " + tempc);
			tempf = tempf + stepf;
		}
	}

}
