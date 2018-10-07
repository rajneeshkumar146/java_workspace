package Practice_Easy;

import java.util.Scanner;

public class Three_consecutive_duplicates  {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		for (int i = 1; i <= n; i++) {
			String str = scn.next();
			String ans = consecutiveString(str);
			if (ans.length()==0) {
				System.out.println("-1");
			} else {
				System.out.println(ans);
			}

		}

	}

	public static String consecutiveString(String str) {
		boolean flag = false;
		for (int i = 0; i <= str.length() - 3; i++) {
			if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i + 1) == str.charAt(i + 2)) {
				str = str.substring(0, i) + str.substring(i + 3);
				flag = true;
			}
		}

		if (flag == false) {
			return str;
		}

		return consecutiveString(str);

	}

}
