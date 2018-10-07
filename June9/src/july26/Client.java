package july26;

import java.util.ArrayList;
import java.util.HashMap;

public class Client {

	public static void main(String[] args) {
		// HashMap<String, Integer> pmap = new HashMap<>();
		//
		// pmap.put("India", 120);
		// pmap.put("Pakistan", 80);
		// pmap.put("China", 200);
		// pmap.put("US", 20);
		// System.out.println(pmap);
		//
		// System.out.println(pmap.get("US"));
		// System.out.println(pmap.get("UK"));
		//
		// pmap.put("China", 210);
		// System.out.println(pmap);
		//
		// pmap.put("Aus", 25);
		// System.out.println(pmap);
		//
		// System.out.println(pmap.remove("UK"));
		// System.out.println(pmap.remove("US"));
		//
		// System.out.println(pmap.containsKey("India"));
		// System.out.println(pmap.containsKey("US"));
		//
		// ArrayList<String> countries = new ArrayList<>(pmap.keySet());
		// System.out.println(countries);

		// highestFreqCharacter("alksessssssssjflkasdjfasasda");
		// int[] one = {1, 1, 2, 2, 2, 3, 5};
		// int[] two = {1, 1, 1, 2, 2, 4, 5};
		// gce1(one, two);
		// gce2(one, two);

		// int[] arr = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1 , 8, 6};
		// longestConsecutiveSeq(arr);
		shortestSubstringWithAllUniqueChars("aabbcaabdaacbbcdaac");
	}

	public static void highestFreqCharacter(String str) {
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.containsKey(ch) ? fmap.get(ch) + 1 : 1);
		}

		ArrayList<Character> allKeys = new ArrayList<>(fmap.keySet());
		char maxFC = allKeys.get(0);
		for (Character key : allKeys) {
			if (fmap.get(key) > fmap.get(maxFC)) {
				maxFC = key;
			}
		}

		System.out.println(maxFC);
	}

	public static void gce1(int[] one, int[] two) {
		HashMap<Integer, Integer> fmap = new HashMap<>();
		for (int val : one) {
			fmap.put(val, fmap.containsKey(val) ? fmap.get(val) + 1 : 1);
		}

		for (int val : two) {
			if (fmap.containsKey(val)) {
				System.out.print(val + " ");
				fmap.remove(val);
			}
		}
		System.out.println();
	}

	public static void gce2(int[] one, int[] two) {
		HashMap<Integer, Integer> fmap = new HashMap<>();
		for (int val : one) {
			fmap.put(val, fmap.containsKey(val) ? fmap.get(val) + 1 : 1);
		}

		for (int val : two) {
			if (fmap.containsKey(val) && fmap.get(val) > 0) {
				System.out.print(val + " ");
				fmap.put(val, fmap.get(val) - 1);
			}
		}
		System.out.println();
	}

	public static void longestConsecutiveSeq(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>(); // starting points

		for (int val : arr) {
			map.put(val, true);
		}

		for (int val : arr) {
			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}
		}

		int mseqsp = 0;
		int mseql = 0;

		for (int val : arr) {
			if (map.get(val) == true) { // actual starting point
				int cseqsp = val;
				int cseql = 1;

				while (map.containsKey(cseqsp + cseql)) {
					cseql++;
				}

				if (cseql > mseql) {
					mseqsp = cseqsp;
					mseql = cseql;
				}
			}
		}

		for (int i = mseqsp; i < mseqsp + mseql; i++) {
			System.out.println(i);
		}
	}

	public static void shortestSubstringWithAllUniqueChars(String str) {
		HashMap<Character, Integer> tmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			tmap.put(ch, tmap.containsKey(ch) ? tmap.get(ch) + 1 : 1);
		}

		String ans = str;
		int start = 0;
		int end = 0;
		HashMap<Character, Integer> cmap = new HashMap<>();

		while (end < str.length() && start < str.length()) {
			if (cmap.size() < tmap.size()) {
				char ech = str.charAt(end);
				end++;
				cmap.put(ech, cmap.containsKey(ech) ? cmap.get(ech) + 1 : 1);
			} else {
				if (start < str.length()) {
					char sch = str.charAt(start);
					start++;
					cmap.put(sch, cmap.get(sch) - 1);
					if (cmap.get(sch) == 0) {
						cmap.remove(sch);
					}
				}
			}

			if (cmap.size() == tmap.size()) {
				String substr = str.substring(start, end);
				if (substr.length() < ans.length()) {
					ans = substr;
				}
			}
		}

		System.out.println(ans);
	}

}
