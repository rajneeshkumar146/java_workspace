package DynamicProgramming.BasicProblem;

public class Q12_Cutting_rod {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 8, 9, 10, 17, 17, 25 };
		System.out.println("ans: " + CuttingRodRec(arr, arr.length));
		System.out.println("ans: " + CuttingRodRec2(arr, arr.length));
		System.out.println("ans: " + CuttingRodDP(arr, arr.length));
	}

	public static int CuttingRodRec(int[] price, int n) {
		if (n <= 0) {
			return 0;
		}

		int Max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int cutprice = price[i] + CuttingRodRec(price, n - i - 1);
			Max = Math.max(cutprice, Max);
		}

		return Max;

	}

	public static int CuttingRodRec2(int[] price, int n) {
		if (n == 1) {
			return price[0];
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n - 1; i++) {
			int srp = price[i- 1] + CuttingRodRec2(price, n - i);
			max = Math.max(srp, max);
		}

		return Math.max(max, price[n-1]);

	}

	public static int CuttingRodDP(int[] price, int size) {

		int[] mparr = new int[size + 1]; // Max_price_array.
		for (int i = 1; i <= size; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				max = Math.max(max, price[j] + mparr[i - j - 1]);
				mparr[i] = max;
			}
		}

		return mparr[size];

	}

}
