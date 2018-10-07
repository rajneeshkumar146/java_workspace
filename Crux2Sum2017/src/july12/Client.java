package july12;

public class Client {

	public static void main(String[] args) {
		A8a_Q9("bcad", "", "bcad");
//		lexico(1, 1000);
	}

	public static void A8a_Q9(String ques, String ans, String oq) {
		if (ques.length() == 0) {
			if (ans.compareTo(oq) > 0) {
				System.out.println(ans);
			}
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String ros = ques.substring(0, i) + ques.substring(i + 1);
			A8a_Q9(ros, ans + ch, oq);
		}

	}

	public static void lexico(int num, int max) {
		// print num itself
		System.out.println(num);

		// call to family
		for (int i = 0; i <= 9; i++) {
			if (num * 10 + i <= max) {
				lexico(num * 10 + i, max);
			}
		}

		// call to neighbor
		if (num < 9) {
			lexico(num + 1, max);
		}

	}

}
