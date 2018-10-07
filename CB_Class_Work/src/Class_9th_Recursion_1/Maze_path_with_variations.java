package Class_9th_Recursion_1;

import java.util.ArrayList;

public class Maze_path_with_variations {

	public static void main(String[] args) {
		
		 ArrayList<String> inter = maze_mul_path(0, 0, 3, 3);
		 System.out.println(inter);

//		mmp(0, 0, 3, 3, "");

	}

	public static ArrayList<String> maze_path(int cr, int cc, int er, int ec) {
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
		ArrayList<String> rrv = maze_path(cr + 1, cc, er, ec); // rr=recursion_resul
		for (String rs : rrv) {
			mr.add("H" + rs);

		}
		ArrayList<String> rrh = maze_path(cr, cc + 1, er, ec); // rr=recursion_resul
		for (String rs : rrh) {
			mr.add("V" + rs);

		}

		return mr;

	}

	public static ArrayList<String> maze_dia_path(int cr, int cc, int er, int ec) {
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
		ArrayList<String> rrv = maze_dia_path(cr + 1, cc, er, ec); // rr=recursion_resul
		for (String rs : rrv) {
			mr.add("H" + rs);

		}
		ArrayList<String> rrh = maze_dia_path(cr, cc + 1, er, ec); // rr=recursion_resul
		for (String rs : rrh) {
			mr.add("V" + rs);

		}

		ArrayList<String> rrd = maze_dia_path(cr + 1, cc + 1, er, ec); // rr=recursion_resul
		for (String rs : rrd) {
			mr.add("D" + rs);

		}

		return mr;

	}

	public static ArrayList<String> maze_mul_path(int cr, int cc, int er, int ec) {
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
		for (int i = 1; i + cr <= er; i++) {
			ArrayList<String> rrv = maze_mul_path(cr + i, cc, er, ec); // rr=recursion_resul
			for (String rs : rrv) {
				mr.add("H" + i + rs);

			}
		}
		for (int i = 1; i + cc <= ec; i++) {
			ArrayList<String> rrh = maze_mul_path(cr, cc + i, er, ec); // rr=recursion_resul
			for (String rs : rrh) {
				mr.add("V" + i + rs);

			}
		}
		for (int i = 1; i + cr <= er && i + cc < ec; i++) {
			ArrayList<String> rrd = maze_mul_path(cr + i, cc + i, er, ec); // rr=recursion_resul
			for (String rs : rrd) {
				mr.add("D" + i + rs);

			}

		}
		return mr;
	}

	public static void mazepath(int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans + ",");
		}

		if (cr > er || cc > ec) {
			return;
		}

		mazepath(cr + 1, cc, er, ec, ans + "H");
		mazepath(cr, cc + 1, er, ec, ans + "V");

	}

	public static void mmp(int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans + ",");
		}

		if (cr > er || cc > ec) {
			return;
		}

		for (int i = 1; cr + i <= er; i++) {
			mmp(cr + i, cc, er, ec, ans + "H" + i);
		}
		for (int i = 1; cc + i <= ec; i++) {
			mmp(cr, cc + i, er, ec, ans + "V" + i);
		}
		for (int i = 1; cr + i <= er && cc + i <= ec; i++) {
			mmp(cr + i, cc + i, er, ec, ans + "D" + i);
		}

	}

}
