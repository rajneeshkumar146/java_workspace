package DynamicProgramming.set;

import java.util.Arrays;
import java.util.Scanner;

public class Set06_MinCostPath {
	private static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] cost = { { 0, 5, 62 }, { 0, 11, 57 }, { 0, 17, 52 }, { 0, 23, 47 } };

		System.out.println(MinCostPath(cost, 0, 0, cost.length - 1, cost[0].length - 1));
		System.out.println(MinCostPathDP(cost, cost.length - 1, cost[0].length - 1));
	}

	private static int Min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	private static int MinCostPath(int[][] cost, int r, int c, int er, int ec) {// er=endRow,r=row
		if (r == er && c == ec) {
			return cost[r][c];
		}

		if (r > er || c > ec) {
			return (int) 1e9;
		}

		int Horizontal = MinCostPath(cost, r, c + 1, er, ec);
		int Vertical = MinCostPath(cost, r + 1, c, er, ec);
		int Diagonal = MinCostPath(cost, r + 1, c + 1, er, ec);

		return cost[r][c] + Min(Horizontal, Diagonal, Vertical);

	}

	private static int MinCostPathDP(int[][] cost, int er, int ec) {
		int[][] arr = new int[er + 2][ec + 2];

		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {

				arr[row][col] = (int) 1e9;

			}
		}

		arr[er + 1][ec + 1] = 0;

		for (int i = er; i >= 0; i--) {
			for (int j = ec; j >= 0; j--) {
				arr[i][j] = cost[i][j] + Min(arr[i][j + 1], arr[i + 1][j], arr[i + 1][j + 1]);
			}
		}
		return arr[0][0];

	}

}
