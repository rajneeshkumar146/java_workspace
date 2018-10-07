package aug1;

import java.util.HashMap;

public class Client {

	public static void main(String[] args) {
		Graph g = new Graph();
		
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("P");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");

		g.addEdge("A", "B", 10);
		g.addEdge("A", "P", 40);
		g.addEdge("B", "C", 10);
		g.addEdge("C", "P", 10);
		g.addEdge("P", "E", 2);
		g.addEdge("E", "F", 3);
		g.addEdge("E", "G", 8);
		g.addEdge("F", "G", 3);
		
		g.djikstra("A");
		Graph mst = g.prims();
		mst.display();
		
//		System.out.println(g.hasPath("A", "G"));
//		g.removeEdge("D", "E");
//		System.out.println(g.hasPath("A", "G"));
//		g.printShortestPath1("A", "G");
//		g.multisolver("A", "G", 2, 40);
//		System.out.println(g.bfs("A", "G"));
//		g.dft();
//		System.out.println(g.IsConnected() + " " + g.IsCyclic() + " " + g.gcc());
	}

}
