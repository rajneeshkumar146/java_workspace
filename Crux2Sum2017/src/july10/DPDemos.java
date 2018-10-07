package july10;

public class DPDemos {

	public static void main(String[] args) {
		// int[] dims = { 10, 20, 30, 40, 50, 60 };
		// System.out.println(mcm(dims, 0, dims.length - 1)); // ABCDE?

		int[] values = { 10, 15, 20, 5, 8 };
		int[] wts = { 20, 15, 15, 5, 18 };
		System.out.println(knapSack(wts, values, 50, 0));
	}

	public static int mcm(int[] dims, int si, int ei) {
		if (si + 1 == ei) {
			return 0;
		}

		System.out.println("Hi " + si + "-" + ei);
		int min = Integer.MAX_VALUE;

		for (int i = si + 1; i < ei; i++) {
			int cost1 = mcm(dims, si, i);
			int cost2 = mcm(dims, i, ei);
			int rcm = dims[si] * dims[ei] * dims[i];
			int tc = cost1 + cost2 + rcm;

			if (tc < min) {
				min = tc;
			}
		}

		return min;
	}

	public static int mcmRDP(int[] dims, int si, int ei, int[][] strg) {
		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		System.out.println("Hi " + si + "-" + ei);

		int min = Integer.MAX_VALUE;

		for (int i = si + 1; i < ei; i++) {
			int cost1 = mcmRDP(dims, si, i, strg);
			int cost2 = mcmRDP(dims, i, ei, strg);
			int rcm = dims[si] * dims[ei] * dims[i];
			int tc = cost1 + cost2 + rcm;

			if (tc < min) {
				min = tc;
			}
		}

		strg[si][ei] = min;
		return min;
	}

	public static int knapSack(int[] wts, int[] values, int cap, int vidx) {
		if (vidx == wts.length) {
			return 0;
		}

		int v1 = 0, v2 = 0;

		if (cap >= wts[vidx]) {
			v1 = values[vidx] + knapSack(wts, values, cap - wts[vidx], vidx + 1); // item
		}

		v2 = 0 + knapSack(wts, values, cap, vidx + 1); // item declined

		return Math.max(v1, v2);
	}

	public static int knapSackNonDPSuited(int[] wts, int[] values, 
										  int cap, int vidx, 
										  int wsf, int vsf) {
		if (vidx == wts.length) {
			return vsf;
		}
		
		int v1 = 0, v2 = 0;

		if (wsf + wts[vidx] <= cap) {
			v1 = knapSackNonDPSuited(wts, values, cap, vidx + 1, wsf + wts[vidx], vsf + values[vidx]);
		}
		
		v2 = knapSackNonDPSuited(wts, values, cap, vidx + 1, wsf, vsf);

		return Math.max(v1, v2);
	}

	public static void soe(){
		
	}
	
	
}
