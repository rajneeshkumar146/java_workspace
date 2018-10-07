import java.util.Scanner;

public class PrintPrimes {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter number");
		int n1 = scn.nextInt();
		
		System.out.println("Enter number");
		int n2 = scn.nextInt();
		
		int n2check = n1;
		while(n2check <= n2){
			int div = 2;
			while (div < n2check) {
				if (n2check % div == 0) {
					break;
				}

				div++;
			}
			
			if (div == n2check) {
				System.out.println(n2check);
			}
			
			n2check++;
		}
	}

}
