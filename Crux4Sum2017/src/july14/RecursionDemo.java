package july14;

import java.util.ArrayList;

public class RecursionDemo {

	public static void main(String[] args) {
		// System.out.println(getSS("abcd"));
		// printSS("abc", "");
		// printBoardPath(0, 10, "");
//		printTargetSS(new int[] { 10, 20, 30, 40, 50, 60, 70 }, 0, 70, "");
		printMP(0, 0, 2, 2, "");
	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSS(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rs : rr) {
			mr.add(rs);
			mr.add(ch + rs);
		}

		return mr;
	}

	public static void printSS(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		printSS(ros, ans + ch); // says yes
		printSS(ros, ans); // says no
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

	public static String getCode(char key) {
		if (key == '1') {
			return "abc";
		} else if (key == '2') {
			return "def";
		} else if (key == '3') {
			return "ghi";
		} else if (key == '4') {
			return "jkl";
		} else if (key == '5') {
			return "mno";
		} else if (key == '6') {
			return "pqrs";
		} else if (key == '7') {
			return "tuv";
		} else if (key == '8') {
			return "wx";
		} else if (key == '9') {
			return "yz";
		} else if (key == '0') {
			return ".,";
		}
		return "";
	}

	public static void printBoardPath(int curr, int end, String path) {
		if (curr == end) {
			System.out.println(path);
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			if (curr + dice <= end) {
				path += dice;
				printBoardPath(curr + dice, end, path);
			}
		}
	}

	public static void printArrSS(int[] arr, int vidx, String ans) {
		if (vidx == arr.length) {
			System.out.println(ans);
			return;
		}

		printArrSS(arr, vidx + 1, ans + " " + arr[vidx]);
		printArrSS(arr, vidx + 1, ans);
	}

	public static void printTargetSS(int[] arr, int vidx, int tar, String ans) {
		if (vidx == arr.length) {
			if (tar == 0) {
				System.out.println(ans);
				return;
			}

			return;
		}

		printTargetSS(arr, vidx + 1, tar - arr[vidx], ans + " " + arr[vidx]);
		printTargetSS(arr, vidx + 1, tar, ans);
	}

	public static void printMP(int cr, int cc, int er, int ec, String path) {
		if (cr == er && cc == ec) {
			System.out.println(path);
			return;
		}

		if (cc < ec) {
			printMP(cr, cc + 1, er, ec, path + "H");
		}

		if (cr < er) {
			printMP(cr + 1, cc, er, ec, path + "V");
		}

		if (cr < er && cc < ec) {
			printMP(cr + 1, cc + 1, er, ec, path + "D");
		}
	}

}
