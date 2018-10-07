package june23;

import java.util.ArrayList;

public class RecursionDemos {

	public static void main(String[] args) {
		// Integer[] one = {1, 1, 2, 2, 2, 3, 5};
		// Integer[] two = {1, 1, 1, 2, 2, 4, 5};
		//
		// ArrayList<Integer> inter = getIntersection(one, two);
		// System.out.println(inter);
		//
		// inter.add(10);
		// inter.add(20);
		// inter.add(30);
		// inter.add(40);
		// inter.add(50);
		// inter.add(60); // 10 to 15

		// inter.add(20);
		// inter.add(30);
		// inter.add(40);
		// inter.add(50);
		// inter.add(60); // 15 to 22
		//
		// int[] normal = {10, 20, 30, 40, 50};

		// System.out.println(getSubsequencesWAscii("ab"));
		// System.out.println(getBoardPaths(0, 10));
		// System.out.println(getMazePaths(0, 0, 2, 2));
		// System.out.println(getBoardPathsVariation(0, 10));
		// System.out.println(getMazePathsQueenMove(0, 0, 2, 2));
		// System.out.println(getKPC("108"));

		// printSS("ab", "");
		// printKPC("268", "");
		// printPermutations("aaabbb", "");
		// int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		// printSplitArray(arr, 0, 0, 0, "", "");
		int n = 4;
		boolean[][] board = new boolean[n][n];
		printNQueens(board, 0, "");
	}

	public static ArrayList<Integer> getIntersection(Integer[] one, Integer[] two) {
		ArrayList<Integer> list = new ArrayList<>();

		int i = 0, j = 0;
		while (i < one.length && j < two.length) {
			if (one[i] > two[j]) {
				j++;
			} else if (one[i] < two[j]) {
				i++;
			} else {
				list.add(one[i]);
				i++;
				j++;
			}
		}

		return list;
	}

	public static ArrayList<String> getSubsequences(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSubsequences(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rs : rr) {
			mr.add(rs); // ch says no
			mr.add(ch + rs); // ch says yes
		}

		return mr;
	}

	public static ArrayList<String> getSubsequencesWAscii(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSubsequencesWAscii(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rs : rr) {
			mr.add(rs); // ch says no
			mr.add(ch + rs); // ch says yes
			mr.add((int) ch + rs); // ch says yes
		}

		return mr;
	}

	// 0 to 10 - 492
	public static ArrayList<String> getBoardPaths(int curr, int end) {
		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> rr = getBoardPaths(curr + dice, end);
			for (String rs : rr) {
				mr.add(dice + rs);
			}
		}

