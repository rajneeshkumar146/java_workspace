package Practice.Algorithms.Implimentation;

import java.math.BigInteger;
import java.util.Scanner;

public class Extra_Long_Factorials {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();

		BigInteger res = new BigInteger("1");
		for (int i = num; i > 0; i--) {

			res = res.multiply(BigInteger.valueOf(i));

		}
		
		System.out.print(res);

	}

}
