package june16;

import java.util.Scanner;

public class PrintCase {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter a character");
		char ch = scn.nextLine().charAt(0);
		
		if(ch >= 'a' && ch <= 'z'){
			System.out.println("lower case");
		} else if(ch >= 'A' && ch <= 'Z'){
			System.out.println("upper case");
		} else {
			System.out.println("invalid");
		}
	}

}
