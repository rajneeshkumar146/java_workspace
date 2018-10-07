import java.util.Scanner;

public class Question_18_Finding_Uppercase_and_Lowercase {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Your character");

		String s = scn.nextLine();

		if (s.length() > 0) {
			char c = s.charAt(0);
			if (c >= 'a' && c <= 'z') {
				System.out.println("lower case Character");

			} else if (c >= 'A' && c <= 'Z') {
				System.out.println("Upper Case Character");

			} else {
				System.out.println("Must be Symbols");

			}

		} else {
			System.out.println("I");
		}

	}

}
