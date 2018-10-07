package july29;

import java.util.ArrayList;

public class Heap {
	private ArrayList<Integer> data = new ArrayList<>();
	private boolean ismin;
	
	public Heap(boolean ismin){
		this.ismin = ismin;
	}
	
	public Heap(boolean ismin, int[] arr){
		this.ismin = ismin;
		
		for(int val: arr){
			data.add(val);
		}
		
		for(int i = data.size() - 1; i >= 0; i--){
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
	
	public void add(int value){
		data.add(value);
		upheapify(data.size() - 1);
	}
	
	private void upheapify(int ci) {
		if(ci == 0){
			return;
		}
		
		int pi = (ci - 1)/ 2;
		
		if(isLarger(ci, pi) == true){
			swap(ci, pi);
			upheapify(pi);
		}
	}

	public int removeHP(){
		swap(0, data.size() - 1);
		int rv = data.remove(data.size() - 1);
		
		downheapify(0);
		
		return rv;
	}
	
	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		
		int max = pi;
		
		if(lci < data.size() && isLarger(lci, max) == true){
			max = lci;
		}
		
		if(rci < data.size() && isLarger(rci, max) == true){
			max = rci;
		}
		
		if(max != pi){
			swap(pi, max);
			downheapify(max);
		}
	}

	public int getHP(){
		return data.get(0);
	}

	private boolean isLarger(int i, int j){
		int ith = data.get(i);
		int jth = data.get(j);
		
		if(ismin){
			if(ith < jth){
				return true;
			} else {
				return false;
			}
		} else {
			if(ith > jth){
				return true;
			} else {
				return false;
			}
		}
	}
	
	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		
		data.set(i, jth);
		data.set(j, ith);
	}
	
	
	
}
