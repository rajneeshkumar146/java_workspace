import java.util.Scanner;

public class SumToN {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter a number");
		int n = scn.nextInt();
		
		int count = 1;
		int sum = 0;
		
		while(count <= n){
			sum = sum + count;
			count = count + 1;
		}
		
		System.out.println(sum);
	}

}
