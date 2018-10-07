package aug1;

import java.util.HashSet;
import java.util.LinkedList;

public class topologicalSort {

	public static void main(String[] args) {
		int[][] graph = new int[7][7];
		
		graph[0][1] = 10;
		graph[1][2] = 10;
		graph[2][3] = 10;
		graph[0][4] = 10;
		graph[5][4] = 10;
		graph[5][6] = 10;
		graph[6][3] = 10;
		
		topologicalSort(graph);
	}
	
	public static void topologicalSort(int[][] graph){
		HashSet<Integer> visited = new HashSet<>();
		LinkedList<Integer> stack = new LinkedList<>();
		
		for(int vtx = 0; vtx < graph.length; vtx++){
			if(visited.contains(vtx) == false){
				topologicalSortComponent(graph, vtx, visited, stack);
			}
		}
		
		System.out.println(stack);
	}
	
	private static void topologicalSortComponent(int[][] graph, 
												 int src, 
												 HashSet<Integer> visited,
												 LinkedList<Integer> stack){
		visited.add(src);
		
		for(int nbr = 0; nbr < graph.length; nbr++){
			if(graph[src][nbr] != 0 && visited.contains(nbr) == false){
				topologicalSortComponent(graph, nbr, visited, stack);
			}
		}
		
		stack.addFirst(src);
	}

}
