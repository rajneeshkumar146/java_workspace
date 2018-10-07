package Theory.Ch05_MatheMatics.T05_NumberTheory;

import java.util.Scanner;

public class T02_Factorial_GCD_Euclid {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		extendedEuclid(25, 18);
		System.out.println(x + " " + y + " " + d);

	}

	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	private static int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}

	static int x;
	static int y;
	static int d;

	private static void extendedEuclid(int a, int b) {
		if (b == 0) {
			x = 1;
			y = 0;
			d = a;
			return;
		}

		extendedEuclid(b, a % b);
		int x1 = y;
		int y1 = x - (a / b) * y;
		x = x1;
		y = y1;
	}

}
