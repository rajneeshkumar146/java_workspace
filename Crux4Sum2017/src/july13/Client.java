package july13;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		
		System.out.println(getMazePath(0, 0, 2, 2));
		System.out.println(getBoardPath(0, 10, new int[] { 0, 0, 0, 0, 7, 0, 9, 0, 0, 0, 0 }));
	}

	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {
		if (cc == ec && cr == er) {
			ArrayList<String> allPathsFromMP = new ArrayList<>();
			allPathsFromMP.add("");
			return allPathsFromMP;
		}

		ArrayList<String> allPathsFromMP = new ArrayList<>();

		if (cc < ec) {
			ArrayList<String> allPathsFromHD = getMazePath(cr, cc + 1, er, ec);
			for (String asinglePathFromHD : allPathsFromHD) {
				String aSinglePathFromMP = "H" + asinglePathFromHD;
				allPathsFromMP.add(aSinglePathFromMP);
			}
		}

		if (cr < er) {
			ArrayList<String> allPathsFromVD = getMazePath(cr + 1, cc, er, ec);
			for (String asinglePathFromVD : allPathsFromVD) {
				String aSinglePathFromMP = "V" + asinglePathFromVD;
				allPathsFromMP.add(aSinglePathFromMP);
			}
		}

		if (cr < er && cc < ec) {
			ArrayList<String> allPathsFromDD = getMazePath(cr + 1, cc + 1, er, ec);
			for (String asinglePathFromDD : allPathsFromDD) {
				String aSinglePathFromMP = "D" + asinglePathFromDD;
				allPathsFromMP.add(aSinglePathFromMP);
			}
		}

		return allPathsFromMP;
	}

	public static ArrayList<String> getBoardPath(int curr, int end, int[] lad) {
		if (curr == end) {
			ArrayList<String> allPathsFromCurrToEnd = new ArrayList<>();
			allPathsFromCurrToEnd.add("\n");
			return allPathsFromCurrToEnd;
		}

		ArrayList<String> allPathsFromCurrToEnd = new ArrayList<>();

		if (lad[curr] != 0) {
			ArrayList<String> allPathsFromLadEPToEnd = getBoardPath(lad[curr], end, lad);
			for (String aSinglePathFromLadEPToEnd : allPathsFromLadEPToEnd) {
				String aSinglePathFromCurrToEnd = "[L" + curr + "->" + lad[curr] + "]" + aSinglePathFromLadEPToEnd;
				allPathsFromCurrToEnd.add(aSinglePathFromCurrToEnd);
			}
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				if (curr + dice <= end) {
					ArrayList<String> allPathsFromCPDiceToEnd = getBoardPath(curr + dice, end, lad);
					for (String aSinglePathFromCPDiceToEnd : allPathsFromCPDiceToEnd) {
						String aSinglePathFromCurrToEnd = dice + aSinglePathFromCPDiceToEnd;
						allPathsFromCurrToEnd.add(aSinglePathFromCurrToEnd);
					}
				}
			}
		}

		return allPathsFromCurrToEnd;
	}

	public static boolean IsValidBoardPath(int curr, int end, int[] snl, int[] dices, int vidx) {
		if (curr == end) {
			return true;
		}
		
		if(vidx == dices.length){
			return false;
		}
		
		if (snl[curr] != 0) {
			return IsValidBoardPath(snl[curr], end, snl, dices, vidx);
		} else {
			if (curr + dices[vidx] <= end) {
				return IsValidBoardPath(curr + dices[vidx], end, snl, dices, vidx + 1);
			} else {
				return IsValidBoardPath(curr, end, snl, dices, vidx + 1);
			}
		}
	}
}
