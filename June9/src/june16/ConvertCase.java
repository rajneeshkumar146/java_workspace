package june16;

import java.util.Scanner;

public class ConvertCase {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter a character");
		char ch = scn.nextLine().charAt(0);
		char con = 0;
		
		if (ch >= 'a' && ch <= 'z') {
			con = (char)(ch + 'A' - 'a');
		} else if (ch >= 'A' && ch <= 'Z') {
			con = (char)(ch - 'A' + 'a');
		} else {
		}
		
		System.out.println(con);
	}

}
