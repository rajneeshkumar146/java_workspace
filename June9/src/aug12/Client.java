package aug12;

import java.util.Vector;

public class Client {

	public static void main(String[] args) {
//		int eggs = 3;
//		int floors = 64;
//		int[][] qb = new int[eggs + 1][floors + 1];
//		System.out.println(eggDrop(eggs, floors, qb));
		System.out.println(mpcTabulated("abccbc"));
	}

	public static int eggDrop(int eggs, int floors, int[][] qb) {
		if (eggs == 1 || floors == 1 || floors == 0) {
			return floors;
		}

		if (qb[eggs][floors] != 0) {
			return qb[eggs][floors];
		}

		int mt = Integer.MAX_VALUE;

		for (int f = 1; f <= floors; f++) {
			int mtIfEggBreaks = eggDrop(eggs - 1, f - 1, qb);
			int mtIfEggSurvives = eggDrop(eggs, floors - f, qb);

			mt = Math.min(mt, Math.max(mtIfEggBreaks, mtIfEggSurvives));
		}

		qb[eggs][floors] = mt + 1;
		return mt + 1;
	}

	public static int maxSizeAll1Square(int[][] arr) {
		int[][] strg = new int[arr.length][arr[0].length];

		for (int i = 0; i < strg[0].length; i++) {
			strg[strg.length - 1][i] = arr[strg.length - 1][i];
		}

		for (int i = 0; i < strg.length; i++) {
			strg[i][strg[0].length - 1] = arr[i][arr[0].length - 1];
		}

		int max = 0;
		for (int i = strg.length - 2; i >= 0; i--) {
			for (int j = strg[0].length - 2; j >= 0; j--) {
				if (arr[i][j] == 1) {
					strg[i][j] = 1 + Math.min(strg[i + 1][j + 1], Math.min(strg[i][j + 1], strg[i + 1][j]));
					max = Math.max(max, strg[i][j]);
				}
			}
		}

		return max;
	}

	public static int unboundedKnapsack(int[] wts, int[] prices, int cap) {
		int[] strg = new int[cap + 1];

		for (int i = 1; i < strg.length; i++) {
			for (int j = 0; j < wts.length; j++) {
				if (i >= wts[j]) {
					strg[i] = Math.max(strg[i], strg[i - wts[j]] + prices[j]);
				}
			}
		}

		return strg[cap];
	}

	public static int mpcTabulated(String str) {
		int[][] strg = new int[str.length()][str.length()];

		for (int gap = 1; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; i < str.length() - gap; i++, j++) {
				if (str.charAt(i) == str.charAt(j) && strg[i + 1][j - 1] == 0) {
					strg[i][j] = 0;
				} else {
					strg[i][j] = Integer.MAX_VALUE;
					for (int k1 = 1, k2 = gap; k1 <= gap && k2 >= 1; k1++, k2--) {
						int left = strg[i][j - k2];
						int right = strg[i + k1][j];
						strg[i][j] = Math.min(strg[i][j], left + right + 1);
					}
				}
			}
		}

		return strg[0][str.length() - 1];
	}
}
