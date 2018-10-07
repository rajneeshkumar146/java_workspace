package aug7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class dp {

	public static void main(String[] args) {
		int n = 30;

		long start = System.currentTimeMillis();
		// System.out.println(Fib(n));
		// System.out.println(FibM(n, new int[n + 1]));
		// System.out.println(FibT(n));
		// System.out.println(cbp(0, n));
		// System.out.println(cbpm(0, n, new int[n + 1]));
		// System.out.println(cbpt(0, n));
		// System.out.println(cmp(3, 3));
		// int[][] cost = {
		// {1, 8, 0, 5, 3},
		// {2, 8, 5, 2, 2},
		// {3, 0, 4, 8, 7},
		// {0, 5, 0, 0, 1},
		// {6, 0, 9, 6, 2}
		// };
		// System.out.println(mcp(cost));
		// int[][] cost = {
		// {2, 2, 5, 8, 2},
		// {5, 3, 0, 0, 4},
		// {3, 4, 6, 7, 7},
		// {4, 1, 0, 0, 0},
		// {0, 8, 8, 5, 5}
		// };
		// System.out.println(goldmine(cost));

		// System.out.println(countPalindromicSubstrings("abccbc"));
		// int[] arr = {4, 0, 5, 2, 0, 3, 1 , 0, 2, 1, 0};
		// System.out.println(minJumps(arr));
		// int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 40, 1 };
		// lbs(arr);
		// int[] coins = {2, 3, 5, 6};
		// coinchangeCombinations(coins, 10);
		// coinchangePermutations(coins, 10);
		// String s = "skdjfslkdfj";
		// System.out.println(mpc(s, 0, s.length() - 1, new
		// int[s.length()][s.length()]));
		// int[] dims = {10, 20, 30, 40, 50, 60};
		// System.out.println(mcm(dims, 0, dims.length - 1, new
		// int[dims.length][dims.length]));
		// System.out.println(countABCSeq("abcabc"));
		// int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		// System.out.println(targetSumSubset(arr, 120));
//		int[] prices = { 40, 30, 20, 30, 10, 50 };
//		int[] wts = { 2, 3, 3, 1, 4, 3 };
//		System.out.println(knapsack(wts, prices, 7));
		int[] costs = {0, 2, 3, 7, 7, 8, 13, 11};
		System.out.println(rodCutting(costs));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	private static int Fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = Fib(n - 1);
		int fnm2 = Fib(n - 2);
		int fn = fnm1 + fnm2;

		return fn;
	}

	private static int FibM(int n, int[] qb) {
		if (n == 0 || n == 1) {
			return n;
		}

		if (qb[n] != 0) {
			return qb[n];
		}

		int fnm1 = FibM(n - 1, qb);
		int fnm2 = FibM(n - 2, qb);
		int fn = fnm1 + fnm2;

		qb[n] = fn; // nth index pe fn, qth index pe ans
		return fn;
	}

	private static int FibT(int n) {
		int[] f = new int[n + 1];

		f[0] = 0;
		f[1] = 1;

		for (int x = 2; x <= n; x++) {
			f[x] = f[x - 1] + f[x - 2];
		}

		return f[n];
	}

	public static int cbp(int src, int dest) {
		if (src == dest) {
			return 1;
		}

		if (src > dest) {
			return 0;
		}

		int cpfstod = 0;

		for (int dice = 1; dice <= 6; dice++) {
			int inter = src + dice;
			int cpfitod = cbp(inter, dest);
			cpfstod += cpfitod;
		}

		return cpfstod;
	}

	public static int cbpm(int src, int dest, int[] qb) {
		if (src == dest) {
			return 1;
		}

		if (src > dest) {
			return 0;
		}

		if (qb[src] != 0) {
			return qb[src];
		}

		int cpfstod = 0;

		for (int dice = 1; dice <= 6; dice++) {
			int inter = src + dice;
			int cpfitod = cbpm(inter, dest, qb);
			cpfstod += cpfitod;
		}

		qb[src] = cpfstod;
		return cpfstod;
	}

	public static int cbpt(int src, int dest) {
		int[] f = new int[dest + 1];

		f[dest] = 1; // dest to dest, there is a single path
		for (int i = dest - 1; i >= src; i--) {
			for (int dice = 1; dice <= 6 && i + dice <= dest; dice++) {
				f[i] += f[i + dice];
			}
		}

		return f[src];
	}

	public static int cmp(int dr, int dc) {
		int[][] qb = new int[dr + 1][dc + 1];

		for (int r = dr; r >= 0; r--) {
			for (int c = dc; c >= 0; c--) {
				if (r == dr && c == dc) { // last cell
					qb[r][c] = 1;
				} else if (r == dr) { // last row
					qb[r][c] += qb[r][c + 1];
				} else if (c == dc) { // last col
					qb[r][c] += qb[r + 1][c];
				} else {
					qb[r][c] += qb[r + 1][c] + qb[r][c + 1];
				}
			}
		}

		return qb[0][0];
	}

	public static int mcp(int[][] cost) {
		int[][] strg = new int[cost.length][cost[0].length];

		for (int r = strg.length - 1; r >= 0; r--) {
			for (int c = strg[0].length - 1; c >= 0; c--) {
				if (r == strg.length - 1 && c == strg[0].length - 1) {
					strg[r][c] = cost[r][c];
				} else if (r == strg.length - 1) {
					strg[r][c] = strg[r][c + 1] + cost[r][c];
				} else if (c == strg[0].length - 1) {
					strg[r][c] = strg[r + 1][c] + cost[r][c];
				} else {
					strg[r][c] = Math.min(strg[r + 1][c], strg[r][c + 1]) + cost[r][c];
				}
			}
		}

		return strg[0][0];
	}

	public static int goldmine(int[][] mine) {
		int[][] strg = new int[mine.length][mine[0].length];

		for (int c = strg[0].length - 1; c >= 0; c--) {
			for (int r = 0; r < strg.length; r++) {
				if (c == strg[0].length - 1) {
					strg[r][c] = mine[r][c];
				} else if (r == 0) {
					strg[r][c] = mine[r][c] + Math.max(strg[r + 1][c + 1], strg[r][c + 1]);
				} else if (r == strg.length - 1) {
					strg[r][c] = mine[r][c] + Math.max(strg[r - 1][c + 1], strg[r][c + 1]);
				} else {
					strg[r][c] = mine[r][c]
							+ Math.max(strg[r - 1][c + 1], Math.max(strg[r + 1][c + 1], strg[r][c + 1]));
				}
			}
		}

		int max = 0;
		for (int r = 0; r < strg.length; r++) {
			if (strg[r][0] > max) {
				max = strg[r][0];
			}
		}

		// System.out.println(max);
		return max;
	}

	public static int countPalindromicSubstrings(String str) {
		boolean[][] strg = new boolean[str.length()][str.length()];

		int count = 0;
		for (int gap = 0; gap < str.length(); gap++) {
			for (int sp = 0; sp < str.length() - gap; sp++) {
				int ep = sp + gap;

				if (gap == 0) {
					strg[sp][ep] = true;
				} else if (gap == 1) {
					strg[sp][ep] = str.charAt(sp) == str.charAt(ep);
				} else {
					strg[sp][ep] = str.charAt(sp) == str.charAt(ep) && strg[sp + 1][ep - 1];
				}

				if (strg[sp][ep]) {
					count++;
				}
			}
		}

		System.out.println(count);
		return count;
	}

	public static Integer minJumps(int[] arr) {
		Integer[] strg = new Integer[arr.length];
		strg[arr.length - 1] = 0;

		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
				if (strg[j] == null) {
					continue;
				} else {
					if (strg[i] == null) {
						strg[i] = strg[j] + 1;
					} else {
						strg[i] = Math.min(strg[i], strg[j] + 1);
					}
				}
			}
		}

		return strg[0];
	}

	public static void lis(int[] arr) {
		Integer[] strg = new Integer[arr.length];
		strg[0] = 1;

		for (int i = 1; i < strg.length; i++) {
			strg[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) { // for increasing
					strg[i] = Math.max(strg[i], strg[j] + 1);
				}
			}
		}

		int max = Collections.max(Arrays.asList(strg));
		System.out.println(max);
	}

	public static void lbs(int[] arr) {
		Integer[] lis = new Integer[arr.length];
		lis[0] = 1;

		for (int i = 1; i < lis.length; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) { // for increasing
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
		}

		Integer[] lds = new Integer[arr.length];
		lds[arr.length - 1] = 1;

		for (int i = arr.length - 2; i >= 0; i--) {
			lds[i] = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) { // for increasing
					lds[i] = Math.max(lds[i], lds[j] + 1);
				}
			}
		}

		int max = lis[0] + lds[0] - 1;
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, lis[i] + lds[i] - 1);
		}

		System.out.println(max);
	}

	public static void coinchangePermutations(int[] coins, int amt) {
		int[] strg = new int[amt + 1];

		strg[0] = 1;
		for (int i = 1; i < strg.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0) {
					strg[i] += strg[i - coins[j]];
				}
			}
		}

		System.out.println(strg[amt]);
	}

	public static void coinchangeCombinations(int[] coins, int amt) {
		int[] strg = new int[amt + 1];

		strg[0] = 1;
		for (int j = 0; j < coins.length; j++) {
			for (int i = 1; i < strg.length; i++) {
				if (i - coins[j] >= 0) {
					strg[i] += strg[i - coins[j]];
				}
			}
		}

		System.out.println(strg[amt]);
	}

	static int counter = 1;

	public static int mpc(String str, int sp, int ep, int[][] qb) {
		if (isPalindrome(str, sp, ep)) {
			return 0;
		}
		if (qb[sp][ep] != 0) {
			return qb[sp][ep];
		}

		int tc = Integer.MAX_VALUE;
		for (int cp = sp; cp < ep; cp++) {
			int lc = mpc(str, sp, cp, qb);
			int rc = mpc(str, cp + 1, ep, qb);
			tc = Math.min(tc, lc + rc + 1);
		}

		qb[sp][ep] = tc;
		System.out.println(counter++ + ". hello");
		return tc;
	}

	private static boolean isPalindrome(String str, int sp, int ep) {
		int left = sp;
		int right = ep;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	public static int mcm(int[] dims, int si, int ei, int[][] qb) {
		if (ei - si == 1) {
			return 0;
		}
		if (qb[si][ei] != 0) {
			return qb[si][ei];
		}

		int tc = Integer.MAX_VALUE;
		for (int cp = si + 1; cp <= ei - 1; cp++) {
			int lc = mcm(dims, si, cp, qb);
			int rc = mcm(dims, cp, ei, qb);
			int realc = dims[si] * dims[cp] * dims[ei];
			tc = Math.min(tc, lc + rc + realc);
		}

		qb[si][ei] = tc;
		// System.out.println(counter++ + ". hello");
		return tc;
	}

	public static int binaryStrings(int n) {
		int[] strg0 = new int[n + 1];
		int[] strg1 = new int[n + 1];

		strg0[1] = 1; // 0
		strg1[1] = 1; // 1

		for (int i = 2; i <= n; i++) {
			strg0[i] = strg0[i - 1] + strg1[i - 1];
			strg1[i] = strg0[i - 1];
		}

		return strg0[n] + strg1[n];
	}

	public static int countABCSeq(String s) {
		int ac = 0;
		int bc = 0;
		int cc = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch == 'a') {
				ac = 1 + ac + ac;
			} else if (ch == 'b') {
				bc = ac + bc + bc;
			} else if (ch == 'c') {
				cc = bc + cc + cc;
			}
		}

		return cc;
	}

	public static boolean targetSumSubset(int[] arr, int tar) {
		boolean[][] strg = new boolean[arr.length + 1][tar + 1];
		ArrayList<String>[][] sets = new ArrayList[arr.length + 1][tar + 1];

		for (int i = 0; i < sets.length; i++) {
			for (int j = 0; j < sets[0].length; j++) {
				sets[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < strg.length; i++) {
			strg[i][0] = true;
			sets[i][0].add("");
		}

		for (int i = 1; i < strg.length; i++) {
			for (int j = 1; j < strg[0].length; j++) {
				if (strg[i - 1][j]) {
					strg[i][j] = true;
					sets[i][j].addAll(sets[i - 1][j]);
				}

				if (j >= arr[i - 1] && strg[i - 1][j - arr[i - 1]]) {
					strg[i][j] = true;

					for (String val : sets[i - 1][j - arr[i - 1]]) {
						sets[i][j].add(val + arr[i - 1]);
					}
				}
			}
		}

		System.out.println(sets[arr.length][tar]);
		return strg[arr.length][tar];
	}

	public static int knapsack(int[] wts, int[] prices, int cap) {
		int[][] strg = new int[wts.length + 1][cap + 1];

		for (int i = 1; i < strg.length; i++) {
			for (int j = 1; j < strg[0].length; j++) {
				strg[i][j] = strg[i - 1][j];
				if (j >= wts[i - 1]) {
					if (strg[i - 1][j - wts[i - 1]] + prices[i - 1] > strg[i][j]) {
						strg[i][j] = strg[i - 1][j - wts[i - 1]] + prices[i - 1];
					}
				}
			}
		}

		return strg[wts.length][cap];
	}

	public static int rodCutting(int[] costs){
		int[] strg = new int[costs.length];
		
		strg[0] = 0;
		strg[1] = costs[1];
		for(int i = 2; i < costs.length; i++){
			strg[i] = costs[i]; // lump sum
			
			// cut maximized
			int left = 1;
			int right = i - 1;
			while(left <= right){
				strg[i] = Math.max(strg[i], strg[left] + strg[right]);
				left++;
				right--;
			}
		}
		
		return strg[strg.length - 1];
	}
}
