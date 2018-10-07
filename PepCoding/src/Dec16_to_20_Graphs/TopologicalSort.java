package Dec16_to_20_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {

		HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();

		// Vertices
		graph.put("A", new HashMap<String, Integer>());
		graph.put("B", new HashMap<String, Integer>());
		graph.put("C", new HashMap<String, Integer>());
		graph.put("D", new HashMap<String, Integer>());
		graph.put("E", new HashMap<String, Integer>());
		graph.put("F", new HashMap<String, Integer>());

		// edge
		graph.get("A").put("C", 5);
		graph.get("A").put("F", 10);
		graph.get("B").put("F", 3);
		graph.get("B").put("E", 1);
		graph.get("D").put("E", 1);
		graph.get("C").put("D", 1);

		// FirstStep-----------------------------------------------------------------------------------------------
		HashMap<String, Boolean> isdone = new HashMap<>();
		LinkedList<String> ll = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(graph.keySet());
		for (String key : keys) {
			if (isdone.containsKey(key)) {
				continue;
			}
	
			topologicalsort(key, graph, isdone, ll);
		}

		System.out.println(ll);
	}

	public static void topologicalsort(String v1name, HashMap<String, HashMap<String, Integer>> graph,
			HashMap<String, Boolean> isdone, LinkedList<String> ll) {

		ArrayList<String> keys = new ArrayList<String>(graph.get(v1name).keySet());

		if (isdone.containsKey(v1name)) {
			return;
		}
		isdone.put(v1name, true);

		for (String key : keys) {
			topologicalsort(key, graph, isdone, ll);
		}
		ll.addFirst(v1name);
	}

}
