package Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ArticulationPairQuestion {

	static boolean[][] graph;
	static ArticulationPair[] result;
	static ArrayList<BridgePair> bridges;
	static int size = 0;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int m = scn.nextInt();

		graph = new boolean[n][n];
		result = new ArticulationPair[n];

		for (int i = 0; i < m; i++) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			graph[x][y] = true;
			graph[y][x] = true;
		}

		for (int i = 0; i < n; i++) {
			result[i] = new ArticulationPair();
		}

		for (int i = n - 1; i >= 0; i--) {
			if (result[i].processed) {
				continue;
			}

			DFT(0, i);
		}

		System.out.println(size);
		for (int i = 0; i < n; i++) {
			if (result[i].isAP) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

		for (int i = 0; i < n; i++) {
			result[i] = new ArticulationPair();
		}

		bridges = new ArrayList<ArticulationPairQuestion.BridgePair>();
		for (int i = n - 1; i >= 0; i--) {
			if (result[i].processed) {
				continue;
			}

			DFTBridges(0, i);
		}

		Collections.sort(bridges);
		System.out.println(bridges.size());
		for (BridgePair bp : bridges) {
			System.out.println(bp.u + " " + bp.v);
		}

	}

	public static void DFT(int time, int currv) {
		result[currv].processed = true;
		result[currv].disc = result[currv].low = time;

		int rootChildCounter = 0;
		for (int i = 0; i < graph.length; i++) {
			if (graph[currv][i] == true) { // edge
				// Case-I_Fresh_Nbr.
				if (!result[i].processed) {
					rootChildCounter++;

					result[i].parent = currv;
					DFT(time + 1, i);
					result[currv].low = Math.min(result[currv].low, result[i].low);

					if (result[currv].parent != -1) {
						if (result[i].low >= result[currv].disc) {
							result[currv].isAP = true;
							size++;

						}
					} else {
						if (rootChildCounter > 1) {
							result[currv].isAP = true;
							size++;

						}
					}
				}
				// Case-II_Processed_Non_Parent
				else if (result[currv].parent != i) {
					result[currv].low = Math.min(result[currv].low, result[i].disc);
				}

			}
		}
	}

	public static void DFTBridges(int time, int currv) {
		result[currv].processed = true;
		result[currv].disc = result[currv].low = time;

		for (int i = 0; i < graph.length; i++) {
			if (graph[currv][i] == true) { // edge
				// Case-I_Fresh_Nbr.
				if (!result[i].processed) {
					result[i].parent = currv;
					DFTBridges(time + 1, i);
					result[currv].low = Math.min(result[currv].low, result[i].low);

					if (result[i].low > result[currv].disc) {
						BridgePair bp = new BridgePair();
						bp.u = i <= currv ? i : currv;
						bp.v = i <= currv ? currv : i;
						bridges.add(bp);
					}
				}
				// Case-II_Non_Processed_Parent.
				else if (result[currv].parent != i) {
					result[currv].low = Math.min(result[currv].low, result[i].disc);
				}
			}
		}
	}

	private static class ArticulationPair {
		private int low;
		private int disc;
		private boolean isAP;
		private int parent = -1;
		private boolean processed;
	}

	private static class BridgePair implements Comparable<BridgePair> {
		private int u;
		private int v;

		@Override
		public int compareTo(BridgePair o) {
			return this.u * 10 + this.v - o.u * 10 - o.v;
		}

	}

}
