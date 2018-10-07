import java.util.Scanner;

public class Febonacci_Less_Than_N {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long n = scn.nextInt();
		long a = 0, b = 1;
		if(n>0 && n<=1000)
		System.out.println(a);
		System.out.println(b);
		long sum=a+b;
		while (sum<=n){
				System.out.println(sum);
				a=b;
				b = sum;
				sum = a + b;
			

			
		}

	}

}
