import java.util.Scanner;

public class Question_03 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter your Octal Number");
		int n = scn.nextInt();
		
		System.out.println("Your decimal number is:" + decimal(n));
		System.out.println("Your binary number is:" + binary(n));
	}
	
	public static int decimal(int n){
		int rv=0,pow=1;
		for(int i=0;n!=0;i++){
			int rem=n%10;
			n=n/10;
			rv=rv + rem*pow;
			pow=pow*8;
		}
		return rv;
	}

	public static int binary(int n){
		int rv=0,pow=1;
	   int nn=decimal(n);
		for(int i=0;nn!=0;i++){
			int rem=nn%2;
			nn=nn/2;
			rv=rv + rem*pow;
			pow=pow*10;
		}
		
		return rv;
		
	}
}
