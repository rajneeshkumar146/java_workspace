package Assingment_08a_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q04_permutationRepeatedOrNonRepeated {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String n = scn.next();

		// System.out.println(count_permutation(n));
		// System.out.println(permutation02(n));
		// permutation03(n, "");

		// System.out.println();
		char[] ch = n.toCharArray();
		Arrays.sort(ch);
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<ch.length;i++){
			sb.append(ch[i]);
		}
		n=sb.toString();
		System.out.println(NonRepeatablePermutation01(n, new boolean[256]));
		NonRepeatablePermutation03(n, "", new boolean[256]);

	}

	public static int count_permutation(String ques) {

		if (ques.length() == 0) {

			return 1;
		}
		int count = 0;
		for (int i = 0; i < ques.length(); i++) {
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			count += count_permutation(roq);
		}
		return count;
	}

	public static ArrayList<String> permutation02(String ques) {
		if (ques.length() == 0) {
			ArrayList<String> recu_res = new ArrayList<>();
			recu_res.add("");
			return recu_res;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		ArrayList<String> result = new ArrayList<>();
		ArrayList<String> recu_res = permutation02(roq);
		for (String rr : recu_res) {
			for (int i = 0; i <= rr.length(); i++) {
				result.add(rr.substring(0, i) + ch + rr.substring(i));
			}
		}
		return result;

	}

	public static void permutation03(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;

		}
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			permutation03(roq, ans + ch);
		}
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------

	public static int NonRepeatablePermutation01(String ques, boolean[] isdone) {

		if (ques.length() == 0) {

			return 1;
		}
		int count = 0;
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			if (isdone[ch] == false) {
				String roq = ques.substring(0, i) + ques.substring(i + 1);
				count += NonRepeatablePermutation01(roq, new boolean[256]);
				isdone[ch] = true;
			}
		}
		return count;
	}

	public static void NonRepeatablePermutation03(String ques, String ans, boolean[] isdone) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;

		}
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			if (isdone[ch] == false) {
				String roq = ques.substring(0, i) + ques.substring(i + 1);
				NonRepeatablePermutation03(roq, ans + ch, new boolean[256]);
				isdone[ch] = true;
			}
		}
	}
}
