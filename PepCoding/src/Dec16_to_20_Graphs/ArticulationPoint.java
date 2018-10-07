package Dec16_to_20_Graphs;

import java.util.Scanner;

public class ArticulationPoint {

	static boolean[][] graph;
	static ArticulationPair[] result;

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int v = scn.nextInt();
		int e = scn.nextInt();

		graph = new boolean[v][v];
		result = new ArticulationPair[v];

		for (int i = 1; i <= e; i++) {
			int x = scn.nextInt();
			int y = scn.nextInt();

			graph[x][y] = true;
			graph[y][x] = true;
		}

		for (int i = 0; i < v; i++) {
			ArticulationPair pair = new ArticulationPair(i);
			result[i] = pair;
		}

		for (int i = 0; i < v; i++) {
			if (result[i].proccessed) {
				continue;
			}

			DFT(i, 0);
		}

		for (int i = 0; i < v; i++) {
			System.out.println(result[i].vert + " => " + result[i].isAP);
		}

	}

	private static void DFT(int currv, int time) {

		result[currv].proccessed = true;
		result[currv].low = result[currv].disc = time;
		int CountChildOfRoot = 0;
		for (int i = 0; i < graph.length; i++) {
			if (graph[currv][i] == true) {
				// Case-I_Fresh_Nbr.
				if (!result[i].proccessed) {
					result[i].parent = currv;
					CountChildOfRoot++;
					DFT(i, time + 1);
					result[currv].low = Math.min(result[i].low, result[currv].low);

					if (result[currv].parent != -1) {
						if (result[i].low >= result[currv].disc) {
							result[currv].isAP = true;
						}
					} else {
						if (CountChildOfRoot > 1) {
							result[currv].isAP = true;
						}
					}
				}

				// Case-II_proessed_Non_Parent.

				else if (result[currv].parent != i) {
					result[currv].low = Math.min(result[i].disc, result[currv].low);
				}

			}
		}

	}

	private static class ArticulationPair {
		private int vert;
		private int low;
		private int disc;
		private boolean isAP;
		private int parent = -1;
		boolean proccessed;

		public ArticulationPair(int vert) {
			this.vert = vert;
		}

	}

}
