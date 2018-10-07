package String.Subsequences;

import java.awt.print.Printable;

public class Q01_Number_of_subsequences_of_the_form_ai_bj_ck {

	public static void main(String[] args) {
		System.out.println(Count_subseq("abcabc"));
		System.out.println();
		print_subsq("abcabc", "");
	}

	public static int Count_subseq(String ques) {

		int acount = 0;// count_of_all_distinct_subsequences_formed_by_a.
		int bcount = 0;// count_of_all_distinct_subsequences_formed_by_a_and_b.
		int ccount = 0;// count_of_all_distinct_subsequences_formed_by_a,b_and_c.

		for (int i = 0; i < ques.length(); i++) {
			/*
			 * then there are following possibilities : a) Current character
			 * begins a new subsequence. b) Current character is part of aCount
			 * subsequences. c) Current character is not part of aCount
			 * subsequences.
			 */
			if (ques.charAt(i) == 'a') {
				acount = 1 + 2 * (acount);
			} else if (ques.charAt(i) == 'b') {
				bcount = acount + 2 * (bcount);
			} else if (ques.charAt(i) == 'c') {
				ccount = bcount + 2 * (ccount);
			}

		}

		return ccount;
	}

	public static void print_subsq(String ques, String ans) {

		if (ques.length() == 0) {
			if (ans.length() >= 3) {
				String res = "";
				for (int i = 0; i < ans.length() - 1; i++) {
					if (ans.charAt(i) != ans.charAt(i + 1)) {
						res += ans.charAt(i);
					}
				}
				res += ans.charAt(ans.length() - 1);
				if (res.equals("abc")) {
					System.out.print(ans + ",");
				}
			}

			return;

		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		print_subsq(roq, ans);
		print_subsq(roq, ans + ch);

	}

}
