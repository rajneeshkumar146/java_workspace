package Practice_Easy;

import java.util.Scanner;

public class palindromic_numbers_less_than_n {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		for (int i = 1; i <= n; i++) {
			int num = scn.nextInt();
			int ans = palindromicSequences(num);
			System.out.println(ans);
		}

	}

	public static int palindromicSequences(int n) {
		int count = 0;
		for (int i = 1; i < n; i++) {
			String str = "" + i;
			boolean flag=true;
			for (int j = 0, k = str.length() - 1; j <= k; j++, k--) {
				if (str.charAt(j)-'0' != str.charAt(k)-'0') {
					flag=false;
				}
			}
			if(flag==true){
				System.out.println(i);
				count++;
			}

		}

		return count;

	}

}
