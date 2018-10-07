package DynamicProgramming.BasicProblem;

public class Q34_break_number_in_3_parts_to_get_maximum_sum {

	public static void main(String[] args) {
		System.out.println(breaksum(12));
		System.out.println(breaksumDP(12));
	}

	public static int breaksum(int n) {
		if (n <= 1) {
			return n;
		}

		int a = breaksum(n / 2);
		int b = breaksum(n / 3);
		int c = breaksum(n / 4);

		return Math.max(a + b + c, n);

	}

	public static int breaksumDP(int n) {

		int[] arr = new int[n + 1];

		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			int sum = arr[i / 2] + arr[i / 3] + arr[i / 4];
			arr[i] = Math.max(sum, i);
		}

		return arr[n];
	}

}
