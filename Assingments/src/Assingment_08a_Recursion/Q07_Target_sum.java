package Assingment_08a_Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Q07_Target_sum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		// int[] arr = { 10, 20, 30,40,50,60,70,80 };
		// int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		
		int tar=scn.nextInt();
		System.out.println(count_target(arr, 0, tar));
		System.out.println(target02(arr, 0, tar, ""));

		target03(arr, 0, tar, "");

	}

	public static int count_target(int[] arr, int vidx, int target) {

		if (vidx == arr.length) {
			if (target == 0) {
				return 1;

			}
			return 0;
		}

		int ch = arr[vidx];
		int count_no_add = count_target(arr, vidx + 1, target);
		int count_add = count_target(arr, vidx + 1, target - ch);

		return count_add + count_no_add;

	}

	public static void target03(int[] arr, int vidx, int target, String ans) {

		if (vidx == arr.length) {
			if (target == 0) {
				System.out.println(ans);

			}
			return;
		}

		int ch = arr[vidx];
		target03(arr, vidx + 1, target, ans);
		target03(arr, vidx + 1, target - ch, ans + ch + " ");

	}

	public static ArrayList<String> target02(int[] arr, int vidx, int target, String ans) {

		if (vidx == arr.length) {
			ArrayList<String> recu_res = new ArrayList<>();
			if (target == 0) {
				recu_res.add(ans);
			}
			return recu_res;
		}

		int ch = arr[vidx];
		ArrayList<String> result = new ArrayList<>();
		ArrayList<String> recu_res1 = target02(arr, vidx + 1, target, ans);
		result.addAll(recu_res1);
		ArrayList<String> recu_res2 = target02(arr, vidx + 1, target - ch, ans + ch + " ");
		result.addAll(recu_res2);

		return result;
	}

}
