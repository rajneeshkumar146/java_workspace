package june18;

import java.util.Scanner;

public class calculator {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);

		while (true) {
			char ch = scn.nextLine().charAt(0);

			if (ch == '+') {
				int n1 = Integer.parseInt(scn.next());
				int n2 = Integer.parseInt(scn.next());
				System.out.println(n1 + n2);
			} else if (ch == '-') {
				int n1 = Integer.parseInt(scn.nextLine());
				int n2 = Integer.parseInt(scn.nextLine());
				System.out.println(n1 - n2);
			} else if (ch == '*') {
				int n1 = Integer.parseInt(scn.nextLine());
				int n2 = Integer.parseInt(scn.nextLine());
				System.out.println(n1 * n2);
			} else if (ch == '/') {
				int n1 = Integer.parseInt(scn.nextLine());
				int n2 = Integer.parseInt(scn.nextLine());
				System.out.println(n1 / n2);
			} else if (ch == '%') {
				int n1 = Integer.parseInt(scn.nextLine());
				int n2 = Integer.parseInt(scn.nextLine());
				System.out.println(n1 % n2);
			} else if (ch == 'x' || ch == 'X') {
				break;
			} else {
				System.out.println("Invalid operation.");
			}
		}
	}

}
