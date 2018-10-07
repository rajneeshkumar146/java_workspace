package Assingment_08b_Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Q02_Mazze_path {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int cr = 0;
		int cc = 0;
//		System.out.println("Enter you end row");
		int er = scn.nextInt();
//		System.out.println("Enter your end column");
		int ec = scn.nextInt();

		System.out.println(mpath_01_recu(cr, cc, er, ec));

//		System.out.println(mpath_01_recu_best(cr, cc, er, ec, new int[er + 1][ec + 1]));
		System.out.println(mpath_02(cr, cc, er, ec));
		mpath_03(cr, cc, er, ec, "");
		


	}

	public static int mpath_01_recu(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int horizontal_path = mpath_01_recu(cr, cc + 1, er, ec);
		int vertical_path = mpath_01_recu(cr + 1, cc, er, ec);

		return horizontal_path + vertical_path;

	}

	public static int mpath_01_recu_best(int cr, int cc, int er, int ec, int[][] strg) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int horizontal_path = mpath_01_recu_best(cr, cc + 1, er, ec, strg);
		int vertical_path = mpath_01_recu_best(cr + 1, cc, er, ec, strg);

		int result = horizontal_path + vertical_path;
		strg[cr][cc] = result;

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

		mpath_03(cr, cc + 1, er, ec, ans + "H");
		mpath_03(cr + 1, cc, er, ec, ans + "V");

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
		
		ArrayList<String> result=new ArrayList<>();
		
		ArrayList<String> recu_res_H=mpath_02(cr, cc+1, er, ec);
		for(String rr:recu_res_H){
			result.add("H"+rr);
		}
		ArrayList<String> recu_res_V =mpath_02(cr+1, cc, er, ec);
		for(String rr:recu_res_V){
			result.add("V"+rr);
		}
		
		
		return result;
		
	}
}
