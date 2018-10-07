package Practice_Easy;

import java.util.Scanner;

public class Chicks_In_Zoo {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		for (int i = 1; i <= n; i++) {
			int num = scn.nextInt();
			int[] arr = chicksInZoo(num);
			int resultidx = num % arr.length;
			if (resultidx == 0) {
				System.out.println(arr[resultidx + 5]);
			} else if (resultidx == 0 && num == 0) {
				System.out.println(arr[resultidx]);
			}

			else {
				System.out.println(arr[resultidx - 1]);
			}
		}

	}

	public static int[] chicksInZoo(int n) {
		int[] arr = new int[6];
		arr[0] = 1;
		for (int i = 1; i <= n; i++) {
			if (i < 6) {
				arr[i] = arr[i - 1] * 2 + arr[i - 1];
			} else {
				int temp = i % 6;
				if (temp + 6 == 6) {
					arr[temp] = arr[5] * 2 + arr[5] - arr[temp + 1];
				} else {
					arr[temp] = arr[temp - 1] * 2 + arr[temp - 1] - arr[(temp + 1) % 6];

				}
			}
		}

		return arr;
	}

}
