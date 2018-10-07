package Theory.Ch04_Graph.T01_GraphTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class T01_Traversal {
	public static Scanner scn = new Scanner(System.in);
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	private static void DFS(int u, boolean[] isdone) {
		isdone[u] = true;
		for (Integer i : graph[u]) {
			if (isdone[i]) {
				continue;
			}

			DFS(i, isdone);
		}
	}

	private static void BFS(int u) {
		int[] distance = new int[graph.length];
		int[] pred = new int[graph.length];
		ArrayDeque<Integer> que = new ArrayDeque<>();
		que.addLast(u);

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[u] = 0;
		pred[u] = -1;

		while (!que.isEmpty()) {
			int v = que.removeFirst();

			for (int i : graph[v]) {
				if (distance[i] != Integer.MAX_VALUE) {
					continue;
				}

				distance[i] = distance[v] + 1;
				pred[i] = u;

				que.addLast(i);
			}
		}

		// BFSPath(pred, scn.nextInt());

	}

	private static void BFSPath(int[] pred, int desti) {
		System.out.println(desti);
		int par = pred[desti];
		while (par != -1) {
			System.out.println(par);
			par = pred[par];
		}

	}

	private static void ConectedComponent() {
		boolean[] isdone = new boolean[graph.length];
		int numCC = 0;

		for (int i = 0; i < graph.length; i++) {
			if (!isdone[i]) {
				System.out.println(++numCC);
				DFS(i, isdone);

			}

		}
	}

}
