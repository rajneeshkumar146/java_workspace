package Dec16_to_20_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class DinicAlgo {
	static HashMap<String, HashMap<String, Integer>> rgraph;
	static HashMap<String, HashMap<String, Integer>> lgraph;
	static HashMap<String, Integer> lgraphLevels;
	static HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();

	public static void main(String[] args) {
		rgraph = new HashMap<String, HashMap<String, Integer>>();
		lgraph = new HashMap<String, HashMap<String, Integer>>();
		lgraphLevels = new HashMap<String, Integer>();

		// vertices
		rgraph.put("S", new HashMap<String, Integer>());
		rgraph.put("A", new HashMap<String, Integer>());
		rgraph.put("B", new HashMap<String, Integer>());
		rgraph.put("C", new HashMap<String, Integer>());
		rgraph.put("D", new HashMap<String, Integer>());
		rgraph.put("T", new HashMap<String, Integer>());

		// edges
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

		int oflow = 0;
		while (true) {
			lgraph = new HashMap<String, HashMap<String, Integer>>();
			lgraphLevels = new HashMap<String, Integer>();
			boolean levelGHasPath = createLevelGraphFromRGraph();

			if (levelGHasPath == false) {
				break;
			}

			while (true) {
				isdone = new HashMap<String, Boolean>();
				int totalflow = getFlowFromPath("S", "T", Integer.MAX_VALUE);
				if (totalflow != 0) {
					oflow += totalflow;
				} else {
					break;
				}
			}
		}

		System.out.println(oflow);
	}

	private static int getFlowFromPath(String v1name, String v2name, int mcap) {
		isdone.put(v1name, true);

		if (v1name.equals(v2name)) {
			return mcap;
		}

		ArrayList<String> nbrnames = new ArrayList<String>(rgraph.get(v1name).keySet());
		for (String nbrname : nbrnames) {
			if (!isdone.containsKey(nbrname) && rgraph.get(v1name).get(nbrname) > 0
					&& lgraphLevels.get(nbrname) == lgraphLevels.get(v1name) + 1) {
				int cap = rgraph.get(v1name).get(nbrname);
				int revcap = rgraph.get(nbrname).get(v1name);
				int localmcap = getFlowFromPath(nbrname, v2name, Math.min(mcap, cap));
				if (localmcap != 0) {
					rgraph.get(v1name).put(nbrname, cap - localmcap);
					rgraph.get(nbrname).put(v1name, revcap + localmcap);
					return localmcap;
				}
			}
		}

		return 0;
	}

	private static boolean createLevelGraphFromRGraph() {
		boolean retVal = false;

		LinkedList<DinicPair> queue = new LinkedList<DinicAlgo.DinicPair>();
		HashMap<String, DinicPair> processed = new HashMap<String, DinicAlgo.DinicPair>();

		DinicPair pair = new DinicPair();
		pair.vname = "S";
		pair.psf = "S";
		pair.level = 0;
		pair.avname = "";

		queue.add(pair);
		while (queue.size() > 0) {
			DinicPair rp = queue.removeFirst();

			if (processed.containsKey(rp.vname)) {
				if (lgraphLevels.get(rp.vname) == rp.level) {
					lgraph.get(rp.avname).put(rp.vname, 0);
				}
				continue;
			}
			processed.put(rp.vname, rp);

			if (rp.vname.equals("T")) {
				retVal = true;
			}

			if (!lgraph.containsKey(rp.vname)) {
				lgraph.put(rp.vname, new HashMap<String, Integer>());
				lgraphLevels.put(rp.vname, rp.level);
			}
			if (!rp.avname.equals("")) {
				lgraph.get(rp.avname).put(rp.vname, 0);
			}

			ArrayList<String> nbrnames = new ArrayList<String>(rgraph.get(rp.vname).keySet());
			for (String nbrname : nbrnames) {
				if (!processed.containsKey(nbrname) && rgraph.get(rp.vname).get(nbrname) > 0) {
					DinicPair np = new DinicPair();
					np.vname = nbrname;
					np.psf = rp.psf + nbrname;
					np.level = rp.level + 1;
					np.avname = rp.vname;
					queue.add(np);
				}
			}
		}

		return retVal;
	}

	static class DinicPair {
		String vname;
		String psf;
		String avname;
		int level;
	}

}
