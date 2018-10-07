import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter number");
		int n = scn.nextInt();
		
		int rev = 0;
		while(n != 0){
			int rem = n % 10;
			n = n / 10;
			
			rev = 10 * rev + rem;
		}
		
		System.out.println(rev);
	}

}
