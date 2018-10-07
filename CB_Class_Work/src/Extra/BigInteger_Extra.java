package Extra;

import java.math.BigInteger;
import java.util.Scanner;

public class BigInteger_Extra {
	private static final BigInteger BigIntger = null;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		// Declaration----------------------------------------------------------------------------
		// int a = 54;
		// int b = 23;
		// BigInteger A = BigInteger.valueOf(54);
		// BigInteger B = BigInteger.valueOf(37);
		// BigInteger C = new BigInteger("54");
		//
		// System.out.println(a);
		// System.out.println(b);
		// System.out.println(A);
		// System.out.println(B);
		// System.out.println(C);

		// Manipulation----------------------------------------------------------------------------

		// String str = "123456789";
		// BigInteger D = A.add(new BigInteger(str));
		// int val = 123456789;
		// BigInteger E = A.add(BigIntger.valueOf(val));

		// Mathematical
		// operations:-----------------------------------------------------------------

		// int c = a + b;
		// C = A.add(B);
		/*
		 * Other similar function are subtract() , multiply(), divide(),
		 * remainder() But all these function take BigInteger as their argument
		 * so if we want these operation with integers or string convert them to
		 * BigInteger before passing them to functions as shown below:
		 */

		// Comparison:--------------------------------------------------------------------------------

		// if (a < b) {
		// } // For primitive int
		// if (A.compareTo(B) < 0) {
		// } // For BigInteger

		// Extraction of value from BigInteger:

		// int x = A.intValue(); // value should be in limit of int x
		// long y = A.longValue(); // value should be in limit of long y
		// String z = A.toString();

		int n = scn.nextInt();
		System.out.println(fact(n));

	}

	public static void addition() {
		// create 3 BigInteger objects
		BigInteger bi1, bi2, bi3;

		// assign values to bi1, bi2
		bi1 = new BigInteger("123");
		bi2 = new BigInteger("50");

		// perform add operation on bi1 using bi2
		bi3 = bi1.add(bi2);

		String str = "Result of addition is " + bi3;
		;

		// print bi3 value
		System.out.println(str);
	}

	public static void and() {
		// create 3 BigInteger objects
		BigInteger bi1, bi2, bi3;

		// assign values to bi1, bi2
		bi1 = new BigInteger("6"); // 110
		bi2 = new BigInteger("3"); // 011

		// perform and operation on bi1 using bi2
		bi3 = bi1.and(bi2);

		String str = "Result of and operation is " + bi3;

		// print bi3 value
		System.out.println(str);
	}

	public static void compare() {
		// create 2 BigInteger objects
		// BigInteger bi1, bi2;
		//
		// bi1 = new BigInteger("6");
		// bi2 = new BigInteger("3");

		// create int object
		// int res;

		// compare bi1 with bi2
		// res = bi1.compareTo(bi2);
		//
		// String str1 = "Both values are equal ";
		// String str2 = "First Value is greater ";
		// String str3 = "Second value is greater";
		//
		// if (res == 0)
		// System.out.println(str1);
		// else if (res == 1)
		// System.out.println(str2);
		// else if (res == -1)
		// System.out.println(str3);
	}

	public static void divideandreminder() {
		/*
		 * This method returns an array of two BigIntegers: the quotient (this /
		 * val) is the initial element, and the remainder (this % val) is the
		 * final element.
		 */
		// create 2 BigInteger objects
		BigInteger bi1, bi2;

		bi1 = new BigInteger("-100");
		bi2 = new BigInteger("3");

		// BigInteger array bi stores result of bi1/bi2
		BigInteger bi[] = bi1.divideAndRemainder(bi2);

		// print quotient and remainder
		System.out.println("Division result");
		System.out.println("Quotient is " + bi[0]);
		System.out.println("Remainder is " + bi[1]);
	}

	public static String fact(int n) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact.toString();
	}

}
