package sept_01_2018.graph_001;

import java.util.Scanner;

public class Topic_002_ArtculationPointAndEdge {
	public static Scanner scn = new Scanner(System.in);

	static int[][] graph;
	static int[] discT, lowT, parent;
	static boolean[] isdone, isAP;
	static int time = 0;

	public static void main(String[] args) throws Exception {

		graph = new int[6][6];

		graph[0][1] = 1;
		graph[1][0] = 1;

		graph[0][5] = 1;
		graph[5][0] = 1;

		graph[1][3] = 1;
		graph[3][1] = 1;

		graph[1][2] = 1;
		graph[2][1] = 1;

		graph[3][4] = 1;
		graph[4][3] = 1;

		graph[3][2] = 1;
		graph[2][3] = 1;

		graph[2][4] = 1;
		graph[4][2] = 1;

		discT = new int[graph.length];
		lowT = new int[graph.length];
		parent = new int[graph.length];
		isdone = new boolean[graph.length];
		isAP = new boolean[graph.length];

		solve();
	}

	public static void solve() throws Exception {

		for (int i = 0; i < graph.length; i++) {
			if (isdone[i]) {
				continue;
			}

			parent[i] = -1;
			DFT(i);
		}

		for (int i = 0; i < isAP.length; i++) {
			if (isAP[i]) {
				System.out.println(i);
			}
		}

	}

	private static void DFT(int src) {
		isdone[src] = true;
		discT[src] = lowT[src] = ++time;
		int count = 0;
		for (int i = 0; i < graph[0].length; i++) {
			if (graph[src][i] == 0) { // Not_A_vertex.
				continue;
			}

			if (!isdone[i]) { // freshNbrs.
				count++;
				parent[i] = src;
				DFT(i);

				lowT[src] = Math.min(lowT[i], lowT[src]);

				if (parent[src] != -1) {
					if (lowT[i] >= discT[src]) {
						// System.out.println(src);
						isAP[src] = true;
					}
				} else if (parent[src] == -1) { // root.
					if (count > 1) {
						// System.out.println(src);
						isAP[src] = true;
					}
				}
			} else if (parent[src] != i) {
				lowT[src] = Math.min(lowT[src], discT[i]);
			}
		}
	}
}
