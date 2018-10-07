package Graph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Q002_BFS {

	// Complete the bfs function below.
	static int[] bfs(int n, int m, ArrayList<Integer>[] map, int s) {
		int[] distance = new int[n + 1];
		Arrays.fill(distance, 1000000);

		ArrayDeque<Integer> que = new ArrayDeque<>();

		que.addLast(s);
		distance[s] = 0;

		boolean isdone[] = new boolean[n + 1];
		while (!que.isEmpty()) {

			Integer process = que.removeFirst();
			if (isdone[process]) {
				continue;
			}

			isdone[process] = true;
			for (Integer key : map[process]) {
				if (isdone[key]) {
					continue;
				}
				distance[key] = Math.min(distance[process] + 6, distance[key]);
				que.addLast(key);
			}

		}

		return distance;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] nm = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nm[0]);

			int m = Integer.parseInt(nm[1]);

			ArrayList<Integer>[] map = new ArrayList[n + 1];

			for (int i = 1; i <= n; i++) {
				map[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();

				map[a].add(b);
				map[b].add(a);
			}

			int s = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] result = bfs(n, m, map, s);

			for (int i = 1; i < result.length; i++) {
				if (i == s) {
					continue;
				}
				int val = result[i] == 1000000 ? -1 : result[i];
				System.out.print(val + " ");

			}

			System.out.println();

		}

		scanner.close();
	}
}
