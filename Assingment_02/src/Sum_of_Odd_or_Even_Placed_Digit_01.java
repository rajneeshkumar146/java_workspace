import java.util.Scanner;

public class Sum_of_Odd_or_Even_Placed_Digit_01 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Your Positive Number");
		long n = scn.nextInt();
		long odd_sum = 0, even_sum = 0, temp_len = 0,length=0,temp_num=0; // temp lenght and temp number created to store there duplicate number.
		long rem=0; //remender of a number when divided by 10
		if (n >= 0) {
			temp_num=n;
			for (length = 0; temp_num != 0; length++) {
				temp_num = temp_num / 10;
			}
			System.out.println("Length Of number"+length);
			temp_len = length;
			for (long loop = 1; loop <= length; loop++) {
				rem=n%10;
				n=n/10;
				if (temp_len % 2 != 0) {
					odd_sum = odd_sum + rem;

				} else {
					even_sum = even_sum + rem;
				}
				temp_len--;
			}
			System.out.println("Sum of Odd Placed Digit is" + odd_sum);
			System.out.println("Sum of Even placed digit is" + even_sum);
		} else {
			System.out.println("Please Enter A Positive Number");
		}

	}

}
