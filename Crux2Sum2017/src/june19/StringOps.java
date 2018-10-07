package june19;

public class StringOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printChars("hello");
		// printSubstrings("abcd");
		// System.out.println(IsPalindrome("pagan"));
		// System.out.println(countPalindromicSubstrings("nitin"));
		// System.out.println(toggleCase("aBcdEF"));
		System.out.println(diffChars("grqtb"));
	}

	public static void printChars(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
	}

	public static void printSubstrings(String s) {
		for (int si = 0; si < s.length(); si++) {
			for (int ei = si + 1; ei <= s.length(); ei++) {
				System.out.println(s.substring(si, ei));
			}
		}
	}

	public static boolean IsPalindrome(String s) {
		int left = 0, right = s.length() - 1;

		while (left <= right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	public static int countPalindromicSubstrings(String s) {
		int count = 0;

		for (int si = 0; si < s.length(); si++) {
			for (int ei = si + 1; ei <= s.length(); ei++) {
				String sub = s.substring(si, ei);

				boolean isSubPalin = IsPalindrome(sub);
				if (isSubPalin == true) {
					System.out.println(sub);
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

	public static String removeDuplicates(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				continue;
			} else {
				sb.append(s.charAt(i));
			}
		}

		sb.append(s.charAt(s.length() - 1));
		return sb.toString();
	}

	public static String compression(String s) {
		StringBuilder sb = new StringBuilder();

		int count = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				count++;
				continue;
			} else {
				sb.append(s.charAt(i));

				if (count > 1) {
					sb.append(count);
				}
				count = 1;
			}
		}

		sb.append(s.charAt(s.length() - 1));
		if (count > 1) {
			sb.append(count);
		}
		
		return sb.toString();
	}

	public static String oddEven(String s){
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			char nch = '\0';
			
			if(i % 2 == 1){
				nch = (char)(ch + 1);
			} else {
				nch = (char)(ch - 1);
			}
			
			sb.append(nch);
		}
		
		return sb.toString();
	}

	public static String diffChars(String s){
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length() - 1; i++) {
			int diff = s.charAt(i + 1) - s.charAt(i);
			
			sb.append(s.charAt(i));
			sb.append(diff);
		}
		
		sb.append(s.charAt(s.length() - 1));
		
		return sb.toString();
	}

}
