package july30;

import java.util.ArrayList;

public class Heap {
	// for true larger value has a higher priority
	// for false smaller value has a higher priority
	private boolean priorityFlag;
	private ArrayList<Integer> data = new ArrayList<>();

	public Heap(boolean priorityFlag) {
		this.priorityFlag = priorityFlag;
	}

	public Heap(boolean priorityFlag, int[] arr){
		this.priorityFlag = priorityFlag;
		
		// O(n)
		for(int val: arr){
			data.add(val);
		}
		
		for(int i = arr.length - 1; i >= 0; i--){
			downheapify(i);
		}
	}
	
	public int size(){
		return data.size();
	}
	
	public boolean isEmpty(){
		return data.isEmpty();
	}
	
	public void display(){
		System.out.println(data);
	}
	
	// logn
	public void add(int val) {
		data.add(val);
		upheapify(data.size() - 1);
	}

	private void upheapify(int ci) {
		if (ci == 0) {
			return;
		}

		int pi = (ci - 1) / 2;
		if (compareTo(ci, pi) > 0) {
			swap(ci, pi);
			upheapify(pi);
		}
	}

	// logn -> highest priority value
	public int remove() {
		swap(0, data.size() - 1);

		int rv = data.remove(data.size() - 1);
		downheapify(0);

		return rv;
	}

	private void downheapify(int pi) {
		int maxi = pi;

		int lci = 2 * pi + 1;
		if (lci < data.size() && compareTo(lci, maxi) > 0) {
			maxi = lci;
		}

		int rci = 2 * pi + 2;
		if (rci < data.size() && compareTo(rci, maxi) > 0) {
			maxi = rci;
		}

		if (pi != maxi) {
			swap(pi, maxi);
			downheapify(maxi);
		}
	}

	// o1 -> highest priority value
	public int peek() {
		return data.get(0);
	}

	// i > j returns > 0
	// i == j returns 0
	// i < j return < 0
	private int compareTo(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);

		if (priorityFlag) {
			return ith - jth;
		} else {
			return jth - ith;
		}
	}

	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);
	}
}
