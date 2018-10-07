package Dec16_to_20_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class HungarianAssingment {

	static HashMap<Integer, HashSet<Integer>> CrossedHMap;
	static HashMap<Integer, HashSet<Integer>> CrossedVMap;

	public static void main(String[] args) {
		int[][] cost = { { 1500, 4000, 4500 }, { 2000, 6000, 3500 }, { 2000, 4000, 2500 } };
		solve(cost);
	}

	private static void solve(int[][] cost) {
		boolean FirstTime = true;

		while (true) {

			if (FirstTime) {
				createZeroesFirstTime(cost);
				FirstTime = false;
			} else {
				createZeroesUncovered(cost);
			}

			CrossedHMap = new HashMap<Integer, HashSet<Integer>>();
			CrossedVMap = new HashMap<Integer, HashSet<Integer>>();
			getMinLines(cost);
			if (CrossedHMap.size() + CrossedVMap.size() == cost.length) {
				break;
			}

		}

		boolean[] seenedRow = new boolean[cost.length];

		for (int row = 0; row < cost.length; row++) {
			if (cost[row][0] == 0) {
				seenedRow[row] = true;
				hasPath(cost, row, 1, seenedRow, "[" + row + ", 0], ");
				seenedRow[row] = false;
			}
		}

	}

	// HasPath---------------------------------------------------------------------------------------------------------------------

	public static void hasPath(int[][] cost, int row, int col, boolean[] seenedRow, String psf) {
		if (col == cost[0].length) {
			System.out.println(psf + ".");
			return;
		}

		for (int r = 0; r < cost[0].length; r++) {
			if (!seenedRow[r] && cost[r][col] == 0) {
				seenedRow[r] = true;
				hasPath(cost, r, col + 1, seenedRow, psf + "(" + r + ", " + col + "), ");
				seenedRow[r] = false;
			}
		}
	}

	// createZeroesFirstTime-------------------------------------------------------------------------------------------------------

	private static void createZeroesFirstTime(int[][] cost) {
		for (int row = 0; row < cost.length; row++) {
			int min = GetminInRow(cost, row);

			if (min != 0) {
				for (int col = 0; col < cost[0].length; col++) {
					cost[row][col] -= min;
				}
			}
		}

		for (int col = 0; col < cost[0].length; col++) {
			int min = GetminIncol(cost, col);
			if (min != 0) {
				for (int row = 0; row < cost.length; row++) {
					cost[row][col] -= min;
				}
			}
		}
	}

	private static int GetminInRow(int[][] cost, int row) {
		int min = cost[row][0];
		for (int col = 0; col < cost[0].length; col++) {
			if (min > cost[row][col]) {
				min = cost[row][col];
			}
		}

		return min;
	}

	private static int GetminIncol(int[][] cost, int col) {
		int min = cost[0][col];
		for (int row = 0; row < cost.length; row++) {
			if (min > cost[row][col]) {
				min = cost[row][col];
			}
		}

		return min;
	}

	// CreateZeroUncovered---------------------------------------------------------------------------------------------------------

	public static void createZeroesUncovered(int[][] cost) {
		int min = Integer.MAX_VALUE;

		for (int row = 0; row < cost.length; row++) {
			for (int col = 0; col < cost[0].length; col++) {
				if (CrossedHMap.containsKey(row)) {
					continue;
				} else if (CrossedVMap.containsKey(col)) {
					continue;
				} else {
					if (cost[row][col] < min) {
						min = cost[row][col];
					}
				}
			}
		}

		for (int row = 0; row < cost.length; row++) {
			if (!CrossedHMap.containsKey(row)) {
				for (int col = 0; col < cost[row].length; col++) {
					cost[row][col] -= min;
				}
			}
		}

		for (int col = 0; col < cost[0].length; col++) {
			if (CrossedVMap.containsKey(col)) {
				for (int row = 0; row < cost.length; row++) {
					cost[row][col] += min;
				}
			}
		}

	}

	// GetMinLines-----------------------------------------------------------------------------------------------------------------

	private static class LinePair {
		private int lineNum;
		private char lineType;
		private HashSet<Integer> zeroLocations = new HashSet<Integer>();

		public LinePair(int lineNum, char lineType) {
			this.lineNum = lineNum;
			this.lineType = lineType;
		}
	}

	private static void getMinLines(int[][] cost) {
		HashMap<String, LinePair> map = new HashMap<String, LinePair>();

		int numZeros = 0;
		for (int row = 0; row < cost.length; row++) {
			LinePair hline = new LinePair(row, 'H');
			for (int col = 0; col < cost[0].length; col++) {
				if (cost[row][col] == 0) {
					numZeros++;
					hline.zeroLocations.add(col);

				}
			}
			map.put("H" + row, hline);
		}

		for (int col = 0; col < cost[0].length; col++) {
			LinePair vline = new LinePair(col, 'V');
			for (int row = 0; row < cost.length; row++) {
				if (cost[row][col] == 0) {
					vline.zeroLocations.add(row);
				}
			}
			map.put("V" + col, vline);
		}

		while (numZeros != 0) {
			LinePair RelevantLinePair = GetRelevantLines(new ArrayList<>(map.values()));
			numZeros -= RelevantLinePair.zeroLocations.size();

			if (RelevantLinePair.lineType == 'H') {

				for (int linenum : RelevantLinePair.zeroLocations) {
					CrossedHMap.put(RelevantLinePair.lineNum, RelevantLinePair.zeroLocations);
					map.get("V" + linenum).zeroLocations.remove(RelevantLinePair.lineNum);
				}

			} else {
				for (int linenum : RelevantLinePair.zeroLocations) {
					CrossedHMap.put(RelevantLinePair.lineNum, RelevantLinePair.zeroLocations);
					map.get("H" + linenum).zeroLocations.remove(RelevantLinePair.lineNum);
				}
			}

			map.remove(RelevantLinePair.lineType + "" + RelevantLinePair.lineNum);

		}

	}

	private static LinePair GetRelevantLines(ArrayList<LinePair> list) {
		LinePair releventLinePair = new LinePair(-1, ' ');

		for (LinePair val : list) {
			if (val.zeroLocations.size() > releventLinePair.zeroLocations.size()) {
				releventLinePair = val;
			}
		}
		return releventLinePair;
	}

}
