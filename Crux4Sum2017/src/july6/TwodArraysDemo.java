package july6;

public class TwodArraysDemo {

	public static void main(String[] args) {
		// int[] arr = { 10, 20, 30 };
		// A4Q15(arr);

		int[][] arr = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 }, { 41, 42, 43, 44 } };
		spiralDisplay(arr);
	}

	public static void A4Q15(int[] arr) {
		int i = 0;
		int limit = (int) Math.pow(2, arr.length);

		while (i < limit) {
			int temp = i;

			System.out.print("[");
			for (int j = 0; j < arr.length; j++) {
				int rem = temp % 2;

				if (rem == 1) {
					System.out.print(arr[j] + ", ");
				}

				temp = temp / 2;
			}
			System.out.println("]");

			i++;
		}
	}

	public static void waveDisplay(int[][] arr) {
		for (int col = 0; col < arr[0].length; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < arr.length; row++) {
					System.out.println(arr[row][col]);
				}
			} else {
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.println(arr[row][col]);
				}
			}
		}
	}

	public static void spiralDisplay(int[][] arr) {
		int rmin = 0, cmin = 0, rmax = arr.length - 1, cmax = arr[0].length - 1;
		int cnt = 1, tne = arr.length * arr[0].length;

		while (cnt <= tne) {
			// east
			for (int row = rmin; cnt <= tne && row <= rmax; row++) {
				System.out.println(arr[row][cmin]);
				cnt++;
			}
			cmin++;

			// south
			for (int col = cmin; cnt <= tne && col <= cmax; col++) {
				System.out.println(arr[rmax][col]);
				cnt++;
			}
			rmax--;

			// west
			for (int row = rmax; cnt <= tne && row >= rmin; row--) {
				System.out.println(arr[row][cmax]);
				cnt++;
			}
			cmax--;

			// north
			for (int col = cmax; cnt <= tne && col >= cmin; col--) {
				System.out.println(arr[rmin][col]);
				cnt++;
			}
			rmin++;
		}
	}

	public static void exitPoint(int[][] arr) {
		int dir = 0; // 0 - east, 1 for s, 2 for w and 3 for n
		int r = 0, c = 0;

		while (true) {
			dir = (dir + arr[r][c]) % 4;

			if (dir == 0) {
				c++;
			} else if (dir == 1) {
				r++;
			} else if (dir == 2) {
				c--;
			} else if (dir == 3) {
				r--;
			}

			if (r == -1) {
				System.out.println(++r + " and " + c);
				break;
			} else if (c == -1) {
				System.out.println(r + " and " + (c + 1));
				break;
			} else if (r == arr.length) {
				System.out.println(--r + " and " + c);
				break;
			} else if (c == arr[0].length) {
				System.out.println(r + " and " + (c - 1));
				break;
			}
		}
	}
}
