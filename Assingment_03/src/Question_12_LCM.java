import java.util.Scanner;

public class Question_12_LCM {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter First Number");
		int n1 = scn.nextInt();

		System.out.println("Enter Second Number");
		int n2 = scn.nextInt();
		
		System.out.println("Your LCM is:"+ lcm(n1,n2));
		

	}

	public static int lcm(int n1, int n2) {
		int rv = 0, quo_1 = 0, quo_2 = 0;
		int gcd = GCD(n1, n2);
		if (gcd != 0) {
			quo_1 = n1 / gcd;
			quo_2 = n2 / gcd;
			rv = quo_1 * quo_2 * gcd;
		}else{
			rv=n1*n2;
		}

		return rv;
	}

	public static int GCD(int divd, int divs) {
		int rv = 0;
		for (int i = 1; divd % divs != 0; i++) {
			int rem = divd % divs;
			divd = divs;
			divs = rem;
			rv = divs;

		}
		return divs;
	}

}
