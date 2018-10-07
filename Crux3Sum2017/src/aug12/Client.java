package aug12;

public class Client {

	public static void main(String[] args) {
		Graph g = new Graph();
		
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("E");
		g.addVertex("D");
		g.addVertex("C");
		g.addVertex("F");
		g.addVertex("G");
		
		g.addEdge("A", "B", 10);
		g.addEdge("A", "D", 40);
		g.addEdge("B", "E", 10);
		g.addEdge("E", "D", 10);
		g.addEdge("D", "C", 2);
		g.addEdge("C", "F", 3);
		g.addEdge("C", "G", 8);
		g.addEdge("F", "G", 3);
		
		g.display();
		
		System.out.println(g.gcc());
	}

}
