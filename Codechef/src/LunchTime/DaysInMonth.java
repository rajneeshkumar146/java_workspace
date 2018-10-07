package LunchTime;

import java.util.Arrays;
import java.util.Scanner;

public class DaysInMonth {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int T = scn.nextInt();
		for (int i = 0; i < T; i++) {
			solve();
		}
	}

	public static void solve() throws Exception {

		int days = scn.nextInt();
		String s = scn.next();

		int n = 0;
		switch (s) {

		case "mon":
			n = 1;
			break;

		case "tues":
			n = 2;
			break;

		case "wed":
			n = 3;
			break;

		case "thurs":
			n = 4;
			break;

		case "fri":
			n = 5;
			break;

		case "sat":
			n = 6;
			break;

		case "sun":
			n = 7;
			break;

		}

		int[] arr = new int[8];
		Arrays.fill(arr, 4);
		int dif = days - 28;
		if (dif != 0) {
			arr = solution(arr, n, dif);
		}
		display(arr);
	}

	private static int[] solution(int[] arr, int n, int dif) {

		for (int i = 0; i < dif; i++) {
			if (n + i <= 7) {
				arr[n + i] += 1;
			} else {
				arr[dif - i]++;
			}
		}

		return arr;
	}

	private static void display(int[] arr) {
		for (int i = 1; i < arr.length - 1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(arr[arr.length - 1]);
	}

}
