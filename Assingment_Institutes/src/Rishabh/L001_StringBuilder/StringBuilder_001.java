package Rishabh.L001_StringBuilder;

import java.util.Scanner;

public class StringBuilder_001 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		String str = "aaabcddef";
		System.out.println(Compression(str));
		System.out.println(CompressionNumber(str));
		System.out.println(ASCIIDiff(str));
		SmallToggle(str);

		ActualToggle("aaBBCasjxbxjaHHHH211231.,.,$%^%%#afxhahj");
	}

	private static String Compression(String str) {
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < str.length(); i++) {
			char chPrev = str.charAt(i - 1);
			char chCurr = str.charAt(i);
			if (chCurr != chPrev) {
				sb.append(chPrev);
			}
		}

		sb.append(str.charAt(str.length() - 1));

		return sb.toString();

	}

	private static String CompressionNumber(String str) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			char chPrev = str.charAt(i - 1);
			char chCurr = str.charAt(i);
			if (chCurr != chPrev) {
				sb.append(chPrev);
				if (count != 1) {
					sb.append(count);
				}
				count = 1;
			} else {
				count++;
			}
		}

		sb.append(str.charAt(str.length() - 1));

		if (count != 1)
			sb.append(count);

		return sb.toString();

	}

	private static boolean Palindrome(String str) {
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			char front = str.charAt(i);
			char back = str.charAt(j);

			if (front != back) {
				return false;
			}

		}
		return true;

	}

	private static String ASCIIDiff(String str) {

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < str.length(); i++) {
			char chPrev = str.charAt(i - 1);
			char chCurr = str.charAt(i);

			sb.append(chPrev);
			if (chCurr - chPrev != 0)
				sb.append((int) (chCurr - chPrev));

		}

		sb.append(str.charAt(str.length() - 1));
		if (str.charAt(str.length() - 1) - str.charAt(str.length() - 2) != 0)
			sb.append(str.charAt(str.length() - 1) - str.charAt(str.length() - 2));

		return sb.toString();

	}

	private static void SmallToggle(String str) {

		StringBuilder sb = new StringBuilder();

		// small To large,assume all char are small.
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			char chNew = (char) (ch - 'a' + 'A');
			sb.append(chNew);
		}

		System.out.println(sb.toString());
		str = sb.toString();

		sb = new StringBuilder();

		// Large To small,assume all char are large.
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			char chNew = (char) (ch - 'A' + 'a');
			sb.append(chNew);
		}

		System.out.println(sb.toString());
	}

	// small to large and large to small.
	private static void ActualToggle(String str) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				sb.append((char) (ch - 'a' + 'A'));
			} else if (ch >= 'A' && ch <= 'Z') {
				sb.append((char) (ch - 'A' + 'a'));
			} else {
				sb.append(ch);
			}
		}
		System.out.println(sb.toString());
	}
	
	


}
