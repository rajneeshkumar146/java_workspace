package L018_Heap;

import java.util.ArrayList;
import java.util.Scanner;

public class Heap_001 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		int[] arr = { 10, 9, 8, 1, 5, 9, -7, 44, 11, 52, 25 };
		// Heap hp = new Heap(arr, true);
		// for (int val : arr) {
		// hp.add(val);
		// }

		// hp.displayAsTree();

		// while (!hp.isEmpty()) {
		// System.out.println(hp.remove());
		// }

		HeapSort(arr);

	}

	// Heap.=======================================================================================

	private static void HeapSort(int[] arr) {

		for (int i = arr.length - 1; i >= 0; i--) {
			downHepify(arr, i, arr.length);
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			swap(arr, 0, i);
			downHepify(arr, 0, i);
		}

		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	private static void downHepify(int[] arr, int pi, int len) {
		int max = pi;

		int lci = (pi * 2) + 1;
		int rci = (pi * 2) + 2;

		if (lci < len && arr[max] < arr[lci]) {
			max = lci;
		}

		if (rci < len && arr[max] < arr[rci]) {
			max = rci;
		}

		if (max != pi) {
			swap(arr, max, pi);
			downHepify(arr, max, len);
		}

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	private static class Heap {

		private ArrayList<Integer> list = new ArrayList<Integer>();

		private boolean priority = true;

		public Heap(boolean isMax) {
			priority = isMax;
		}

		public Heap(int[] arr, boolean isMax) {
			this.priority = isMax;

			for (int val : arr) {
				list.add(val);
			}

			for (int i = list.size() - 1; i >= 0; i--) {
				downheapify(i);
			}

		}

		public void add(int data) {
			this.list.add(data);
			int ci = list.size() - 1;
			uphepify(ci);
		}

		public int remove() {
			int rv = list.get(0);
			swap(0, list.size() - 1);
			list.remove(list.size() - 1);
			downheapify(0);

			return rv;
		}

		public void update(int data) {
			int idx = Find(data);
			if (idx == -1) {
				return;
			}

			this.list.set(idx, data);
			uphepify(idx);
			downheapify(idx);

		}

		private void uphepify(int ci) {
			if (ci == 0) {
				return;
			}

			int pi = (ci - 1) >> 1;
			if (compareTo(ci, pi) > 0) {
				swap(ci, pi);
				uphepify(pi);
			}
		}

		public void downheapify(int pi) {
			int max = pi;

			int lci = (pi << 1) + 1;
			int rci = (pi << 1) + 2;

			if (lci < list.size() && compareTo(lci, max) > 0) {
				max = lci;
			}

			if (rci < list.size() && compareTo(rci, max) > 0) {
				max = rci;
			}
			if (max != pi) {
				swap(pi, max);
				downheapify(max);
			}
		}

		private int compareTo(int i, int j) {
			int ith = list.get(i);
			int jth = list.get(j);

			if (priority) {
				return ith - jth;
			} else {
				return jth - ith;
			}
		}

		// General.==============================================================

		private void displayAsTree() {
			int pi = 0;
			StringBuilder sb = new StringBuilder();
			while (pi < list.size()) {

				int lci = 2 * pi + 1;
				int rci = 2 * pi + 2;

				sb.append(lci < list.size() ? list.get(lci) : -1);
				sb.append(" => " + list.get(pi) + " <= ");
				sb.append(rci < list.size() ? list.get(rci) : -1);
				sb.append("\n");
				pi++;
			}

			System.out.println(sb.toString());
		}

		private void swap(int ci, int pi) {
			int cdata = list.get(ci);
			int pdata = list.get(pi);

			list.set(ci, pdata);
			list.set(pi, cdata);
		}

		public int Find(int data) {
			int idx = -1;
			for (int i = 0; i < list.size(); i++) {
				if (data == list.get(i)) {
					idx = i;
				}
			}

			return idx;
		}

		public int size() {
			return list.size();
		}

		public boolean isEmpty() {
			return (list.size() == 0);
		}

	}

}
