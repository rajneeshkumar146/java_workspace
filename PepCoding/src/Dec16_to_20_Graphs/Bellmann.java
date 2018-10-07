package Dec16_to_20_Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class Bellmann {

	public static void main(String[] args) {

		ArrayList<String> Vertexs = new ArrayList<String>();
		ArrayList<Bellmann.Edge> GraphEdge = new ArrayList<Bellmann.Edge>();

		Vertexs.add("A");
		Vertexs.add("B");
		Vertexs.add("C");
		Vertexs.add("D");

		GraphEdge.add(new Edge("A", "D", 8));
		GraphEdge.add(new Edge("A", "B", 3));
		GraphEdge.add(new Edge("C", "A", -5));
		GraphEdge.add(new Edge("C", "D", 2));
		GraphEdge.add(new Edge("B", "C", 1));

		HashMap<String, Bellmann.Bfpair> result = new HashMap<>();
		String src = "A";
		for (String vname : Vertexs) {
			Bfpair bp = new Bfpair();
			if (src.equals(vname)) {
				bp.psf = vname;
				bp.csf = 0;
			} else {
				bp.psf = null;
				bp.csf = Integer.MAX_VALUE;
			}

			result.put(vname, bp);

		}

		for (int i = 1; i <= Vertexs.size() - 1; i++) {
			for (Edge edge : GraphEdge) {
				Bfpair spair = result.get(edge.v1name);
				Bfpair dpair = result.get(edge.v2name);
				int weight = edge.weight;

				if (spair.psf == null) {
					continue;
				}

				if (spair.csf + weight < dpair.csf) {
					dpair.csf = spair.csf + weight;
					dpair.psf = spair.psf + edge.v2name;
				}

			}
		}

		for (Edge edge : GraphEdge) {
			Bfpair spair = result.get(edge.v1name);
			Bfpair dpair = result.get(edge.v2name);
			int weight = edge.weight;

			if (spair.psf == null) {
				continue;
			}

			if (spair.csf + weight < dpair.csf) {
				System.out.print("Cycle");
				return;
			}

		}

		System.out.println(result);

	}

	private static class Edge {
		private String v1name;
		private String v2name;
		private int weight;

		public Edge(String v1, String v2, int w) {
			this.v1name = v1;
			this.v2name = v2;
			this.weight = w;
		}

	}

	private static class Bfpair {
		private String psf;
		private int csf;

		@Override
		public String toString() {
			return "[" + this.psf + " via " + this.csf + "]";
		}

	}

}
