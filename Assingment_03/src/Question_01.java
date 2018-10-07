import java.util.Scanner;

public class Question_01 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter your Number");
		int n = scn.nextInt();
		
	  System.out.println("Your Decimal Number is:" + decimal(n));

	}

	public static int decimal(int n) {
		int rv = 0;
		int temp = n, pow = 1;

		for (int i = 1; temp != 0; i++) {
			int rem = temp % 10;
			temp = temp / 10;
			// rv=rv+ rem*((int)Math.pow(2,(i-1)));
			rv = rv + rem * pow;
			pow = pow * 2;

		}

		return rv;

	}

}
