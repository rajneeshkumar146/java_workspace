package DynamicProgramming.Basics;

import java.util.Scanner;

public class Q215_BinaryStrings {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		int n = 5;
		System.out.println(BinaryStrings_Rec(n, false));

	}

	private static int BinaryStrings_Rec(int n, boolean isOneEnd) {

		int zeroend = 1;
		int oneend = 1;
		for (int i = 1; i < n; i++) {
			int temp = oneend + zeroend;
			oneend=zeroend;
			zeroend=temp;
		}
		
		return zeroend+oneend;
		

	}

}
