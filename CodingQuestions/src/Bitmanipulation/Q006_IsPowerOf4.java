package Bitmanipulation;

import java.util.Scanner;

public class Q006_IsPowerOf4 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int n = 8;
		if ((n & (n - 1)) == 0) {
			int count = 0;
			while (n > 1) {
				count++;
				n >>>= 1;
			}

			if ((count & 1) == 0) {
				System.out.println(true);
				
			} else {
				System.out.println(false);
			}
		}

	}

}
