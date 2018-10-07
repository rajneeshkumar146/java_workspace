package Assingment_04_Array;

import java.util.Scanner;

public class Q02_searching_and_returning_index {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr = take_input();
		display(arr);

		System.out.println(search(arr));
	}

	public static int[] take_input() {
		System.out.println("\tEnter size of array");
		int n = scn.nextInt();

		int[] rv = new int[n];

		for (int i = 0; i < rv.length; i++) {
			System.out.println("Enter your " + (i + 1) + "th element");
			rv[i] = scn.nextInt();
		}
		return rv;

	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + "\t");
		}
		System.out.println();
	}

	public static int search(int[] arr) {
		System.out.println("Enter your number you want to search");
		int n = scn.nextInt();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n) {
			    return i;
			}
		}
		return -1;
	}

}