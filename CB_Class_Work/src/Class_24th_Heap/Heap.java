package Class_24th_Heap;

import java.util.ArrayList;

public class Heap {

	private ArrayList<Integer> data = new ArrayList<>();

	private boolean ismin;

	public Heap(boolean ismin) {
		this.ismin = ismin;
	}

	public Heap() {
		this.ismin = true;
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}

	public void display() {
		System.out.print(this.data);
	}

	public void add(int value) {
		this.data.add(value);

		int ci = this.data.size() - 1;
		this.upheapify(ci);

	}

	private void upheapify(int ci) {
		if (ci == 0) {
			return;
		}

		int pi = (ci - 1) / 2;
		if (this.islarger(ci, pi) == true) {
			this.swap(ci, pi);
			upheapify(pi);
		}

	}

	public int removeHP() {

		int rv = data.get(0);
		this.swap(0, this.data.size() - 1);
		data.remove(data.size() - 1);
		this.downheapify(0);

		return rv;

	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int max = pi;

		if (lci < data.size() && this.islarger(lci, max)) {
			max = lci;
		}

		if (rci < data.size() && this.islarger(rci, max)) {
			max = rci;
		}

		if (max != pi) {
			swap(max, pi);
			downheapify(max);
		}
	}

	private boolean islarger(int ci, int pi) {
		int cidata = data.get(ci);
		int pidata = data.get(pi);

		if (this.ismin) {
			if (cidata < pidata) {
				return true;
			} else {
				return false;
			}
		} else {
			if (cidata > pidata) {
				return true;
			} else {
				return false;
			}
		}
	}

	private void swap(int ci, int pi) {
		int cidata = data.get(ci);
		int pidata = data.get(pi);

		data.set(ci, pidata);
		data.set(pi, cidata);
	}

	public void display2() {
		display2(0);

	}

	private void display2(int pi) {

		while (pi < data.size()) {
			String str = new String();
			str = "";
			int lci = 2 * pi + 1;
			int rci = 2 * pi + 2;

			if (lci < data.size()) {
				str += data.get(lci);
				str += "=>";
			} else {
				str += ".";
				str += "=>";

			}

			str += data.get(pi);

			if (rci < data.size()) {
				str += "<=";
				str += data.get(rci);
			} else {
				str += "<=";
				str += ".";
			}

			System.out.println(str);
			pi++;

		}
	}

	public Heap(int[] arr, boolean ismin) {
		this.ismin = ismin;

		for (int i = 0; i < arr.length; i++) {
			this.data.add(arr[i]);
		}

		for (int i = data.size() / 2 - 1; i >= 0; i--) {
			this.downheapify(i);
		}
	}

}
