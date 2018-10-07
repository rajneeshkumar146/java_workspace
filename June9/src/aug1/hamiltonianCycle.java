package aug1;

import java.util.HashSet;

public class hamiltonianCycle {

	public static void main(String[] args) {
		int[][] graph = new int[7][7];
		
		addEdge(graph, 0, 1, 10);
		addEdge(graph, 1, 2, 10);
		addEdge(graph, 2, 3, 10);
		addEdge(graph, 0, 3, 40);
		addEdge(graph, 3, 4, 2);
		addEdge(graph, 4, 5, 3);
		addEdge(graph, 4, 6, 8);
		addEdge(graph, 5, 6, 3);
//		addEdge(graph, 2, 5, 1);
		
//		printAllPaths(0, 6, graph, new HashSet<>(), "0");
		hamiltonian(3, graph, new HashSet<>(), "3", 3);
	}
	
	private static void addEdge(int[][] graph, int i, int j, int wt){
		graph[i][j] = wt;
		graph[j][i] = wt;
	}
	
	private static void printAllPaths(int src, int dest, 
							   int[][] graph, 
							   HashSet<Integer> visited, 
							   String psf){
		if(src == dest){
			System.out.println(psf);
			return;
		}
		
		visited.add(src);
		
		for(int nbr = 0; nbr < graph.length; nbr++){
			if(graph[src][nbr] != 0){ // real nbr
				if(visited.contains(nbr) == false){ // unvisted nbr
					printAllPaths(nbr, dest, graph, visited, psf + nbr);
				}
			}
		}
		
		visited.remove(src);
	}

	private static void hamiltonian(int src, int[][] graph, 
									HashSet<Integer> visited, 
									String psf, int osrc){
		if(visited.size() == graph.length - 1){
			System.out.print(psf + " is a hp");
			if(graph[src][osrc] != 0){
				System.out.println(" and a cycle.");
			} else {
				System.out.println(".");
			}
			return;
		}
		
		visited.add(src);
		
		for(int nbr = 0; nbr < graph.length; nbr++){
			if(graph[src][nbr] != 0 && visited.contains(nbr) == false){
				hamiltonian(nbr, graph, visited, psf + nbr, osrc);
			}
		}
		
		visited.remove(src);
	}
}