		return mr;
	}

	public static ArrayList<String> getBoardPathsVariation(int curr, int end) {
		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			if (curr == 0) {
				if (dice == 1 || dice == 6) {
					ArrayList<String> rr = getBoardPathsVariation(curr + dice, end);
					for (String rs : rr) {
						mr.add(dice + rs);
					}
				}
			} else {
				ArrayList<String> rr = getBoardPathsVariation(curr + dice, end);
				for (String rs : rr) {
					mr.add(dice + rs);
				}
			}
		}

		return mr;
	}

	public static ArrayList<String> getMazePaths(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = getMazePaths(cr, cc + 1, er, ec);
		for (String rs : rrh) {
			mr.add("H" + rs);
		}

		ArrayList<String> rrv = getMazePaths(cr + 1, cc, er, ec);
		for (String rs : rrv) {
			mr.add("V" + rs);
		}

		ArrayList<String> rrd = getMazePaths(cr + 1, cc + 1, er, ec);
		for (String rs : rrd) {
			mr.add("D" + rs);
		}

		return mr;
	}

	public static ArrayList<String> getMazePathsQueenMove(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int move = 1; cc + move <= ec; move++) {
			ArrayList<String> rrh = getMazePathsQueenMove(cr, cc + move, er, ec);
			for (String rs : rrh) {
				mr.add("H" + move + rs);
			}
		}

		for (int move = 1; cr + move <= er; move++) {
			ArrayList<String> rrv = getMazePathsQueenMove(cr + move, cc, er, ec);
			for (String rs : rrv) {
				mr.add("V" + move + rs);
			}
		}

		for (int move = 1; cr + move <= er && cc + move <= ec; move++) {
			ArrayList<String> rrd = getMazePathsQueenMove(cr + move, cc + move, er, ec);
			for (String rs : rrd) {
				mr.add("D" + move + rs);
			}
		}
		return mr;
	}

	public static ArrayList<String> getPermutations(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getPermutations(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rs : rr) {
			for (int i = 0; i <= rs.length(); i++) {
				String ms = rs.substring(0, i) + ch + rs.substring(i);
				mr.add(ms);
			}
		}

		return mr;
	}

	public static ArrayList<String> getKPC(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getKPC(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rs : rr) {
			String code = getCode(ch);
			for (int i = 0; i < code.length(); i++) {
				String ms = code.charAt(i) + rs;
				mr.add(ms);
			}
		}

		return mr;
	}

	public static String getCode(char ch) {
		if (ch == '1') {
			return "abc";
		} else if (ch == '2') {
			return "def";
		} else if (ch == '3') {
			return "ghi";
		} else if (ch == '4') {
			return "jkl";
		} else if (ch == '5') {
			return "mno";
		} else if (ch == '6') {
			return "pqrs";
		} else if (ch == '7') {
			return "tuv";
		} else if (ch == '8') {
			return "wx";
		} else if (ch == '9') {
			return "yz";
		} else {
			return ".;";
		}
	}

	public static void printSS(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans + ""); // ch said no
		printSS(roq, ans + ch); // ch said yes
	}

	public static void printSSWAscii(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSSWAscii(roq, ans + ""); // ch said no
		printSSWAscii(roq, ans + ch); // ch said yes
		printSSWAscii(roq, ans + (int) ch); // ch said ascii
	}

	public static void printKPC(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		String code = getCode(ch);
		for (int i = 0; i < code.length(); i++) {
			printKPC(roq, ans + code.charAt(i));
		}
	}

	public static void printPermutations(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		boolean[] dupli = new boolean[256];

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			if (dupli[ch] == false) {
				printPermutations(roq, ans + ch);
				dupli[ch] = true;
			}
		}
	}

	public static void printTargetSS(int[] arr, int vidx, int target, String asf) {
		if (vidx == arr.length) {
			if (target > 0) {
				System.out.println(asf);
			}
			return;
		}

		printTargetSS(arr, vidx + 1, target, asf); // no
		printTargetSS(arr, vidx + 1, target - arr[vidx], asf + "\t" + arr[vidx]); // yes
	}

	public static void printSplitArray(int[] arr, int vidx, int sg1, int sg2, String g1, String g2) {
		if (vidx == arr.length) {
			if (sg1 == sg2) {
				System.out.println(g1 + " and " + g2);
			}
			return;
		}

		printSplitArray(arr, vidx + 1, sg1, sg2, g1, g2);
		printSplitArray(arr, vidx + 1, sg1 + arr[vidx], sg2, g1 + " " + arr[vidx], g2);
		printSplitArray(arr, vidx + 1, sg1, sg2 + arr[vidx], g1, g2 + " " + arr[vidx]);
	}

	public static void printNQueens(boolean[][] board, int qpsf, String ans) {
		if (qpsf == board.length) {
			System.out.println(ans);
			return;
		}

		int row = qpsf;
		for (int col = 0; col < board[0].length; col++) {
			if (isItSafe(board, row, col) == true) {
				board[row][col] = true;
				printNQueens(board, qpsf + 1, ans + "[" + row + "-" + col + "]");
				board[row][col] = false;
			}
		}
	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {
		int r = row, c = col;
		
		// check vertical
		while(r >= 0){
			if(board[r][col] == true){
				return false;
			}
			r--;
		}
		
		// check +ve diag
		r = row;
		c = col;
		while(r >= 0 && c < board.length){
			if(board[r][c] == true){
				return false;
			}
			r--;
			c++;
		}
		
		// check -ve diag
		r = row;
		c = col;
		while(r >= 0 && c >= 0){
			if(board[r][c] == true){
				return false;
			}
			r--;
			c--;
		}
		
		return true;
	}

}
