package Algorithms;

import java.util.Scanner;

public class Boyer_Moores_Voting_Algorithm {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int size = scn.nextInt();
		// int[] arr = new int[] { 2, 2, 2, 2, 5, 5, 2, 3, 3 };
		int[] arr = new int[size];
		takeinput(arr, arr.length);
		
		int ele = FindCandidate(arr, arr.length);
		boolean res = isMajor(arr, arr.length, ele);
		System.out.println(res + " => " + ele);
	}

	private static void takeinput(int[] arr, int size) {
		for (int i = 0; i < size; i++) {
			arr[i] = scn.nextInt();
		}
	}

	private static int FindCandidate(int[] arr, int size) {

		int maj_index = 0;
		int count = 1;
		for (int i = 1; i < size; i++) {
			if (arr[i] == arr[maj_index]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				maj_index = i;
				count = 1;
			}
		}

		return arr[maj_index];
	}

	private static boolean isMajor(int[] arr, int size, int ele) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (arr[i] == ele) {
				count++;
			}
		}

		return count > size / 2 ? true : false;
	}

}