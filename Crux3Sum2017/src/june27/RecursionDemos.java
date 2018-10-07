package june27;

import java.util.ArrayList;

public class RecursionDemos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] one = {1, 1, 2, 2, 2, 3, 5};
		// int[] two = {1, 1, 1, 2, 2, 4, 5};
		// ArrayList<Integer> inter = getIntersection(one, two);
		// System.out.println(inter);
		// System.out.println(getSS("ab"));
		// System.out.println(getPerm("abc"));
		// System.out.println(getBoardPaths(0, 10));
		// System.out.println(getMazePaths(0, 0, 2, 2));
//		System.out.println(getMazePathsWD(0, 0, 2, 2));
//		System.out.println(getMazePathsWDMultiSteps(0, 0, 2, 2));
//		printSS("abc", "");
//		printPerms("abc", "");
		
		printMP(0, 0, 2, 2, "");
	}

	public static ArrayList<Integer> getIntersection(int[] one, int[] two) {
		ArrayList<Integer> rv = new ArrayList<>();

		return rv;
	}

	public static ArrayList<String> getSS(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add(s);
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);

		ArrayList<String> rr = getSS(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String rs : rr) {
			mr.add(rs);
			mr.add(ch + rs);
			mr.add((int) ch + rs);
		}

		return mr;
	}

	public static ArrayList<String> getPerm(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add(s);
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);

		ArrayList<String> rr = getPerm(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rs : rr) {
			for (int i = 0; i <= rs.length(); i++) {
				String ms = rs.substring(0, i) + ch + rs.substring(i);
				mr.add(ms);
			}
		}

		return mr;
	}

	public static ArrayList<String> getKPC(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add(s);
			return br;
		}

		char ch = s.charAt(0);
		String ros = s.substring(1);

		ArrayList<String> rr = getKPC(ros);
		ArrayList<String> mr = new ArrayList<>();

		String choices = getChoice(ch);
		for (String rs : rr) {
			for (int i = 0; i < choices.length(); i++) {
				String ms = choices.charAt(i) + rs;
				mr.add(ms);
			}
		}

		return mr;
	}

	public static String getChoice(char key) {
		if (key == '1') {
			return "abc";
		}
		if (key == '2') {
			return "def";
		}
		if (key == '3') {
			return "ghi";
		}
		if (key == '4') {
			return "jkl";
		}
		if (key == '5') {
			return "mno";
		}
		if (key == '6') {
			return "pqrs";
		}
		if (key == '7') {
			return "tuv";
		}
		if (key == '8') {
			return "wx";
		}
		if (key == '9') {
			return "yz";
		}
		if (key == '0') {
			return ".;";
		}
		return "";
	}

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
			ArrayList<String> rrdice = getBoardPaths(curr + dice, end);
			for (String rs : rrdice) {
				mr.add(dice + rs);
			}
		}

		return mr;
	}

	public static ArrayList<String> getMazePaths(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
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

		return mr;
	}

	public static ArrayList<String> getMazePathsWD(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = getMazePathsWD(cr, cc + 1, er, ec);
		for (String rs : rrh) {
			mr.add("H" + rs);
		}

		ArrayList<String> rrv = getMazePathsWD(cr + 1, cc, er, ec);
		for (String rs : rrv) {
			mr.add("V" + rs);
		}

		if (cr == cc || cr + cc == ec) {
			ArrayList<String> rrd = getMazePathsWD(cr + 1, cc + 1, er, ec);
			for (String rs : rrd) {
				mr.add("D" + rs);
			}
		}

		return mr;
	}

	public static ArrayList<String> getMazePathsWDMultiSteps(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		int move = 1;

		while (move <= ec) {
			ArrayList<String> rrh = getMazePathsWDMultiSteps(cr, cc + move, er, ec);
			for (String rs : rrh) {
				mr.add("H" + move + rs);
			}

			move++;
		}

		move = 1;
		while (move <= er) {
			ArrayList<String> rrv = getMazePathsWDMultiSteps(cr + move, cc, er, ec);
			for (String rs : rrv) {
				mr.add("V" + move + rs);
			}
			move++;
		}

		move = 1;
		while (move <= er && move <= ec) {
			ArrayList<String> rrd = getMazePathsWDMultiSteps(cr + move, cc + move, er, ec);
			for (String rs : rrd) {
				mr.add("D" + move + rs);
			}
			move++;
		}

		return mr;
	}

	public static void printSS(String qst, String ans){
		if(qst.length() == 0){
			System.out.println(ans);
			return;
		}
		
		char ch = qst.charAt(0);
		String roq = qst.substring(1);
		
//		System.out.println("Hello " + ch);
		
		printSS(roq, ans + ""); // no
		
//		System.out.println("From no to yes for: " + ch);
		
		printSS(roq, ans + ch); // yes
		
//		System.out.println("Bye " + ch);
	}
	
	public static void printSSWAscii(String qst, String ans){
		if(qst.length() == 0){
			System.out.println(ans);
			return;
		}
		
		char ch = qst.charAt(0);
		String roq = qst.substring(1);
		
		printSSWAscii(roq, ans + ""); // no
		printSSWAscii(roq, ans + ch); // yes
		printSSWAscii(roq, ans + (int)ch); // ascii
	}
	
	public static void printPerms(String qst, String ans){
		if(qst.length() == 0){
			System.out.println(ans);
			return;
		}
		
		for(int i = 0; i < qst.length(); i++){
			char ch = qst.charAt(i);
			String roq = qst.substring(0, i) + qst.substring(i + 1);
			printPerms(roq, ans + ch);
		}
	}
	
	public static void printMP(int cr, int cc, int er, int ec, String ans){
		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}

		if (cr > er || cc > ec) {
			return;
		}
		
		printMP(cr, cc + 1, er, ec, ans + "H");
		printMP(cr + 1, cc, er, ec, ans + "V");
		printMP(cr + 1, cc + 1, er, ec, ans + "D");
	}
	
	
	
	
	
	
}
