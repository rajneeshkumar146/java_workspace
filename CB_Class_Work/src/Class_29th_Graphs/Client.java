package Class_29th_Graphs;

public class Client {

	public static void main(String[] args) {

		Graphs g = new Graphs();
		g.addvertex("A");
		g.addvertex("B");
		g.addvertex("C");
		g.addvertex("D");
		g.addvertex("E");
		g.addvertex("F");
		g.addvertex("G");

		g.addEdge("A", "B", 10);
		g.addEdge("A", "D", 40);
		g.addEdge("B", "C", 10);
		g.addEdge("C", "D", 10);
		g.addEdge("D", "E", 2);
		g.addEdge("E", "F", 3);
		g.addEdge("E", "G", 8);
		g.addEdge("F", "G", 3);

		g.display();

//		System.out.println(g.bfs("A", "G"));
//		System.out.println();
//		g.bft();
//		System.out.println();
//		g.dft();
//
//		System.out.println(g.IsConnected());
//		System.out.println(g.IsCyclic());
//		System.out.println(g.IsTree());
		
		System.out.println(g.djikstra("A"));
		
//		Graphs gp=g.PrimsPair("A");
//		gp.display();
		
		System.out.println(g.Isbipartite());

	}

}
