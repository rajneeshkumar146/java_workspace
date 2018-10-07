package Assingment_05_String;

import java.util.Scanner;

public class Q08_Maximum_fequency_char {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		String s;
		s = scn.next();
		btr_max_freq(s);

	}

	public static void btr_max_freq(String s) {

		int[] arr = new int[256];

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			arr[ch]++;
		}
		int mf = arr[0];
		int mfi = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > mf) {
				mf = arr[i];
				mfi = i;
			}
		}
		char ch = (char) mfi;
		System.out.println(ch);
	}

}
