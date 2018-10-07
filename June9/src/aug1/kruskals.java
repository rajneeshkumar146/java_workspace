package aug1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class kruskals {

	public static void main(String[] args) {
		ArrayList<Edge> graph = new ArrayList<>();
		graph.add(new Edge("A", "B", 10));
		graph.add(new Edge("A", "D", 40));
		graph.add(new Edge("B", "C", 10));
		graph.add(new Edge("C", "D", 10));
		graph.add(new Edge("D", "E", 2));
		graph.add(new Edge("E", "F", 3));
		graph.add(new Edge("E", "G", 8));
		graph.add(new Edge("F", "G", 3));
		
		ArrayList<Edge> mst = kruskals(graph);
		for(Edge mste: mst){
			System.out.println(mste.v1 + " " + mste.v2 + " " + mste.weight);
		}
	}
	
	private static ArrayList<Edge> kruskals(ArrayList<Edge> graph){
		ArrayList<Edge> mstgraph = new ArrayList<>();
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(
								 Collections.reverseOrder());
		for(Edge edge: graph){
			pq.add(edge);
		}
		
		HashMap<String, Pair> disjointSets = new HashMap<>();
		for(Edge edge: graph){
			disjointSets.put(edge.v1, new Pair(1, edge.v1));
			disjointSets.put(edge.v2, new Pair(1, edge.v2));
		}
		
		while(pq.size() > 0){
			// 1. remove
			Edge re = pq.remove();
			
			// 2. find
			String v1set = find(re.v1, disjointSets);
			String v2set = find(re.v2, disjointSets);
			
			// 3. create edge and union of sets, 
			// if they belong to different sets
			if(v1set.equals(v2set) == false){
				// add edge to your mst
				mstgraph.add(re);
				
				// merge two sets
				merge(v1set, v2set, disjointSets);
			}
		}
		
		return mstgraph;
	}
	
	private static String find(String vtx, 
							   HashMap<String, Pair> disjointSets){
		Pair pp = disjointSets.get(vtx);
		
		if(vtx.equals(pp.vname)){
			return vtx;
		} else {
			pp.vname = find(pp.vname, disjointSets);
			return pp.vname;
		}
	}
	
	private static void merge(String v1set, String v2set, 
							  HashMap<String, Pair> disjointSets) {
		Pair v1setp = disjointSets.get(v1set);
		Pair v2setp = disjointSets.get(v2set);
		
		if(v1setp.size < v2setp.size){
			v2setp.size += v1setp.size;
			v1setp.vname = v2setp.vname;
			v1setp.size = -1;
		} else {
			v1setp.size += v2setp.size;
			v2setp.vname = v1setp.vname;
			v2setp.size = -1;
		}
	}

	private static class Pair {
		int size;
		String vname;
		
		Pair(int size, String parent){
			this.size = size;
			this.vname = parent;
		}
	}
	
	private static class Edge implements Comparable<Edge> {
		String v1;
		String v2;
		int weight;
		
		Edge(String v1, String v2, int weight){
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return o.weight - this.weight;
		}
	}

}
