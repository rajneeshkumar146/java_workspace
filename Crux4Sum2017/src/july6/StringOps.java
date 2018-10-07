package july6;

public class StringOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Part 1
		// String str = "Hello";
		// System.out.println(str.length());
		// Part 3
		// System.out.println(str.charAt(0));
		// Part 4
		// System.out.println(str.substring(2, 4)); // ll

		printPalindromicSS("abcd");
	}

	public static void printSubstrings(String s) {

	}

	public static boolean IsPalindrome(String s) {

	}

	public static void printPalindromicSS(String s) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (IsPalindrome(s.substring(i, j)) == true) {
					System.out.println(s.substring(i, j));
				}
			}
		}
	}

}
