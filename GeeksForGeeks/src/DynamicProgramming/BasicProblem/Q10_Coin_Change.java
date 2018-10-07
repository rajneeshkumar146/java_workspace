package DynamicProgramming.BasicProblem;

public class Q10_Coin_Change {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int res = 10;
		System.out.println("count of coin change: " + coinRec(arr, 0, res, ""));
		System.out.println("count of coin change: " + coinDP(arr, res));

	}

	public static int coinRec(int[] arr, int vidx, int res, String ans) {
		if (res == 0) {
			System.out.println(ans);
			return 1;
		}

		if (res < 0) {
			return 0;
		}

		if (vidx == arr.length) {
			return 0;
		}

		int count = 0;
		count += coinRec(arr, vidx, res - arr[vidx], ans + arr[vidx]);
		count += coinRec(arr, vidx + 1, res, ans);
		return count;

	}

	public static int coinDP(int[] opt, int res) {
		int[] arr = new int[res + 1];
		arr[0] = 1;
		for (int i = 0; i < opt.length; i++) {
			for (int j = opt[i]; j <= res; j++) {
				arr[j] += arr[j - opt[i]]; // for_better_explanation_seeQ21.
			}
		}

		return arr[res];
	}

}
