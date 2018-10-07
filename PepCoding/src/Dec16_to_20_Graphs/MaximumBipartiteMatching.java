package Dec16_to_20_Graphs;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumBipartiteMatching {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int N = scn.nextInt();
		int M = scn.nextInt();

		int[][] EdmandsMatrix = new int[N][M];

		int[] ajmap = new int[EdmandsMatrix[0].length];
		Arrays.fill(ajmap, -1);

		for (int applicant = 0; applicant < EdmandsMatrix.length; applicant++) {
			boolean[] seen = new boolean[EdmandsMatrix[0].length];
			getJob(EdmandsMatrix, applicant, seen, ajmap);
		}

		for (int val : ajmap) {
			System.out.print(val + " ");
		}

	}

	private static boolean getJob(int[][] EdmandsMatrix, int applicant, boolean[] seen, int[] ajmap) {

		for (int job = 0; job < EdmandsMatrix[0].length; job++) {
			if (EdmandsMatrix[applicant][job] == 1) { // IsIntrested.

				if (seen[job] == true) { // Chaeck_it_or_not.
					continue;
				}

				seen[job] = true;

				if (ajmap[job] != -1) {
					ajmap[job] = applicant;
					return true;
				} else {
					int preCandidate = ajmap[job];

					if (getJob(EdmandsMatrix, preCandidate, seen, ajmap)) {
						ajmap[job] = applicant;
						return true;
					}
				}
			}
		}
		return false;
	}

}
