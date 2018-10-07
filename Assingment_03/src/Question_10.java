import java.util.Scanner;

public class Question_10 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		// System.out.println("Enter Your Number N1");
		int sr = scn.nextInt();

		// System.out.println("Enter Your Number N2");
		int er = scn.nextInt();

		armgstrom(sr, er);

	}

	public static void armgstrom(int n1, int n2) {
		int oder = 0;
		int temp1 = n2;
		while (temp1 != 0) { // Finding_Order.
			temp1 = temp1 / 10;
			oder++;
		}

		for (int i = n1; i <= n2; i++) { // Checking_One_by_One_for_Armstrong_Number.
			int temp = i;
			int sum = 0;
			while (temp != 0) {
				int rem = temp % 10;
				temp = temp / 10;

				sum = sum + (int) Math.pow(rem, oder);

			}

			if (sum == i) {
				System.out.println(sum);
			}

		}

	}

}
