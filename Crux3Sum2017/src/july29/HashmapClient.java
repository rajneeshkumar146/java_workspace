package july29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HashmapClient {

	public static void main(String[] args) {
		// HashMap<String, Integer> popmap = new HashMap<>();
		//
		// popmap.put("India", 120);
		// popmap.put("China", 200);
		// popmap.put("Pak", 80);
		// popmap.put("US", 25);
		// popmap.put("UK", 20);
		//
		// System.out.println(popmap);
		//
		// popmap.put("India", 125);
		// popmap.put("Nigeria", 50);
		//
		// System.out.println(popmap);
		//
		// System.out.println(popmap.get("Nigeria"));
		// System.out.println(popmap.get("Utopia"));
		//
		// System.out.println(popmap.containsKey("Nigeria"));
		// System.out.println(popmap.containsKey("Utopia"));
		//
		// System.out.println(popmap.remove("Nigeria"));
		// System.out.println(popmap.remove("Utopia"));
		//
		// System.out.println(popmap);
		//
		// ArrayList<String> keys = new ArrayList<>(popmap.keySet());
		// System.out.println(keys);

		// System.out.println(highestFreqChar("ababadaads"));
		//
		// int[] one = {1, 1, 2, 2, 2, 3, 5};
		// int[] two = {1, 1, 1, 2, 2, 4, 5};
		// System.out.println(gce2(one, two));

		 int[] arr = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
		 lcnscutiveseq(arr);

	}

	public static Character highestFreqChar(String word) {
		HashMap<Character, Integer> fm = new HashMap<>();

		for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);

			if (fm.containsKey(ch)) {
				fm.put(ch, fm.get(ch) + 1);
			} else {
				fm.put(ch, 1);
			}
		}

		System.out.println(fm);

		Character maxc = ' ';
		Integer maxcf = 0;

		ArrayList<Character> keys = new ArrayList<>(fm.keySet());
		for (Character key : keys) {
			int keyf = fm.get(key);
			if (keyf > maxcf) {
				maxc = key;
				maxcf = keyf;
			}
		}

		return maxc;
	}

	public static ArrayList<Integer> gce1(int[] one, int[] two) {
		HashMap<Integer, Integer> fm = new HashMap<>();

		for (int val : one) {
			if (fm.containsKey(val)) {
				fm.put(val, fm.get(val) + 1);
			} else {
				fm.put(val, 1);
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int val : two) {
			if (fm.containsKey(val)) {
				list.add(val);
				fm.remove(val);
			}
		}

		return list;
	}

	public static ArrayList<Integer> gce2(int[] one, int[] two) {
		HashMap<Integer, Integer> fm = new HashMap<>();

		for (int val : one) {
			if (fm.containsKey(val)) {
				fm.put(val, fm.get(val) + 1);
			} else {
				fm.put(val, 1);
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int val : two) {
			if (fm.containsKey(val)) {
				list.add(val);

				if (fm.get(val) > 1) {
					fm.put(val, fm.get(val) - 1);
				} else {
					fm.remove(val);
				}
			}
		}

		return list;
	}

	public static void lcnscutiveseq(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int val : arr) {
			map.put(val, true);
		}

		for (int val : arr) {
			if (map.containsKey(val - 1)) {
				map.put(val, false);
			}
		}

		int maxsp = 0;
		int maxsl = 0;

		for (int val : arr) {
			if (map.get(val) == true) {
				int seql = 0;

				while (map.containsKey(val + seql)) {
					seql++;
				}

				if (seql > maxsl) {
					maxsp = val;
					maxsl = seql;
				}
			}
		}

		for (int i = 0; i < maxsl; i++) {
			System.out.println(maxsp + i);
		}
	}
}
