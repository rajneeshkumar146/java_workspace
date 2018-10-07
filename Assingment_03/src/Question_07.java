import java.util.Scanner;

public class Question_07 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Your Number");
		int n = scn.nextInt();
		
		System.out.println("Your Reverse Numkber is:"+ reverse(n));

	}

	public static int reverse(int n) {
		int rv = 0;
		for (int i = 1; n != 0; i++) {
			int rem = n % 10;
			n = n / 10;
     		int pow=1;
			for (int j = 1; j < rem; j++) {
				pow = pow * 10;
			}
//     		 pow=(int)Math.pow(10,rem-1);
			 rv = rv + i * pow;
		}

		return rv;

	}
}
