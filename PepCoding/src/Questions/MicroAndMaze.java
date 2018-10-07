package Questions;

import java.util.Scanner;

public class MicroAndMaze {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int i = scn.nextInt();
		int j = scn.nextInt();

		boolean[][] isdone = new boolean[i][j];
		isdone[0][0] = true;
		int[][] path = new int[i][j];

		for (int row = 0; row < path.length; row++) {
			for (int col = 0; col < path.length; col++) {
				path[row][col] = scn.nextInt();
			}
		}

		boolean res = MAM(path, 0, 0, isdone, path.length - 1, path.length - 1);
		System.out.println(res);

	}

	public static boolean MAM(int[][] arr, int r, int c, boolean[][] isdone, int er, int ec) {

		if (r == er && c == ec) {
			return true;
		}

		boolean res = false;
		if ((r + 1) <= er && isdone[r + 1][c] == false && arr[r + 1][c] == 1) {
			isdone[r + 1][c] = true;
			res = MAM(arr, r + 1, c, isdone, er, ec);
			if (res == true) {
				return true;
			}
		} else if ((c + 1) <= ec && isdone[r][c + 1] == false && arr[r][c + 1] == 1) {
			isdone[r][c + 1] = true;
			res = MAM(arr, r, c + 1, isdone, er, ec);
			if (res == true) {
				return true;
			}
		} else if ((r - 1) >= 0 && isdone[r - 1][c] == false && arr[r - 1][c] == 1) {
			isdone[r - 1][c] = true;
			res = MAM(arr, r - 1, c, isdone, er, ec);
			if (res == true) {
				return true;
			}
		} else if ((c - 1) >= 0 && isdone[r][c - 1] == false && arr[r][c - 1] == 1) {
			isdone[r][c - 1] = true;
			res = MAM(arr, r, c - 1, isdone, er, ec);
			if (res == true) {
				return true;
			}
		}

		return res;
	}

}
