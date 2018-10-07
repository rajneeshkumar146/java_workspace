package Assingment_08b_Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Q01_board_path {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int start = 0;
		System.out.println("Enter you end condition");
		int end = scn.nextInt();
		System.out.println("Enter your faces");
		int face = scn.nextInt();

		System.out.println(bpath_rec_01(start, end, face));

		// System.out.println(bpath_rec_01_best(start, end, face, new int[end
		// +6]));

		// System.out.println(bpath_02(start, end, face));
		// bpath_03(start, end, face, "");
		bpath_04(start, end, face, new StringBuilder());

	}

	public static int bpath_rec_01(int start, int end, int face) {
		if (start == end) {
			return 1;
		}
		if (start > end) {
			return 0;
		}

		int count = 0;
		for (int i = 1; i <= face; i++) {
			count += bpath_rec_01(start + i, end, face);
		}
		return count;
	}

	public static int bpath_rec_01_best(int start, int end, int face, int[] strg) {
		if (start == end) {
			return 1;
		}
		if (start > end) {
			return 0;
		}
		if (strg[start] != 0) {
			return strg[start];
		}

		int count = 0;
		for (int i = 1; i <= face; i++) {
			count += bpath_rec_01_best(start + i, end, face, strg);
		}

		strg[start] = count;

		return count;
	}

	public static ArrayList<String> bpath_02(int start, int end, int face) {
		if (start == end) {
			ArrayList<String> recu_res = new ArrayList<>();
			recu_res.add("");
			return recu_res;
		}

		if (start > end) {
			ArrayList<String> recu_res = new ArrayList<>();
			return recu_res;
		}

		ArrayList<String> result = new ArrayList<>();
		for (int i = 1; i <= face; i++) {
			ArrayList<String> recu_res = bpath_02(start + i, end, face);
			for (String rr : recu_res) {
				result.add(i + rr);
			}
		}
		return result;
	}

	public static void bpath_03(int start, int end, int face, String ans) {
		if (start == end) {
			System.out.println(ans);
			return;
		}
		if (start > end) {
			return;
		}

		for (int i = 1; i <= face; i++) {
			bpath_03(start + i, end, face, ans + i);
		}
	}

	public static void bpath_04(int start, int end, int face, StringBuilder ans) {
		if (start == end) {
			System.out.println(ans);
			return;
		}

		for (int i = 1; i <= face && i + start <= end; i++) {
			bpath_04(start + i, end, face, ans.append(i));
			ans.deleteCharAt(ans.length() - 1);
		}
	}

}
