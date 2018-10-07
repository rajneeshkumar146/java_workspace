package june17;

import java.util.Scanner;

public class A2Q18 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char ch = scn.nextLine().charAt(0);
		
		if(ch >= 'a' && ch <= 'z'){
			System.out.println("L");
		} else if(ch >= 'A' && ch <= 'Z'){
			System.out.println("U");
		} else {
			System.out.println("I");
		}
	}

}
