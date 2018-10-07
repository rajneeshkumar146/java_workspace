package Practice_Easy;

import java.util.Scanner;

public class productSum {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("No of test case");
		int not = scn.nextInt();
		for (int i = 0; i <= not; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			int ans = a * b;
			if (ans == 0) {
				System.out.println("1");
			} else {
				int count = 0;
				System.out.println(productSum(ans, count));
			}
		}

	}

	public static int productSum(int val, int count) {
		if (val == 0) {
			return count;
		}

		val = val / 10;
		return productSum(val, count + 1);
	}

}
