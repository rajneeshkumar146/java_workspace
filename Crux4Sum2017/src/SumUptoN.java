import java.util.Scanner;

public class SumUptoN {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter a number");
		int n = scn.nextInt();

		int sum = 0;
		int count = 1;

		while (count <= n) {
			sum = sum + count;
			count++;
		}

		System.out.println(sum);
	}

}
