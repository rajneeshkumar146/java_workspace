package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Q422_RoadsAndLibraries {

	public static long roadsAndLibraries(int n, int costlib, int costroad) {
		HashSet<Integer> isdone = new HashSet<>();
		long cost = 0;

		for (Integer i : Graph.keySet()) {
			if (isdone.contains(i)) {
				continue;
			}

			cost += costlib;
			long count = GetConnectedComponents(i, isdone);

			cost += (count - 1) * (costlib < costroad ? costlib : costroad);

		}

		return cost;
	}

	public static long GetConnectedComponents(int vtx, HashSet<Integer> isdone) {
		long count = 1;

		isdone.add(vtx);

		for (int i : Graph.get(vtx)) {
			if (isdone.contains(i)) {
				continue;
			}
			count += GetConnectedComponents(i, isdone);
		}
		return count;

	}

	private static final Scanner scanner = new Scanner(System.in);

	private static HashMap<Integer, HashSet<Integer>> Graph;

	public static void main(String[] args) {

		int q = scanner.nextInt();

		for (int qItr = 0; qItr < q; qItr++) {

			int n = scanner.nextInt();

			int m = scanner.nextInt();

			int c_lib = scanner.nextInt();

			int c_road = scanner.nextInt();

			Graph = new HashMap<>();

			for (int i = 1; i <= n; i++) {
				Graph.put(i, new HashSet<>());
			}

			for (int i = 0; i < m; i++) {

				int city1 = scanner.nextInt();
				int city2 = scanner.nextInt();

				Graph.get(city1).add(city2);
				Graph.get(city2).add(city1);
			}

			long result = roadsAndLibraries(n, c_lib, c_road);

			System.out.println(result);

		}

		scanner.close();
	}

}
