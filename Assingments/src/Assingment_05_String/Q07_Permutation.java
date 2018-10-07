package Assingment_05_String;

import java.util.ArrayList;
import java.util.Scanner;

public class Q07_Permutation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		String str = scn.nextLine();
		printPermutations(str);
	}
	
	public static void printPermutations(String str) {
		String[] seed = { str, "" };
		ArrayList<String[]> list = new ArrayList<>();
		list.add(seed);

		while (!list.isEmpty()) {
			String[] sa = list.remove(list.size() - 1);

			String src = sa[0];
			String dest = sa[1];
			if (src.length() != 0) {
				for (int i = 0; i < src.length(); i++) {
					String newSrc = src.substring(0, i) + src.substring(i + 1);
					String newDest = src.charAt(i) + dest;
					list.add(new String[] { newSrc, newDest });
				}
			} else {
				System.out.println(dest);
			}
		}
	}

}
