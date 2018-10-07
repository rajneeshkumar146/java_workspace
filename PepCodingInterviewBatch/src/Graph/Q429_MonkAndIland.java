package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Q429_MonkAndIland {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int m = scn.nextInt();

			HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
			for (int i = 1; i <= n; i++) {
				map.put(i, new HashSet<>());
			}

			for (int i = 1; i <= m; i++) {
				int v1 = scn.nextInt();
				int v2 = scn.nextInt();

				map.get(v1).add(v2);
				map.get(v2).add(v1);
			}

			BFS(1, n, map);

		}

	}

	private static void BFS(int src, int desti, HashMap<Integer, HashSet<Integer>> map) {
		HashSet<Integer> isdone = new HashSet<>();
		LinkedList<Integer> q = new LinkedList<>();

		q.addLast(src);
		q.addLast(null);
		int count = 0;
		while (!q.isEmpty()) {
			Integer process = q.removeFirst();

			if (process == null) {
				count++;
				q.addLast(null);
				continue;
			}

			if (isdone.contains(process)) {
				continue;
			}

			if (process == desti) {
				System.out.println(count);
				return;
			}

			isdone.add(process);
			for (Integer key : map.get(process)) {
				if (isdone.contains(key)) {
					continue;
				}

				q.addLast(key);

			}
		}

	}

}
