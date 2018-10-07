package june26;

public class Client {

	public static void main(String[] args) {
		// printSSAscii("ab", "");
		// printKPC("245", "");
		// printBoardPaths(0, 10, "");
		printMazePath(0, 0, 2, 2, "");
	}

	public static void printSS(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans + ch); // yes
		printSS(roq, ans + ""); // no
	}

	public static void printSSAscii(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSSAscii(roq, ans + ch); // yes
		printSSAscii(roq, ans + ""); // no
		printSSAscii(roq, ans + (int) ch); // no
	}

	static String[] codes = { ".;", "abc", "def", "ghij", "kl", "mnop", "qrs", "tuv", "wx", "yz" };

	public static void printKPC(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		String code = codes[ch - '0'];
		for (int i = 0; i < code.length(); i++) {
			printKPC(roq, ans + code.charAt(i));
		}
	}

	public static void printBoardPaths(int s, int d, String ans) {
		if (s == d) {
			System.out.println(ans);
			return;
		}

		if (s > d) {
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			int inter = s + dice;
			printBoardPaths(inter, d, ans + dice);
		}
	}

	public static void printMazePath(int sr, int sc, int dr, int dc, String path) {
		if (sr == dr && sc == dc) {
			System.out.println(path);
			return;
		}
		
		if(sr > dr || sc > dc){
			return;
		}

		printMazePath(sr + 1, sc, dr, dc, path + "V");
		printMazePath(sr, sc + 1, dr, dc, path + "H");
	}

}
