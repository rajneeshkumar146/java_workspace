package DynamicProgramming.BasicProblem;

public class Q14_Minimum_number_of_jumps_to_reach_end {

	public static void main(String[] args) {
		int[] arr = { 2, 0, 6, 3, 2, 3, 6, 8, 9, 5 };
		int end = arr.length - 1;
		System.out.println(MinJumps(arr, 0, end));
		System.out.println(MinJumpsDP(arr, end));

	}

	public static int MinJumps(int[] arr, int vidx, int end) {
		if (arr[vidx] == 0 || end == 0) {
			return Integer.MAX_VALUE;
		}

		if (vidx == end) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int i = vidx + 1; i <= end && i <= vidx + arr[vidx]; i++) {
			int jumps = MinJumps(arr, i, end);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min) {
				min = jumps + 1;
			}

		}

		return min;
	}

	public static int MinJumpsDP(int[] arr, int end) {
		if (end == 0 || arr[0] == 0) {
			return Integer.MAX_VALUE;
		}

		int[] rarr = new int[end + 1];
		rarr[end] = 0;

		for (int i = end - 1; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			if (arr[i] == 0) {
				rarr[i] = Integer.MAX_VALUE;
			} else {
				for (int j = i; j < i + arr[i] && j < end; j++) {
					if (min > rarr[j + 1]) {
						min = rarr[j + 1];
					}
				}
			}
			if (arr[i] != 0) {
				rarr[i] = min + 1;
			}
		}
		display(rarr);
		return rarr[0];
	}

	private static void display(int[] rarr) {
		for (int i : rarr) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

}
