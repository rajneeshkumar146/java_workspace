package L021_FenwickTree;

import java.util.Scanner;

public class FenwickTree_001 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] arr = { 1, 2, 5, 8, -9, 7, 78, 56, -535, 67, 45, 65, 0, 7, 0, 1, 2, 4 };
		fenwickTree fv = new fenwickTree(arr);
		System.out.println(fv.GetSum(0, 2));
		fv.update(0, 10);
		System.out.println(fv.GetSum(0, 2));
	}

	public static class fenwickTree {
		private int[] Farr;

		public fenwickTree(int[] Oarr) {
			Farr = new int[Oarr.length + 1];
			for (int i = 0; i < Oarr.length; i++) {
				update(i, Oarr[i]);
			}
		}

		public int GetSum(int i, int j) {
			return GetSum(j) - GetSum(i - 1);

		}

		private int GetSum(int idx) {
			idx++;

			int sum = 0;
			while (idx != 0) {
				sum += Farr[idx];
				idx -= RightSetMostBit(idx);
			}

			return sum;
		}

		public void update(int idx, int delta) {
			idx++;
			while (idx < Farr.length) {
				Farr[idx] += delta;
				idx += RightSetMostBit(idx);
			}
		}

		private int RightSetMostBit(int pos) {
			return (pos & -pos);
		}

	}

}
