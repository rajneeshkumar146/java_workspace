package june14;

import java.util.Scanner;

public class TwodArrayOps {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// int[][] arr = { { 11, 12, 13, 14,15, 16 },
		// { 21, 22, 23, 24, 25, 26 },
		// { 31, 32, 33, 34, 35, 36 },
		// { 41, 42, 43, 44, 45, 46 },
		// { 51, 52, 53, 54, 55, 56 },
		// { 61, 62, 63, 64, 65, 66 } };
		// shellRotate(arr, 2, 2);
		// display(arr);
		// spiraldisplay2(arr);
		// int[][] arr = { { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1,
		// 0, 1, 0 }};
		int r = scn.nextInt();
		int c = scn.nextInt();
		int[][] arr = new int[r][c];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}

		}
		exitPoint(arr);
	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
	}

	public static void wavedisplay(int[][] arr) {
		for (int col = 0; col < arr[0].length; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < arr.length; row++) {
					System.out.print(arr[row][col] + ", ");
				}
			} else {
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.print(arr[row][col] + ", ");
				}
			}
		}

		System.out.println(".");
	}

	public static void exitPoint(int[][] arr) {
		int dir = 0, row = 0, col = 0;

		while (true) {
			dir = (dir + arr[row][col]) % 4;

			if (dir == 0) { // east
				col++;
				if (col == arr[0].length) {
					System.out.println(row + ", " + (col - 1));
					break;
				}
				
			} else if (dir == 1) { // south
				row++;
				if (row == arr.length) {
					System.out.println((row - 1) + ", " + (col));
					break;
				}
			} else if (dir == 2) { // west
				col--;
				if (col == -1) {
					System.out.println(row + ", " + (0));
					break;
				}
			} else if (dir == 3) { // north
				row--;
				if (row == -1) {
					System.out.println(0 + ", " + (col));
					break;
				}
			}
		}
	}

	public static void spiraldisplay(int[][] arr) {
		int dir = 0; // south, east, north, west
		int rmin = 0, cmin = 0, rmax = arr.length - 1, cmax = arr[0].length - 1;
		int row = rmin, col = cmin;

		int tne = arr.length * arr[0].length;
		int counter = 1;

		while (counter <= tne) {
			System.out.println(arr[row][col]);
			counter++;

			if (dir == 0) {
				row++;
				if (row == rmax) {
					if (row > rmax) {
						row = rmax;
						col++;
					}
					dir++;
				}
			} else if (dir == 1) {
				col++;
				if (col >= cmax) {
					if (col > cmax) {
						col = cmax;
						row--;
					}
					dir++;
				}
			} else if (dir == 2) {
				row--;
				if (row <= rmin) {
					if (row < rmin) {
						row = rmin;
						col--;
					}
					dir++;
				}
			} else if (dir == 3) {
				col--;
				if (col <= cmin) {
					if (col < cmin) {
						col = cmin;
						row++;
					}

					dir = 0;

					rmin++;
					cmin++;
					rmax--;
					cmax--;

					row = rmin;
					col = cmin;
				}
			}
		}

	}

	public static void spiraldisplay2(int[][] arr) {
		int rmin = 0, cmin = 0, rmax = arr.length - 1, cmax = arr[0].length - 1;
		int tne = arr.length * arr[0].length;
		int counter = 1;

		while (counter <= tne) {
			// left wall
			for (int row = rmin; counter <= tne && row <= rmax; row++) {
				System.out.println(arr[row][cmin]);
				counter++;
			}
			cmin++;

			// bottom wall
			for (int col = cmin; counter <= tne && col <= cmax; col++) {
				System.out.println(arr[rmax][col]);
				counter++;
			}
			rmax--;

			// right wall
			for (int row = rmax; counter <= tne && row >= rmin; row--) {
				System.out.println(arr[row][cmax]);
				counter++;
			}
			cmax--;

			// top wall
			for (int col = cmax; counter <= tne && col >= cmin; col--) {
				System.out.println(arr[rmin][col]);
				counter++;
			}
			rmin++;
		}
	}

	public static void shellRotate(int[][] arr, int k, int r) {
		int rmin = k - 1, cmin = k - 1, rmax = arr.length - k, cmax = arr[0].length - k;
		int counter = 0;
		int[] oned = new int[2 * (rmax - rmin + cmax - cmin)];

		// left wall
		for (int row = rmin; row <= rmax; row++) {
			oned[counter] = arr[row][cmin];
			counter++;
		}
		cmin++;

		// bottom wall
		for (int col = cmin; col <= cmax; col++) {
			oned[counter] = arr[rmax][col];
			counter++;
		}
		rmax--;

		// right wall
		for (int row = rmax; row >= rmin; row--) {
			oned[counter] = arr[row][cmax];
			counter++;
		}
		cmax--;

		// top wall
		for (int col = cmax; col >= cmin; col--) {
			oned[counter] = arr[rmin][col];
			counter++;
		}
		rmin++;

		int[] rotoned = june12.ArrayOps.rotate(oned, r);
		rmin = k - 1;
		cmin = k - 1;
		rmax = arr.length - k;
		cmax = arr[0].length - k;
		counter = 0;

		// left wall
		for (int row = rmin; row <= rmax; row++) {
			arr[row][cmin] = rotoned[counter];
			counter++;
		}
		cmin++;

		// bottom wall
		for (int col = cmin; col <= cmax; col++) {
			arr[rmax][col] = rotoned[counter];
			counter++;
		}
		rmax--;

		// right wall
		for (int row = rmax; row >= rmin; row--) {
			arr[row][cmax] = rotoned[counter];
			counter++;
		}
		cmax--;

		// top wall
		for (int col = cmax; col >= cmin; col--) {
			arr[rmin][col] = rotoned[counter];
			counter++;
		}
		rmin++;
	}

}
