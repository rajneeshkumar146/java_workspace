package Class_24th_Heap;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapClient {

	public static void main(String[] args) {

		int[] one = { 1, 1, 2, 2, 2, 3, 5 };
		int[] two = { 1, 1, 1, 2, 2, 4, 5 };

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };

		System.out.println(gcc1(one, two));
		System.out.println(gcc2(one, two));
		System.out.println(longestSubseq(arr));

	}

	public static Character highestFreqChar(String word) {
		HashMap<Character, Integer> fm = new HashMap<>();

		for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);
			if (fm.containsKey(ch)) {
				fm.put(ch, fm.get(ch) + 1);
			} else {
				fm.put(ch, fm.get(ch));
			}
		}

		ArrayList<Character> maxa = new ArrayList<>(fm.keySet());
		Character maxch = ' ';
		Integer maxf = 0;
		for (int i = 0; i < maxa.size(); i++) {
			if (fm.get(maxa.get(i)) > maxf) {
				maxch = maxa.get(i);
				maxf = fm.get(maxa.get(i));
			}
		}

		return maxch;

	}

	public static ArrayList<Integer> gcc1(int[] one, int[] two) {

		HashMap<Integer, Integer> store = new HashMap<>();

		for (int i = 0; i < one.length; i++) {
			if (store.containsKey(one[i])) {
				store.put(one[i], store.get(one[i]) + 1);

			} else {
				store.put(one[i], 1);
			}
		}

		ArrayList<Integer> rv = new ArrayList<>();
		for (int i = 0; i < two.length; i++) {
			int data = two[i];
			if (store.containsKey(data)) {
				rv.add(data);
				store.remove(data);

			}
		}
		return rv;
	}

	public static ArrayList<Integer> gcc2(int[] one, int[] two) {

		HashMap<Integer, Integer> store = new HashMap<>();

		for (int i = 0; i < one.length; i++) {
			if (store.containsKey(one[i])) {
				store.put(one[i], store.get(one[i]) + 1);

			} else {
				store.put(one[i], 1);
			}
		}

		ArrayList<Integer> rv = new ArrayList<>();
		for (int i = 0; i < two.length; i++) {
			int data = two[i];
			if (store.containsKey(data)) {
				if (store.get(data) > 1) {
					rv.add(data);
					store.put(data, store.get(data) - 1);
				} else {
					rv.add(data);
					store.remove(data);
				}

			}
		}
		return rv;
	}

	public static ArrayList<Integer> longestSubseq(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int val : arr) {
			map.put(val, true);
		}

		ArrayList<Integer> gk = new ArrayList<>(map.keySet());
		for (int val : gk) {
			if (map.containsKey(val - 1)) {
				map.put(val, false);
			}
		}

		ArrayList<Integer> fi = new ArrayList<>();

		for (int val : gk) {
			ArrayList<Integer> tem = new ArrayList<>();
			if (map.containsKey(val) == true) {
				int count = 0;
				while (map.containsKey(val + count)){
					
					tem.add(count + val);
					count++;
				}
			}
			if (tem.size() > fi.size()) {
				fi = tem;
			}

		}

		return fi;

	}

}
