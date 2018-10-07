package june30;

public class A7 {

	public static void main(String[] args) {
		// System.out.println(Q2("1234"));
		Q7("abexexdexed", "", 0);
		Q8("hiihihit", "");
		Q12("1123", "");
	}

	public static int Q2(String str) {
		if (str.length() == 0) {
			return 0;
		}

		char ch = str.charAt(str.length() - 1);
		String ros = str.substring(0, str.length() - 1);

		int rr = Q2(ros);
		int mr = 10 * rr + ch - '0';

		return mr;
	}

	public static void Q7(String qst, String ans, int count) {
		if (qst.length() == 0) {
			for (int i = 0; i < count; i++) {
				ans = ans + 'x';
			}
			System.out.println(ans);
			return;
		}

		char ch = qst.charAt(0);
		String ros = qst.substring(1);

		if (ch == 'x') {
			Q7(ros, ans, count + 1);
		} else {
			Q7(ros, ans + ch, count);
		}

	}

	public static void Q8(String qst, String ans) {
		if (qst.length() < 2) {
			if (qst.length() == 0) {
				System.out.println(ans);
			} else {
				System.out.println(ans + qst);
			}
			return;
		}

		String ch01 = qst.substring(0, 2);

		if (ch01.equals("hi")) {
			String ros01 = qst.substring(2);
			Q8(ros01, ans + "bye");
		} else {
			String ros0 = qst.substring(1);
			Q8(ros0, ans + qst.charAt(0));
		}
	}

	public static void Q12(String qst, String ans){
		if(qst.length() == 0){
			System.out.println(ans);
			return;
		}
		
		Integer ch0 = Integer.parseInt(qst.substring(0, 1));
		String ros0 = qst.substring(1);
		
		Q12(ros0, ans + (char)('a' - 1 + ch0));
		
		if(qst.length() >= 2){
			Integer ch01 = Integer.parseInt(qst.substring(0, 2));
			String ros01 = qst.substring(2);
			
			if(ch01 <= 26){
				Q12(ros01, ans + (char)('a' - 1 + ch01));
			}
		}
	}
}
