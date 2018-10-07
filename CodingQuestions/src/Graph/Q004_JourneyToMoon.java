package Graph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q004_JourneyToMoon {

	// Complete the journeyToMoon function below.
	static int journeyToMoon(int n, ArrayList<Integer>[] arr) {

		ArrayList<Integer> compo = new ArrayList<>();
		boolean[] isdone = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (isdone[i]) {
				continue;
			}

			count = 0;
			PriorityQueue<Integer> heap = new PriorityQueue<>();
			heap.add(i);
			while (!heap.isEmpty()) {
				Integer process = heap.remove();
				if (isdone[process]) {
					continue;
				}

				isdone[process] = true;
				for (Integer key : arr[process]) {
					if (isdone[key]) {
						continue;
					}

					heap.add(key);
					count++;
				}
			}
			compo.add(count + 1);

		}

//		System.out.println(compo);

		int res = 0;
		int remaining = n;
		for (int i = 0; i < compo.size() - 1; i++) {
			remaining -= compo.get(i);
			res += compo.get(i) * remaining;
		}

		return res;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] np = scanner.nextLine().split(" ");

		int n = Integer.parseInt(np[0]);

		int p = Integer.parseInt(np[1]);

		ArrayList<Integer>[] arr = new ArrayList[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < p; i++) {

			int a = scanner.nextInt();
			int b = scanner.nextInt();
			arr[a].add(b);
			arr[b].add(a);
		}

		int result = journeyToMoon(n, arr);

		System.out.println(result);

		scanner.close();
	}
}
