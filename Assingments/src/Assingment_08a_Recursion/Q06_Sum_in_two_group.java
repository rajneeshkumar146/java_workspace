package Assingment_08a_Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Q06_Sum_in_two_group {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// int[] arr = { 10, 20, 30,40,50,60,70,80 };
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		System.out.println(count_sum_of_group(arr, 0, 0, 0));

		System.out.println(sum_of_group02(arr, 0, 0, 0, "", ""));

		sum_of_group03(arr, 0, 0, 0, "", "");

	}

	public static int count_sum_of_group(int[] arr, int count, int sog1, int sog2) {// sog1=sum_of_group_1
		if (count == arr.length) {
			if (sog1 == sog2) {
				return 1;
			}
			return 0;
		}

		int ch = arr[count];
		int count_g1 = count_sum_of_group(arr, count + 1, sog1 + ch, sog2);
		int count_g2 = count_sum_of_group(arr, count + 1, sog1, sog2 + ch);

		return count_g1 + count_g2;
	}

	public static void sum_of_group03(int[] arr, int count, int sog1, int sog2, String ansg1, String ansg2) {// sog1=sum_of_group_1
		if (count == arr.length) {
			if (sog1 == sog2) {
				System.out.println(ansg1 + "\t" + ansg2);
			}
			return;
		}

		int ch = arr[count];
		sum_of_group03(arr, count + 1, sog1 + ch, sog2, ansg1 + ch + " ", ansg2);
		sum_of_group03(arr, count + 1, sog1, sog2 + ch, ansg1, ansg2 + ch + " ");

	}

	public static ArrayList<String> sum_of_group02(int[] arr, int count, int sog1, int sog2, String ansg1,
			String ansg2) {// sog1=sum_of_group_1
		if (count == arr.length) {
			ArrayList<String> result = new ArrayList<>();
			if (sog1 == sog2) {
				result.add(ansg1 + " and " + ansg2);
			}

			return result;
		}

		int num = arr[count];

		ArrayList<String> result = new ArrayList<>();
		ArrayList<String> g1 = sum_of_group02(arr, count + 1, sog1 + num, sog2, ansg1 + num + " ", ansg2);
		result.addAll(g1);

		ArrayList<String> g2 = sum_of_group02(arr, count + 1, sog1, sog2 + num, ansg1, ansg2 + num + " ");
		result.addAll(g2);

		return result;

	}

}
