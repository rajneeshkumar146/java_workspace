package Dec16_to_20_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MaxFlow_FordFulkerson {
	public static Scanner scn = new Scanner(System.in);

	private static HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
	private static int flow = 0;

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		// Vertices

		graph.put("A", new HashMap<String, Integer>());
		graph.put("B", new HashMap<String, Integer>());
		graph.put("C", new HashMap<String, Integer>());
		graph.put("D", new HashMap<String, Integer>());
		graph.put("S", new HashMap<String, Integer>());
		graph.put("T", new HashMap<String, Integer>());

		// Edge
		graph.get("S").put("A", 10);
		graph.get("A").put("S", 0);

		graph.get("S").put("C", 8);
		graph.get("C").put("S", 0);

		graph.get("A").put("C", 2);
		graph.get("C").put("A", 0);
 
		graph.get("A").put("B", 5);
		graph.get("B").put("A", 0);

		graph.get("C").put("D", 10);
		graph.get("D").put("C", 0);

		graph.get("D").put("T", 10);
		graph.get("T").put("D", 0);

		graph.get("D").put("B", 8);
		graph.get("B").put("D", 0);

		graph.get("B").put("T", 7);
		graph.get("T").put("B", 0);

		while (true) {
			HashSet<String> isdone = new HashSet<>();
			int localmcap = hasPath("S", "T", Integer.MAX_VALUE, isdone); // localMinimumCapacity.
			if (localmcap == -1) {
				break;
			}

		}
		System.out.println(flow);
	}

	public static int hasPath(String v1name, String v2name, int mcap, HashSet<String> isdone) {
		isdone.add(v1name);

		if (v1name.equals(v2name)) {
			flow += mcap;
			return mcap;
		}

		ArrayList<String> nbrnames = new ArrayList<String>(graph.get(v1name).keySet());
		for (String nbrname : nbrnames) {
			if (!isdone.contains(nbrname) && graph.get(v1name).get(nbrname) > 0) {
				int Capacity = graph.get(v1name).get(nbrname);
				int revCapacity = graph.get(nbrname).get(v1name);
				int localmcap = hasPath(nbrname, v2name, Math.min(mcap, Capacity), isdone);
				if (localmcap != -1) {
					graph.get(v1name).put(nbrname, Capacity - localmcap);
					graph.get(nbrname).put(v1name, revCapacity + localmcap);
					return localmcap;
				}
			}
		}
		return -1;
	}
}
