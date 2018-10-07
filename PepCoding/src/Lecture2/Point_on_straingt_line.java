package Lecture2;

import java.util.Scanner;

public class Point_on_straingt_line {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int T = scn.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = scn.nextInt();
			int x[] = input(N);
			int y[] = input(N);
			System.out.println(posl(x, y));
		}

	}

	public static int[] input(int N) {
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	public static int posl(int[] x_cor, int[] y_cor) {
		if (x_cor.length < 1) {
			return 0;
		}

		if (x_cor.length == 2) {
			return 2;
		}
		double y = y_cor[1] - y_cor[0];
		double x = x_cor[1] - x_cor[0];
		double slop = 0;
		if (x != 0) {
			double sl = (y) / (x); // Slope
			slop = Math.abs(sl);
		} else {
			slop = Integer.MAX_VALUE;
		}

		int cnp = 1; // Count_Number_of _points,
		for (int i = 0; i < x_cor.length - 1; i++) {
			double ty = y_cor[i + 1] - y_cor[0];
			double tx = x_cor[i + 1] - x_cor[0];
			double tslop = 0;
			if (tx != 0) {
				double tsl = (ty) / (tx); // Temp_Slope
				tslop = Math.abs(tsl);

			} else {
				tslop = Integer.MAX_VALUE;
			}
			if (slop == tslop) {
				cnp++;
			}

		}

		return cnp;

	}

	
}
