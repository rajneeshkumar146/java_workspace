package Beginner;

import java.math.BigInteger;
import java.util.Scanner;

public class Q10_SmallFactorial_FLOW018 {

	private static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int T = scn.nextInt();
		while (T-- > 1) {
			System.out.println(solve() + "");
		}

		System.out.print(solve() + "");
		scn.close();

	}

	public static String solve() throws Exception {
		int i = scn.nextInt();
		BigInteger result = new BigInteger("1");
		while (i > 0) {
			result = result.multiply(BigInteger.valueOf(i));
			i--;
		}

		return result.toString();

	}

}
