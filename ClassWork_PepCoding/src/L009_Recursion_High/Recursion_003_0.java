package L009_Recursion_High;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Recursion_003_0 {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {

		// 1.1 printBoardPath, BP16, BP16Ladders, BP16SnakesAndLadders
		// 1.2 printMazePath, printMPWithDiagonal, printMPWithMultiMoves,
		// floodfill

		solve();
		pnter.close();
	}

	public static void solve() throws Exception {

		// ArrayList<String> Boardpath =BoardPathAL(0, 10);
		// pnter.printLine(Boardpath+"");

		// BoardPath(0, 10, "");

		// Subsequence("abc", "");

		// keyPad("245", "");

		// ArrayList<String> MazePath_HV = MazePathAL_HV(0, 0, 2, 2);

		// pnter.printLine(MazePath_HV + "");

		// ArrayList<String> MazePath_HVD = MazePathAL_HVD(0, 0, 2, 2);
		// pnter.printLine(MazePath_HVD + "");

		// ArrayList<String> MazePathAL_MutiHVD = MazePathAL_MutiHVD(0, 0, 2,
		// 2);
		// pnter.printLine(MazePathAL_MutiHVD + "");

		// mazePath_HV(0, 0, 2, 2, "");

		// mazePath_HVD(0, 0, 3, 5, "");

		// mazePath_MultiHVD(0, 0, 2, 2, "");

		// int[][] maze = new int[5][6];
		// maze[0][1] = 1;
		// maze[0][5] = 1;
		// maze[1][3] = 1;
		// maze[1][5] = 1;
		// maze[3][4] = 1;
		// maze[4][3] = 1;
		// maze[3][2] = 1;
		// maze[3][3] = 1;
		// boolean[][] isdone = new boolean[maze.length][maze[0].length];
		// floodFill(0, 0, maze, "", isdone);

	}

	private static ArrayList<String> BoardPathAL(int src, int desti) {
		if (src == desti) {
			ArrayList<String> baseAl = new ArrayList<>();
			baseAl.add("\n");
			return baseAl;
		}

		ArrayList<String> myres = new ArrayList<>();

		for (int dice = 1; dice <= 6 && src + dice <= desti; dice++) {
			ArrayList<String> recRes = BoardPathAL(src + dice, desti);
			for (String res : recRes) {
				myres.add(res + dice);
			}
		}
		return myres;
	}

	private static void BoardPath(int src, int desti, String ans) throws IOException {
		if (src == desti) {
			pnter.printLine(ans);
			return;
		}

		for (int dice = 1; dice <= 6 && src + dice <= desti; dice++) {
			BoardPath(src + dice, desti, ans + dice);
		}
	}

	private static void Subsequence(String str, String ans) throws IOException {
		if (str.length() == 0) {
			pnter.print(ans + " ");
			return;
		}

		Subsequence(str.substring(1), ans + str.charAt(0));
		Subsequence(str.substring(1), ans);
	}

	private static String getcode(char ch) {
		if (ch == '1') {
			return "abc";
		} else if (ch == '2') {
			return "def";
		} else if (ch == '3') {
			return "ghi";
		} else if (ch == '4') {
			return "gil";
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
			return "./_";
		}
	}

	private static void keyPad(String str, String ans) throws IOException {
		if (str.length() == 0) {
			pnter.printLine(ans);
			return;
		}

		char ch = str.charAt(0);
		String roq = str.substring(1);
		String code = getcode(ch);
		for (int i = 0; i < code.length(); i++) {
			keyPad(roq, ans + code.charAt(i));
		}
	}

	private static ArrayList<String> MazePathAL_HV(int cr, int cc, int er, int ec) { // countRow,countcolumn,endrow,endcol.
		if (cr == er && cc == ec) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}

		ArrayList<String> myres = new ArrayList<>();

		if (cr + 1 <= er && cc <= ec) {
			ArrayList<String> recRes = MazePathAL_HV(cr + 1, cc, er, ec);
			for (String res : recRes) {
				myres.add("H" + res);
			}
		}

		if (cc + 1 <= ec && cr <= er) {
			ArrayList<String> recRes = MazePathAL_HV(cr, cc + 1, er, ec);
			for (String res : recRes) {
				myres.add("V" + res);
			}
		}

		return myres;

	}

	private static ArrayList<String> MazePathAL_HVD(int cr, int cc, int er, int ec) { // countRow,countcolumn,endrow,endcol.
		if (cr == er && cc == ec) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}

		ArrayList<String> myres = new ArrayList<>();

		if (cr + 1 <= er && cc <= ec) {
			ArrayList<String> recRes = MazePathAL_HVD(cr + 1, cc, er, ec);
			for (String res : recRes) {
				myres.add("H" + res);
			}
		}

		if (cc + 1 <= ec && cr <= er) {
			ArrayList<String> recRes = MazePathAL_HVD(cr, cc + 1, er, ec);
			for (String res : recRes) {
				myres.add("V" + res);
			}
		}

		if (cr + 1 <= er && cc + 1 <= ec) {
			ArrayList<String> recRes = MazePathAL_HVD(cr + 1, cc + 1, er, ec);
			for (String res : recRes) {
				myres.add("D" + res);
			}
		}

		return myres;

	}

	private static ArrayList<String> MazePathAL_MutiHVD(int cr, int cc, int er, int ec) { // countRow,countcolumn,endrow,endcol.
		if (cr == er && cc == ec) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}

		ArrayList<String> myres = new ArrayList<>();

		for (int i = 1; cr + i <= er && cc <= ec; i++) {
			ArrayList<String> recRes = MazePathAL_MutiHVD(cr + i, cc, er, ec);
			for (String res : recRes) {
				myres.add("H" + i + res);
			}
		}

		for (int i = 1; cc + i <= ec && cr <= er; i++) {
			ArrayList<String> recRes = MazePathAL_MutiHVD(cr, cc + i, er, ec);
			for (String res : recRes) {
				myres.add("V" + i + res);
			}
		}

		for (int i = 1; cr + i <= er && cc + i <= ec; i++) {
			ArrayList<String> recRes = MazePathAL_MutiHVD(cr + i, cc + i, er, ec);
			for (String res : recRes) {
				myres.add("D" + i + res);
			}
		}

		return myres;

	}

	private static void mazePath_HV(int cr, int cc, int er, int ec, String ans) throws IOException {
		if (cr == er && cc == ec) {
			pnter.printLine(ans + " ");
			return;
		}

		if (cr + 1 <= er && cc <= ec) {
			mazePath_HV(cr + 1, cc, er, ec, ans + "H");
		}

		if (cc + 1 <= ec && cr <= er) {
			mazePath_HV(cr, cc + 1, er, ec, ans + "V");
		}

	}

	private static void mazePath_HVD(int cr, int cc, int er, int ec, String ans) throws IOException {
		if (cr == er && cc == ec) {
			pnter.printLine(ans + " ");
			return;
		}

		if (cr + 1 <= er && cc <= ec) {
			mazePath_HVD(cr + 1, cc, er, ec, ans + "H");
		}

		if (cc + 1 <= ec && cr <= er) {
			mazePath_HVD(cr, cc + 1, er, ec, ans + "V");
		}

		if (cc + 1 <= ec && cr + 1 <= er) {
			mazePath_HVD(cr + 1, cc + 1, er, ec, ans + "D");
		}
	}

	private static void mazePath_MultiHVD(int cr, int cc, int er, int ec, String ans) throws IOException {

		if (cr == er && cc == ec) {
			pnter.printLine(ans);
			return;
		}

		for (int iH = 1; cr + iH <= er && cc <= ec; iH++) {
			mazePath_MultiHVD(cr + iH, cc, er, ec, ans + "H" + iH);
		}

		for (int iV = 1; cr <= er && cc + iV <= ec; iV++) {
			mazePath_MultiHVD(cr, cc + iV, er, ec, ans + "V" + iV);
		}

		for (int iD = 1; cr + iD <= er && cc + iD <= ec; iD++) {
			mazePath_MultiHVD(cr + iD, cc + iD, er, ec, ans + "D" + iD);
		}
	}

	private static void floodFill(int sr, int sc, int[][] maze, String path, boolean[][] isdone) throws IOException {
		// If_I_remove_all_elseif()_with_if()_then_we_get_all_backtracks.

		if (sr == maze.length - 1 && sc == maze[0].length - 1) {
			pnter.printLine(path + "");
			return;
		}

		if (sr + 1 <= maze.length - 1 && maze[sr + 1][sc] != 1 && !isdone[sr + 1][sc]) {
			isdone[sr + 1][sc] = true;
			floodFill(sr + 1, sc, maze, path + "(" + sr + ", " + sc + ") ", isdone);
			isdone[sr + 1][sc] = false;
		}

		else if (sc + 1 <= maze[0].length - 1 && maze[sr][sc + 1] != 1 && !isdone[sr][sc + 1]) {
			isdone[sr][sc + 1] = true;
			floodFill(sr, sc + 1, maze, path + "(" + sr + ", " + sc + ") ", isdone);
			isdone[sr][sc + 1] = false;
		}

		else if (sr + 1 <= maze.length - 1 && sc + 1 <= maze[0].length - 1 && maze[sr + 1][sc + 1] != 1
				&& !isdone[sr + 1][sc + 1]) {
			isdone[sr + 1][sc + 1] = true;
			floodFill(sr + 1, sc + 1, maze, path + "(" + sr + ", " + sc + ") ", isdone);
			isdone[sr + 1][sc + 1] = false;
		}

		else if (sr - 1 >= 0 && maze[sr - 1][sc] != 1 && !isdone[sr - 1][sc]) {
			isdone[sr - 1][sc] = true;
			floodFill(sr - 1, sc, maze, path + "(" + sr + ", " + sc + ") ", isdone);
			isdone[sr - 1][sc] = false;
		}

		else if (sc - 1 >= 0 && maze[sr][sc - 1] != 1 && !isdone[sr][sc - 1]) {
			isdone[sr][sc - 1] = true;
			floodFill(sr, sc - 1, maze, path + "(" + sr + ", " + sc + ") ", isdone);
			isdone[sr][sc - 1] = false;
		}

		else if (sr - 1 >= 0 && sc - 1 >= 0 && maze[sr - 1][sc - 1] != 1 && !isdone[sr - 1][sc]) {
			isdone[sr - 1][sc - 1] = true;
			floodFill(sr - 1, sc - 1, maze, path + "(" + sr + ", " + sc + ") ", isdone);
			isdone[sr - 1][sc - 1] = false;
		}
	}
	// -------------------------------------------------------------------------------------------------------------

	private static int[][] Eightdirction() {
		int[][] dirc = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

		return dirc;

	}

	private static int NumberLength(int n) {
		int length = 0;
		while (n != 0) {
			length++;
			n = n / 10;
		}

		return length;
	}

	private static void ReverseArray(int[] arr, int st, int en) {
		for (int i = st; st <= en; st++, en--) {
			swap(arr, st, en);
		}
	}

	private static int[] PrifixSumArray(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}

		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void Swap2DEle(int[][] arr, int i1, int j1, int i2, int j2) {
		int temp = arr[i1][j1];
		arr[i1][j1] = arr[i2][j2];
		arr[i2][j2] = temp;
	}

	private static int maxInArray(int[] arr) {
		int max = arr[0];
		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}

		return max;
	}

	private static int[] takeArrayInput(int n) throws IOException {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.scanInt();
			// arr[i] = scn.nextInt();
		}
		return arr;
	}

	private static int[][] takeMatrixInput(int n, int m) throws IOException {
		int[][] arr = new int[n][m];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				arr[row][col] = scn.scanInt();
				// arr[row][col] = scn.nextInt();
			}
		}
		return arr;
	}

	private static void displayArray(int[] arr) throws IOException {
		for (int i = 0; i < arr.length; i++) {
			pnter.print(arr[i] + " ");
			// System.out.print(arr[i]+" ");
		}
		pnter.printLine("");
		// System.out.println();
	}

	private static void displayMatrix(int[][] arr) throws IOException {
		for (int[] i : arr) {
			for (int el : i) {
				pnter.print(el + " ");
				// System.out.print(el+" ");
			}
			pnter.printLine("");
			// System.out.println();
		}
	}

	private static void cloneArray(int[] arr, int[] Oarr, int n) {
		for (int i = 0; i < n; i++) {
			arr[i] = Oarr[i];
		}

	}

	static class Scan {
		private InputStream in;
		private byte[] buf = new byte[1024 * 1024];
		private int index;
		private int total;

		public Scan(InputStream in) {
			this.in = in;
		}

		public int scan() throws IOException {
			if (total < 0)
				throw new InputMismatchException();
			if (index >= total) {
				index = 0;
				total = in.read(buf);
				if (total <= 0)
					return -1;
			}
			return buf[index++];
		}

		public int scanInt() throws IOException {
			int integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			return neg * integer;
		}

		public long scanLong() throws IOException {
			long integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			return neg * integer;
		}

		public double scanDouble() throws IOException {
			double doub = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n) && n != '.') {
				if (n >= '0' && n <= '9') {
					doub *= 10;
					doub += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			if (n == '.') {
				n = scan();
				double temp = 1;
				while (!isWhiteSpace(n)) {
					if (n >= '0' && n <= '9') {
						temp /= 10;
						doub += (n - '0') * temp;
						n = scan();
					} else
						throw new InputMismatchException();
				}
			}
			return doub * neg;
		}

		public String scanString() throws IOException {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			while (!isWhiteSpace(n)) {
				sb.append((char) n);
				n = scan();
			}
			return sb.toString();
		}

		private boolean isWhiteSpace(int n) {
			if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}
	}

	static class Print {
		private final BufferedWriter bw;

		public Print() {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(String str) throws IOException {
			bw.append(str);
		}

		public void printLine(String str) throws IOException {
			print(str);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}
}
