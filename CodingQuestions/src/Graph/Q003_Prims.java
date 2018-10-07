package Graph;

import java.io.*;
import java.util.*;

public class Q003_Prims {

	private static class Edge implements Comparable<Edge> {
		int vtx;
		int weight;

		Edge(int vtx, int weight) {
			this.vtx = vtx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	// Complete the prims function below.
	static int prims(int n, ArrayList<Edge>[] map, int start) {

		boolean[] unvisited = new boolean[n + 1];
		PriorityQueue<Edge> heap = new PriorityQueue<>();

		for (Edge e : map[start]) {
			heap.add(e);
		}

		unvisited[start] = true;

		int cost = 0;
		while (heap.size() != 0) {
			Edge ed = heap.remove();
			if (unvisited[ed.vtx]) {
				continue;
			}

			unvisited[ed.vtx] = true;
			cost += ed.weight;
			for (Edge e : map[ed.vtx]) {
				if (unvisited[e.vtx]) {
					continue;
				}

				heap.add(e);
			}
		}

		return cost;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		ArrayList<Edge>[] map = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			map[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();

			map[a].add(new Edge(b, c));
			map[b].add(new Edge(a, c));

		}

		int start = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int result = prims(n, map, start);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
