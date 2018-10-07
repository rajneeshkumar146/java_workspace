package Q001_030;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Q005_ONP_TransformExpression {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int t = Integer.parseInt(scn.nextLine());
		while (t-- > 0) {
			String str = scn.nextLine();
			System.out.println(ONP(str));
		}
	}

	private static String ONP(String str) {
		ArrayList<Character> ans = new ArrayList<>();
		ArrayDeque<Character> operator = new ArrayDeque<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (isOperator(ch)) {
				operator.addFirst(ch);
			} else if (ch == ')') {
				char test = operator.removeFirst();
				while (test != '(') {
					ans.add(test);
					test = operator.removeFirst();
				}
			} else {
				ans.add(ch);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i));
		}

		return sb.toString();
	}

	private static boolean isOperator(char ch) {
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '(') {
			return true;
		}

		return false;
	}

}
