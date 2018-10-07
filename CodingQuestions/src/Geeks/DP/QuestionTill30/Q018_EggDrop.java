package Geeks.DP;

import java.util.Scanner;

public class Q018_EggDrop {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int floor = 10, eggs = 2;
		System.out.println(EggDrop(floor, eggs));

	}

	private static int EggDrop(int floor, int eggs) {
		if (eggs == 1 || eggs == 0 || floor == 1) {
			return floor;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= floor; i++) {
			int eggBreak = EggDrop(i - 1, eggs - 1);
			int NotBreak = EggDrop(floor - i, eggs);

			int max = Math.max(eggBreak, NotBreak);

			if (max < min) {
				min = max;
			}

		}

		return min + 1;

	}

}
