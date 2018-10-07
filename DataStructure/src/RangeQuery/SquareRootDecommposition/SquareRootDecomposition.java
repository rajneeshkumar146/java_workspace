package RangeQuery.SquareRootDecommposition;

import java.util.Scanner;

public class SquareRootDecomposition {
	final int mod = 1000000000 + 7;
	final int max = Integer.MAX_VALUE;
	final int min = Integer.MIN_VALUE;
	public static Scanner scn = new Scanner(System.in);

	private static int[] input;
	private static long[] SRTarr;
	private static int ClusterSize;

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		Intialization();

		System.out.println(Query(3, 8));
		System.out.println(Query(1, 6));
		Update(0, 8);
		System.out.println(Query(8, 8));

	}

	public static long Query(int left, int right) {
		long sum = 0;

		while (left < right && left != 0 && left % ClusterSize != 0) {
			sum += input[left];
			left++;
		}

		while ((left + ClusterSize) <= right) {
			sum += SRTarr[left / ClusterSize];
			left += ClusterSize;
		}

		while (left <= right) {
			sum += input[left];
			left++;
		}

		return sum;

	}

	public static void Update(int data, int i) {
		int oldValue = input[i];
		SRTarr[i % ClusterSize] += data - oldValue;
		input[i] = data;
	}

	private static void Intialization() {
		// input = ArrayInput(n);

		int[] arr = { 1, 5, 2, 4, 6, 1, 3, 5, 7, 10 };
		input = arr;
		int n = arr.length;

		ClusterSize = (int) (Math.sqrt(n))+1; // Cluster_Size.
		SRTarr = new long[ClusterSize]; // Array_That_contain_sum_of_cluster.

		int clusterIndex = -1;
		for (int i = 0; i < n; i++) {
			if (i % ClusterSize == 0) {
				clusterIndex++;
			}
			SRTarr[clusterIndex] += input[i];
		}

	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	private static void displayArray(long[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}