package Bitmanipulation;

import java.util.Scanner;

public class Q005_FindAloneWhereAllRepeate_KTimes {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		int[] arr = { 2, 2, 2,3};
		int k = 3;

		int[] bits = new int[64];
		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < bits.length; i++) {
				if ((arr[j] & (1 << i)) != 0) {
					bits[i] += 1;
				}
			}
		}

		long var = 0;
		for (int i = 0; i < bits.length; i++) {
			var += ((bits[i] % k) * (1 << i));
		}

		System.out.println(var);

	}

}
