package june22;

public class StringOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printChars("hello");
		// printSubstrings("abcd");
		// System.out.println(countPalindromicSubStrings("malayalam"));
		// System.out.println(toggleCase("ABcdEf"));
//		System.out.println(oddEven("abcd"));
//		System.out.println(insertDiff("fca"));
		System.out.println(compression("aaabbbaabbccds"));
	}

	public static void printChars(String s) {
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			System.out.println(ch);
		}
	}

	public static void printSubstrings(String s) {
		for (int si = 0; si < s.length(); si++) {
			for (int ei = si + 1; ei <= s.length(); ei++) {
				System.out.println(s.substring(si, ei));
			}
		}
	}

	public static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	public static int countPalindromicSubStrings(String s) {
		int count = 0;

		for (int si = 0; si < s.length(); si++) {
			for (int ei = si + 1; ei <= s.length(); ei++) {
				String sub = s.substring(si, ei);
				boolean result = isPalindrome(sub);
				if (result == true) {
					count++;
				}
			}
		}

		return count;
	}

	public static String toggleCase(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			char nch = '\0';

			if (ch >= 'a' && ch <= 'z') {
				nch = (char) (ch - 'a' + 'A');
			} else if (ch >= 'A' && ch <= 'Z') {
				nch = (char) (ch - 'A' + 'a');
			}

			sb.append(nch);
		}

		return sb.toString();
	}

	public static String oddEven(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			char nch = '\0';

			if (i % 2 == 1) {
				nch = (char) (ch + 1);
			} else {
				nch = (char) (ch - 1);
			}

			sb.append(nch);
		}

		return sb.toString();
	}

	public static String insertDiff(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length() - 1; i++) {
			char ch = s.charAt(i);
			char nch = s.charAt(i + 1);
			int diff = nch - ch;

			sb.append(ch);
			sb.append(diff);
		}

		sb.append(s.charAt(s.length() - 1));

		return sb.toString();
	}

	public static String compression(String s) {
		StringBuilder sb = new StringBuilder();

		int rptions = 1;

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
//				rptions++;
			} else {
				sb.append(s.charAt(i));
//				if (rptions > 1) {
//					sb.append(rptions);
//				}
//				rptions = 1;
			}
		}
		
		sb.append(s.charAt(s.length() - 1));
//		if (rptions > 1) {
//			sb.append(rptions);
//		}

		return sb.toString();
	}
}
