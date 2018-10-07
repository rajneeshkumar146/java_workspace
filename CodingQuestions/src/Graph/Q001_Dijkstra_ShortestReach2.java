package Graph;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q001_Dijkstra_ShortestReach2 {

	private static class Pair implements Comparable<Pair> {
		int vtx;
		int cost;

		Pair(int vtx, int cost) {
			this.vtx = vtx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}

	}

	// Complete the shortestReach function below.
	static int[] shortestReach(int n, HashMap<Integer, HashMap<Integer, Integer>> map, int s) {
		PriorityQueue<Pair> heap = new PriorityQueue<>();
		int[] distance = new int[n + 1];
		Arrays.fill(distance, 1000000);

		Pair p = new Pair(s, 0);
		heap.add(p);
		distance[s] = 0;

		boolean[] isdone = new boolean[n + 1];

		while (heap.size() != 0) {
			Pair pair = heap.remove();
			if (isdone[pair.vtx]) {
				continue;
			}

			isdone[pair.vtx] = true;

			for (Integer i : map.get(pair.vtx).keySet()) {

				int oldcost = distance[i];
				int newcost = pair.cost + map.get(pair.vtx).get(i);
				if (newcost < oldcost) {
					Pair npair = new Pair(i, newcost);
					heap.add(npair);
					distance[i] = newcost;
				}
			}
		}

		return distance;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String[] nm = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nm[0]);

			int m = Integer.parseInt(nm[1]);

			HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

			for (int i = 1; i <= n; i++) {
				map.put(i, new HashMap<>());
			}

			for (int i = 0; i < m; i++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				int c = scanner.nextInt();

				if (map.get(a).containsKey(b)) {
					if (c < map.get(a).get(b)) {
						map.get(a).put(b, c);
						map.get(b).put(a, c);
					}
				} else {
					map.get(a).put(b, c);
					map.get(b).put(a, c);
				}
			}

			int s = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int update[] = shortestReach(n, map, s);
			for (int i = 1; i < update.length; i++) {
				if (i == s) {
					continue;
				}
				int ans = update[i] != 1000000 ? update[i] : -1;
				System.out.print(ans + " ");
			}
			System.out.println();

		}

		scanner.close();
	}

}
