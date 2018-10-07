import java.util.Scanner;

public class Question_02 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter your Number");
		int n = scn.nextInt();
		
		System.out.println("Your Octal number is:" + octal(n));

	}
	
	public static int octal(int n){
		int rv=0,pow=1;
		for(int i=0;n!=0;i++){
			int rem=n%8;
			n=n/8;
			rv=rv + rem*pow;
			pow=pow*10;
		}
		return rv;
	}

}
