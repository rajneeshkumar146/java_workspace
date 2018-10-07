import java.util.Scanner;

public class Question_16_Square_root {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Your Number");
		int n = scn.nextInt();
		
		System.out.println("Your Square root is:"+sqt(n));
	}
	public static int sqt(int nn){
		int sqrt=0;
		for(sqrt=0;sqrt*sqrt<=nn;sqrt++){
		}
			return sqrt-1;
		
		
		
	}

}
