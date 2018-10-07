package Dec16_to_20_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class STMinCut_FordFulkerson {
	static HashMap<String, HashMap<String, Integer>> graph = new HashMap<String, HashMap<String, Integer>>();
	static HashSet<String> isdone = new HashSet<String>();
	static HashMap<String, HashMap<String, Integer>> rgraph = new HashMap<String, HashMap<String, Integer>>();

	public static void main(String[] args) {

		// vertices
		graph.put("A", new HashMap<String, Integer>());
		graph.put("B", new HashMap<String, Integer>());
		graph.put("C", new HashMap<String, Integer>());
		graph.put("D", new HashMap<String, Integer>());
		graph.put("S", new HashMap<String, Integer>());
		graph.put("T", new HashMap<String, Integer>());

		rgraph.put("A", new HashMap<String, Integer>());
		rgraph.put("B", new HashMap<String, Integer>());
		rgraph.put("C", new HashMap<String, Integer>());
		rgraph.put("D", new HashMap<String, Integer>());
		rgraph.put("S", new HashMap<String, Integer>());
		rgraph.put("T", new HashMap<String, Integer>());

		// edges
		graph.get("S").put("A", 10);
		graph.get("S").put("C", 8);
		graph.get("A").put("C", 2);
		graph.get("A").put("B", 5);
		graph.get("C").put("D", 10);
		graph.get("D").put("T", 10);
		graph.get("D").put("B", 8);
		graph.get("B").put("T", 7);

		// redges
		rgraph.get("S").put("A", 10);
		rgraph.get("A").put("S", 0);

		rgraph.get("S").put("C", 8);
		rgraph.get("C").put("S", 0);

		rgraph.get("A").put("C", 2);
		rgraph.get("C").put("A", 0);

		rgraph.get("A").put("B", 5);
		rgraph.get("B").put("A", 0);

		rgraph.get("C").put("D", 10);
		rgraph.get("D").put("C", 0);

		rgraph.get("D").put("T", 10);
		rgraph.get("T").put("D", 0);

		rgraph.get("D").put("B", 8);
		rgraph.get("B").put("D", 0);

		rgraph.get("B").put("T", 7);
		rgraph.get("T").put("B", 0);

		int flow = 0;
		while (true) {
			isdone = new HashSet<String>();
			int pathFlow = fordFulkerson("S", "T", Integer.MAX_VALUE);
			flow += pathFlow;
			if (pathFlow == 0) {
				break;
			}
		}
		System.out.println(flow);

		int mincut = 0;
		isdone = new HashSet<String>();
		dft("S");
		ArrayList<String> rachables = new ArrayList<>(isdone);
		for (String reached : rachables) {

			ArrayList<String> keys = new ArrayList<>(graph.get(reached).keySet());
			for (String key : keys) {
				if (!isdone.contains(key)) {
					mincut += graph.get(reached).get(key);
					System.out.println(reached + "-" + key + "=>" + mincut);
				}
			}
		}
		System.out.println(mincut);
	}

	public static int fordFulkerson(String v1name, String v2name, int mcap) {
		isdone.add(v1name);

		if (v1name.equals(v2name)) {
			return mcap;
		}

		ArrayList<String> nbrnames = new ArrayList<String>(rgraph.get(v1name).keySet());
		for (String nbrname : nbrnames) {
			if (!isdone.contains(nbrname) && rgraph.get(v1name).get(nbrname) > 0) {
				int cap = rgraph.get(v1name).get(nbrname);
				int revcap = rgraph.get(nbrname).get(v1name);
				int localmcap = fordFulkerson(nbrname, v2name, Math.min(mcap, cap));
				if (localmcap != 0) {
					rgraph.get(v1name).put(nbrname, cap - localmcap);
					rgraph.get(nbrname).put(v1name, revcap + localmcap);
					return localmcap;
				}
			}
		}

		return 0;
	}

	private static void dft(String vname) {
		LinkedList<String> st = new LinkedList<String>();
		st.addFirst(vname);

		while (!st.isEmpty()) {
			String rv = st.removeFirst();
			if (isdone.contains(rv)) {
				continue;
			}

			isdone.add(rv);

			ArrayList<String> keys = new ArrayList<String>(rgraph.get(rv).keySet());
			for (String key : keys) {
				if (!isdone.contains(key) && rgraph.get(rv).get(key) > 0) {
					st.addFirst(key);
				}
			}
		}

	}
}
