package Assingment_08b_Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Q04_Mazze_path_multimove {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int cr = 0;
		int cc = 0;
		// System.out.println("Enter you end row");
		int er = scn.nextInt();
		// System.out.println("Enter your end column");
		int ec = scn.nextInt();

		System.out.println(mpath_01_recu(cr, cc, er-1, ec-1));

		System.out.println(mpath_02(cr, cc, er-1, ec-1));

		mpath_03(cr, cc, er-1, ec-1, "");

	}

	public static int mpath_01_recu(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int count = 0;
		for (int i = 1; i + cc <= ec; i++) {
			count += mpath_01_recu(cr, cc + i, er, ec);
		}

		for (int i = 1; i + cr <= er; i++) {
			count += mpath_01_recu(cr + i, cc, er, ec);
		}

		for (int i = 1; i + cr <= er && i + cc <= ec; i++) {
			count += mpath_01_recu(cr + i, cc + i, er, ec);
		}

		return count;

	}

	public static ArrayList<String> mpath_02(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> recu_res = new ArrayList<>();
			recu_res.add("");
			return recu_res;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> recu_res = new ArrayList<>();
			return recu_res;
		}

		ArrayList<String> result = new ArrayList<>();
		for (int i = 1; i + cc <= ec; i++) {
			ArrayList<String> recu_res_H = mpath_02(cr, cc + i, er, ec);
			for (String rr : recu_res_H) {
				result.add("H"+ i + rr);
			}
		}
		for (int i = 1; i + cr <= er; i++) {
			ArrayList<String> recu_res_V = mpath_02(cr + i, cc, er, ec);
			for (String rr : recu_res_V) {
				result.add("V"+i + rr);
			}
		}
		for (int i = 1; i + cr <= er&& i + cc <= ec; i++) {
			ArrayList<String> recu_res_D = mpath_02(cr + i, cc + i, er, ec);
			for (String rr : recu_res_D) {
				result.add("D"+i + rr);
			}
		}

		return result;

	}

	public static void mpath_03(int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}

		if (cr > er || cc > ec) {
			return;
		}

		for (int i = 1; i + cc <= ec; i++) {
			mpath_03(cr, cc + i, er, ec, ans + "H" + i);
		}
		for (int i = 1; i + cr <= er; i++) {
			mpath_03(cr + i, cc, er, ec, ans + "V" + i);
		}
		for (int i = 1; i + cr <= er && i + cc <= ec; i++) {
			mpath_03(cr + i, cc + i, er, ec, ans + "D" + i);
		}

	}

}
