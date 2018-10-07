import java.util.Scanner;

public class Question_13_higher_power {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Your Number");
		int n = scn.nextInt();
		
		System.out.println("Enter your Power");
		int p=scn.nextInt();
      
		System.out.println("Your answer is:" + power(n,p));

	}
	public static int power(int n,int p){
		int rv=0,pow=1;
		for(int i=1;i<=p;i++){
			pow=pow*n;
			
		}
		rv=pow;
		return rv;
		
	}

}
