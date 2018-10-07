package Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class TopologicalSortTut {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int m = scn.nextInt();

		int[][] graph = new int[n + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			int row = scn.nextInt();
			int col = scn.nextInt();
			graph[row][col] = 1;
		}

		boolean[] isdone = new boolean[n + 1];

		LinkedList<Integer> ll = new LinkedList<>();

		for (int i = n; i > 0; i--) {
			if (isdone[i]) {
				continue;
			}
			tsort(graph, isdone, ll, i);
		}

		while (!ll.isEmpty()) {
			System.out.print(ll.removeFirst() + " ");
		}

	}

	public static void tsort(int[][] graph, boolean[] isdone, LinkedList<Integer> ll, int row) {

		if (isdone[row] == true) {
			return;
		}

		isdone[row] = true;

		for (int nv = graph[0].length-1; nv > 0; nv--) {
			if (graph[row][nv] == 1) {
				tsort(graph, isdone, ll, nv);
			}
		}

		ll.addFirst(row);

	}

}
