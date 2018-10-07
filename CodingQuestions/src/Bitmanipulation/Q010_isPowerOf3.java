package Bitmanipulation;

import java.util.Scanner;

public class Q010_isPowerOf3 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int n = scn.nextInt();
		System.out.println(n > 0 && 1162261467 % n == 0);
	}

}
