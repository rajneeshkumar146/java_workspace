package Class_4th_Functions_and_Array;

import java.util.Scanner;

public class Far_to_cal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Min far?");
		int minf = scn.nextInt();

		System.out.println("Max far?");
		int maxf = scn.nextInt();

		System.out.println("Step far?");
		int stepf = scn.nextInt();
		
		celsius(minf,maxf,stepf);

		
	}
	public static void celsius(int minf,int maxf, int stepf){
		while(minf<=maxf){
		int ans=(int)((5.0/9)*(minf-32));
		minf=minf+stepf;
		System.out.println(ans+"\t"+minf);
		}
	}

}
