package july6;

import java.util.Arrays;

public class DPDemos {

	public static void main(String[] args) {
		int n = 3;

		// TnsDemos.startWatch();
		// System.out.println(FibRBtr(n, new int[n + 1]));
		// System.out.println(Fib(n));
		// System.out.println(FibIS(n));
		// TnsDemos.endWatch("FibIS", n);

		// TnsDemos.startWatch();
		// System.out.println(cbpIS(n));
		// TnsDemos.endWatch("cbpI", n);

		TnsDemos.startWatch();
		System.out.println(cmpDI(n, n));
		TnsDemos.endWatch("cmpDI", n);

		A7_Q12("1023", "");
	}

	public static int Fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		int fnm1 = Fib(n - 1);
		int fnm2 = Fib(n - 2);
		int fn = fnm1 + fnm2;

		return fn;
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

		int fnm1 = FibRBtr(n - 1, strg);
		int fnm2 = FibRBtr(n - 2, strg);
		int fn = fnm1 + fnm2;

		strg[n] = fn; // strg[qust] = ans
		return fn;
	}

	public static int FibI(int n) {
		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	public static int FibIS(int n) {
		int[] arr = new int[2];

		arr[0] = 0;
		arr[1] = 1;

		for (int i = 1; i <= n - 1; i++) {
			int nv = arr[0] + arr[1];
			arr[0] = arr[1];
			arr[1] = nv;
		}

		return arr[1];
	}

	public static int cbp(int curr, int end) {
		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			int cdice = cbp(curr + dice, end);
			count += cdice;
		}

		return count;
	}

	public static int cbpRB(int curr, int end, int[] strg) {
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
			int cdice = cbpRB(curr + dice, end, strg);
			count += cdice;
		}

		strg[curr] = count; // strg[qust] = ans
		return count;
	}

	public static int cbpI(int n) {
		int[] arr = new int[n + 6];
		arr[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			arr[i] = arr[i + 1] + arr[i + 2] + arr[i + 3] + arr[i + 4] + arr[i + 5] + arr[i + 6];
		}

		return arr[0];
	}

	public static int cbpIS(int n) {
		int[] arr = new int[6];
		arr[0] = 1; // 0: 10, 1: 11, 2: 12, 3: 13, 4: 14, 5: 15

		for (int i = 1; i <= n; i++) {
			int nv = arr[0] + arr[1] + arr[2] + arr[3] + arr[4] + arr[5];
			arr[5] = arr[4];
			arr[4] = arr[3];
			arr[3] = arr[2];
			arr[2] = arr[1];
			arr[1] = arr[0];
			arr[0] = nv;
		}

		return arr[0];
	}

	public static int cmp(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cc > ec || cr > er) {
			return 0;
		}

		int ch = cmp(cr, cc + 1, er, ec);
		int cv = cmp(cr + 1, cc, er, ec);
		int count = ch + cv;

		return count;
	}

	public static int cmpRB(int cr, int cc, int er, int ec, int[][] strg) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cc > ec || cr > er) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = cmpRB(cr, cc + 1, er, ec, strg);
		int cv = cmpRB(cr + 1, cc, er, ec, strg);
		int count = ch + cv;

		strg[cr][cc] = count;
		return count;
	}

	public static int cmpI(int er, int ec) {
		int[][] arr = new int[er + 1][ec + 1];

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (row == er || col == ec) {
					arr[row][col] = 1;
				} else {
					arr[row][col] = arr[row + 1][col] + arr[row][col + 1];
				}
			}
		}

		return arr[0][0];
	}

	public static int cmpIS(int er, int ec) {
		int[] arr = new int[ec + 1];

		Arrays.fill(arr, 1);

		for (int row = er - 1; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					arr[col] = 1;
				} else {
					int nv = arr[col] + arr[col + 1];
					arr[col] = nv;
				}
			}
		}

		return arr[0];
	}

	public static int cmpDI(int er, int ec) {
		int[] arr = new int[ec + 1];

		int diag = 0, nv = 0;
		Arrays.fill(arr, 1);

		for (int row = er - 1; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					diag = 1;
					arr[col] = 1;
				} else {
					nv = arr[col] + arr[col + 1] + diag;
					diag = arr[col];
					arr[col] = nv;
				}
			}
		}

		return arr[0];
	}

	public static void A7_Q12(String quest, String ans) {
		if (quest.length() == 0) {
			System.out.println(ans);
			return;
		}

		String ch0 = quest.substring(0, 1);
		String ros0 = quest.substring(1);

		if (Integer.parseInt(ch0) != 0) {
			A7_Q12(ros0, ans + (char) (Integer.parseInt(ch0) + 'a' - 1));
		} else {
			A7_Q12(ros0, ans);
			return;
		}

		if (quest.length() >= 2) {
			String ch01 = quest.substring(0, 2);
			String ros01 = quest.substring(2);

			if (Integer.parseInt(ch01) <= 26) {
				A7_Q12(ros01, ans + (char) (Integer.parseInt(ch01) + 'a' - 1));
			}
		}
	}

}
