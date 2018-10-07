package Array;

public class Q02_Minimum_number_of_jumps_to_reach_end {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 8, 9, 0, 6, 7, 6, 8, 9 };
		System.out.println(MinJumpsRec(arr, 0, arr.length - 1));

	}

	public static int MinJumpsRec(int[] arr, int le, int re) {

		if (le == re) {
			return 0;
		}

		if (arr[le] == 0) {
			return Integer.MAX_VALUE;
		}

		int min = Integer.MAX_VALUE;
		for (int i = le + 1; i < arr.length && i <= le + arr[le]; i++) {
			int jump = MinJumpsRec(arr, i, re);
			if (jump != Integer.MAX_VALUE && jump + 1 < min) {
				min = jump + 1;
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
