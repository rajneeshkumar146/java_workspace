import java.util.Scanner;

public class Question_06 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Your Number");
		int n = scn.nextInt();
		System.out.println("Enter Digit");
		int d=scn.nextInt();
		System.out.println(digit(n,d));
		

	}
	public static int digit(int n, int d){
		int rv=0;
		for(int i=0;n!=0;i++){
           int rem=n%10;
			n=n/10;
         if(rem==d){
        	 rv++;
         }
		}
		return rv;
	}

}
