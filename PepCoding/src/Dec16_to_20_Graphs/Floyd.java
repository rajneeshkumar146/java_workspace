package Dec16_to_20_Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class Floyd {

	public static void main(String[] args) {

		HashMap<String, HashMap<String, Integer>> graph = new HashMap<String, HashMap<String, Integer>>();

		// Vertices
		graph.put("A", new HashMap<String, Integer>());
		graph.put("B", new HashMap<String, Integer>());
		graph.put("C", new HashMap<String, Integer>());
		graph.put("D", new HashMap<String, Integer>());

		// edge
		graph.get("A").put("B", 5);
		graph.get("A").put("D", 10);
		graph.get("B").put("C", 3);
		graph.get("C").put("D", 1);

		// result------------------------------------------------------------------------------------------------

		HashMap<String, HashMap<String, floydPair>> result = new HashMap<String, HashMap<String, floydPair>>();

		// FirstStep-----------------------------------------------------------------------------------------------

		ArrayList<String> vnames = new ArrayList<String>(graph.keySet());
		for (String srcvname : vnames) {
			result.put(srcvname, new HashMap<String, Floyd.floydPair>());
			for (String dvname : vnames) {
				floydPair pair = new floydPair();
				if (srcvname.equals(dvname)) {
					pair.psf = srcvname;
					pair.csf = 0;
				} else if (graph.get(srcvname).containsKey(dvname)) {
					pair.psf = srcvname + dvname;
					pair.csf = graph.get(srcvname).get(dvname);
				} else {
					pair.psf = null;
					pair.csf = Integer.MAX_VALUE;
				}

				result.get(srcvname).put(dvname, pair);
			}
		}

		// SecondStep------------------------------------------------------------------------------------------------

		for (String ivanme : vnames) {
			for (String svname : vnames) {
				for (String dvname : vnames) {
					if (svname.equals(ivanme) || ivanme.equals(dvname)) {
						continue;
					}
					floydPair s2d = result.get(svname).get(dvname);
					floydPair s2i = result.get(svname).get(ivanme);
					floydPair i2d = result.get(ivanme).get(dvname);

					if (s2i.psf == null || i2d.psf == null) {
						continue;
					} else if (s2i.csf + i2d.csf < s2d.csf) {
						s2d.csf = s2i.csf + i2d.csf;
						s2d.psf = s2i.psf + " => " + i2d.psf;
					}
				}
			}
		}

		System.out.println(result);

	}

	public static class floydPair {
		public String psf;
		public int csf;

		@Override
		public String toString() {
			return "[" + this.psf + " : " + this.csf + "]\n";
		}

	}

}
