package Bitmanipulation;

import java.util.Scanner;

public class Q007_EvenOrNot {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int n = scn.nextInt();
		boolean res = (n & 1) == 0;
		System.out.println(res);

	}

}
