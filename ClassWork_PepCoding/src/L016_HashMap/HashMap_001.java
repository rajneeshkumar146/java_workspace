package L016_HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HashMap_001 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		// MaxFrequencyCharacter("aaabjabjavxajvxavanxbvanxvnba");

		// int[] one = { 1, 1, 1, 2, 2, 3, 5 };
		// int[] two = { 1, 1, 2, 2, 2, 3, 3, 5 };
		// GCC1(one, two);
		// GCC2(one, two);

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		LongestConsecutiveSequence(arr);

	}

	private static void MaxFrequencyCharacter(String str) {
		HashMap<Character, Integer> freq = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			freq.put(str.charAt(i), !freq.containsKey(str.charAt(i)) ? 1 : freq.get(str.charAt(i)) + 1);
		}

		int max = Integer.MIN_VALUE;
		char ch = '\u0000';
		ArrayList<Character> keys = new ArrayList<>(freq.keySet());
		for (Character key : keys) {
			if (freq.get(key) > max) {
				max = freq.get(key);
				ch = key;
			}
		}

		System.out.println(ch);

	}

	private static void GCC1(int[] one, int[] two) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i : one) {
			map.put(i, !map.containsKey(i) ? 1 : map.get(i) + 1);
		}

		for (int i : two) {
			if (map.containsKey(i)) {
				System.out.print(i + " ");
				map.remove(i);
			}
		}
		System.out.println();

	}

	private static void GCC2(int[] one, int[] two) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i : one) {
			map.put(i, !map.containsKey(i) ? 1 : map.get(i) + 1);
		}

		for (int i : two) {
			if (map.containsKey(i)) {
				System.out.print(i + " ");
				map.put(i, map.get(i) - 1);
				if (map.get(i) == 0) {
					map.remove(i);
				}
			}
		}
		System.out.println();
	}

	private static void LongestConsecutiveSequence(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i : arr) {
			map.put(i, true);
		}

		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		for (int i : keys) {
			if (map.containsKey(i - 1)) {
				map.put(i, false);
			}
		}

		int size = 0;
		int number = 0;
		keys = new ArrayList<>(map.keySet());
		for (int i : keys) {
			if (map.get(i)) {
				int PotentialSize = 0;
				int PotentialNumber = i;
				while (map.containsKey(PotentialNumber + PotentialSize)) {
					PotentialSize++;

				}

				if (PotentialSize > size) {
					size = PotentialSize;
					number = PotentialNumber;
				}
			}
		}

		for (int i = number; i < number + size; i++) {
			System.out.print(i + " ");
		}

	}

}
