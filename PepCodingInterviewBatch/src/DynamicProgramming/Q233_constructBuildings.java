package DynamicProgramming;

import java.util.Scanner;

public class Q233_constructBuildings {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int n = scn.nextInt();
		System.out.println(ConstructBuildings(n));
		System.out.println(ConstructBuildings2(n));
	}

	private static int ConstructBuildings(int n) {

		int[] Building = new int[n];
		int[] Space = new int[n];

		Building[0] = 1;
		Space[0] = 1;

		for (int i = 1; i < n; i++) {
			Space[i] = Building[i - 1] + Space[i - 1];
			Building[i] = Space[i - 1];
		}

		int ans = Building[n - 1] + Space[n - 1];

		return ans * ans;
	}

	private static int ConstructBuildings2(int n) {

		int Building = 1;
		int Space = 1;

		for (int i = 1; i < n; i++) {
			int temp = Building + Space;
			Building = Space;
			Space=temp;
		}

		int ans = Building + Space;

		return ans * ans;
	}

}
