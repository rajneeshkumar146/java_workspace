package Class_15th_MCM_knapsack_SOE;

public class MCM {

	public static void main(String[] args) {
		int[] dims = { 10, 20, 30, 40, 50,60,70,80,35,67};

		System.out.println(mcm(dims, 0, dims.length - 1));
		System.out.println(mcmDP(dims));

	}

	public static int mcm(int[] dims, int str, int end) {
		if (str + 1 == end) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int i = str + 1; i < end; i++) {
			int cost1 = mcm(dims, str, i);
			int cost2 = mcm(dims, i, end);
			int rcm = dims[str] * dims[end] * dims[i]; // real_cost_of_multiplication.
			int tc = cost1 + cost2 + rcm;

			if (tc < min) {
				min = tc;
			}
		}

		return min;

	}

	public static int mcmDP(int[] dims) {
		int len = dims.length;
		int[][] arr = new int[len - 1][len - 1];
		for (int i = 0; i < len - 1; i++) { // all_elements_at_disagonal_equal_to_0
			arr[i][i] = 0;
		}

		for (int col = 1; col < len - 1; col++) {
			for (int row = 0; row < len - 1 - col; row++) {
				int rcm = dims[row] * dims[row + col + 1] * dims[row + col]; // 0*1=[10,20]*[20,30].
				int min = Math.min(arr[row + 1][row + col], arr[row][row + col - 1]);
				arr[row][row + col] = rcm + min;

			}
		}
		return arr[0][len - 2];
	}

}
