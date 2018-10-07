import java.util.Scanner;

public class Question_09 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		// System.out.println("Enter Your Number N1");
		int arn = scn.nextInt();
		System.out.println(result(arn));

	}

	public static boolean result(int rnum) {
		int oder = 0;
		int temp1 = rnum;
		while (temp1 != 0) { // Finding_Order.
			temp1 = temp1 / 10;
			oder++;
		}

		int num = rnum;
		int rv = 0;
		while (num != 0) { // Checking_Whether_Number_is_Armstrong_Or_Not.
			int rem = num % 10;
			num = num / 10;
			rv = rv + (int) Math.pow(rem, oder);

		}

		if (rnum == rv) {
			return true;
		} else {
			return false;
		}
	}

}
