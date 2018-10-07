import java.util.Scanner;

public class Nth_Fabonacci {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Your Number");
		int n = scn.nextInt();
		int a = 0, b = 1;
		n++;
		int sum=0;
		for (int row = 2; row <= n; row++) {
			sum = a + b;
			b=a;
			a = sum;
			
		}
		System.out.println(sum);

	}

}
