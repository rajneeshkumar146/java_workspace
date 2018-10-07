package Class_10th_Recursion_2;

public class print_permutation {
	public static void main(String[] args) {
		double st = System.currentTimeMillis();
		// print_wdupli_permutatio("bab", "");
		printpermutation("abcdefghi", "");
		double la = System.currentTimeMillis();
		System.out.println(la - st);

	}

	public static void printpermutation(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			printpermutation(roq, ans + ch);
		}

	}

	public static void print_wdupli_permutatio(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		boolean[] dupli = new boolean[256];

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			if (dupli[ch] == false) {
				print_wdupli_permutatio(roq, ans + ch);
				dupli[ch] = true;
			}
		}

	}

	 
   	
	
	
}
