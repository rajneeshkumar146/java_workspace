package Dec16_Hashtable;

import java.util.ArrayList;
import java.util.HashMap;

public class hashmap {

	public static void main(String[] args) {
		int[] one = { 1, 1, 2, 2, 2, 3, 5 };
		int[] two = { 1, 1, 1, 2, 2, 4, 5 };
		HM(one, two);
	}

	public static void HM(int[] one, int[] two) {
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
			if (store.containsKey(two[i])) {
				rv.add(two[i]);
				store.remove(two[i]);
			}
		}
		System.out.println(rv);
	}

	public static void gce(int[] one, int[] two) {
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
	}

	public static void lps(int[] arr) {
		HashMap<Integer, Boolean> store = new HashMap<>();
		for (int val : arr) {
			store.put(val, false);
		}

		for (int val : arr) {
			if (store.containsKey(val - 1)) {
				store.put(val, true);
			}
		}

		int finalL = 0;
		int finalsp = -1;

		for (int val : arr) {
			if (store.get(val) == true) {
				int count = 0;
				while (store.containsKey(val + count)) {
					count++;
				}

				if (count > finalL) {
					finalL = count;
					finalsp = val;
				}
			}

		}

		for (int i = finalsp; i <= finalL; i++) {
			System.out.print(i + ",");
		}

	}
}