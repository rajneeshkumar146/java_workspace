import java.util.Scanner;

public class Question_08 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Your Number");
		int n = scn.nextInt();
	   if(result(n)){
		  System.out.println("true"); 
	   }
	   else{
		  System.out.println("false"); 
	   }
	}

	public static boolean result(int n ) {
		int rv = 0;
		int temp=n;
		for (int i = 1; temp != 0; i++) {
			int rem = temp % 10;
			temp = temp / 10;
     		int pow=1;
			for (int j = 1; j < rem; j++) {
				pow = pow * 10;
			}
			 rv = rv + i * pow;
		}

		if (rv == n) {
			return true;
		}
		else{
			return false;
		}
	}

}
