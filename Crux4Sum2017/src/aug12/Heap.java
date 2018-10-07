package aug12;

import java.util.ArrayList;

public class Heap {
	private ArrayList<Integer> data = new ArrayList<>();
	
	public int size(){
		return data.size();
	}
	
	public boolean isEmpty(){
		return data.isEmpty();
	}
	
	public void display(){
		System.out.println(data);
	}
	
	public int getHP(){
		return data.get(0);
	}
	
	public void addHP(int value){
		data.add(value);
		this.upheaipfy(data.size() - 1);
	}
	
	private void upheaipfy(int ci) {
		int pi = (ci - 1) / 2;
		
		if(data.get(pi) > data.get(ci)){ // parent ki value jyada to priority kamm
			swap(pi, ci);
			upheaipfy(pi);
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
		int rci = lci + 1;
		
		int mini = pi;
		
		if(lci < data.size() && data.get(lci) < data.get(mini)){
			mini = lci;
		}
		
		if(rci < data.size() && data.get(rci) < data.get(mini)){
			mini = rci;
		}
		
		if(mini != pi){
			swap(mini, pi);
			downheapify(mini);
		}
	}

	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);
	}
}
