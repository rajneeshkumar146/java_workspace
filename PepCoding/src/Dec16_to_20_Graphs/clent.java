package Dec16_to_20_Graphs;

public class clent {

	public static void main(String[] args) throws Exception {

		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");

		// g.addEdge("A", "B", 10);
		// g.addEdge("A", "D", 40);
		// g.addEdge("B", "C", 10);
		// g.addEdge("C", "D", 10);
		// g.addEdge("D", "E", 2);
		// g.addEdge("E", "F", 3);
		// g.addEdge("E", "G", 8);
		// g.addEdge("F", "G", 3);

		g.addEdge("D", "A", 5);
		g.addEdge("A", "B", 7);
		g.addEdge("B", "C", 8);
		g.addEdge("C", "E", 5);
		g.addEdge("E", "G", 9);
		g.addEdge("E", "F", 8);
		g.addEdge("G", "F", 11);
		g.addEdge("F", "D", 6);
		g.addEdge("D", "E", 15);
		g.addEdge("D", "B", 9);
		g.addEdge("B", "E", 7);

		g.display();
		System.out.println();
		// g.haspathDisplay("A", "G");
		// g.haspathDisplayall("A", "G");
		// g.preOderDisplay("A");
		// g.postOderDisplay("A");

		// System.out.println(g.BFSIrr("A", "G") + "\n");
		// System.out.println(g.DFSIrr("A", "G"));
		// System.out.println(g.IsCyclic());
		// g.GCC();
		// System.out.println(g.DijkstraPair("A"));
		Graph gp1 = g.PrimsMST("A");
		gp1.display();
		System.out.println();
		Graph gp = g.Kruskal();
		gp.display();
	}

}
