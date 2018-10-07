package Class_9th_Recursion_1;

import java.util.ArrayList;

public class Get_Board_Path {

	public static void main(String[] args) {

		ArrayList<String> inter = Get_Board_Path(0, 10);
		// ArrayList<String> inter = Get_Board_Path_variation(0, 10);
		System.out.println(inter.size());

		GetBoardPath(0, 10, "");
		System.out.println();
		System.out.println(countBoardPath(0, 10));

	}

	public static ArrayList<String> Get_Board_Path(int curr, int end) {
		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;

		}

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;

		}

		ArrayList<String> mr = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> rr = Get_Board_Path(curr + dice, end); // rr=recursion_resul
			for (String rs : rr) {
				mr.add(dice + rs);
			}

		}

		return mr;

	}

	public static ArrayList<String> Get_Board_Path_variation(int curr, int end) {
		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;

		}

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;

		}

		ArrayList<String> mr = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {
			if (curr == 0) {

			} else {
				ArrayList<String> rr = Get_Board_Path_variation(curr + dice, end); // rr=recursion_resul
				for (String rs : rr) {
					mr.add(dice + rs);
				}

			}
		}

		return mr;

	}

	public static void GetBoardPath(int curr, int end, String asf) {
		if (curr == end) {
			System.out.print(asf + ",");
			return;
		}

		for (int dice = 1; dice <= 6 && curr + dice <= end; dice++) {
			GetBoardPath(curr + dice, end, asf + dice);

		}

	}

	public static int countBoardPath(int curr, int end) {
		if (curr == end) {
			return 1;
		}

		int count = 0;
		for (int dice = 1; dice <= 6 && curr + dice <= end; dice++) {

			count += countBoardPath(curr + dice, end);

		}
		return count;

	}
}
