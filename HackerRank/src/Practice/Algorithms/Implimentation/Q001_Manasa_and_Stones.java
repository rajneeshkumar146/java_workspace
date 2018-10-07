package Practice.Algorithms.Implimentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Q001_Manasa_and_Stones {
	private static final Scanner scanner = new Scanner(System.in);

	private static int[] stones(int n, int a, int b) {

		HashSet<Integer> set = new HashSet<>();

		for (int i = n - 1, j = 0; i >= 0 && j < n; i--, j++) {
			set.add((a * i + b * j));
		}

		int[] ra = new int[set.size()];
		int index = 0;
		ArrayList<Integer> keys = new ArrayList<>(set);
		for (Integer key : keys) {
			ra[index] = key;
			index++;
		}

		Arrays.sort(ra);
		return ra;

	}

	public static void main(String[] args) throws IOException {

		int T = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int TItr = 0; TItr < T; TItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int a = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int b = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] result = stones(n, a, b);

			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");

			}

			System.out.println();

		}

		scanner.close();
	}

}
