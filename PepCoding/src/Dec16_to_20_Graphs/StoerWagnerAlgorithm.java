package Dec16_to_20_Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class StoerWagnerAlgorithm {
	public static Scanner scn = new Scanner(System.in);

	private static HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();

	public static void main(String[] args) throws Exception {
		solve();
	}

	private static void solve() throws Exception {
		// Vertices

		graph.put("A", new HashMap<String, Integer>());
		graph.put("B", new HashMap<String, Integer>());
		graph.put("C", new HashMap<String, Integer>());
		graph.put("D", new HashMap<String, Integer>());
		graph.put("E", new HashMap<String, Integer>());
		graph.put("F", new HashMap<String, Integer>());

		// Edge
		graph.get("A").put("B", 6);
		graph.get("B").put("A", 6);

		graph.get("B").put("D", 3);
		graph.get("D").put("B", 3);

		graph.get("B").put("C", 8);
		graph.get("C").put("B", 8);

		graph.get("D").put("E", 20);
		graph.get("E").put("D", 20);

		graph.get("C").put("E", 1);
		graph.get("E").put("C", 1);

		graph.get("D").put("F", 5);
		graph.get("F").put("D", 5);

		graph.get("E").put("F", 2);
		graph.get("F").put("E", 2);

		PhaseSTMinCutPair globalMinCut = new PhaseSTMinCutPair();
		globalMinCut.value = Integer.MAX_VALUE;

		while (graph.size() > 1) {
			PhaseSTMinCutPair phaseMincut = MinCutPhase();
			System.out.println(phaseMincut.value + "=>" + phaseMincut.edges);
			if (phaseMincut.value < globalMinCut.value) {
				globalMinCut = phaseMincut;
			}
			
		}

		System.out.println();
		System.out.println(globalMinCut.value + "=>" + globalMinCut.edges);

	}

	private static PhaseSTMinCutPair MinCutPhase() throws Exception {
		HashMap<String, PhaseSTMinCutPair> objMap = new HashMap<String, PhaseSTMinCutPair>();
		HashSet<String> Aqvtces = new HashSet<String>();
		GenericHeap<PhaseSTMinCutPair> heap = new GenericHeap<PhaseSTMinCutPair>(PhaseSTMinCutPair.ctor);

		boolean flag = false;
		ArrayList<String> vnames = new ArrayList<String>(graph.keySet());
		for (String vname : vnames) {
			PhaseSTMinCutPair pair = new PhaseSTMinCutPair();
			pair.vname = vname;
			objMap.put(vname, pair);
			if (flag == false) {
				pair.inHeap = true;
				heap.add(pair);
				flag = true;
			}
		}

		PhaseSTMinCutPair slast = null;
		PhaseSTMinCutPair last = null;

		while (Aqvtces.size() != graph.size()) {

			PhaseSTMinCutPair rp = heap.remove();
			rp.inHeap = false;

			

			if (Aqvtces.size() == graph.size() - 2) {
				slast = rp;

			} else if (Aqvtces.size() == graph.size() - 1) {
				last = rp;
			}
			
			Aqvtces.add(rp.vname);

			ArrayList<String> keys = new ArrayList<String>(graph.get(rp.vname).keySet());
			for (String key : keys) {
				if (Aqvtces.contains(key)) {
					continue;
				}

				PhaseSTMinCutPair operation = objMap.get(key);
				if (operation.inHeap) {
					operation.value += graph.get(rp.vname).get(key);
					operation.edges.add(operation.vname + key);
					heap.update(operation);

				} else {
					operation.value = graph.get(rp.vname).get(key);
					operation.edges.add(rp.vname + key);
					operation.inHeap = true;
					heap.add(operation);
				}

				
			}

		}
		
		merging(slast, last);

		return last;

	}

	private static void merging(PhaseSTMinCutPair slast, PhaseSTMinCutPair last) {

		String nvtx = slast.vname + last.vname;
		graph.put(nvtx, new HashMap<String, Integer>());
		ArrayList<String> nbrOfSlast = new ArrayList<String>(graph.get(slast.vname).keySet());
		for (String vname : nbrOfSlast) {
			if (vname.equals(last.vname)) {
				continue;
			}

			int weight = graph.get(slast.vname).get(vname);
			if (graph.get(nvtx).containsKey(vname)) {
				int prevWeight = graph.get(nvtx).get(vname);
				graph.get(nvtx).put(vname, prevWeight + weight);
				graph.get(vname).put(nvtx, prevWeight + weight);
			} else {
				graph.get(nvtx).put(vname, weight);
				graph.get(vname).put(nvtx, weight);
			}

			graph.get(slast.vname).remove(vname);
			graph.get(vname).remove(slast.vname);

		}

		ArrayList<String> nbrOfLast = new ArrayList<String>(graph.get(last.vname).keySet());
		for (String vname : nbrOfLast) {
			if (vname.equals(slast.vname)) {
				continue;
			}

			int weight = graph.get(last.vname).get(vname);
			if (graph.get(nvtx).containsKey(vname)) {
				int prevWeight = graph.get(nvtx).get(vname);
				graph.get(nvtx).put(vname, prevWeight + weight);
				graph.get(vname).put(nvtx, prevWeight + weight);

			} else {
				graph.get(nvtx).put(vname, weight);
				graph.get(vname).put(nvtx, weight);
			}

			graph.get(last.vname).remove(vname);
			graph.get(vname).remove(last.vname);

		}

		graph.remove(last.vname);
		graph.remove(slast.vname);

	}

	private static class PhaseSTMinCutPair {
		private String vname;
		private int value;
		private ArrayList<String> edges = new ArrayList<String>();
		private boolean inHeap;

		private static final GlobalMinCutComparator ctor = new GlobalMinCutComparator();

		private static class GlobalMinCutComparator implements Comparator<PhaseSTMinCutPair> {

			@Override
			public int compare(PhaseSTMinCutPair o1, PhaseSTMinCutPair o2) {

				return o1.value - o2.value;
			}

		}

	}

}
