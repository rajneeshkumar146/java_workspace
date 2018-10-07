package Class_13_and_14th_DP_making_better_comlexicity;

import java.util.ArrayList;
import java.util.Arrays;

public class Count_board_path_better {

	public static void main(String[] args) {

		// System.out.println(cbp(0, 30, new int[31]));

		// long start=System.currentTimeMillis();
		//
		// System.out.println(cmp(0, 0,16,16, new int[17][17]));
		//
		// long end=System.currentTimeMillis();
		//
		// System.out.println(end-start);

		// System.out.println(cbpI(10));
		// System.out.println(cbpIbtr(10));

		// System.out.println(mazze_path(3, 3));
		//
		// System.out.println(mazze_path_best(3, 3));
		//
		// System.out.println(mazze_path_diag_best(3, 3));
		//
		// System.out.println(longest_common_SS_Irr("abefg", "aefdg"));
		System.out.println(edit_distance("abcefh", "ackfzh"));
		System.out.println(editDistanceDP("abcefh", "ackfzh"));

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

		int count_h = cmp(cr, cc + 1, er, ec, strg);
		int count_v = cmp(cr + 1, cc, er, ec, strg);
		int count = count_h + count_v;

		strg[cr][cc] = count;

		return count;

	}

	public static int cbpI(int n) { // count_board_path

		int[] strg = new int[16];

		strg[10] = 1;
		for (int i = n - 1; i >= 0; i--) {

			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}

		return strg[0];

	}

	public static int cbpI2(int n) { // count_board_path

		int[] strg = new int[n + 1];

		strg[n] = 1;
		for (int i = n - 1; i >= 0; i--) {

			for (int dice = 1; dice <= 6; dice++) {
				if (i + dice <= 10) {
					strg[i] += strg[i + dice];
				}

			}
		}

		return strg[0];

	}

	public static int cbpIbtr(int n) {

		int[] strg = new int[6];
		strg[0] = 1;
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

	public static int mazze_path(int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];
		strg[er + 1][ec] = 1;

		for (int row = er; row > 0; row--) {
			for (int col = ec; col > 0; col--) {

				strg[row][col] = strg[row + 1][col] + strg[row][col + 1];

			}
		}

		return strg[1][1];

	}

	public static int mazze_path_best(int er, int ec) {

		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);
		for (int row = er - 1; row >= 0; row--) {
			for (int col = ec - 1; col >= 0; col--) {
				strg[col] = strg[col] + strg[col + 1];

			}
		}
		return strg[0];

	}

	public static int mazze_path_diag(int er, int ec) {

		int[][] strg = new int[er + 1][ec + 1];
		strg[er][ec] = 1;

		for (int row = er - 1; row >= 0; row--) {
			for (int col = ec - 1; col >= 0; col--) {

				strg[row][col] = strg[row + 1][col] + strg[row][col + 1] + strg[row + 1][col + 1];

			}
		}

		return strg[0][0];

	}

	public static int mazze_path_diag_best(int er, int ec) {

		int[] strg = new int[ec + 1];
		Arrays.fill(strg, 1);
		for (int row = er - 1; row >= 0; row--) {
			int diag = 1;
			for (int col = ec - 1; col >= 0; col--) {
				int nv = strg[col] + strg[col + 1] + diag;
				diag = strg[col];
				strg[col] = nv;

			}
		}

		return strg[0];

	}

	public static int longest_common_SS_rec_worst(String str1, String str2) {
		if (str1.length() == 0 || str2.length() == 0) {
			return 0;
		}
		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(0);

		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);

		if (ch1 == ch2) {
			return 1 + longest_common_SS_rec_worst(ros1, ros2);
		} else {
			int f1 = longest_common_SS_rec_worst(ros1, str2);
			int f2 = longest_common_SS_rec_worst(str1, ros2);
			return Math.max(f1, f2);
		}

	}

	public static int longest_common_SS_rec_best(char[] s1, int i, char[] s2, int j, int[][] strg) {
		if (i == s1.length || j == s2.length) {
			return 0;
		}
		char ch1 = s1[i];
		char ch2 = s2[j];

		if (strg[i][j] != 0) {
			return strg[i][j];
		}

		else if (ch1 == ch2) {
			return 1 + longest_common_SS_rec_best(s1, i + 1, s2, j + 1, strg);
		} else {
			int f1 = longest_common_SS_rec_best(s1, i + 1, s2, j, strg);
			int f2 = longest_common_SS_rec_best(s1, i, s2, j + 1, strg);
			strg[i][j] = Math.max(f1, f2);
			return Math.max(f1, f2);
		}

	}

	public static int longest_common_SS_Irr_btr(String s1, String s2) {
		int strg[][] = new int[s1.length() + 1][s2.length() + 1];

		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] = 1 + strg[i + 1][j + 1];
				} else {
					strg[i][j] = Math.max(strg[i + 1][j], strg[i][j + 1]);
				}

			}

		}
		return strg[0][0];
	}

	public static int longest_common_SS_Irr_best(String s1, String s2) {
		int strg[] = new int[s2.length() + 1]; // s2_define_column

		for (int i = s1.length() - 1; i >= 0; i--) {
			int diag = 0;
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					strg[j] = 1 + diag;
				} else {
					diag = strg[j];
					strg[j] = Math.max(strg[j], strg[j + 1]);

				}

			}

		}
		return strg[0];
	}

	public static String longest_common_SS_Irr_string(String s1, String s2) {

		String strg[][] = new String[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s1.length(); i++) {
			strg[i][s2.length()] = "";
		}

		for (int i = 0; i <= s2.length(); i++) {
			strg[s1.length()][i] = "";
		}

		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] = s1.charAt(i) + strg[i + 1][j + 1];
				} else {

					if (strg[i][j + 1].length() > strg[i + 1][j].length()) {
						strg[i][j] = strg[i][j + 1];
					} else {
						strg[i][j] = strg[i + 1][j];
					}

				}
			}
		}

		return strg[0][0];

	}

	public static int edit_distance(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			if (s1.length() != 0) {
				return s1.length();
			} else if (s2.length() != 0) {
				return s2.length();
			}
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String roq1 = s1.substring(1);
		String roq2 = s2.substring(1);

		if (ch1 == ch2) {
			return edit_distance(roq1, roq2);
		} else {
			int f1 = edit_distance(roq1, s2);
			int f2 = edit_distance(s1, roq2);
			int f3 = edit_distance(roq1, roq2);

			return Math.min(f1, Math.min(f2, f3)) + 1;

		}

	}

	public static int editDistanceDP(String s1, String s2) { // s1__at_row_and_s2_at_col_if_equal.
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int i = s1.length()-1; i >= 0; i--) {
			strg[s2.length()][i] = 1 + strg[s2.length()][i + 1];
		}

		for (int i = s2.length()-1; i >= 0; i--) {
			strg[i][s1.length()] = 1 + strg[i + 1][s1.length()];
		}

		for (int row = s1.length() - 1; row >= 0; row--) {
			for (int col = s2.length() - 1; col >= 0; col--) {
				int min = Math.min(strg[row + 1][col], Math.min(strg[row][col + 1], strg[row + 1][col + 1]));

				if (s2.charAt(row) == s1.charAt(col)) {
					strg[row][col] = min;
				} else {
					strg[row][col] = min + 1;
				}
			}
		}

		return strg[0][0];
	}
}
