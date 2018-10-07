package july5;

import java.util.Arrays;

public class DP {
	public static long start = 0;
	public static long end = 0;

	public static void startWatch() {
		start = System.currentTimeMillis();
	}

	public static void endWatch(String algo, int n) {
		end = System.currentTimeMillis();
		System.out.println(algo + " took " + (end - start) + " ms for n = " + n);
	}

	public static void main(String[] args) {
		int n = 16;

		// startWatch();
		// System.out.println(Fib(n));
		// endWatch("Fib", n);

		// startWatch();
		// System.out.println(FibRBtr(n, new int[n + 1]));
		// System.out.println(FibISW(n));
		// endWatch("FibISW", n);

		// startWatch();
		// System.out.println(cbpISW(n));
		// endWatch("cbpI", n);

//		startWatch();
		// System.out.println(cmp(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(cmpISW(n, n));
//		System.out.println(cmpDISW(3, 3));
//		endWatch("cmpDISW", n);
		
		System.out.println(editDistance("abcefh", "ackfzh"));
	}

	public static int Fib(int n) {
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		int fibnm1 = Fib(n - 1);
		int fibnm2 = Fib(n - 2);
		int fibn = fibnm1 + fibnm2;

		return fibn;
	}

	public static int FibRBtr(int n, int[] strg) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		int fibnm1 = FibRBtr(n - 1, strg);
		int fibnm2 = FibRBtr(n - 2, strg);
		int fibn = fibnm1 + fibnm2;

		strg[n] = fibn; // strg[quest] = ans
		return fibn;
	}

	public static int FibIBtr(int n) {
		int[] strg = new int[n + 1];

		// init
		strg[0] = 0; // f(0)
		strg[1] = 1; // f(1)

		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[strg.length - 1];
	}

	public static int FibISW(int n) {
		int[] strg = new int[2];

		// init
		strg[0] = 0; // f(0)
		strg[1] = 1; // f(1)

		for (int i = 1; i < n; i++) {
			int newfib = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = newfib;
		}

		return strg[1];
	}

	public static int cbp(int curr, int end, int[] strg) {
		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += cbp(curr + dice, end, strg);
		}

		strg[curr] = count;
		return count;
	}

	public static int cbpI(int n) {
		int[] strg = new int[n + 6];

		// init
		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}

		return strg[0];
	}

	public static int cbpISW(int n) {
		int[] strg = new int[6];

		// init
		strg[0] = 1; // 0 is to 10, 1 is to 11, 2 is to 12 and so on

		for (int i = n - 1; i >= 0; i--) {
			int nv = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];
			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];
			strg[0] = nv;
		}

		return strg[0];
	}

	public static int cmp(int cr, int cc, int er, int ec, int[][] strg) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = cmp(cr, cc + 1, er, ec, strg);
		int cv = cmp(cr + 1, cc, er, ec, strg);
		int count = ch + cv;

		strg[cr][cc] = count;
		return count;
	}

	public static int cmpI(int er, int ec) {
		int[][] arr = new int[er + 1][ec + 1];
		arr[er][ec] = 1;

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (row == er && col == ec) {
					continue;
				} else if (row == er) {
					arr[row][col] = arr[row][col + 1];
				} else if (col == ec) {
					arr[row][col] = arr[row + 1][col];
				} else {
					arr[row][col] = arr[row + 1][col] + arr[row][col + 1];
				}
			}
		}

		return arr[0][0];
	}

	public static int cmpISW(int er, int ec) {
		int[] wnd = new int[ec + 1];
		Arrays.fill(wnd, 1);

		for (int row = er - 1; row >= 0; row--) {
			for (int col = ec - 1; col >= 0; col--) {
				int nv = wnd[col] + wnd[col + 1];
				wnd[col] = nv;
			}
		}

		return wnd[0];
	}

	public static int cmpD(int er, int ec) {
		int[][] arr = new int[er + 1][ec + 1];
		arr[er][ec] = 1;

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (row == er && col == ec) {
					continue;
				} else if (row == er) {
					arr[row][col] = arr[row][col + 1];
				} else if (col == ec) {
					arr[row][col] = arr[row + 1][col];
				} else {
					arr[row][col] = arr[row + 1][col] + arr[row][col + 1] + arr[row + 1][col + 1];
				}
			}
		}

		return arr[0][0];
	}

	public static int cmpDISW(int er, int ec) {
		int[] wnd = new int[ec + 1];
		Arrays.fill(wnd, 1);

		int diag = 0, nv = 0;
		for (int row = er - 1; row >= 0; row--) {
			diag = 1;
			for (int col = ec - 1; col >= 0; col--) {
				nv = wnd[col] + wnd[col + 1] + diag;
				diag = wnd[col];
				wnd[col] = nv;
			}
		}

		return wnd[0];
	}

	public static int lcs(String s1, String s2) {
		if(s1.length() == 0 || s2.length() == 0){
			return 0;
		}
		
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if (ch1 == ch2) {
			return 1 + lcs(ros1, ros2);
		} else {
			int f1 = lcs(s1, ros2);
			int f2 = lcs(ros1, s2);
			
			return Math.max(f1, f2);
		}
	}

	public static int editDistance(String s1, String s2){
		if(s1.length() == 0){
			return s2.length(); // removals
		}
		
		if(s2.length() == 0){
			return s1.length(); // insert
		}
		
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		
		if(ch1 == ch2){
			return editDistance(ros1, ros2);
		} else{
//			int finsert = editDistance(s1, ch1 + s2); // ros1, s2
//			int freplace = editDistance(s1, ch1 + ros2); // ros1, ros2
			int finsert = 1 + editDistance(ros1, s2); // ros1, s2
			int freplace = 1 + editDistance(ros1, ros2); // ros1, ros2
			int fremove = 1 + editDistance(s1, ros2);
			
			int rv = Math.min(finsert, Math.min(freplace, fremove));
			return rv;
		}
		
	}
}
