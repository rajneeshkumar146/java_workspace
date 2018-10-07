package Assingment_08a_Recursion;

import java.util.Scanner;

public class Q05_Tower_of_hanoi {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(counttoh(n, "A", "C", "B")); // beign=A,help=B,end=C.
		toh(n, "A", "C", "B");
	}

	public static int counttoh(int n, String begin, String end, String help) {
		if (n == 0) {
			return 0;
		}
		int count = 0;
		count += counttoh(n - 1, begin, help, end);
		count++;
		count += counttoh(n - 1, help, end, begin);
		return count;

	}

	public static void toh(int n, String begin, String end, String help) {
		if (n == 0) {
			return;
		}

		toh(n - 1, begin, help, end);
		System.out.println("Move disc [" + n + "] from " + begin + " to " + end);
		toh(n - 1, help, end, begin);

	}

}
