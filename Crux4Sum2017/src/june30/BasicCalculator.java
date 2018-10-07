package june30;

import java.util.Scanner;

public class BasicCalculator {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char op = ' ';

		do {
			System.out.println("operation?");
			op = scn.nextLine().charAt(0);

			if (op == '+') {
				System.out.println("operand 1?");
				int op1 = Integer.parseInt(scn.nextLine());

				System.out.println("operand 2?");
				int op2 = Integer.parseInt(scn.nextLine());

				System.out.println(op1 + op2);
			} else if (op == '-') {
				System.out.println("operand 1?");
				int op1 = Integer.parseInt(scn.nextLine());

				System.out.println("operand 2?");
				int op2 = Integer.parseInt(scn.nextLine());

				System.out.println(op1 - op2);
			} else if (op == '*') {
				System.out.println("operand 1?");
				int op1 = Integer.parseInt(scn.nextLine());

				System.out.println("operand 2?");
				int op2 = Integer.parseInt(scn.nextLine());

				System.out.println(op1 * op2);
			} else if (op == '/') {
				System.out.println("operand 1?");
				int op1 = Integer.parseInt(scn.nextLine());

				System.out.println("operand 2?");
				int op2 = Integer.parseInt(scn.nextLine());

				System.out.println(op1 / op2);
			} else if (op == '%') {
				System.out.println("operand 1?");
				int op1 = Integer.parseInt(scn.nextLine());

				System.out.println("operand 2?");
				int op2 = Integer.parseInt(scn.nextLine());

				System.out.println(op1 % op2);
			} else {
				System.out.println("Try again");
			}
		} while (op != 'x' && op != 'X');
	}

}
