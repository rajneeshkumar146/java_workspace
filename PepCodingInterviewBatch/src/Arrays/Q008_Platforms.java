package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Q008_Platforms {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] arrivals = new int[n];
		int[] departures = new int[n];

		for (int i = 0; i < arrivals.length; i++) {
			arrivals[i] = scn.nextInt();
		}

		for (int i = 0; i < departures.length; i++) {
			departures[i] = scn.nextInt();
		}

		solve(arrivals, departures);
	}

	private static void solve(int[] arrivals, int[] departures) {
		Arrays.sort(arrivals);
		Arrays.sort(departures);

		int arridx = 1;
		int depaidx = 0;
		int result = 1;
		int traverseCount = 1;

		while (arridx < arrivals.length && depaidx < departures.length) {

			if (arrivals[arridx] <= departures[depaidx]) {
					traverseCount++;
				
				arridx++;

				if (traverseCount > result) {
					result = traverseCount;
				}

			} else {
				traverseCount--;
				depaidx++;
			}

		}

		System.out.println(result);
	}
}