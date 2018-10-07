package Dec16_to_20_Graphs;

import java.util.Scanner;

public class ArticulationEdge {
	static boolean[][] graph;
	static ArticulationEdgePair[] result;

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int v = scn.nextInt();
		int e = scn.nextInt();

		graph = new boolean[v][v];
		result = new ArticulationEdgePair[v];

		for (int i = 1; i <= e; i++) {
			int x = scn.nextInt();
			int y = scn.nextInt();

			graph[x][y] = true;
			graph[y][x] = true;
		}

		for (int i = 0; i < v; i++) {
			ArticulationEdgePair pair = new ArticulationEdgePair();
		}

		for (int i = v - 1; i >= 0; i--) {
			if (result[i].proccessed) {
				continue;
			}

			DFT(i, 0);
		}

	}

	private static void DFT(int currv, int time) {

		result[currv].proccessed = true;
		result[currv].low = result[currv].disc = time;
		for (int i = 0; i < graph.length; i++) {
			if (graph[currv][i] == true) {

				// Case-I_Fresh_Nbr.

				if (!result[i].proccessed) {
					result[i].parent = currv;
					DFT(i, time + 1);
					result[currv].low = Math.min(result[i].low, result[currv].low);

					if (result[i].low > result[currv].disc) {
						System.out.println(i + " => " + currv);
					}

				}

				// Case-II_proessed_Non_Parent.

				else if (result[currv].parent != i) {
					result[currv].low = Math.min(result[i].disc, result[currv].low);
				}

			}
		}

	}

	private static class ArticulationEdgePair {
		private int low;
		private int disc;
		private int parent = -1;
		boolean proccessed;

	}
}
