package Assingment_05_String;

import java.util.ArrayList;
import java.util.Scanner;

public class Q06_subsequence {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter your String");
		String s;
		s = scn.nextLine();
		subsequence(s);

	}

	public static void subsequence(String s) {

		ArrayList<String> arr = new ArrayList<String>();
		arr.add(" ");
		for (int i = s.length() - 1; i >= 0; i--) {
			int n = arr.size();
			char ch = s.charAt(i);
			for (int j = 0; j < n; j++) {
				String str = ch + arr.get(j);
				arr.add(str);
			}
		}

		for(String str:arr){
			System.out.println(str);
		}
	}
}
