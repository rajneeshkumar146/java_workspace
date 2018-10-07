import java.util.Scanner;

public class Question_11_GCD {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Your Dividend");
		int divd = scn.nextInt();

		System.out.println("Enter Your Divisor");
		int divs = scn.nextInt();

		System.out.println("Your GCD is:" + result(divd, divs));

	}

	public static int result(int divd, int divs) {
		int rv=0;
		for (int i = 1;divd % divs!= 0; i++) {
			int rem = divd % divs;
			divd = divs;
			divs = rem;
            rv=divs;
            
		}
		return divs;
	}
	

}
