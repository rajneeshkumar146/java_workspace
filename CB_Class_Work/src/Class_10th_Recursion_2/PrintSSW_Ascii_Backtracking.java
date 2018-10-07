package Class_10th_Recursion_2;

import java.util.ArrayList;

public class PrintSSW_Ascii_Backtracking {

	public static void main(String[] args) {

		printssw_Ascii("abc", "");
		System.out.println(countSS("ABC"));

	}

	public static void printssw_Ascii(String ques, String ans) {
		if (ques.length() == 0) {
			if (ans.length() != 0)
				System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1); // roq=rest_of_question
		printssw_Ascii(roq, ans);
		printssw_Ascii(roq, ans + ch);
		printssw_Ascii(roq, ans + (int) ch);

	}

	public static int countSS(String ques) {
		if (ques.length() == 0) {
			return 0;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1); // roq=rest_of_question
		int count = 0;
		count += 0 + countSS(roq);
		count += 1 + countSS(roq);
		count += 1 + countSS(roq);
		return count;
	}

}
