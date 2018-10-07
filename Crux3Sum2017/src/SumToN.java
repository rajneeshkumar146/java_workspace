import java.util.Scanner;

public class SumToN {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter number");
		int n = scn.nextInt();
		
		int sum = 0, counter = 1;
		while(counter <= n){
			sum = sum + counter;
			counter++;
		}
		
		System.out.println(sum);
	}

}
