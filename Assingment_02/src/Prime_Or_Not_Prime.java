import java.util.Scanner;

public class Prime_Or_Not_Prime {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Your Number between 2 to n");
		long n = scn.nextInt();
		if (n > 2) {
			for (long temp = 2; temp<=(n-1); temp++) {
				if (n%temp==0) {
					System.out.println("Not Prime");
					return;
				}
			}
			System.out.println("Prime");
		} 
		else {
			System.out.println("Please Enter A Positive Number");
		}

	}

}